package com.tts.weatherapp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tts.weatherapp.model.Response;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;
	
	public Response getForecast(String zipCode) {
		UriComponentsBuilder uri =  UriComponentsBuilder.newInstance();
		
		builder.Scheme("https");
		builder.Host("api.openweathermap.ord");
		builder.setpath("/data/2.5/weather");
		builder.addParameter("zip", zipCode+",us");
		builder.addParameter("units","imperial");
		builder.addParameter("appid","apiKey");
		URL url = builder.build().toURL();

		
		String url = "http:api.openweathermap.org/data/2.5/weather?zip=" +
				zipCode + ",us&units=imperial&appid" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		
		Response response;
		try {
		   response = restTemplate.getForObject(url, Response.class);
		}
				catch (HttpClientErrorException ex) {
				    response = new Response();	
				    response.setName("error");
				} 
				    return response;
		
	}

}
