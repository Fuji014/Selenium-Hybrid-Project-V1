package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement txtBoxQuantity;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement dropDownBtnSize;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement btnAddToCart;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity) {
		Action.type(txtBoxQuantity, quantity);
	}
	
	public void selectSize(String size) {
		Action.selectByVisibleText(dropDownBtnSize, size);
	}
	
	public void clickOnAddToCart() {
		Action.click(driver, btnAddToCart);
	}
	
}
