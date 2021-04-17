package com.sp.stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.sp.pageObjects.SigninPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInStep {

	public WebDriver driver;
	public SigninPage sp;

	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "//Drivers//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sp = new SigninPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		sp.setUserName(email);
		sp.setPassword(password);
	}

	@When("I press {string}")
	public void i_press(String signin) {
		sp.clickSignin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String CurrentUrl) {
		
		if (driver.getPageSource().contains("These credentials do not match our records.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(CurrentUrl, driver.getCurrentUrl());
		}
	}

	@When("user click logout link")
	public void user_click_logout_link() throws InterruptedException {

		sp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}
}
