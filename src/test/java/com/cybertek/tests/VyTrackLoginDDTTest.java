package com.cybertek.tests;

import com.cybertek.pages.VyTrackDashboardPage;
import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 45);

    @Before
    public void setUp(){
        //set up browser etc if needed
        //open the url
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrak.url"));
    }

    @After
    public void tearDown(){
        //close browser here
       // Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws Exception {
        //open excel file
        String filePath = "VyTrackQa2Users.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);
        int usedRowsCount = sheet.getLastRowNum();

        //add page objects

        //loop and read credentials
        //write the result in excel file
        for(int i = 1; i <= usedRowsCount; i++ ){

            String userName = sheet.getRow(i).getCell(0).toString();
            String passWord = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();

            VyTrackLoginPage loginPage = new VyTrackLoginPage();
            loginPage.login(userName, passWord);

            VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();
            String actualFullName = dashboardPage.fullName.getText();

            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if(actualFullName.contains(firstName) && actualFullName.contains(lastName)){
                resultCell.setCellValue("PASS");
            }else{
                resultCell.setCellValue("FAIL");
            }

            dashboardPage.logout();

//            WebElement dropdownCarrot = Driver.getDriver().findElement(By.xpath("//i[@class='fa-caret-down']"));
//            wait.until(ExpectedConditions.elementToBeClickable(dropdownCarrot));
//            dropdownCarrot.click();
//            WebElement logoutBtn = Driver.getDriver().findElement(By.xpath("//a[@href='/user/logout']"));
//            //Driver.getDriver().findElement(By.xpath("//*[@id='user-menu']/ul/li[5]/a"));
//            wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
//            logoutBtn.click();

        }

        //save changes in the excel file
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        fis.close();
        out.close();
        workbook.close();

    }
}
