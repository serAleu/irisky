package ru.seraleu.irisky;

import org.springframework.ai.autoconfigure.openai.OpenAiAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ru.seraleu.irisky.config.GigaChatProperties;

@EnableConfigurationProperties(GigaChatProperties.class) //
@SpringBootApplication(exclude = {OpenAiAutoConfiguration.class})
@EnableFeignClients
public class IriskyApplication {

	public static void main(String[] args) {
		SpringApplication.run(IriskyApplication.class, args);
	}

}
