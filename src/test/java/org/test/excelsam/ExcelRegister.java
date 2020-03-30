package org.test.excelsam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

public class ExcelRegister {
public static void main(String[] args) throws IOException {
	File flocation = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\Register.xls");
	
	FileInputStream stream = new FileInputStream(flocation);
	
	Workbook w = new HSSFWorkbook(stream);
	Sheet s= w.getSheet("DATA");
//	Row r = s.getRow(4);
//	Cell c = r.getCell(1);
//	System.out.println(c);
//	int rowcount = s.getPhysicalNumberOfRows();
//	System.out.println(rowcount);
	
	for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		Row row = s.getRow(i);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cc = row.getCell(j);
			int type = cc.getCellType();
		//	System.out.println(type);//
			if(type==1)
			{
				String value = cc.getStringCellValue();
				System.out.print(value +"  " );
			}
			if(type==0)
			{
				if(DateUtil.isCellDateFormatted(cc))
				{
					Date date = new Date();
					SimpleDateFormat ss= new SimpleDateFormat("dd-MMM-yyyy");
					String format = ss.format(date);
					System.out.print(format +" ");
				}
				else
				{
					double dd = cc.getNumericCellValue();
					long ll = (long)dd;
					String name = String.valueOf(ll);
					System.out.print(name +"  ");
				}
			}
		}
		System.out.println();
		
	}
}
}

