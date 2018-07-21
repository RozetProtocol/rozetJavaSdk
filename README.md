# Rozet Java SDK

[Javascript](https://github.com/RozetProtocol/rozetJavascriptSdk) | [Python](https://github.com/RozetProtocol/rozetPythonSdk)

The Rozet Java SDK implements the server-side libraries used by
applications using the Rozet protocols. 

## Getting Started

### Installation

To use Rozet in your project include the rozetJavaSdk-1.0.0.jar file in your project using one of the following methods

* **Direct download**

Download and include jar from  ```artifact/rozetJavaSdk-1.0.0.jar```

* **Using maven**

This SDK is also distributed via Maven. Add following dependency in your project's pom.xml to start using it. 
 
```
<dependency>
	<groupId>com.rozet</groupId>
	<artifactId>rozetJavaSdk</artifactId>
	<version>1.0.0</version>
</dependency>
```

### Usage

Before you can start working on the Rozet Java SDK, you need to have Java 7+ 
or greater installed on your machine. 

Create a package e.g. com.rozet.example and add a class with the name issueBadge

**Example** - Issue a badge:

Save file as **IssueBadge.java**

```
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rozet.core.RozetClient;

public class IssueBadge {

	private static final Logger logger = LoggerFactory.getLogger(IssueBadge.class);
	final static String BADGE_STRING = "{"
			+ "		title: \"Great guy!\","
			+ "		content: \"Great doing business with you!\"," 
			+ "		rating:\"\","
			+ "		recipient: \"john_b\","
			+ "		recipientsEthAddress: \"0x1111111111111111111111111111111111111111\","
			+ "		sender: \"nathan!\",\n" 
			+ "		sendersEthAddress: \"0x1111111111111111111111111111111111111111\""
			+ "	}";

	public static void main(String args[]) throws Exception {

		// Initialize rozet connection
		//Replace mnemonics with your own
		RozetClient rozet = new RozetClient().setup("test")
				.init("example example example example example example example example example example example example");
		// Create badge object
		JSONObject badge = new JSONObject(BADGE_STRING);
		// Process it through rozet library
		String txHash = rozet.issueBadge(badge);

		logger.info("Badge Issued with Transactio Hash {}", txHash);
	}
}
```
Execute class as a java program

Create a package e.g. com.rozet.example and add a class with the name listenForBadges

**Example** - Listen for new badges:

Save file as **ListenForBadges.java**

```
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.core.methods.response.Transaction;

import com.rozet.core.RozetClient;
import com.rozet.core.callback.RozetBlockTransactionCallBack;

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

```

Execute class as a java program

## License 
You can view our [license here](https://github.com/RozetProtocol/rozetJavaSdk/blob/master/LICENSE).
