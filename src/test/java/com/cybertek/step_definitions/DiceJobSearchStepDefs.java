package com.cybertek.step_definitions;

import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiceJobSearchStepDefs {

    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        System.out.println("USER IS ON DICE HOMEPAGE...");
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));

    }

    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {
        System.out.println("USER ENTERS JAVA AND 32826...");
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement keyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("typeaheadInput")));
        //WebElement keyword = Driver.getDriver().findElement(By.id("typeaheadInput"));
        WebElement zipCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("google-location-search")));
       // WebElement zipCode = Driver.getDriver().findElement(By.id("google-location-search"));
        keyword.sendKeys("java");
        zipCode.sendKeys("76655" + Keys.ENTER);
    }

    @Then("User should see search results")
    public void user_should_see_search_results() {
        System.out.println("USER SHOULD SEARCH RESULTS...");
        WebElement jobCount = Driver.getDriver().findElement(By.id("totalJobCount"));
        System.out.println("JOB COUNT = " + jobCount.getText());
        Driver.closeDriver();
    }

}
