package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpartanHomePage extends BasePage {

    @FindBy(linkText = "Web Data")
    public WebElement webDataLink;

}
