/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : PoiWriteExcelFile.java 
 * Package Name            : 
 * 
 * Date                    : Sep 9, 2014 10:01:47 PM
 * 
 * Change Date             : Sep 9, 2014 10:01:47 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiWriteExcelFile
{

	public static void main ( String [] args )
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream ( "c:/temp/poi-test.xls" );
			HSSFWorkbook workbook = new HSSFWorkbook ();
			HSSFSheet worksheet = workbook.createSheet ( "POI Worksheet" );

			// index from 0,0... cell A1 is cell(0,0)
			HSSFRow row1 = worksheet.createRow ( ( short ) 0 );

			//style
			HSSFCellStyle cellStyle = workbook.createCellStyle ();

			cellStyle.setFillPattern ( HSSFCellStyle.SOLID_FOREGROUND );

			HSSFCell cellA1 = row1.createCell ( ( short ) 0 );
			cellA1.setCellValue ( "Hello" );
			cellA1.setCellStyle ( cellStyle );

			worksheet.autoSizeColumn ( 0 );

			workbook.write ( fileOut );
			fileOut.flush ();
			fileOut.close ();
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace ();
		}
		catch ( IOException e )
		{
			e.printStackTrace ();
		}

	}

}
