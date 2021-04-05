package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement txtFormTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateAccountCreatePage() {
		Action.isDisplayed(driver, txtFormTitle);
	}

}
