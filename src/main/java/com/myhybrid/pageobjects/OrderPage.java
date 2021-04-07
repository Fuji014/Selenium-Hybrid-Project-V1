package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(xpath="//span[@class='price']//span[@class='price']")
	WebElement txtUniPrice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement txtTotalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement btnProceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitPrice = txtUniPrice.getText();
		String removeCharUnitPrice = unitPrice.replaceAll("[^a-zA-Z0-9]", "");
		double convertedToDoubleUnitPrice = Double.parseDouble(removeCharUnitPrice);
		return convertedToDoubleUnitPrice/100;
		
	}
	
	public double getTotalPrice() {
		String totalPrice = txtTotalPrice.getText();
		String removeCharTotalPrice = totalPrice.replaceAll("[^a-zA-Z0-9]", "");
		double convertedToDoubleTotalPrice = Double.parseDouble(removeCharTotalPrice);
		return convertedToDoubleTotalPrice/100;
	}
	
	public LoginPage clickCheckOut() {
		Action.click(driver, btnProceedToCheckOut);
		return new LoginPage();
	}

}
