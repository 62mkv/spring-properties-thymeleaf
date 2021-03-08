package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.context.Context;
import org.thymeleaf.expression.Dates;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	SpringTemplateEngine templateEngine;

	@Value("${test-template}")
	String template;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String template = "[(${#dates.format(date, 'dd-MM-yyyy HH:mm')})]";// []

		final Context context = new Context();
		context.setVariable("date", new Date());
		String rendered = templateEngine.process(template, context);
		log.info("Template rendered as [{}]", rendered);
	}
}
