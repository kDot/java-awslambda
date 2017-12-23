package calculator;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitfinex.v1.BitfinexExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.marketdata.MarketDataService;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class PriceDiffCalculator implements RequestHandler<String, String> {

	public String handleRequest(String input, Context context) {

		Exchange bitfinex = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());
		MarketDataService marketDataService = bitfinex.getMarketDataService();
		try {
			System.out.println(marketDataService.getTicker(CurrencyPair.IOTA_USD));
		} catch (Exception e) {

		}
		return "";
	}

}
