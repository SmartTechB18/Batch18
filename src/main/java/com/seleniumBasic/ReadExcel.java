package com.seleniumBasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Urmi\\Desktop\\General_IT_Proffessional\\UserNme_Password.xlsx";
		File fl = new File(path);
		FileInputStream fi = new FileInputStream(fl);
		
		Workbook wb = new XSSFWorkbook(fi);
	//	CreationHelper createHelper = wb.getCreationHelper();
		
		Sheet sheet = wb.getSheet("Sheet1");
		
		int row = sheet.getLastRowNum();
		System.out.println(row);
		
		Cell cellValue = sheet.getRow(3).getCell(0);
		System.out.println(cellValue);
		
		Row r = sheet.createRow(4);
		cellValue = r.createCell(0);
		cellValue.setCellValue("Smart");
		cellValue = r.createCell(1);
		cellValue.setCellValue(127);
		
		File fl1 = new File("C:\\Users\\Urmi\\Desktop\\General_IT_Proffessional\\WriteExcel.xlsx");
		FileOutputStream fo = new FileOutputStream(fl1);
		
		wb.write(fo);
		
	}

}
