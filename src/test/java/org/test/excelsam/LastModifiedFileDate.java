package org.test.excelsam;

import java.io.File;
import java.text.SimpleDateFormat;

public class LastModifiedFileDate {
public static void main(String[] args) {
	File f= new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\Register.xls");
	SimpleDateFormat ss = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	System.out.println("Last Modified date: " +ss.format(f.lastModified()));
	
}
}
