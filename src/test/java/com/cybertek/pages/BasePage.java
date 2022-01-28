package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
