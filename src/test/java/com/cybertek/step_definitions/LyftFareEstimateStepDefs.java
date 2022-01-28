package com.cybertek.step_definitions;

import com.cybertek.pages.LyftFareEstimatePage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class LyftFareEstimateStepDefs {

    LyftFareEstimatePage fareEstimatePage = new LyftFareEstimatePage();

    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("lyft.fare.estimate.url"));
        String expectedTitle = "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals(expectedTitle,actualTitle);
    }

    @When("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String pickUpLocation) {

        //fareEstimatePage.pickUp.sendKeys(pickUpLocation);
        fareEstimatePage.enterPickUpLocation(pickUpLocation);
    }

    @And("User enters {string} to drop-off address")
    public void user_enters_to_drop_address(String dropOffLocation) {

        fareEstimatePage.dropOff.sendKeys(dropOffLocation);
    }

    @When("User clicks on get estimate button")
    public void user_clicks_on_get_estimate_button() {

       // Actions actions = new Actions(Driver.getDriver());
     //   actions.moveToElement(fareEstimatePage.getEstimateBtn).doubleClick().build().perform();

        fareEstimatePage.getEstimateBtn.click();
        BrowserUtils.sleep(3);
        fareEstimatePage.getEstimateBtn.click();
    }

    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {

        assertTrue(fareEstimatePage.rideTypeHeader.isDisplayed());
        System.out.println("Lyft Estimated Price: " + fareEstimatePage.liftPrice.getText());
    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {

        assertTrue("Error message is not displayed", fareEstimatePage.errorMsg.isDisplayed());
    }
}
