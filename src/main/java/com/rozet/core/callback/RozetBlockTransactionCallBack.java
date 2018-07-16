package com.rozet.core.callback;

import org.web3j.protocol.core.methods.response.Transaction;

/**
 * Callable Interface for Observing black transaction. This is set with Ethereum
 * transaction that can be accessed in call methods
 * 
 * @author kedar@etasens.com
 *
 */
public abstract class RozetBlockTransactionCallBack {

	public abstract void execute(Transaction transaction);
}
