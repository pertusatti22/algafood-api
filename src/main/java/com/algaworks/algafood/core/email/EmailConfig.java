package com.algaworks.algafood.core.email;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        AWSCredentialsProvider awsCredentialsProvider = DefaultAWSCredentialsProviderChain.getInstance();
        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(environment.getProperty("spring.mail.port", Integer.class));
        mailSender.setUsername(awsCredentialsProvider.getCredentials().getAWSAccessKeyId().toString());
        mailSender.setPassword(awsCredentialsProvider.getCredentials().getAWSSecretKey().toString());

        return mailSender;
    }
}
