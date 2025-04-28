package com.learnFw.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook workbook;
	public ExcelDataProvider() {
		File file = new File("TestData/Data.xlsx");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			System.out.println("Unavilable file"+e.getMessage());
		}
		
	}
public String getStringData(int sheetIndex, int rows,int columns) {
		return workbook.getSheetAt(sheetIndex).getRow(rows).getCell(columns).getStringCellValue();
	}
	public String getStringData(String sheetName, int rows,int columns) {
		return workbook.getSheet(sheetName).getRow(rows).getCell(columns).getStringCellValue();
	}
	public double getNumetricData(String sheetName, int rows,int columns) {
		return workbook.getSheet(sheetName).getRow(rows).getCell(columns).getNumericCellValue();
	}
	  
}
