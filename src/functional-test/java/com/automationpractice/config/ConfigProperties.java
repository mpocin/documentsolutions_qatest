package com.automationpractice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:messages-validation.properties"})
public class ConfigProperties {

    @Value("${firefox.driver}")
    private String firefoxDriver;

    @Value("${chrome.driver}")
    private String chromeDriver;

    @Value("${firefox.driver.path}")
    private String firefoxDriverPath;

    @Value("${chrome.driver.path}")
    private String chromeDriverPath;

    @Value("${base.url}")
    public String baseURL;

    @Value("${email.default}")
    private String emailDefault;

    @Value("${password.default}")
    private String passwordDefault;

    @Value("${msg.error.register}")
    private String msgErrorRegister;

    @Value("${home.title}")
    private String homeTitle;

    @Value("${register.title}")
    private String registerTitle;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getFirefoxDriver() {
        return firefoxDriver;
    }

    public void setFirefoxDriver(String firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    public String getFirefoxDriverPath() {
        return firefoxDriverPath;
    }

    public void setFirefoxDriverPath(String firefoxDriverPath) {
        this.firefoxDriverPath = firefoxDriverPath;
    }

    public String getChromeDriver() {
        return chromeDriver;
    }

    public void setChromeDriver(String chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public void setChromeDriverPath(String chromeDriverPath) {
        this.chromeDriverPath = chromeDriverPath;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getEmailDefault() {
        return emailDefault;
    }

    public void setEmailDefault(String emailDefault) {
        this.emailDefault = emailDefault;
    }

    public String getPasswordDefault() {
        return passwordDefault;
    }

    public void setPasswordDefault(String passwordDefault) {
        this.passwordDefault = passwordDefault;
    }

    public String getMsgErrorRegister() {
        return msgErrorRegister;
    }

    public void setMsgErrorRegister(String msgErrorRegister) {
        this.msgErrorRegister = msgErrorRegister;
    }

    public String getHomeTitle() {
        return homeTitle;
    }

    public void setHomeTitle(String homeTitle) {
        this.homeTitle = homeTitle;
    }

    public String getRegisterTitle() {
        return registerTitle;
    }

    public void setRegisterTitle(String registerTitle) {
        this.registerTitle = registerTitle;
    }
}
