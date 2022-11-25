package com.challenge.test.defs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.challenge.process.LoginProcess.*;
import static com.challenge.process.CheckoutFlowProcess.*;

public class CheckoutFlowTest {

    @Given("a user visit the homepage")
    public void a_user_visit_the_homepage() {
        loginPage();
    }

    @When("add a product to the cart")
    public void add_a_product_to_the_cart() {
        addProduct();
    }

    @When("select Place Order option")
    public void select_place_order_option() {
        checkCart();
    }

    @When("fill all data fields")
    public void fill_all_data_fields() {
        fillData();
    }

    @When("select Purchase")
    public void select_purchase() {
        purchaseOrder();
    }

    @Then("the system response is successful")
    public void the_system_response_is_successful() {
        Assert.assertTrue(isSuccessful());
    }

    @Then("the credit card number in the confirmation popup is equal as the entered previously")
    public void the_credit_card_number_in_the_confirmation_popup_is_equal_as_the_entered_previously() {
        Assert.assertTrue(isCorrectCardNumber());
    }

    @After
    public void close() {
        quit();
    }
}
