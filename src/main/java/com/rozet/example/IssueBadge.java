package com.rozet.example;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rozet.core.RozetClient;

/**
 * Example Code for issuing badge
 * 
 * @author kedar@etasens.com
 *
 */
public class IssueBadge {

	private static final Logger logger = LoggerFactory.getLogger(IssueBadge.class);
	
	final static String BADGE_STRING = "{"
			+ "		title: \"Great guy!\","
			+ "		content: \"Great doing business with you!\"," 
			+ "		rating: 5,"
			+ "		recipient: \"john_b\","
			+ "		recipientsEthAddress: \"0x1111111111111111111111111111111111111111\","
			+ "		sender: \"nathan!\",\n" 
			+ "		sendersEthAddress: \"0x1111111111111111111111111111111111111111\""
			+ "	}";
	
	final static String MNEMONIC = "traffic situate feed render intact share ritual trip upgrade wave body acoustic";
	
	public static void main(String args[]) throws Exception {

		// Initialize rozet connection
		RozetClient rozet = new RozetClient().setup("test")
				.init(MNEMONIC);
		
		// Create badge object
		JSONObject badge = new JSONObject(BADGE_STRING);
		// Process it through rozet library
		String txHash = rozet.issueBadge(badge);

		logger.info("Badge Issued with Transaction Hash {}", txHash);
	}
}
