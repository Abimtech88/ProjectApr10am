package org.test.excelsam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ModifiedExcelRead {
	public static void main(String[] args) throws IOException {
		File flocation = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\Register.xls");
		
		FileInputStream stream = new FileInputStream(flocation);
		
		Workbook w = new HSSFWorkbook(stream);
		Sheet s= w.getSheet("Registerdetails");
//		Row r = s.getRow(4);
//		Cell c = r.getCell(1);
//		System.out.println(c);
//		int rowcount = s.getPhysicalNumberOfRows();
//		System.out.println(rowcount);
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				int type = row.getCell(j).getCellType();
				if(type==1)
				{
					String value = row.getCell(j).getStringCellValue();
					System.out.print(value +"  " );
				}
				if(type==0)
				{
					if(DateUtil.isCellDateFormatted(row.getCell(j)))
					{
						String format = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
						System.out.print(format +" ");
					}
					else
					{
						String name = String.valueOf((long)row.getCell(j).getNumericCellValue());
						System.out.print(name +"  ");
					}
				}
			}
			System.out.println();
			
		}
	}
}
