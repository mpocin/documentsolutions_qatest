//package com.automationpractice.tests;
//
//import static org.junit.Assert.assertEquals;
//
//import com.automationpractice.pages.MyAccountPage;
//import com.automationpractice.pages.RegisterPage;
//import com.automationpractice.setup.Setup;
//import org.springframework.beans.factory.annotation.Value;
//import org.junit.Test;
//
//public class RegisterPageTest extends Setup {
//
//	@Value("${email.default}")
//	private String userEmail;
//
//	@Value("${password.default}")
//	private String userPassword;
//
//	private MyAccountPage myAccount;
//	private RegisterPage register;
//
//	/**
//	 *
//	 */
//	@Test
//	public void shouldAccessWithValidCredentials() {
//
//		myAccount = new MyAccountPage(driver);
//		register = new RegisterPage(driver);
//
//		// when
//		register.loginAsValidUser(userEmail, userPassword);
//
//		// then
//		assertEquals(dashBoard.getDashBoardUrl(), baseURL + "?controller=my-account");
//
//	}
//
//
//	/**
//	 *
//	 */
//	@Test
//	public void deveMostrarMsgErroComCredencialInvalida() {
//
//		// given
//		senhaUsuario = "12345";
//
//		register = new RegisterPage(driver);
//
//		// when
//		register.logarComCredencialInvalida(userEmail, senhaUsuario);
//
//		// then
//		assertEquals(register.getMsgTexto(), Messages.MSG_ERROR_INVAL_CRED);
//
//	}
//
//}