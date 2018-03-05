package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	//@CacheLookup
	private WebElement inputEmail;

	@FindBy(id = "passwd")
	//@CacheLookup
	private WebElement inputPassword;

	@FindBy(id = "SubmitLogin")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(id = "create_account_error")
    private WebElement msgErrorEmail;

	@FindBy(css = ".alert.alert-danger")
	private WebElement msgErrorWrongCredentials;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateAccountPage createAccountWithValidEmail(String email) {

		registerEmail(email);

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.urlContains("account-creation"));

		return new CreateAccountPage(driver);
	}

	public String createAccountWithInvalidEmail(String email) {

		registerEmail(email);

        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOf(msgErrorEmail));

		return msgErrorEmail.getText();
	}

	public MyAccountPage loginWithValidCredentials(String email, String password) {
		loginAs(email, password);

//		WebDriverWait wait = new WebDriverWait(driver, 500);
//		wait.until(ExpectedConditions.urlContains("my-account"));

		return new MyAccountPage(driver);
	}

	public String loginWithInvalidCredentials(String email, String password) {
		loginAs(email, password);

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOf(msgErrorWrongCredentials));

		return msgErrorWrongCredentials.getText();
	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public String getPageUrl() {

	    return driver.getCurrentUrl();
    }

	public void loginAs(String email, String password) {

		inputEmail.clear();
		inputEmail.sendKeys(email);
		inputPassword.clear();
		inputPassword.sendKeys(password);
		loginButton.click();
	}

	public void registerEmail(String email) {

        inputEmailCreate.sendKeys(email);
        createButton.click();
    }

}