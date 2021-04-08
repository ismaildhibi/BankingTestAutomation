package com.intBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public AddCustomerPage clickAddCustomer() {
		clickLink("New Customer");
		return new AddCustomerPage(driver);
	}

	public DepositInputPage clickDiposit() {
		clickLink("Deposit");
		return new DepositInputPage(driver);
	}

	public WithdrawalPage clickWithdrawal() {
		clickLink("Withdrawal");
		return new WithdrawalPage(driver);
	}

	public FundTranserPage clickFundTranser() {
		clickLink("Fund Transfer");
		return new FundTranserPage(driver);
	}

	public CustomisedStatementPage clickCustomisedStatement() {
		clickLink("Customised Statement");
		return new CustomisedStatementPage(driver);
	}

	private void clickLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
}
