package com.automationpractice.setup;

import java.util.concurrent.TimeUnit;

import com.automationpractice.config.ConfigProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FunctionalTestApplication.class)
@ContextConfiguration(classes = ConfigProperties.class)
public abstract class Setup {

	public WebDriver driver;

	@Autowired
	public ConfigProperties properties;

	@Before
	public void setup() {
		System.setProperty(properties.getFirefoxDriver(), properties.getFirefoxDriverPath());
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--headless");

		driver = new FirefoxDriver(firefoxOptions);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(properties.getBaseURL());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}