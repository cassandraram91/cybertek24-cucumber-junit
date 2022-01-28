package com.cybertek.pages;

import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MockarooPage {

    public MockarooPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "num_rows")
    public WebElement numOfRowsField;

    @FindBy(id = "mui-component-select-file_format")
    public WebElement formatDropDown;

    @FindBy(xpath = "//li[.='Excel']")
    public WebElement excelOption;

    @FindBy(xpath = "//span[.='Preview']")
    public WebElement previewBtn;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> tableHeaders;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//span[.='Download Data']")
    public WebElement downloadBtn;

    public void selectExcelFormat(){
        BrowserUtils.scrollDown(500);
        formatDropDown.click();
        BrowserUtils.sleep(1);
        excelOption.click();
    }

}
