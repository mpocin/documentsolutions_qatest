package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {

        return driver.getCurrentUrl();
    }
}
