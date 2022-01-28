package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public CalculatorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sciOutPut")
    public WebElement resultElem;

    public void clickOn(String buttonTxt){
        WebElement elem = Driver.getDriver().findElement(By.xpath("//span[.='"+buttonTxt+"']"));
        elem.click();
    }

}
