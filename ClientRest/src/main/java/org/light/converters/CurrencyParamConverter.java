//package org.light.converters;
//
//import javax.ws.rs.ext.ParamConverter;
//
//import org.light.Currency;
//
//public class CurrencyParamConverter implements ParamConverter<Currency> {
//
//	//  localhost:8080/NewMaven/JAXRS/nice?code=EUR
//	@Override
//	public Currency fromString(String code) {
//		//handling the business logic over here!
//		Currency currency=null;
//		code = code.toLowerCase();
//		
//		switch(code) {
//		case"eur":currency = new Currency(code, "Euro");
//				break;
//		case"usd":currency = new Currency(code, "US Dollar");
//				break;
//		case"lei":currency = new Currency(code, "Romanian Leu");
//				break;
//		case"inr":currency = new Currency(code, "Rupees");
//				break;
//		}
//		return currency;
//	}
//
//	@Override
//	public String toString(Currency currency) {
//		
//		return currency.toString();
//	}
//
//}
