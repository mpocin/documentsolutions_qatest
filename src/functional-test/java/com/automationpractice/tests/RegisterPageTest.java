package com.automationpractice.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.RegisterPage;
import com.automationpractice.setup.Setup;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageTest extends Setup {

    private HomePage home;
	private RegisterPage register;
	private CreateAccountPage createAccount;

	@Before
    public void setupRegisterPage() {
	    home = new HomePage(driver);
	    register = home.clickOnSignIn();
    }

	/**
	 *
	 */
	@Test
	public void shouldAccessCreateAccountWithValidCredentials() {

		properties.setEmailDefault("test@bla.com");

		// when
		createAccount = register.createAccountAsValidEmail(properties.getEmailDefault());

		// then
		assertTrue(createAccount.getPageUrl().contains("account-creation"));

	}


	/**
	 *
	 */
	@Test
	public void shouldShowMsgWithInvalidEmail() {

	    // given
        properties.setEmailDefault("test@foo");

		// when
        String expectedMsg = register.createAsInvalidEmail(properties.getEmailDefault());

		// then
		assertEquals(expectedMsg, properties.getMsgErrorRegister());

	}

}