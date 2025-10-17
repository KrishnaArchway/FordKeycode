package com.archway.estore.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
 * File Name               : HttpUtils.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:23 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:23 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class HttpUtils
{

	/**
	 * 
	 * @param textToPrint
	 * @return
	 */
	public static boolean print ( String textToPrint )
	{
		boolean returnflag = true;
		try
		{
			PrintService psZebra = null;
			String sPrinterName = null;

			PrintService service = PrintServiceLookup.lookupDefaultPrintService ();

			psZebra = service;

			String s = textToPrint;

			byte [] by = s.getBytes ();
			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet ();

			DocPrintJob job = psZebra.createPrintJob ();

			Doc doc = new SimpleDoc ( by , flavor , null );

			job.print ( doc , null );

		}
		catch ( PrintException e )
		{
			e.printStackTrace ();
			returnflag = false;
		}
		return returnflag;

	}

	/**
	 * 
	 * @param url
	 * @param filename
	 * @return
	 */
	public static boolean fileExistsViaUrl ( String url , String filename )
	{
		boolean fileIsThere = false;
		java.net.HttpURLConnection huc = null;
		try
		{
			java.net.URL myURI = new java.net.URL ( url + filename );

			huc = ( java.net.HttpURLConnection ) myURI.openConnection ();
			huc.setRequestMethod ( "HEAD" );
			huc.connect ();

			if ( huc.getResponseCode () == java.net.HttpURLConnection.HTTP_OK )
																				fileIsThere = true;

		}
		catch ( Exception e )
		{
		}
		finally
		{
			try
			{
				huc.disconnect ();
			}
			catch ( Exception e )
			{
			}
		}

		return fileIsThere;
	}

	/**
	 * virtualName = "/pimages"
	 * 
	 * @param request
	 * @param virtualName
	 * @return
	 * @throws Exception
	 */
	public static String getVirtualDirectoryPath (
													HttpServletRequest request ,
													String virtualName )
																		throws Exception
	{
		String returnString = "";
		ServletContext context = request.getSession ().getServletContext ();
		;
		returnString = context.getRealPath ( virtualName );
		return returnString;
	}

	/**
	 * Download content from the given url and save's it to specified output
	 * path .
	 * 
	 * Useage
	 * DownLoadImage("http://bhattam0.tsdet.archway.com/dwd/pimages/1111.jpg","c:/dwd/tmp/1111.jpg")
	 * 
	 * @param URL
	 * @param outputFileAndPath
	 * @return
	 */
	public static boolean DownLoadImage ( String URL , String outputFileAndPath )
	{
		DataInputStream di = null;
		FileOutputStream fo = null;
		byte [] b = new byte[1];
		boolean returnFlag = false;
		try
		{
			// input
			URL url = new URL ( URL );
			URLConnection urlConnection = url.openConnection ();
			urlConnection.connect ();
			di = new DataInputStream ( urlConnection.getInputStream () );

			fo = new FileOutputStream ( outputFileAndPath );

			while ( - 1 != di.read ( b , 0 , 1 ) )
			{
				fo.write ( b , 0 , 1 );
			}
			di.close ();
			fo.close ();
			returnFlag = true;
		}
		catch ( Exception ex )
		{
			returnFlag = false;

		}
		return returnFlag;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public static void getIpAddress () throws Exception
	{
		InetAddress localHost = InetAddress.getLocalHost ();
		InetAddress [] all_IPs = InetAddress.getAllByName ( localHost.getHostName () );
		for ( int i = 0 ; i < all_IPs.length ; i++ )
		{
			System.out.println ( "IP address = " + all_IPs [i] );
		}
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getIpAddress ( HttpServletRequest request )
																	throws Exception
	{
		String IP = request.getRemoteAddr ();
		return IP;
	}

	/**
	 * 
	 * @param HostName
	 * @return
	 */
	public static String getIpFromHostName ( String HostName )
	{
		String ipAddrStr = "";
		try
		{

			InetAddress addr = InetAddress.getByName ( HostName );
			byte [] ipAddr = addr.getAddress ();

			// Convert to dot representation

			for ( int i = 0 ; i < ipAddr.length ; i++ )
			{
				if ( i > 0 )
				{
					ipAddrStr += ".";
				}
				ipAddrStr += ipAddr [i] & 0xFF;
			}

		}
		catch ( UnknownHostException e )
		{
		}

		return ipAddrStr;
	}

	/**
	 * 
	 * @return
	 */
	public static String Ipaddr ()
	{

		String returnString = "";
		long localip[] =
			{ 0 , 0 , 0 , 0 };
		try
		{

			Enumeration e = NetworkInterface.getNetworkInterfaces ();

			while ( e.hasMoreElements () )
			{
				NetworkInterface netface = ( NetworkInterface ) e.nextElement ();

				Enumeration e2 = netface.getInetAddresses ();

				while ( e2.hasMoreElements () )
				{
					InetAddress ip = ( InetAddress ) e2.nextElement ();

					if ( ! ip.isLoopbackAddress () && ip.getHostAddress ().indexOf ( ":" ) == - 1 )
					{

						byte [] ipAddr = ip.getAddress ();
						localip [0] = ( ipAddr [0] & 0xFF );
						returnString += localip [0] + "|";
						localip [1] = ( ipAddr [1] & 0xFF );
						returnString += localip [1] + "|";
						localip [2] = ( ipAddr [2] & 0xFF );
						returnString += localip [2] + "|";
						localip [3] = ( ipAddr [3] & 0xFF );
						returnString += localip [3];
					}
				}
			}

		}
		catch ( Exception e )
		{
			System.out.println ( "Could not get ip addr" );
		}
		return returnString;
	}

	/**
	 * 
	 * @param HostName
	 * @return
	 */
	public static String who ( String HostName )
	{
		Socket s = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try
		{
			// Connect to port 79 (the standard finger port) on the host.
			String hostname = HostName;
			s = new Socket ( hostname , 79 );
			// Set up the streams
			out = new PrintWriter ( new OutputStreamWriter ( s.getOutputStream () ) );
			in = new BufferedReader ( new InputStreamReader ( s.getInputStream () ) );

			// Send a blank line to the finger server, telling it that we want
			// a listing of everyone logged on instead of information about an
			// individual user.
			out.print ( "\n" );
			out.flush (); // Send it out

			// Now read the server's response
			// The server should send lines terminated with \n or \r.
			String line;
			while ( ( line = in.readLine () ) != null )
			{
				System.out.println ( line );
			}
			System.out.println ( "Who's Logged On: " + hostname );
		}
		catch ( IOException e )
		{
			System.out.println ( "Who's Logged On: Error" );
		}
		// Close the streams!
		finally
		{
			try
			{
				in.close ();
				out.close ();
				s.close ();
			}
			catch ( Exception e )
			{
			}
		}
		return "";
	}

	/**
	 * Default Constructor.
	 * 
	 */
	public HttpUtils ()
	{

	}
}