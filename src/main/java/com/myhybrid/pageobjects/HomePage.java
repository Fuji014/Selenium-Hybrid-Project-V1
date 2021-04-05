package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//span[contains(text(), 'My wishlists')]")
	WebElement txtWishList;
	
	@FindBy(xpath="//span[contains(text(), 'Order history and details')]")
	WebElement txtOrderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateWishList() {
		Action.isDisplayed(driver, txtWishList);
	}
	
	public void validateOrderHistory() {
		Action.isDisplayed(driver, txtOrderHistory);
	}

}
