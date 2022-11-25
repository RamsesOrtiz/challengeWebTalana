package com.challenge.test.defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.challenge.process.LoginProcess.*;
import static com.challenge.process.ShoppingCartProcess.*;

public class ShoppingCartTest {

    @Given("a user visits the webpage")
    public void a_user_visits_the_webpage() {
        loginPage();
    }

    @When("add some products to the cart")
    public void add_some_products_to_the_cart() {
        addProducts();
    }

    @When("goes to cart option")
    public void goes_to_cart_option() {
        //step done in add_some_products_to_the_cart method
    }

    @Then("the cart displays each product added correctly")
    public void the_cart_displays_each_product_added_correctly() {
        Assert.assertTrue(isFirstProductDisplayed);
        Assert.assertTrue(isSecondProductDisplayed);
        Assert.assertTrue(isThirdProductDisplayed);
    }

    @After
    public void close() {
        quit();
    }
}
