package com.api.estate.api.common.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {


    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        String pwd = System.getProperty("jasypt.encryptor.password"); // VM

        if (pwd == null || pwd.isEmpty()) {
            pwd = System.getenv("JASYPT_ENCRYPTOR_PASSWORD");
        }

        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(pwd);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setConfig(config);
        return encryptor;
    }
}