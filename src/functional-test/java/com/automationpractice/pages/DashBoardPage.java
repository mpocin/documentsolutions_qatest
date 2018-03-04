package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	private WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getDashBoardUrl() {
		return driver.getCurrentUrl() + "?controller=my-account";
	}

}
