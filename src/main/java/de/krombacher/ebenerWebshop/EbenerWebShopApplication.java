package de.krombacher.ebenerWebshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.krombacher")
@EnableAutoConfiguration
public class EbenerWebShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbenerWebShopApplication.class, args);
	}

}
