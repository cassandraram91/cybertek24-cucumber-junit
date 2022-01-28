package com.cybertek.step_definitions;

import com.cybertek.pages.MockarooPage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MockarooStepDefs {

    MockarooPage mockarooPage = new MockarooPage();

    @Given("User is on mockaroo homepage")
    public void user_is_on_mockaroo_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("mockaroo.url"));
    }

    @Given("Number of rows is {int}")
    public void number_of_rows_is(int rowsCount) {

        mockarooPage.numOfRowsField.sendKeys(Keys.DELETE);
        mockarooPage.numOfRowsField.sendKeys(rowsCount + "");
    }

    @Given("Format is Excel")
    public void format_is_excel() {
//        mockarooPage.formatDropDown.click();
//        mockarooPage.excelOption.click();
        mockarooPage.selectExcelFormat();
    }

    @When("User clicks on preview")
    public void user_clicks_on_preview() {
        mockarooPage.previewBtn.click();
    }

    @Then("following columns should be displayed:")
    public void following_columns_should_be_displayed(List<String> expectedColumns) {
        System.out.println("expected columns = " + expectedColumns);

        List<String> actualColumns = new ArrayList<>();

        for(WebElement headerName : mockarooPage.tableHeaders){
           actualColumns.add(headerName.getText());
        }

        Assert.assertEquals(expectedColumns, actualColumns);
    }

    @Then("{int} rows of data should be displayed")
    public void rows_of_data_should_be_displayed(int expectedRowsCount) {

        Assert.assertEquals(expectedRowsCount, mockarooPage.tableRows.size());
    }

    @When("User clicks on download")
    public void userClicksOnDownload() {

        mockarooPage.downloadBtn.click();
    }

    int excelFileRowscount;

    @Then("following columns should be displayed in excel file:")
    public void followingColumnsShouldBeDisplayedInExcelFile(List<String> expectedColumns) throws Exception {

        /**
         * comparing data in feature file with data in excel file
         */

        String filePath = System.getProperty("user.home") + "/Downloads/MOCK_DATA.xlsx"; //path to our downloaded file
//                            //how to find in any computer
        //open excel file using ExcelUtil
        ExcelUtil excel = new ExcelUtil(filePath, "data");
        //read and compare column names using ExcelUtil getColumnsNames method
        Assert.assertEquals(expectedColumns,excel.getColumnsNames());
        
        
        
//        FileInputStream in = new FileInputStream(filePath); //used to read from the file
//        XSSFWorkbook workbook = new XSSFWorkbook(in); //to get input stream and open the workbbok
//        XSSFSheet worksheet = workbook.getSheetAt(0);
//
//        //get number of column names. top row and cells count
//        int excelHeadersCount = worksheet.getRow(0).getPhysicalNumberOfCells();
//
//        excelFileRowscount = worksheet.getLastRowNum();
//
//        List<String> actualColumns = new ArrayList<>();
//
//        //loop and read column names and store into List<String> actualColumns
//        for(int i = 0; i < excelHeadersCount; i++){
//            actualColumns.add(worksheet.getRow(0).getCell(i).toString());
//        }
//
//        Assert.assertEquals(expectedColumns, actualColumns);

    }

    String filePath = System.getProperty("user.home") + "/Downloads/MOCK_DATA.xlsx"; //path to our downloaded file

    @And("{int} rows of data should be displayed in excel file")
    public void rowsOfDataShouldBeDisplayedInExcelFile(int numberOfRows) {

        ExcelUtil excel = new ExcelUtil(filePath, "data");
        int excelFileRowscount = excel.rowCount();
        Assert.assertEquals(numberOfRows, excelFileRowscount);
    }

    @And("data should be present in excel file")
    public void dataShouldBePresentInExcelFile() {
        //open excel file, read data and print values
        ExcelUtil excel = new ExcelUtil(filePath,"data");
        System.out.println("Excel file data: " + excel.getDataList());

    }
}
