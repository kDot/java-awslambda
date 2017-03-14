package de.heuschild.java.awslambda.hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWorldFunctionHandler implements RequestHandler<String, String> {

	public String handleRequest(final String input, final Context context) {
		context.getLogger().log("kMethod called");
		return "Hello " + input + "!";
	}

}
