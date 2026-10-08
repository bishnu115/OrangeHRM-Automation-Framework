package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.name("email");
    By password = By.name("pass");


    public void login(String user, String pass) {
        WaitUtil.waitForElementVisible(driver, username).sendKeys(user);
        WaitUtil.waitForElementVisible(driver, password).sendKeys(pass);

        driver.close();
        // WaitUtil.waitForElementClickable(driver, loginBtn).click();
    }

}