package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {

    String filePath = "Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
        //open the Employees.xlsx using Apache POI
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);

        //Goto "data" sheet or go to first sheet by index
        XSSFSheet dataSheet = workbook.getSheetAt(0); //use getSheetAt index if you don't know/want to use the name of sheet(name could be changing etc.)

        //print column names. row is 0. cells, 0,1,2
        System.out.println("COLUMN NAMES: ");
        System.out.println(dataSheet.getRow(0).getCell(0));
        System.out.println(dataSheet.getRow(0).getCell(1));
        System.out.println(dataSheet.getRow(0).getCell(2));

        System.out.println("=====================================");
        //loop and print all 3 column names
        for(int i = 0; i <= 2; i++){
            System.out.println(dataSheet.getRow(0).getCell(i));
        }

        //find out number of rows in the worksheet
        int rowsCount = dataSheet.getPhysicalNumberOfRows(); //8 this method starts counting from 1 not 0 and will ignore empty rows in between (will not count)
        System.out.println("rows count = " + rowsCount);

        int usedRowsCount = dataSheet.getLastRowNum(); //7 this method starts counting from 0 and counts empty rows as well, good fit for loop , especially if there are empty rows
        System.out.println("usedRowsCount = " + usedRowsCount);

        //print all first names using a loop
        for (int i = 0; i <= usedRowsCount; i++){
            System.out.println(dataSheet.getRow(i).getCell(0));
        }

        //loop and find "Fahima" in firstname column and print firstname | lastname | job id then exit loop
        for(int i = 1; i <= usedRowsCount; i++){
            if(dataSheet.getRow(i).getCell(0).toString().equals("Fahima")){
                System.out.println(dataSheet.getRow(i).getCell(0) + "|" + dataSheet.getRow(i).getCell(1) + "|" + dataSheet.getRow(i).getCell(2));
                break;
            }
        }
    }

}
