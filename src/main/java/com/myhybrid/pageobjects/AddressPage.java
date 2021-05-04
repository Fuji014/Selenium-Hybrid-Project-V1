package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(xpath = "//button[@name='processAddress']")
	private WebElement btnProceedToCheckOut;

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage clickOnCheckOut() {
		Action.click(getDriver(), btnProceedToCheckOut);
		return new ShippingPage();
	}
}
