package com.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Configuration
	@EnableAutoConfiguration
	class DateTimeConfig {
		@Bean
		public FormattingConversionService conversionService(){
			DefaultFormattingConversionService conversionService= new DefaultFormattingConversionService(false);
			DateFormatterRegistrar registrar = new DateFormatterRegistrar();
			registrar.setFormatter(new DateFormatter("dd-MM-yyyy"));
			registrar.registerFormatters(conversionService);
			return conversionService;
		}
	}
}
