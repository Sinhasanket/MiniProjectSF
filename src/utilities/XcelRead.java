package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelRead {
    
	public static Object[][] readFrom(String filename){
		
		System.out.println("Inside xcel reading method");
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook( new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rows2 = sheet1.getLastRowNum() - sheet1.getFirstRowNum() + 1;
		int cols2 = sheet1.getRow(0).getLastCellNum();
		
		System.out.println("rows=" + rows2 + "cols=" + cols2);
		
		Object[][] data = new Object[ rows2-1 ][ cols2 ];
	    
	    for( int i=1 ; i<rows2; i++) {
	    	
	    	Row row = sheet1.getRow(i);
	    	for( int j=0; j<cols2; j++) {
	    	    
	    		data[i-1][j] = row.getCell(j).getStringCellValue();
	    	}
	    }
	    
	    return data;
	}
}
