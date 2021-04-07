package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement btnProceedToCheckOut;

	public AddressPage() {
		PageFactory.initElements(driver, this);
	}

	public ShippingPage clickOnCheckOut() {
		Action.click(driver, btnProceedToCheckOut);
		return new ShippingPage();
	}
}
