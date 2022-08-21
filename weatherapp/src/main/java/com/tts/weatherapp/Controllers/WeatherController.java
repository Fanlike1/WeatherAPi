package com.tts.weatherapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.weatherapp.model.Request;
import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.services.WeatherService;

@Controller
public class WeatherController {
	
	// we want  a copy of weather services 
	@Autowired
	private WeatherService weatherService;
	
	// in SB we are frequently not going to construct 
	// our own objects. instead we are going to tell SB
	// how to make an object and later we can  just as SB
	//for an object and we don't  have to instatiate it ourselves
	// use @Autowired annotation to ask for the objects.
	
	
	 @RequestMapping(path="/", method=RequestMethod.GET)  // respond to get requests to "/ " only
	//@ResponseBody
	@GetMapping(path="/")
	public String getIndex(Model model) {
		Response response= weatherService.getForecast("85102");
		
		// we have to get response to web page
		// to do that we have to store response somewhere that
		// the web page template can get to. 
		Request request = new Request();
		request.setZipCode("99999-totally-invlid");
		model.addAttribute("request, request");
		model.addAttribute("data",response);
		
		return"index";
	}
	 @PostMapping(path="/")
	 public String postIndex(Request request, Model model) {
			Response response= weatherService.getForecast(request.zipCode());
			model.addAttribute("data", response);
			return"index";

		 
	 }
	
}
 