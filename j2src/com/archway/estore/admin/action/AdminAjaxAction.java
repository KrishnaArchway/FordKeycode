package com.archway.estore.admin.action;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;
import com.archway.estore.entities.ReportEntity;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.archway.estore.util.EncrypterDecrypter;
import com.archway.estore.util.DateUtility;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : AdminAjaxAction.java 
 * Package Name            : com.archway.estore.admin.action
 * 
 * Date                    : Sep 9, 2014 2:48:43 PM
 * 
 * Change Date             : Sep 9, 2014 2:48:43 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class AdminAjaxAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( AdminAjaxAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "AdminAjaxAction.execute :::";
		logger.entering ( methodName );
		String html = "";
		try
		{
			if ( request.getParameter ( "actionType" ) != null )
			{
				String actionType = request.getParameter ( "actionType" );
				if ( actionType.equalsIgnoreCase ( "generateReport" ) )
				{
					String startDate = request.getParameter ( "startDate" );
					String endDate = request.getParameter ( "endDate" );
					logger.warn ( "Start Date :" + startDate );
					logger.warn ( "End Date :" + endDate );
					ReportEntity [] re = DMLManager.getReportData ( startDate , endDate );

					//generate the excel file and show them a link to download report.
					String fileName = generateReport ( re );

					html = "<a href=\"../../tmp/"+fileName+"\">Download Report</a>";
					logger.warn ( "html = " + html );

					response.setContentType ( "text/html" );
					response.setHeader ( "Cache-Control" , "no-cache" );
					response.getWriter ().write ( html );

				}
			}
		}
		catch ( Exception ex )
		{
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
		}
		finally
		{
			logger.exiting ( methodName );
		}

		return null;

	}

	public static void main ( String args[] )
	{
		//generateReport();
	}

	public static String generateReport ( ReportEntity [] re )
	//public static String generateReport()
	{
		String methodName = "generateReport( ReportEntity [] )";
		logger.warn ( methodName );

		String fileName = "";
		//ReportEntity [] re = null;
		String constant = "|";
		
		
		
		
		
		try
		{
			fileName = EncrypterDecrypter.Encrypt ( DateUtility.getCurrentDateTime4FileName () ) + ".xlsx";
			
			XSSFWorkbook wb = new XSSFWorkbook ();
			XSSFSheet sheet = wb.createSheet ( "Key Code Exception Report" );

			XSSFFont headerFont = wb.createFont ();
			headerFont.setBold ( true );
			headerFont.setColor ( new XSSFColor ( new java.awt.Color ( 255 , 255 , 255 ) ) );

			XSSFFont dataFont = wb.createFont ();
			dataFont.setBold ( false );
			dataFont.setColor ( new XSSFColor ( new java.awt.Color ( 255 , 255 , 255 ) ) );

			int row = 0;
			int col = 0;

			String header = "VIN|Parts & Accessories|Parts & Accessories Name|Parts & Accessories Phone|USERid|first name|last name|address|city|state|zip|phone|" + "title|registration|insurance|other|other description|exception|circumstances description|vehicle year| vehicle make|vehicle model|" + "vehicle color|license plate number|vehicle registration state|odometer reading|submitted by first name|submitted by last name|database record creation date".toUpperCase ();
			String arr[] = header.split ( "\\|" );
			int numberOfColumns = arr.length;

			XSSFRow rows = sheet.createRow ( ( short ) row );
			for ( int i = 0 ; i < arr.length ; i++ )
			{
				XSSFCell cell = rows.createCell ( i );
				XSSFRichTextString rt = new XSSFRichTextString ( arr [i].toUpperCase () );
				rt.applyFont ( headerFont );
				cell.setCellValue ( rt );
			}
			

			for ( int i = 0 ; i < re.length ; i++ )
			{
				row++;
				rows = sheet.createRow ( ( short ) row );
				String temp = "";
				temp = re [i].getVin () + constant + re [i].getPa_code () + constant + re [i].getPa_name () + constant + re [i].getPa_phone () + constant + re [i].getFmcdealer_userid () + constant + re [i].getVo_first_name () + constant + re [i].getVo_last_name () + constant + re [i].getVo_address () + constant + re [i].getVo_city () + constant + re [i].getVo_state () + constant + re [i].getVo_zip () + constant + re [i].getVo_phone () + constant + re [i].getId_title () + constant + re [i].getId_registration () + constant + re [i].getId_insurance () + constant + re [i].getId_other () + constant + re [i].getOther_descrip () + constant + re [i].getException () + constant + re [i].getCircumstances_descrip () + constant + re [i].getVehicle_year () + constant + re [i].getVehicle_make () + constant + re [i].getVehicle_model () + constant + re [i].getVehicle_color () + constant + re [i].getLicense_plate_number () + constant + re [i].getState_vehicle_reg () + constant + re [i].getOdometer () + constant + re [i].getSubmit_first_name () + constant + re [i].getSubmit_last_name () + constant + re [i].getCreation_date ();
				temp = temp.toUpperCase ();
				String arrInner[] = temp.split ( "\\|" );
				for ( int j = 0 ; j < arrInner.length ; j++ )
				{
					XSSFCell cell = rows.createCell ( j );
					XSSFRichTextString rt = new XSSFRichTextString ( arrInner [j] );
					rt.applyFont ( dataFont );
					cell.setCellValue ( rt );
				}
				

			}

			//auto size all the columns
			for ( int i = 0 ; i < numberOfColumns ; i++ )
			{
				sheet.autoSizeColumn ( i );
			}

			//			 Write the output to a file
			FileOutputStream fileOut = new FileOutputStream ( ConfigurationServlet.getApplicationProperty ( "EXCEL_CREATION_PATH" ) + fileName );
			wb.write ( fileOut );
			fileOut.close ();

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
