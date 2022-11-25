package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.challenge.config.LoggerPage.logger;
import static com.challenge.config.TestDataPage.*;
import static com.challenge.process.AddMultipleCategoriesProcess.isAddedToCart;

public class CheckoutFlowProcess extends ConfigPage {

    private static final Logger logger = logger(CheckoutFlowProcess.class);

    public CheckoutFlowProcess(WebDriver driver) {
        super(driver);
    }

    public static boolean isCreditCardNumberDisplayed = false;

    private static final By cartMenuLocator = By.id("cartur");
    private static final By placeOrderBtn = By.cssSelector("button[data-target='#orderModal'][type='button']");
    private static final By purchaseBtn = By.cssSelector("button[onclick*='purchase'][type='button']");
    private static final By modalConfirm = By.cssSelector("p[class*='text-muted']");
    private static final By productLocator = By.cssSelector("a[href='prod.html?idp_=2'][class='hrefch']");
    private static final By addProductToCartLocator = By.cssSelector("a[onclick='addToCart(2)']");
    private static final By nameLocator = By.cssSelector("input[id='name']");
    private static final By countryLocator = By.cssSelector("input[id='country']");
    private static final By cityLocator = By.cssSelector("input[id='city']");
    private static final By creditCardLocator = By.cssSelector("input[id='card']");
    private static final By monthLocator = By.cssSelector("input[id='month']");
    private static final By yearLocator = By.cssSelector("input[id='year']");

    public static void addProduct(){
        waitAndClick(productLocator);
        waitAndClick(addProductToCartLocator);
        isAddedToCart("Product Sc3");
    }

    public static void checkCart(){
        waitAndClick(cartMenuLocator);
        waitAndClick(placeOrderBtn);
    }

    public static void fillData(){
        clickAndType(NAME, nameLocator);
        clickAndType(COUNTRY, countryLocator);
        clickAndType(CITY, cityLocator);
        clickAndType(CARD, creditCardLocator);
        clickAndType(MONTH, monthLocator);
        clickAndType(YEAR, yearLocator);
        screenshot("Data filled Sc3");
    }

    public static void purchaseOrder(){
        waitAndClick(purchaseBtn);
    }

    public static boolean isSuccessful(){
        if(isDisplayed(modalConfirm)){
            screenshot("Purchase confirmed Sc3");
            return true;
        } else return false;
    }

    public static boolean isCorrectCardNumber(){
        return getText(modalConfirm).contains("Card Number: " + CARD);
    }
}
