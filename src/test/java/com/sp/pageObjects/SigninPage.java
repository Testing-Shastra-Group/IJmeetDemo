package com.sp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SigninPage {

	WebDriver ldriver;
	

	public SigninPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id ="email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(name ="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[contains(text() , 'Sign In')]")
	@CacheLookup
	WebElement lnSignin;
	
	@FindBy(xpath = "//a[@class='dropdown-item']")
	@CacheLookup
	WebElement lnkLogout;
	
	@FindBy(id="profileDropdown")
	@CacheLookup
	WebElement profileDropdown;

	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickSignin() {
		lnSignin.click();
	}

	public void clickLogout() throws InterruptedException {
		profileDropdown.click();
		Thread.sleep(2000);
		lnkLogout.click();
    	 
	}

}
