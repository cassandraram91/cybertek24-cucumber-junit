package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpartansDataTablePage extends BasePage {


    @FindBy(id = "add_spartan_btn")
    public WebElement addSpartanBtn;

}
