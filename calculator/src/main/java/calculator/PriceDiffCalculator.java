package calculator;

import java.math.BigDecimal;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitfinex.v1.BitfinexExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class PriceDiffCalculator implements RequestHandler<String, String> {

	public String handleRequest(String input, Context context) {

		Exchange bitfinex = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());
		MarketDataService marketDataService = bitfinex.getMarketDataService();
		try {
			Ticker bfTicker = marketDataService.getTicker(CurrencyPair.IOTA_USD);
			BigDecimal lastPrice = bfTicker.getLast();
			System.out.println(bfTicker);

			AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();

		} catch (Exception e) {

		}
		return "";
	}

}
