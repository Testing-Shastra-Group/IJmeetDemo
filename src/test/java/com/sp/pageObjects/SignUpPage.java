package com.sp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	WebDriver ldriver;

	public SignUpPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "full name")
	WebElement txtFullName;

	@FindBy(name = "company name")
	WebElement txtCompanyName;

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(name = "mobile number")
	WebElement txtMobileNumber;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement InSignUp;

	public void setFullName(String name) {
		txtFullName.clear();
		txtFullName.sendKeys(name);
	}

	public void setCompanyName(String cname) {
		txtCompanyName.clear();
		txtCompanyName.sendKeys(cname);

	}

	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setMobileNumber(String number) {
		txtMobileNumber.clear();
		txtMobileNumber.sendKeys(number);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickSignUp() {
		InSignUp.click();
	}

}
