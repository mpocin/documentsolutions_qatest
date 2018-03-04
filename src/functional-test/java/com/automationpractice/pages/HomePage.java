package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "a.login")
    @CacheLookup
    private WebElement signIn;

    @FindBy(css = "a.logout")
    private WebElement logOut;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public RegisterPage clickOnSignIn() {
        signIn.click();
        return new RegisterPage(driver);
    }

    public HomePage clickOnLogOut() {
        logOut.click();
        return new HomePage(driver);
    }

}
