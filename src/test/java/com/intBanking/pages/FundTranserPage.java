package com.intBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTranserPage {
	public WebDriver driver;
	private By payersField = By.name("payersaccount");
	private By payeerField = By.name("payeeaccount");
	private By ammountField = By.name("ammount");
	private By descField = By.name("desc");
	private By submitButton = By.name("AccSubmit");

	public FundTranserPage(WebDriver driver) {
		super();
		this.driver = driver;

	}

	public void setPayers(String payers) {
		driver.findElement(payersField).sendKeys(payers);
	}

	public void setPayeer(String payeer) {
		driver.findElement(payeerField).sendKeys(payeer);
	}

	public void setAmmount(String ammount) {
		driver.findElement(ammountField).sendKeys(ammount);
	}

	public void setDescription(String descreption) {
		driver.findElement(descField).sendKeys(descreption);
	}

	public ValidationFundTransferPage clickSubmit() {
		driver.findElement(submitButton).click();
		return new ValidationFundTransferPage(driver);
	}

}
