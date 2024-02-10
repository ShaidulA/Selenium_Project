package Utilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	String excelpath="C:\\Users\\owner\\Desktop\\Project.xlsx";
	public String[] readExcel() throws IOException
	{
		String[] data=new String[5];
		FileInputStream fis=new FileInputStream(excelpath);
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		Row row=sheet.getRow(1);
		
		Cell cell1=row.getCell(0);
		String userid=cell1.getStringCellValue();
		Cell cell2=row.getCell(1);
		String newpass=cell2.getStringCellValue();
		Cell cell3=row.getCell(2);
		String repeatpassword=cell3.getStringCellValue();
		
		data[0]=userid;
		data[1]=newpass;
		data[2]=repeatpassword;
		return data;
	}
}
