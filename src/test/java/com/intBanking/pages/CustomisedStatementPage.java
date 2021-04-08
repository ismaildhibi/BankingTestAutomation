package com.intBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomisedStatementPage {
	public WebDriver driver;
	private By accountNoField = By.name("accountno");
	private By fdateField = By.name("fdate");
	private By tdateField = By.name("tdate");
	private By amountlowerlimitField = By.name("amountlowerlimit");
	private By numtransactionField = By.name("numtransaction");
	private By submitButton = By.name("AccSubmit");

	public CustomisedStatementPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void setAccountNo(String accountNo) {
		driver.findElement(accountNoField).sendKeys(accountNo);
	}

	public void setFdate(String d, String m, String y) {
		driver.findElement(fdateField).sendKeys(d, m, y);
	}

	public void setTdate(String d, String m, String y) {
		driver.findElement(tdateField).sendKeys(d, m, y);
	}

	public void setAmountLowerLimit(String amountlimit) {
		driver.findElement(amountlowerlimitField).sendKeys(amountlimit);
	}

	public void setNumTransactionField(String numtransac) {
		driver.findElement(numtransactionField).sendKeys(numtransac);
	}

	public ValidationCustomisedStatementPage clickSubmit() {
		driver.findElement(submitButton).click();
		return new ValidationCustomisedStatementPage(driver);
	}
}
