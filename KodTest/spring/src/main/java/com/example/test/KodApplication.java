package com.example.test;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KodApplication {

	@GetMapping("/symbols")
	public ArrayList<String> getCurrencies () {
		ArrayList<String> list = new ArrayList<String>();
		list.add("HUF");
		list.add("EUR");
		return list;
	}

	@GetMapping("/convert")
	public double convert (@RequestParam(value = "from", defaultValue = "HUF") String from,
							@RequestParam(value = "to", defaultValue = "EUR") String to,
							@RequestParam(value = "amount", defaultValue = "0") String amount){
		double result = Double.valueOf(amount);
		if (from == to) {
			return result;
		}else if (from == "EUR"){
			return result*330;
		}
		else {
			return result/330;
		}

	}

}
