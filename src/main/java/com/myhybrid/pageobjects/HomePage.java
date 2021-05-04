package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(), 'My wishlists')]")
	private WebElement txtWishList;

	@FindBy(xpath = "//span[contains(text(), 'Order history and details')]")
	private WebElement txtOrderHistory;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateWishList() {
		return Action.isDisplayed(getDriver(), txtWishList);
	}

	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), txtOrderHistory);
	}

	public String getCurrentURL() {
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}

}
