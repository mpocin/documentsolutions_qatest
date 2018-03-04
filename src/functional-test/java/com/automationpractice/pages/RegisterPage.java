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
	@CacheLookup
	private WebElement inputEmail;

	@FindBy(id = "passwd")
	@CacheLookup
	private WebElement inputPassword;

	@FindBy(id = "SubmitLogin")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(id = "create_account_error")
    private WebElement msgError;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateAccountPage createAccountAsValidEmail(String email) {

		registerEmail(email);

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.urlContains("account-creation"));

		return new CreateAccountPage(driver);
	}

	public String createAsInvalidEmail(String email) {

		registerEmail(email);

        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOf(msgError));

		return msgError.getText();
	}

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

	public void registerEmail(String email) {

        inputEmailCreate.sendKeys(email);
        createButton.click();
    }

}