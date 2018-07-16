package com.rozet.core;

import static com.rozet.core.CONSTANTS.GAS_LIMIT;
import static com.rozet.core.CONSTANTS.GAS_PRICE;
import static com.rozet.core.CONSTANTS.NETWORK_PROD_ENDPOINT;
import static com.rozet.core.CONSTANTS.NETWORK_TEST_ENDPOINT;
import static com.rozet.core.CONSTANTS.ROZET_CONTRACT_ADDRESS;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import com.rozet.contract.wrappers.Rozet;
import com.rozet.core.callback.RozetBlockTransactionCallBack;
import com.rozet.core.utils.RozetUtils;

import rx.Subscription;

/**
 * This is the main class for using Rozet Protocols
 * 
 * @author kedar@etasens.com
 *
 */
public final class RozetClient {
	private static final Logger logger = LoggerFactory.getLogger(RozetClient.class);
	private Web3j web3j;
	private ExecutorService executor = Executors.newCachedThreadPool();
	private String network = "test";
	private Subscription subscription;
	private Credentials credentials;
	private Rozet rozetContract;

	public RozetClient setup(String network) {
		if ("test".equals(network) || "prod".equals(network))
			this.network = network;
		else
			throw new RuntimeException(network + " not supported.");
		return this;
	}

	/**
	 * Initialize the connection to Ethereum network and extracts wallet information
	 * 
	 * @param mnemonic
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public RozetClient init(String mnemonic) throws InterruptedException, ExecutionException {
		initNetwork();
		initCredentials(mnemonic);
		return this;
	}

	/**
	 * Initialize the connection to Ethereum network
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public RozetClient init() throws InterruptedException, ExecutionException {

		initNetwork();

		return this;
	}

	/**
	 * Issues Badge on the contract if the balance is available
	 * 
	 * @param reputationData
	 * @return
	 * @throws Exception
	 */
	public String issueBadge(JSONObject reputationData) throws Exception {

		String walletAddress = credentials.getAddress();
		logger.info("Wallet Address is " + walletAddress);

		EthGetBalance ethGetBalance = web3j.ethGetBalance(walletAddress, DefaultBlockParameterName.LATEST).sendAsync()
				.get();
		BigInteger balance = ethGetBalance.getBalance();

		// check balance
		if (RozetUtils.balanceIsTooLow(balance)) {
			logger.error("Balance " + balance + " is too low");
		} else {
			logger.info("Balance " + balance + " is ok.");
		}

		// Clean up the json object passed in
		RozetUtils.deleteUndefinedPropsFromObject(reputationData);
		
		String reputationString = reputationData.toString();
		String senderAddress = reputationData.getString("sendersEthAddress").toString();
		String receiverAddress = reputationData.getString("recipientsEthAddress").toString();

		RemoteCall<TransactionReceipt> txHash = rozetContract.issueBadge(senderAddress, receiverAddress, senderAddress,
				reputationString);

		TransactionReceipt transRec = txHash.send();

		return transRec.getTransactionHash();

	}

	/**
	 * Checks previous blocks for transactions
	 * 
	 * @param previousBlocks
	 * @param callback
	 * @throws Exception
	 */
	public void listenForBadges(BigInteger previousBlocks, RozetBlockTransactionCallBack callback) throws Exception {
		// Current Block
		BigInteger currentBlockNumber = web3j.ethBlockNumber().send().getBlockNumber();
		logger.info("Fetched currentBlockNumber as {}", currentBlockNumber);
		DefaultBlockParameter endBlockParameter = DefaultBlockParameter.valueOf(currentBlockNumber);
		DefaultBlockParameter startBlockParameter = DefaultBlockParameter
				.valueOf(currentBlockNumber.subtract(previousBlocks));
		subscription = web3j.replayTransactionsObservable(startBlockParameter, endBlockParameter)
				.subscribe(transaction -> {
					RozetBlockTransactionCallable newCallable = new RozetBlockTransactionCallable(callback,
							transaction);
					executor.submit(newCallable);
				});
	}

	/**
	 * Connects to rinkbey through the end point e.g. infura
	 */
	private void initNetwork() {
		logger.info("Connecting to rinkeby for enviroment {}", network);

		switch (network) {
		case "test":
			web3j = Web3j.build(new HttpService(NETWORK_TEST_ENDPOINT));
			break;
		case "prod":
			web3j = Web3j.build(new HttpService(NETWORK_PROD_ENDPOINT));
			break;
		}
	}

	/**
	 * Extracts wallet credentials from mnemonic and loads the contract
	 * 
	 * @param mnemonic
	 */
	private void initCredentials(String mnemonic) {
		credentials = WalletUtils.loadBip39Credentials("", mnemonic);

		rozetContract = Rozet.load(ROZET_CONTRACT_ADDRESS, web3j, credentials, GAS_PRICE, GAS_LIMIT);
	}
}
