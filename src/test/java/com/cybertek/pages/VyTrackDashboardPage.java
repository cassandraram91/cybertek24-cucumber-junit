package com.cybertek.pages;

import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VyTrackDashboardPage {

    public VyTrackDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(linkText = "Logout")
    public WebElement logoutBtn;

    public void logout(){

       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 50);
//        wait.until(ExpectedConditions.visibilityOf(fullName));
//        wait.until(ExpectedConditions.elementToBeClickable(fullName));



      //  BrowserUtils.sleep(5);
        fullName.click();
       // BrowserUtils.sleep(5);
        logoutBtn.click();
    }

}
