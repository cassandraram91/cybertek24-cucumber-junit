package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyAllCategoriesPage;
import com.cybertek.pages.EtsyHomePage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsySearchStepDefs {

    WebDriver driver;

    @Given("User is on etsy homepage")
    public void user_is_on_etsy_homepage() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("etsy.url"));
    }

    @Then("Page title should be as expected")
    public void page_title_should_be_as_expected() {
        Assert.assertEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", driver.getTitle());     //different than testng in that the assert has expected first then actual
    }

    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
        EtsyHomePage homePage = new EtsyHomePage();
        homePage.searchFor("wooden spoon");
    }

    @Then("Page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
        BrowserUtils.sleep(3);
        Assert.assertTrue("title did not match",driver.getTitle().startsWith("Wooden spoon"));
    }


    @When("User searches for empty value")
    public void userSearchesForEmptyValue() {
        EtsyHomePage homePage = new EtsyHomePage();
        homePage.searchFor(""); //or can do Strings.EMPTY
    }


    @Then("All categories should be displayed")
    public void allCategoriesShouldBeDisplayed() {
        //wait for title to change to all categories
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.titleIs("All categories | Etsy"));
        Assert.assertEquals("All categories | Etsy", driver.getTitle());

        EtsyAllCategoriesPage allCategoriesPage = new EtsyAllCategoriesPage();
        Assert.assertTrue(allCategoriesPage.allCategoriesHeader.isDisplayed());
    }
}
