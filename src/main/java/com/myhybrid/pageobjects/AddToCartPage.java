package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	private WebElement txtBoxQuantity;

	@FindBy(xpath = "//select[@id='group_1']")
	private WebElement dropDownBtnSize;

	@FindBy(xpath = "//span[contains(text(), 'Add to cart')]")
	private WebElement btnAddToCart;

	@FindBy(xpath = "//div[@id='layer_cart']//h2//i")
	private WebElement txtAddToCartMessage;

	@FindBy(xpath = "//span[contains(text(), 'Proceed to checkout')]")
	private WebElement btnProceedToCheckout;

	@FindBy(xpath = "//iframe[@class='fancybox-iframe']")
	private WebElement iframeAddToCart;

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean switchIframe(String windowTitle, int count) {
		System.out.println("wewww");
		return Action.switchWindowByTitle(getDriver(), windowTitle, count);
	}

	public void enterQuantity(String quantity) {
		Action.type(txtBoxQuantity, quantity);
	}

	public void selectSize(String size) {
		Action.selectByVisibleText(dropDownBtnSize, size);
	}

	public void clickOnAddToCart() {
		Action.click(getDriver(), btnAddToCart);
	}

	public boolean validateAddToCart() {
		Action.fluentWait(getDriver(), txtAddToCartMessage, 10);
		return Action.isDisplayed(getDriver(), txtAddToCartMessage);
	}

	public OrderPage clickOnProceedToCheckout() throws Exception {
		Action.fluentWait(getDriver(), btnProceedToCheckout, 10);
		Action.JSClick(getDriver(), btnProceedToCheckout);
		return new OrderPage();
	}

}
