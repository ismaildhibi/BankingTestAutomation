package com.intBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidationAddCustomerPage {
	private WebDriver driver;
	private String text;
	private By textSuccess = By.className("heading3");

	public ValidationAddCustomerPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getText() {
		String title = driver.findElement(textSuccess).getText();
		return title;
	}

}
