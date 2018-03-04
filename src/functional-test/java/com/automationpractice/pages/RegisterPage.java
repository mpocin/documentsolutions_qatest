package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private WebDriver driver;

	@FindBy(id = "email_create")
	@CacheLookup
	private WebElement inputEmailCreate;

	@FindBy(css = "input:invalid")
	private WebElement inputInvalid;

	@FindBy(id = "SubmitCreate")
	@CacheLookup
	private WebElement createButton;

	@FindBy(id = "email")
	@CacheLookup
	private WebElement inputEmail;

	@FindBy(id = "passwd")
	@CacheLookup
	private WebElement inputPassword;

	@FindBy(id = "SubmitLogin")
	@CacheLookup
	private WebElement loginButton;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public CreateAccountPage createAsValidEmail(String email) {
//
//		this.inputEmailCreate.sendKeys(email);
//
//		return new CreateAccountPage(driver);
//	}
//
//	public RegisterPage createAsInvalidUser(String email) {
//
//		this.inputEmailCreate.sendKeys(email);
//
//		return new RegisterPage(driver);
//	}
//
//	public MyAccountPage loginAsValidUser(String username, String password) {
//
//		loginAs(username, password);
//
//		return new MyAccountPage(driver);
//
//	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public String getPageUrl() {

	    return driver.getCurrentUrl();
    }

	public void loginAs(String username, String password) {

		inputEmail.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();
	}

}