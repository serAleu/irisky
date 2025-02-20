package ru.seraleu.irisky.config;


import feign.Client;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

@Configuration
@Slf4j
public class FeignClientConfig {
    @Bean
    public Client client(SslBundles sslBundles) {
        log.info("Configuring SSL Context for Feign Client");
        SSLContext sslContext = sslBundles.getBundle("my-client").createSslContext();
        return new Client.Default(sslContext.getSocketFactory(), HttpsURLConnection.getDefaultHostnameVerifier());
    }

    @Bean
    public Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
        return new SpringFormEncoder(new SpringEncoder(converters));
    }
}
