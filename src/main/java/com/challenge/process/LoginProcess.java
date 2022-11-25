package com.challenge.process;

import com.challenge.config.ConfigPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

import static com.challenge.config.LoggerPage.logger;
import static com.challenge.config.PropertiesPage.*;

public class LoginProcess extends ConfigPage {

    private static final Logger logger = logger(LoginProcess.class);

    private static final By loginLocator = By.id("login2");
    private static final By usernameLocator = By.id("loginusername");
    private static final By passwordLocator = By.id("loginpassword");
    private static final By loginSubmitLocator = By.cssSelector("[class='btn btn-primary'][onclick='logIn()']");
    private static final By logoutLocator = By.id("logout2");

    public LoginProcess(WebDriver driver) {
        super(driver);
    }

    public static void visitWebPage() {
        setup(browser);
        visit(URL);
        logger.info("Web visited successfully: " + URL);
    }

    public static void selectLoginOption() {
        waitAndClick(loginLocator);
    }

    public static void fillUserData() {
        waitAndClick(usernameLocator);
        type(USERNAME, usernameLocator);
        type(PASSWORD, passwordLocator);
        click(loginSubmitLocator);
        logger.info("Data filled OK");
        wait(5);
    }

    public static void loginPage(){
        try {
            visitWebPage();
            selectLoginOption();
            fillUserData();
            logger.info("Login successfully");
        } catch (NotFoundException e){
            logger.error("Login failed:" + e);
        }
    }

    public static void logoutPage(){
        waitAndClick(logoutLocator);
    }
}
