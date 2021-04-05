package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtBoxEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtBoxPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnSignIn;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement txtBoxNewEmail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement btnSignup;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String passwd) {
		Action.type(txtBoxEmail, uname);
		Action.type(txtBoxPassword, passwd);
		Action.click(driver, btnSignIn);
		return new HomePage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(txtBoxNewEmail, newEmail);
		return new AccountCreationPage();
	}
	
	
	
	
}
 