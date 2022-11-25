package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.challenge.config.LoggerPage.logger;
import static com.challenge.process.AddMultipleCategoriesProcess.isAddedToCart;

public class ShoppingCartProcess extends ConfigPage {

    private static final Logger logger = logger(ShoppingCartProcess.class);

    public ShoppingCartProcess(WebDriver driver) {
        super(driver);
    }

    public static boolean isFirstProductDisplayed = false;
    public static boolean isSecondProductDisplayed = false;
    public static boolean isThirdProductDisplayed = false;

    private static final By homePageLocator = By.cssSelector("a[href='index.html'][class='nav-link']");
    private static final By cartMenuLocator = By.id("cartur");
    private static final By productsTableInCart = By.id("tbodyid");
    private static final By firstProductLocator = By.cssSelector("a[href='prod.html?idp_=2'][class='hrefch']");
    private static final By addFirstProductToCartLocator = By.cssSelector("a[onclick='addToCart(2)']");
    private static final By secondProductLocator = By.cssSelector("a[href='prod.html?idp_=6'][class='hrefch']");
    private static final By addSecondProductToCartLocator = By.cssSelector("a[onclick='addToCart(6)']");
    private static final By thirdProductLocator = By.cssSelector("a[href='prod.html?idp_=8'][class='hrefch']");
    private static final By addThirdProductToCartLocator = By.cssSelector("a[onclick='addToCart(8)']");

    private static boolean addProduct(By productLocator, By addCartLocator, String product) {
        wait(2);
        boolean result = false;
        String productAdded = getText(productLocator);
        waitAndClick(productLocator);
        waitAndClick(addCartLocator);
        if (isAddedToCart(product)) {
            click(cartMenuLocator);
            if (isDisplayed(productsTableInCart)) {
                int i = 1;
                while (i > 0) {
                    By elementList = By.xpath("//*[@id='tbodyid']/tr[" + i + "]/td[2]");
                    if (isDisplayed(elementList)) {
                        if (getText(elementList).contentEquals(productAdded)) {
                            result = true;
                            screenshot(product + " in the Shopping Cart Sc2");
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        wait(2);
        click(homePageLocator);
        return result;
    }

    private static void addFirstProduct() {
        try {
            isFirstProductDisplayed = addProduct(firstProductLocator, addFirstProductToCartLocator, "First Product Sc2");
            logger.info("First product added successfully");
        } catch (NotFoundException e) {
            logger.error("First product not found " + e);
        }
    }

    private static void addSecondProduct() {
        try {
            isSecondProductDisplayed = addProduct(secondProductLocator, addSecondProductToCartLocator, "Second Product Sc2");
            logger.info("Second product added successfully");
        } catch (NotFoundException e) {
            logger.error("Second product not found " + e);
        }
    }

    private static void addThirdProduct() {
        try {
            isThirdProductDisplayed = addProduct(thirdProductLocator, addThirdProductToCartLocator, "Third Product Sc2");
            logger.info("Third product added successfully");
        } catch (NotFoundException e) {
            logger.error("Third product not found " + e);
        }
    }

    public static void addProducts(){
        addFirstProduct();
        addSecondProduct();
        addThirdProduct();
    }
}
