package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement checkBoxTermsOfService;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement btnProceedToCheckOut;

	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkTermsOfService() {
		Action.click(driver, checkBoxTermsOfService);
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		Action.click(driver, btnProceedToCheckOut);
		return new PaymentPage();
	}
	
}
