package com.inetBanking.testcases;

import org.testng.annotations.Test;

import com.inetBanking.utilities.BaseTest;
import com.inetBanking.utilities.ReadConfig;
import com.intBanking.pages.HomePage;
import com.intBanking.pages.LoginPage;
import com.intBanking.pages.ValidationWithdrawalPage;
import com.intBanking.pages.WithdrawalPage;

public class TC_WithdrawalTest_005 extends BaseTest {
	ReadConfig readconfig = new ReadConfig();

	@Test
	public void withdrawal() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(readconfig.getUsername());
		logger.info("username provided");
		loginPage.setPassword(readconfig.getPassword());
		logger.info("password provided");

		HomePage homePage = loginPage.clickSubmit();
		WithdrawalPage withdrawalPage = homePage.clickWithdrawal();
		withdrawalPage.setAccountNo("1234");
		logger.info("Account_N° provided");
		withdrawalPage.setAmmount("200");
		logger.info("Ammount provided");
		withdrawalPage.setDescription("Fund deposit");
		logger.info("description provided");
		ValidationWithdrawalPage validationDepositPage = withdrawalPage.clickSubmit();
		validationDepositPage.driver.switchTo().alert().accept();

	}
}
