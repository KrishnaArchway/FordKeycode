
import com.archway.estore.common.Logger;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * Demonstrates how to work with rich text
 */
public class WorkingWithRichText
{

	private static Logger	logger	= Logger.getLogger ( WorkingWithRichText.class );

	public static void main ( String [] args ) throws Exception
	{

		XSSFWorkbook wb = new XSSFWorkbook (); //or new HSSFWorkbook();

		XSSFSheet sheet = wb.createSheet ();
		XSSFRow row = sheet.createRow ( ( short ) 0 );

		XSSFCell cell = row.createCell ( 0 );
		XSSFRichTextString rt = new XSSFRichTextString ( "The quick brown fox" );

		XSSFFont font1 = wb.createFont ();
		font1.setBold ( false );
		font1.setColor ( new XSSFColor ( new java.awt.Color ( 255 , 255 , 255 ) ) );

		/*
		 XSSFFont font2 = wb.createFont ();
		 font2.setItalic ( true );
		 font2.setUnderline ( XSSFFont.U_DOUBLE );
		 font2.setColor ( new XSSFColor ( new java.awt.Color ( 0 , 255 , 0 ) ) );
		 rt.applyFont ( 10 , 19 , font2 );

		 XSSFFont font3 = wb.createFont ();
		 font3.setColor ( new XSSFColor ( new java.awt.Color ( 0 , 0 , 255 ) ) );
		 rt.append ( " Jumped over the lazy dog" , font3 );*/

		rt.applyFont ( font1 );
		cell.setCellValue ( rt );

		sheet.autoSizeColumn ( 0 );

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream ( "c:/temp/xssf-richtext.xlsx" );
		wb.write ( fileOut );
		fileOut.close ();
	}

	public static String generateReport ()
	{
		String methodName = "generateReport( )";
		logger.warn ( methodName );

		String fileName = "";

		try
		{
			XSSFWorkbook wb = new XSSFWorkbook (); //or new HSSFWorkbook();
			XSSFSheet sheet = wb.createSheet ();

			int row = 0;
			int col = 0;

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception e :" + e.getMessage () );
		}
		finally
		{
			logger.exiting ( methodName );
		}

		return fileName;
	}

}
