package org.light.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import org.light.Currency;





@Provider
public class CurrencyParamConverterProvider implements ParamConverterProvider {

	@SuppressWarnings("unchecked")
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
	
		return new ParamConverter<T>() {

			@Override
			public T fromString(String code) {
				Currency currency=null;
				code = code.toLowerCase();
				
				switch(code) {
				case"eur":currency = new Currency(code, "Euro");
						break;
				case"usd":currency = new Currency(code, "US Dollar");
						break;
				case"lei":currency = new Currency(code, "Romanian Leu");
						break;
				case"inr":currency = new Currency(code, "Rupees");
						break;
				}
				return (T) currency;
			}

			@Override
			public String toString(T value) {
				
				return value.toString();
			}
			
			
		};
	}

	

}
