package com.inetBanking.testcases;

import org.testng.annotations.Test;

import com.inetBanking.utilities.BaseTest;
import com.inetBanking.utilities.ReadConfig;
import com.intBanking.pages.DepositInputPage;
import com.intBanking.pages.HomePage;
import com.intBanking.pages.LoginPage;
import com.intBanking.pages.ValidationDepositPage;

public class TC_DepositTest_004 extends BaseTest {
	ReadConfig readconfig = new ReadConfig();

	@Test
	public void deposit() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(readconfig.getUsername());
		loginPage.setPassword(readconfig.getPassword());
		HomePage homePage = loginPage.clickSubmit();
		DepositInputPage depositInputPage = homePage.clickDiposit();
		depositInputPage.setAccountNo("1234");
		depositInputPage.setAmmount("200");
		depositInputPage.setDescription("Fund deposit");
		ValidationDepositPage validationDepositPage = depositInputPage.clickSubmit();
		validationDepositPage.driver.switchTo().alert().accept();

	}
}
