package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement anchorTagBankWirePaymentMethod;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement anchorTagChequePaymentMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnBankWire() {
		Action.click(driver, anchorTagBankWirePaymentMethod);
		return new OrderSummaryPage();
	}
	
	
}
