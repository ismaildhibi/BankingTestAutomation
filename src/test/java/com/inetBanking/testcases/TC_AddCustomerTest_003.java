package com.inetBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.utilities.BaseTest;
import com.inetBanking.utilities.ReadConfig;
import com.intBanking.pages.AddCustomerPage;
import com.intBanking.pages.HomePage;
import com.intBanking.pages.LoginPage;
import com.intBanking.pages.ValidationAddCustomerPage;

public class TC_AddCustomerTest_003 extends BaseTest {
	ReadConfig readconfig = new ReadConfig();

	@Test
	public void addNewCustomer() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(readconfig.getUsername());
		logger.info("username provided");
		loginPage.setPassword(readconfig.getPassword());
		logger.info("password provided");
		HomePage homePage = loginPage.clickSubmit();
		AddCustomerPage addCustomerPage = homePage.clickAddCustomer();
		addCustomerPage.setName("user");
		logger.info("username of customer provided");
		addCustomerPage.setGender();
		logger.info("gender of customer provided");
		addCustomerPage.setBirthday("12", "12", "1989");
		logger.info("birthday of customer provided");
		addCustomerPage.setAddress("From Tunisia");
		logger.info("address of customer provided");
		addCustomerPage.setCity("Tunis");
		logger.info("city of customer provided");
		addCustomerPage.setState("married");
		logger.info("state of customer provided");
		addCustomerPage.setPin("123456");
		logger.info("pin of customer provided");
		addCustomerPage.setPhone("12345454");
		logger.info("phone-number of customer provided");
		String email = addCustomerPage.generateRandomEmail() + "123@gmail.com";
		addCustomerPage.setEmail(email);
		logger.info("email of customer provided " + email);
		addCustomerPage.setPassword("123abdou");
		logger.info("password of customer provided");

		ValidationAddCustomerPage validationAddCustomerPage = addCustomerPage.clickSubmit();
		String text = validationAddCustomerPage.getText();
		Assert.assertTrue(text.contains("Successfully"));
		logger.warn("pass");

	}

}
