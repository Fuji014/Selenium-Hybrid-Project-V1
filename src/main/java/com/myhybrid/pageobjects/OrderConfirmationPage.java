package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//div[@class='box']//p//strong[contains(text(), 'Your order on My Store is complete.')]")
	WebElement txtConfirmMessage;

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmMessage() {
		String confirmMessage = txtConfirmMessage.getText();
		return confirmMessage;
	}
	
	

}
