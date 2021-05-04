package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(xpath = "//input[@id='cgv']")
	private WebElement checkBoxTermsOfService;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	private WebElement btnProceedToCheckOut;

	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTermsOfService() {
		Action.click(getDriver(), checkBoxTermsOfService);
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		Action.click(getDriver(), btnProceedToCheckOut);
		return new PaymentPage();
	}
	
}
