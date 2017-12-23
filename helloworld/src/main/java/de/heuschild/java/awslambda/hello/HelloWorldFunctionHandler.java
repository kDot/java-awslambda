package de.heuschild.java.awslambda.hello;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWorldFunctionHandler implements RequestHandler<String, String> {

	public String handleRequest(final String input, final Context context) {
		context.getLogger().log("kkMethod called");
		System.out.println("Function name: " + context.getFunctionName());
		System.out.println("Max mem allocated: " + context.getMemoryLimitInMB());
		System.out.println("Time remaining in milliseconds: " + context.getRemainingTimeInMillis());
		System.out.println("CloudWatch log stream name: " + context.getLogStreamName());
		System.out.println("CloudWatch log group name: " + context.getLogGroupName());

		final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		final Map<String, AttributeValue> valueMap = new HashMap<String, AttributeValue>();
		valueMap.put("value", new AttributeValue("Created on "));
		client.putItem("T_Entry", valueMap);

		return "Hello " + input + "!";
	}

}
