package com.challenge.config;

import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.challenge.config.LoggerPage.*;

public class ConfigPage {

    private static final Logger logger = logger(ConfigPage.class);

    private static WebDriver driver;

    public ConfigPage(WebDriver driver) {
        ConfigPage.driver = driver;
    }

    @BeforeAll
    public static void setup(String webBrowser) {

        if (webBrowser.toLowerCase().contentEquals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
            logger.info("Setup Chrome OK");
        } else if (webBrowser.toLowerCase().contentEquals("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
            logger.info("Setup Firefox OK");
        }
    }

    public static void waitElement(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitAndClick(By locator) {
        waitElement(locator, 5);
        click(locator);
    }

    public static void addProductsToCart(By menuLocator, By productLocator, By addCartLocator){
        waitAndClick(menuLocator);
        waitAndClick(productLocator);
        waitAndClick(addCartLocator);
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }

    public static List<WebElement> itemList(By locator){
        return driver.findElements(locator);
    }

    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getText(WebElement element){
        return element.getText();
    }

    public static void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public static void clickAndType(String inputText, By locator){
        waitAndClick(locator);
        type(inputText, locator);
    }

    public static boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            logger.error(e);
            return false;
        }
    }

    public static void visit(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void quit() {
        driver.quit();
    }

    public static void manageAlert() {
        driver.switchTo().alert().accept();
    }

    @Attachment(value = "Screenshot", fileExtension = ".png")
    public static byte[] screenshot(String step) {
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scr, new File("screenshots/step-" + step + ".png"));
        } catch (IOException ignored) {
        }

        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
