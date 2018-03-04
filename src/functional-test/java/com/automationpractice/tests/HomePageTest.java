package com.automationpractice.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.RegisterPage;
import com.automationpractice.setup.Setup;
import org.junit.Test;

public class HomePageTest extends Setup {

    private HomePage home;
    private RegisterPage register;

    /**
     *
     */
    @Test
    public void shouldCheckHomeTitle() {

        // given
        home = new HomePage(driver);

        // when
        String expectedTitle = home.getTitle();

        // then
        assertEquals(expectedTitle, properties.getHomeTitle());
    }

    /**
     *
     */
    @Test
    public void shouldAccessRegisterPage() {

        // given
        home = new HomePage(driver);

        // when
        register = home.clickOnSignIn();

        // then
        assertTrue(register.getPageUrl().contains("authentication"));
        assertEquals(register.getPageTitle(), properties.getRegisterTitle());
    }
}
