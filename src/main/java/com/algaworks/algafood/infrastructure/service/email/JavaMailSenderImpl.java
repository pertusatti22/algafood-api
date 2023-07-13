package com.algaworks.algafood.infrastructure.service.email;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaMailSenderImpl {

    AWSCredentialsProvider awsCredentialsProvider = DefaultAWSCredentialsProviderChain.getInstance();
    
}
