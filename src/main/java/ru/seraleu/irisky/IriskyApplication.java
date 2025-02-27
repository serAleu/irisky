package ru.seraleu.irisky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class IriskyApplication {

	public static void main(String[] args) {
		SpringApplication.run(IriskyApplication.class, args);
		log.info("I-Risky application successfully started!");
	}

}
