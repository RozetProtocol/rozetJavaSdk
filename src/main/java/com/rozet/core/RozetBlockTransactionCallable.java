package com.rozet.core;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.core.methods.response.Transaction;

import com.rozet.core.callback.RozetBlockTransactionCallBack;

/**
 * Callable for async observation of callblocks
 * 
 * @author kedar@etasens.com
 *
 */
public final class RozetBlockTransactionCallable implements Callable<Void> {
	private static final Logger logger = LoggerFactory.getLogger(RozetBlockTransactionCallable.class);

	private RozetBlockTransactionCallBack callback;
	private Transaction transaction;

	RozetBlockTransactionCallable(RozetBlockTransactionCallBack callback, Transaction transaction) {
		super();
		this.callback = callback;
		this.transaction = transaction;
	}

	@Override
	public Void call() throws Exception {
		logger.info("Executing callback for blocknumber={}, blockhash={}", transaction.getBlockNumber(),
				transaction.getBlockHash());
		callback.execute(transaction);
		return null;
	}
}
