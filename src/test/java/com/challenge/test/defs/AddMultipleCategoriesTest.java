package com.challenge.test.defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.challenge.process.LoginProcess.*;
import static com.challenge.process.AddMultipleCategoriesProcess.*;

public class AddMultipleCategoriesTest {
    @Given("a user visits the demoblaze webpage")
    public void a_user_visits_the_demoblaze_webpage() {
        loginPage();
    }

    @When("visit and adds a product from each category")
    public void visit_and_adds_a_product_from_each_category() {
        selectPhoneProduct();
        selectLaptopProduct();
        selectMonitorProduct();
    }

    @Then("the system response is successful for each product added")
    public void the_system_response_is_successful_for_each_product_added() {
        Assert.assertTrue(isPhoneAdded);
        Assert.assertTrue(isLaptopAdded);
        Assert.assertTrue(isMonitorAdded);
    }

    @After
    public void close() {
        quit();
    }
}
