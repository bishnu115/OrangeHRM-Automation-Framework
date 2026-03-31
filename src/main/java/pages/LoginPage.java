package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By errorMsg = By.xpath("//p[text()='Invalid credentials']");
    By brandImage = By.xpath("//img[contains(@alt,'company-branding')]");
    By linkedin = By.xpath("//a[contains(@href,'linkedin')]");
    By facebook = By.xpath("//a[contains(@href,'facebook')]");
    By twitter = By.xpath("//a[contains(@href,'twitter')]");
    By youtube = By.xpath("//a[contains(@href,'youtube')]");
    By footerText = By.xpath("//p[contains(text(),'OrangeHRM')]");

    public void login(String user, String pass) {
        WaitUtil.waitForElementVisible(driver, username).sendKeys(user);
        WaitUtil.waitForElementVisible(driver, password).sendKeys(pass);
        WaitUtil.waitForElementClickable(driver, loginBtn).click();
    }

    public boolean isErrorDisplayed() {
        return WaitUtil.waitForElementVisible(driver, errorMsg).isDisplayed();
    }

    public boolean isBrandImageDisplayed() {
        return WaitUtil.waitForElementVisible(driver, brandImage).isDisplayed();
    }

    public boolean isLinkedInDisplayed() {
        return WaitUtil.waitForElementVisible(driver, linkedin).isDisplayed();
    }

    public boolean isFacebookDisplayed() {
        return WaitUtil.waitForElementVisible(driver, facebook).isDisplayed();
    }

    public boolean isTwitterDisplayed() {
        return WaitUtil.waitForElementVisible(driver, twitter).isDisplayed();
    }

    public boolean isYoutubeDisplayed() {
        return WaitUtil.waitForElementVisible(driver, youtube).isDisplayed();
    }

    public boolean isFooterTextDisplayed() {
        return WaitUtil.waitForElementVisible(driver, footerText).isDisplayed();
    }
}