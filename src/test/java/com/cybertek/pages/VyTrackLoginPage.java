package com.cybertek.pages;

import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

  public VyTrackLoginPage(){
      PageFactory.initElements(Driver.getDriver(), this);
  }

    /* we do not need to put @FindBy(name="_username") for those elements because selenium will automatically search for elements with matching name or id to variable name

    public WebElement _username;
    public WebElement _password;
    */

    @FindBy(id = "prependedInput")
    public WebElement usernameField;

    @FindBy(id = "prependedInput2")
    public WebElement passwordField;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginBtn;

//    @FindBy(xpath = "//div[.='Invalid user name or password.']")
//    public WebElement invalidLoginMsg;
//
//    @FindBy(linkText = "Forgot your password?")
//    public WebElement forgotPassLink;
//
//    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
//    public WebElement rememberMeChkbx;


    public void login(String user, String password){
        usernameField.sendKeys(user);
        passwordField.sendKeys(password);
        loginBtn.click();

    }

}
