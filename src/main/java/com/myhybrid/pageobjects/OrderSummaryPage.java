package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class OrderSummaryPage extends BaseClass {
	
	@FindBy(xpath="//span[contains(text(), 'I confirm my order')]")
	WebElement btnConfirmMyOrder;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		Action.click(driver, btnConfirmMyOrder);
		return new OrderConfirmationPage();
	}
	
	
	
}
