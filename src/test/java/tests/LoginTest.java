package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.DashboardPage;
import utils.ConfigReader;
import utils.ExcelUtil;

public class LoginTest extends BaseTest {

    LoginPage login;
    DashboardPage dashboard;

    @BeforeClass
    public void initPages() {
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
    }

    @Test(priority = 1)
    public void validateLoginPageUI() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(login.isBrandImageDisplayed(), "Brand image not displayed");
        softAssert.assertTrue(login.isLinkedInDisplayed(), "LinkedIn icon not displayed");
        softAssert.assertTrue(login.isFacebookDisplayed(), "Facebook icon not displayed");
        softAssert.assertTrue(login.isTwitterDisplayed(), "Twitter icon not displayed");
        softAssert.assertTrue(login.isYoutubeDisplayed(), "YouTube icon not displayed");
       // softAssert.assertTrue(login.isFooterTextDisplayed(), "Footer text not displayed");

        softAssert.assertAll(); // 🔥 MUST (without this test will always pass)
    }
    @Test(priority = 2)
    public void invalidLoginTest() throws InterruptedException {
        // 1. Open the Excel file once
        ExcelUtil.oepnExcel("src/main/resources/loginData.xlsx", "Sheet1");

        // --- TEST ROW 0 ---
        String user0 = ExcelUtil.getSpecificData(0, 0);
        String pass0 = ExcelUtil.getSpecificData(0, 1);
        login.login(user0, pass0);
        Assert.assertTrue(login.isErrorDisplayed(), "Error not shown for Row 0");
        Thread.sleep(2000);
        driver.navigate().refresh();

        // --- TEST ROW 1 ---
        String user1 = ExcelUtil.getSpecificData(1, 0);
        String pass1 = ExcelUtil.getSpecificData(1, 1);
        login.login(user1, pass1);
        Assert.assertTrue(login.isErrorDisplayed(), "Error not shown for Row 1");
        Thread.sleep(2000);
        driver.navigate().refresh();

        // --- TEST ROW 2 ---
        String user2 = ExcelUtil.getSpecificData(2, 0);
        String pass2 = ExcelUtil.getSpecificData(2, 1);
        login.login(user2, pass2);

        Assert.assertTrue(login.isErrorDisplayed(), "Error not shown for Row 2");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void validLoginTest() {

        login.login(
                ConfigReader.get("valid.username"),
                ConfigReader.get("valid.password")
        );

        Assert.assertTrue(dashboard.isDashboardDisplayed(), "Valid login failed");
    }


}