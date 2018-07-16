package com.rozet.core;

import java.math.BigInteger;

/**
 * Applications predefined constants
 * 
 * @author kedar@etasens.com
 *
 */
public final class CONSTANTS {
	// Predefined Constants
	private static final String GAS_PRICE_STRING = "20000000000";
	private static final String GAS_LIMIT_STRING = "4704624";
	private static final String BALANCE_THRESHOLD_STRING = "1701971370265500";
	
	// Constants for use in application
	public static final String NETWORK_TEST_ENDPOINT = "https://rinkeby.infura.io/pNKoGo0nRKJnmcS2u91K ";
	public static final String NETWORK_PROD_ENDPOINT = "https://rinkeby.infura.io/uaNKEkpjsyvArG0sHifx";
	
	// The deployed contract address taken from truffle console or ganache logs
	public static final String ROZET_CONTRACT_ADDRESS = "0xb93ca7fda4422ce8a70daa7058a603bd613033a9";
	
	public static final BigInteger GAS_PRICE = new BigInteger(GAS_PRICE_STRING);
	public static final BigInteger GAS_LIMIT = new BigInteger(GAS_LIMIT_STRING);
	public static final BigInteger BALANCE_THRESHOLD = new BigInteger(BALANCE_THRESHOLD_STRING);
}
