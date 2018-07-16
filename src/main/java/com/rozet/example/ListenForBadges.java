package com.rozet.example;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.core.methods.response.Transaction;

import com.rozet.core.RozetClient;
import com.rozet.core.callback.RozetBlockTransactionCallBack;

/**
 * Example Code for listening to badges
 * 
 * @author kedar@etasens.com
 *
 */
public class ListenForBadges {
	private static final Logger logger = LoggerFactory.getLogger(ListenForBadges.class);
	
	private static final Long PREVIOUS_BLOCKS = 100l;

	public static void main(String args[]) throws Exception {
		// Initialize rozet connection
		RozetClient rozet = new RozetClient().setup("test").init();

		// Start observing blocks of data.
		rozet.listenForBadges(BigInteger.valueOf(PREVIOUS_BLOCKS), new RozetBlockTransactionCallBack() {

			@Override
			public void execute(Transaction transaction) {
				logger.info("{} sent a badge with txHash {}", transaction.getFrom(), transaction.getHash());
			}
		});
	}
}
