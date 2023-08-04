package com.martrust.FXRatesWidgets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.martrust.FXRatesWidgets"})
public class FxRatesWidgetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxRatesWidgetsApplication.class, args);
	}

}
