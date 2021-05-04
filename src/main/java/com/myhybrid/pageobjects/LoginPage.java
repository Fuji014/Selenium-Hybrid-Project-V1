package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtBoxEmail;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement txtBoxPassword;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	private WebElement btnSignIn;

	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement txtBoxNewEmail;

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	private WebElement btnSignup;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePage login(String uname, String passwd) {
		Action.type(txtBoxEmail, uname);
		Action.type(txtBoxPassword, passwd);
		Action.click(getDriver(), btnSignIn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String passwd) {
		Action.type(txtBoxEmail, uname);
		Action.type(txtBoxPassword, passwd);
		Action.click(getDriver(), btnSignIn);
		return new AddressPage();
	}

	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(txtBoxNewEmail, newEmail);
		Action.click(getDriver(), btnSignup);
		return new AccountCreationPage();
	}
	
	

}
