package com.rozet.core.utils;

import static com.rozet.core.CONSTANTS.BALANCE_THRESHOLD;

import java.math.BigInteger;
import java.util.Iterator;

import org.json.JSONObject;

/**
 * This is the utility class and provides static utility functions.
 * 
 * @author kedar@etasens.com
 *
 */
public class RozetUtils {

	/**
	 * This method validates if passed in balance is sufficient for operation to
	 * proceed
	 * 
	 * @param balance
	 * @return
	 */
	public static boolean balanceIsTooLow(BigInteger balance) {
		if (balance.compareTo(BALANCE_THRESHOLD) == -1)
			return true;
		else
			return false;

	}

	/**
	 * This methods deletes keys which are null or has null values from the passed
	 * in json object
	 * 
	 * @param json
	 */
	public static void deleteUndefinedPropsFromObject(JSONObject json) {
		Iterator<String> keys = json.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();

			if (json.isNull(key) || (json.get(key) instanceof String && json.getString(key).isEmpty())) {
				keys.remove();
			}

		}
	}
}
