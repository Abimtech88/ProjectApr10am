package org.test.excelsam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DataDrivenQ1 {
public static void main(String[] args) throws IOException {
    File floc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\Register.xls");
	FileInputStream stream = new FileInputStream(floc);
	Workbook w = new HSSFWorkbook(stream);
	Sheet s= w.getSheet("DATA");
	System.out.println("Total number of Rows");
	
	int rows = s.getPhysicalNumberOfRows();
	System.out.println(rows);
	System.out.println(); 
	System.out.println("Total number of cells");
	Row row = s.getRow(0);
	int num = row.getPhysicalNumberOfCells();
	//short num = row.getLastCellNum();
	System.out.println(num);
	System.out.println();
	
	for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		Row r  = s.getRow(i);
		
		for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			Cell c = r.getCell(j);
			
			System.out.println(c);
		}
	}
	
	Row rr = s.createRow(11);
	Cell cell = rr.createCell(0);
	
	cell.setCellValue("Rithu");
	
	Cell cell2 = rr.createCell(1);
	cell2.setCellValue("MSC");
	
	FileOutputStream o=new FileOutputStream(floc);
	w.write(o);
	System.out.println();
	System.out.println("Inserted one row");
}
}





