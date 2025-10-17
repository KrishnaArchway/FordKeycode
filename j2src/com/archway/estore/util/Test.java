package com.archway.estore.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.imageio.ImageIO;

/**
 * 
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : Test.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:48 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:48 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class Test
{

	public void captureScreen ( String fileName ) throws Exception
	{

		Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		Rectangle screenRectangle = new Rectangle ( screenSize );
		Robot robot = new Robot ();
		BufferedImage image = robot.createScreenCapture ( screenRectangle );
		ImageIO.write ( image , "png" , new File ( fileName ) );

	}

	public static synchronized Connection getConnection ( String aLoginId )
																			throws Exception
	{
		Connection connection = null;
		String url = "";
		String user = "nfscomplaintweb";
		String password = "nfscomplaintweb_egemqa";
		url = "jdbc:oracle:thin:@egemqa:1521:egemqa";
		try
		{
			Class.forName ( "oracle.jdbc.driver.OracleDriver" );
			connection = DriverManager.getConnection ( url , user , password );

		}
		catch ( Exception e )
		{
			System.out.println ( "DataBase HAS GOT An Error in acquring an JDBC DATABASE Connection \n Amar Please Or Contact him at amar_bhatt@Archway.com or ext 2019 \n if amar is not available please restart tomcat web server by typeing shutdown and then startup on the dos console window (c:/jakarta-tomcat/bin)  ---->    " + e.getMessage () );
		}

		return connection;
	}

	public static String getFileContents ( String fileName )
															throws FileNotFoundException ,
															IOException
	{
		StringBuffer contents = new StringBuffer ();
		BufferedReader reader = null;
		try
		{
			// Read in the file
			reader = new BufferedReader ( new FileReader ( fileName ) );
			while ( reader.ready () )
			{
				contents.append ( reader.readLine () );
				contents.append ( "\n" ); // Throw away LF chars, and just replace
				// CR
			}
		}
		finally
		{
			if ( reader != null ) try
			{
				reader.close ();
			}
			catch ( IOException e )
			{
			}
		}
		return contents.toString ();
	}

	/**
	 * @param args
	 */
	public static void main ( String [] args ) throws Exception
	{
		// String x = getFileContents ( "c:/in.txt" );
		// System.out.println(x);
		// System.out.println ( print ( x , "158.60.140.112" , 9100 ) );

		//String a = "1234567890";
		//System.out.println ( a.length () );

		String from = "amar_bhatt@archway.com";
		String to = "amar_bhatt@archway.com";
		String cc = "amar_bhatt@archway.com";
		String bcc = "amar_bhatt@archway.com";
		String subject = "test from 10.12.4.11 email relay";
		String body = "test from 10.12.4.11 email relay";
		String text = "test from 10.12.4.11 email relay";
		Email.SendHtmlEmailWithFileAttachment ( from , to.split ( "\\," ) , to.split ( "\\," ) , to.split ( "\\," ) , subject , null , body , text );

	}

	public static int print (
								String labelText ,
								String printerIP ,
								int printerPORT )
	{

		int retCode = 0;
		Socket socket = null;
		int max_retries = 3;
		int timeout = 5000;
		int try_num = 0;
		boolean printed = false;

		while ( ! printed && try_num < max_retries )
		{
			try
			{

				// Open the socket

				socket = new Socket ();
				InetSocketAddress lobjInetAddress = new java.net.InetSocketAddress ( printerIP , printerPORT );
				socket.connect ( lobjInetAddress , timeout );

				OutputStream outputStream = socket.getOutputStream ();

				// Create a printWriter from the output stream
				PrintWriter toServer = new PrintWriter ( new OutputStreamWriter ( outputStream ) );

				// write the stream to the server
				// single tag version

				toServer.println ( labelText );

				// Flush the server
				toServer.flush ();
				toServer.close ();
				socket.close ();
				printed = true;

			}
			catch ( Exception e )
			{
				System.out.println ( e.getMessage () );
				retCode = - 1;

				if ( socket != null )
				{
					try
					{
						socket.close ();
					}
					catch ( Exception r )
					{

					}
				}

				try_num++;

				try
				{
					Thread.sleep ( 200 );
				}
				catch ( Exception r )
				{

				}

			}
		}

		// throw an error if we went over the allowed number of tries
		if ( ! printed && try_num >= max_retries )
		{
			retCode = - 1;
		}

		return retCode;
	}

}
