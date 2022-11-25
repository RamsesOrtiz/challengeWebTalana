package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

import static com.challenge.config.LoggerPage.logger;

public class AddMultipleCategoriesProcess extends ConfigPage {

    private static final Logger logger = logger(AddMultipleCategoriesProcess.class);

    public AddMultipleCategoriesProcess(WebDriver driver) {
        super(driver);
    }

    private static final By homePageLocator = By.cssSelector("a[href='index.html'][class='nav-link']");
    private static final By phonesMenuLocator = By.cssSelector("a[id='itemc'][onclick*='phone']");
    private static final By phoneProductLocator = By.cssSelector("a[href='prod.html?idp_=1'][class='hrefch']");
    private static final By addPhoneToCartLocator = By.cssSelector("a[onclick='addToCart(1)']");
    private static final By laptopsMenuLocator = By.cssSelector("a[id='itemc'][onclick*='notebook']");
    private static final By laptopProductLocator = By.cssSelector("a[href='prod.html?idp_=8'][class='hrefch']");
    private static final By addLaptopToCartLocator = By.cssSelector("a[onclick='addToCart(8)']");
    private static final By monitorsMenuLocator = By.cssSelector("a[id='itemc'][onclick*='monitor']");
    private static final By monitorProductLocator = By.cssSelector("a[href='prod.html?idp_=10'][class='hrefch']");
    private static final By addMonitorToCartLocator = By.cssSelector("a[onclick='addToCart(10)']");

    public static boolean isPhoneAdded = false;

    public static boolean isLaptopAdded = false;

    public static boolean isMonitorAdded = false;

    public static boolean isAddedToCart(String product){
        try{
            wait(3);
            manageAlert();
            logger.info("Product was added to cart");
            screenshot("Product " + product + " added OK");
            return true;
        } catch (NoAlertPresentException e){
            logger.error(e);
            screenshot("Product added error: " + e);
            return false;
        }
    }

    public static void selectPhoneProduct(){
        try {
            addProductsToCart(phonesMenuLocator, phoneProductLocator, addPhoneToCartLocator);
            isPhoneAdded = isAddedToCart("Phone Sc1");
            click(homePageLocator);
            logger.info("Phone added successfully");
        } catch (NotFoundException e){
            logger.error("Product not found: " + e);
        }
    }

    public static void selectLaptopProduct(){
        try {
            addProductsToCart(laptopsMenuLocator, laptopProductLocator, addLaptopToCartLocator);
            isLaptopAdded = isAddedToCart("Laptop Sc1");
            click(homePageLocator);
            logger.info("Laptop added successfully");
        } catch (NotFoundException e){
            logger.error("Product not found: " + e);
        }
    }

    public static void selectMonitorProduct(){
        try {
            addProductsToCart(monitorsMenuLocator, monitorProductLocator, addMonitorToCartLocator);
            isMonitorAdded = isAddedToCart("Monitor Sc1");
            click(homePageLocator);
            logger.info("Monitor added successfully");
        } catch (NotFoundException e){
            logger.error("Product not found: " + e);
        }
    }




}
