package com.sp.stepdefinations;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStep {
	WebDriver driver;
	Scenario scenario;

	@Before()
	public void testSetup(Scenario scenario) {
		this.scenario = scenario;
		driver = new ChromeDriver();
		System.out.println("Test Enviornment Set Up");
		System.out.println("-------------------------------------------------");
		System.out.println("Executing Scenario:" + scenario.getName());
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Given("I've a valid set of data and access to sign up page")
	public void userValiditycheck() {
		System.out.println("Navigating Sign Up Page");
		driver.get("https://ijmeet.com");
		driver.manage().window().maximize();
	}

	@When("Sign Up page Displayed")
	public void userOnsignup() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));
		WebElement signup = driver.findElement(By.linkText("Sign Up"));
		signup.click();

	}

	@Then("user enters valid data on sign up page")
	public void provideData(DataTable usertable) {

		List<Map<String, String>> user = usertable.asMaps(String.class, String.class);
		for (Map<String, String> e : user) {

			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(user.get(0).get("fullname"));
			driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(user.get(1).get("companyname"));
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user.get(2).get("email"));
			driver.findElement(By.xpath("//input[@id='contact']")).sendKeys(user.get(3).get("mobilenumber"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(user.get(4).get("password"));

		}

	}

	@Then("user clicks sign up button")
	public void user_clicks_sign_up_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
	}

}
