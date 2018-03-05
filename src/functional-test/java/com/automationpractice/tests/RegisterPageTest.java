package com.automationpractice.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.RegisterPage;
import com.automationpractice.setup.Setup;
import org.junit.Before;
import org.junit.Test;

public class RegisterPageTest extends Setup {

    private HomePage home;
	private RegisterPage register;
	private CreateAccountPage createAccount;
	private MyAccountPage myAccount;

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
		createAccount = register.createAccountWithValidEmail(properties.getEmailDefault());

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
        String expectedMsg = register.createAccountWithInvalidEmail(properties.getEmailDefault());

		// then
		assertEquals(expectedMsg, properties.getMsgErrorRegister());

	}

	/**
	 *
	 */
//	@Test
//	public void shouldAccessMyAccountPageWithValidCredentials() {
//
//		// when
//		myAccount = register.loginWithValidCredentials(properties.getEmailDefault(), properties.getPasswordDefault());
//
//		// then
//		assertTrue(myAccount.getPageUrl().contains("my-account"));
//		assertEquals(myAccount.getTitle(), properties.getMyAccountTitle());
//	}

	/**
	 *
	 */
	@Test
	public void shouldShowErrorMsgWithInvalidCredentials() {

		// given
		properties.setPasswordDefault("bla");

		// when
		String expectedMsg = register.loginWithInvalidCredentials(properties.getEmailDefault(),
				properties.getPasswordDefault());

		// then
		assertTrue(expectedMsg.contains("error"));
	}
}