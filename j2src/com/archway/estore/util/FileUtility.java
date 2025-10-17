package com.archway.estore.util;

import com.archway.estore.common.Logger;
import com.archway.estore.entities.FileBean;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

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
 * File Name               : FileUtility.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:08 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:08 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class FileUtility
{

	private static Logger	logger	= Logger.getLogger ( FileUtility.class );

	/**
	 * 
	 * @param oldFile
	 * @param newFile
	 * @throws Exception
	 * 
	 * Oct 25, 2011 10:53:11 AM
	 */
	public static void rename ( String oldFile , String newFile )
																	throws Exception
	{
		// Construct the file object. Does NOT create a file on disk!
		File f = new File ( oldFile ); // backup of this source file.
		// Rename the backup file to "junk.dat"
		// Renaming requires a File object for the target.
		f.renameTo ( new File ( newFile ) );
	}

	/**
	 * Check if the file exists or not
	 * 
	 * @param PathName
	 * @param FileName
	 * @return
	 * @throws Exception
	 */
	public static boolean CheckFileExists ( String PathName , String FileName )
																				throws Exception
	{
		File f = new File ( PathName + FileName );
		return ( f.exists () );
	}

	/**
	 * Create a file
	 * 
	 * @param PathAndFileName
	 * @param contentsToFile
	 * @return
	 * @throws IOException
	 */
	public static boolean CreateFile (
										String PathAndFileName ,
										String contentsToFile )
																throws IOException
	{
		// Create a File object
		File file = new File ( PathAndFileName );
		boolean success = false;
		try
		{
			// Create file on disk (if it doesn't exist)
			BufferedWriter out = new BufferedWriter ( new FileWriter ( file ) );
			out.write ( contentsToFile );
			out.close ();
			success = true;
		}
		catch ( IOException e )
		{
			success = false;
			e.printStackTrace ();
		}
		if ( ! success )
		{
			throw new IOException ( "Unable to Create File" );
		}
		return success;
	}

	/**
	 * @param prefix
	 * @param sufix
	 * @param contentsToFile
	 * @return An Absolute pathname denoting a newly-created empty file
	 * @throws Exception
	 */
	public static String CreateTempFile (
											String prefix ,
											String sufix ,
											String contentsToFile )
																	throws Exception
	{
		// Create a temporary file object
		File tempFile = File.createTempFile ( prefix , sufix );
		// Write to temporary file
		BufferedWriter out = new BufferedWriter ( new FileWriter ( tempFile ) );
		out.write ( contentsToFile );
		out.close ();
		return tempFile.getAbsolutePath ();
	}

	/**
	 * -----------------------------------------------------------------------------
	 * This program demonstrates how to create a temporary file that will be
	 * deleted when the program exits. The Java I/O package contains a method
	 * for creating temporary files. The method creates a new empty file in the
	 * specified directory, using the given prefix and suffix strings to
	 * generate its name. If this method returns successfully then it is
	 * guaranteed that: 1.) The file denoted by the returned abstract pathname
	 * did not exist before this method was invoked, and 2.) Neither this method
	 * nor any of its variants will return the same abstract pathname again in
	 * the current invocation of the virtual machine. This method provides only
	 * part of a temporary-file facility. To arrange for a file created by this
	 * method to be deleted automatically, use the deleteOnExit() method. The
	 * prefix argument must be at least three characters long. It is recommended
	 * that the prefix be a short, meaningful string such as "hjb" or "mail".
	 * The suffix argument may be null, in which case the suffix ".tmp" will be
	 * used. To create the new file, the prefix and the suffix may first be
	 * adjusted to fit the limitations of the underlying platform. If the prefix
	 * is too long then it will be truncated, but its first three characters
	 * will always be preserved. If the suffix is too long then it too will be
	 * truncated, but if it begins with a period character ('.') then the period
	 * and the first three characters following it will always be preserved.
	 * Once these adjustments have been made the name of the new file will be
	 * generated by concatenating the prefix, five or more internally-generated
	 * characters, and the suffix. If the directory argument is null then the
	 * system-dependent default temporary-file directory will be used. The
	 * default temporary-file directory is specified by the system property
	 * java.io.tmpdir. On UNIX systems the default value of this property is
	 * typically "/tmp" or "/var/tmp"; on Win32 systems it is typically
	 * "c:\\temp". A different value may be given to this system property when
	 * the Java virtual machine is invoked, but programmatic changes to this
	 * property are not guaranteed to have any effect upon the the temporary
	 * directory used by this method. Parameters: prefix - The prefix string to
	 * be used in generating the file's name; must be at least three characters
	 * long suffix - The suffix string to be used in generating the file's name;
	 * may be null, in which case the suffix ".tmp" will be used directory - The
	 * directory in which the file is to be created, or null if the default
	 * temporary-file directory is to be used Returns: An abstract pathname
	 * denoting a newly-created empty file
	 * -----------------------------------------------------------------------------
	 */
	public static void CreateTempFileDelete (
												String prefix ,
												String sufix ,
												String contentsToFile )
																		throws Exception
	{
		// Create a temporary file object
		File tempFile = File.createTempFile ( prefix , sufix );
		// Delete temp file when program exits
		tempFile.deleteOnExit ();
		// Write to temporary file
		BufferedWriter out = new BufferedWriter ( new FileWriter ( tempFile ) );
		out.write ( contentsToFile );
		out.close ();
	}

	/**
	 * 
	 * @param decimalVal
	 * @param position
	 * @return
	 */
	private static long decimalTokenize ( double decimalVal , int position )
	{

		long returnDecimalVal = 0;
		String strDecimalVal = "";

		if ( decimalVal > 0 ) strDecimalVal = String.valueOf ( decimalVal );

		if ( strDecimalVal.length () > 0 )
		{
			StringTokenizer decimalToken = new StringTokenizer ( strDecimalVal , "." );
			// System.out.print("\n String tokenized
			// successfully"+decimalToken.countTokens());
			// int count = decimalToken.countTokens();

			if ( position == 1 )
			{
				returnDecimalVal = Long.parseLong ( decimalToken.nextToken () );
			}
			else if ( position == 2 )
			{
				decimalToken.nextToken ();
				returnDecimalVal = Long.parseLong ( decimalToken.nextToken () );
			}
		}
		return returnDecimalVal;
	}

	/**
	 * 
	 * @param Path
	 * @param FileName
	 * @return
	 * @throws Exception
	 */
	public static boolean DeleteFile ( String Path , String FileName )
																		throws Exception
	{
		// Create a File object
		File file = new File ( Path + FileName );
		boolean success = file.delete ();
		if ( ! success )
		{
			throw new Exception ( "Unable to Delete File" );
		}
		return success;
	}

	/**
	 * 
	 * @param argLength
	 * @return
	 */
	private static long divider ( long argLength )
	{
		long varDivider = 1;

		for ( int i = 0 ; i < ( argLength - 1 ) ; i++ )
		{
			varDivider = varDivider * 10;
		}

		return varDivider;
	}

	/**
	 * creates a zip file
	 * 
	 * @param zipFileName
	 * @param filesToBeZipped
	 *            (Array pass path+filename)
	 */
	public static void doCreateZipFile (
										String zipFileName ,
										String [] filesToBeZipped )
	{
		byte [] buf = new byte[1024];
		try
		{
			ZipOutputStream out = new ZipOutputStream ( new FileOutputStream ( zipFileName ) );
			out.setComment ( "Efulfillment" );
			// Compress the files
			for ( int i = 0 ; i < filesToBeZipped.length ; i++ )
			{
				FileInputStream in = new FileInputStream ( filesToBeZipped [i] );
				String name = ( new File ( filesToBeZipped [i] ) ).getName ();
				out.putNextEntry ( new ZipEntry ( name ) );
				// Transfer bytes from the file to the ZIP file
				int len;
				while ( ( len = in.read ( buf ) ) > 0 )
				{
					out.write ( buf , 0 , len );
				}
				// Complete the entry
				out.closeEntry ();
				in.close ();
			}
			// Complete the ZIP file
			out.close ();
		}
		catch ( IOException e )
		{
			e.printStackTrace ();
		}
	}

	/**
	 * extracts a specific file from zip file
	 * 
	 * @param zipFileName
	 * @param fileToBeRetrived
	 *            PATH+FILENAME
	 */
	public static void doUnzipFiles (
										String zipFileName ,
										String fileToBeRetrived )
	{
		try
		{
			ZipFile zf = new ZipFile ( zipFileName );
			// Enumerate each entry
			for ( Enumeration entries = zf.entries () ; entries.hasMoreElements () ; )
			{
				// Get the entry and its name
				ZipEntry zipEntry = ( ZipEntry ) entries.nextElement ();
				String zipEntryName = zipEntry.getName ();
				System.out.println ( "  inflating: " + zipEntryName );
				if ( zipEntryName.equalsIgnoreCase ( fileToBeRetrived ) )
				{
					OutputStream out = new FileOutputStream ( zipEntryName );
					InputStream in = zf.getInputStream ( zipEntry );
					byte [] buf = new byte[1024];
					int len;
					while ( ( len = in.read ( buf ) ) > 0 )
					{
						out.write ( buf , 0 , len );
					}
					// Close streams
					out.close ();
					in.close ();
				}
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace ();

		}
	}

	/**
	 * 
	 * @param url
	 * @param filename
	 * @return
	 */
	public static boolean fileExistsOverHttp ( String url , String filename )
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
			logger.warn ( "Exception From fileExistsOverHttp :" + e.getMessage () );
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
	 * 
	 * @param f
	 * @return
	 */
	public static String FindFileSize ( File f )
	{
		double fileSizeKB = 0;
		/** Specify the location and name of the file whose size is to be found * */

		// File f = new File ( "C:\\arulTest\\arul2.zip" );
		String fileLength = String.valueOf ( f.length () );
		int fileLengthDigitCount = fileLength.length ();
		double fileLengthLong = f.length ();
		double decimalVal = 0.0;
		String howBig = "";

		// System.out.println ( "fileLengthDigitCount is..." +
		// fileLengthDigitCount );

		if ( f.length () > 0 )
		{
			if ( fileLengthDigitCount < 5 )
			{
				fileSizeKB = Math.abs ( fileLengthLong );
				howBig = "Byte(s)";
			}
			else if ( fileLengthDigitCount >= 5 && fileLengthDigitCount <= 6 )
			{
				fileSizeKB = Math.abs ( ( fileLengthLong / 1024 ) );
				howBig = "KB";
			}
			else if ( fileLengthDigitCount >= 7 && fileLengthDigitCount <= 9 )
			{
				fileSizeKB = Math.abs ( fileLengthLong / ( 1024 * 1024 ) );
				howBig = "MB";
			}
			else if ( fileLengthDigitCount > 9 )
			{
				fileSizeKB = Math.abs ( ( fileLengthLong / ( 1024 * 1024 * 1024 ) ) );
				decimalVal = fileLengthLong % ( 1024 * 1024 * 1024 );
				howBig = "GB";
			}
		}
		// System.out.println ( "....bytes....." + fileSizeKB );
		String finalResult = getRoundedValue ( fileSizeKB );
		// System.out.println ( "\n....Final Result....." + finalResult + " " +
		// howBig );
		return ( finalResult + " " + howBig );
	}

	/**
	 * 
	 * @param remortServerName
	 * @param username
	 * @param password
	 * @param PathNameFileName
	 */
	public static void FtpFile (
								String remortServerName ,
								String username ,
								String password ,
								String PathNameFileName )
	{

		try
		{
			JakartaFtpWrapper ftp = new JakartaFtpWrapper ();
			String serverName = remortServerName;
			if ( ftp.connectAndLogin ( serverName , username , password ) )
			{
				System.out.println ( "Connected to " + serverName );
				try
				{
					System.out.println ( "Welcome message:\n" + ftp.getReplyString () );
					System.out.println ( "Current Directory: " + ftp.printWorkingDirectory () );
					ftp.setPassiveMode ( true );
					System.out.println ( "Files in this directory:\n" + ftp.listFileNamesString () );
					System.out.println ( "Subdirectories in this directory:\n" + ftp.listSubdirNamesString () );
					System.out.println ( "Downloading file robots.txt" );
					ftp.ascii ();
					ftp.uploadFile ( "c:/FS6110lr.pdf" , "FS6110lr.pdf" );
					ftp.downloadFile ( "robots.txt" , "C:\\robots.txt" );
				}
				catch ( Exception ftpe )
				{
					ftpe.printStackTrace ();
				}
				finally
				{
					ftp.logout ();
					ftp.disconnect ();
				}
			}
			else
			{
				System.out.println ( "Unable to connect to" + serverName );
			}
			System.out.println ( "Finished" );
		}
		catch ( Exception e )
		{
			e.printStackTrace ();
		}

	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static File [] getDirectoryContents ( String path ) throws Exception
	{
		File files[];
		files = new File ( path ).listFiles ();
		Arrays.sort ( files );
		return files;

	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static String [] getDirectoryListing ( String path )
																throws Exception
	{
		File dir = new File ( path );
		File [] files = dir.listFiles ();
		String children = "";
		Arrays.sort ( files , LastModifiedFileComparator.LASTMODIFIED_REVERSE );
		for ( int i = 0 ; i < files.length ; i++ )
		{
			children += files [i].getName () + "|";
		}
		return children.split ( "\\|" );
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static long getDirectorySize ( String path ) throws Exception
	{
		return FileUtils.sizeOfDirectory ( new File ( path ) );
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static String getDirectorySizeHumanReadableForm ( String path )
																			throws Exception
	{
		return FileUtils.byteCountToDisplaySize ( FileUtils.sizeOfDirectory ( new File ( path ) ) );
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static FileBean [] getFileInfoFromDirectory ( String path )
																		throws Exception
	{
		String arr[] = getDirectoryListing ( path );
		Vector list = new Vector ();
		String DATE_FORMAT = "MM/dd/yyyy"; // Refer Java DOCS for formats
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat ( DATE_FORMAT );
		for ( int i = 0 ; i < arr.length ; i++ )
		{
			File file = new File ( path + "/" + arr [i] );
			String exists = getYesNo ( file.exists () );
			String canRead = getYesNo ( file.canRead () );
			String canWrite = getYesNo ( file.canWrite () );
			String isFile = getYesNo ( file.isFile () );
			String isHid = getYesNo ( file.isHidden () );
			String isDir = getYesNo ( file.isDirectory () );
			String isAbs = getYesNo ( file.isAbsolute () );

			FileBean fb = new FileBean ();
			fb.setCanRead ( canRead );
			fb.setCanWrite ( canWrite );
			fb.setExists ( exists );
			fb.setIsAbs ( isAbs );
			fb.setIsDir ( isDir );
			fb.setIsFile ( isFile );
			fb.setIsHid ( isHid );
			Date d = new Date ( file.lastModified () );
			fb.setLastModified ( ( DateFormat.getDateTimeInstance ( DateFormat.LONG , DateFormat.SHORT ).format ( new Date ( file.lastModified () ) ) ) );
			fb.setLastModified ( DateFormat.getDateTimeInstance ( DateFormat.SHORT , DateFormat.SHORT ).format ( d ) );

			// logger.warn ( "1 " +sdf.format(d) );
			fb.setLastModified ( sdf.format ( d ) );

			fb.setLastModified ( sdf.format ( d ) );
			// fb.setFileLastModified((DateFormat.getDateTimeInstance(DateFormat.LONG,
			// DateFormat.SHORT).format(new Date(file.lastModified ()))));
			// fb.setFileLastModified ( DateFormat.getDateTimeInstance (
			// DateFormat.SHORT , DateFormat.SHORT ).format ( d ) );

			// logger.warn ( "1 " + new Date ( file.lastModified () ) );
			// logger.warn ( "2 " + DateFormat.getDateTimeInstance (
			// DateFormat.LONG , DateFormat.SHORT ).format ( new Date (
			// file.lastModified () ) ) );
			// logger.warn ( "3 " + DateFormat.getDateTimeInstance (
			// DateFormat.SHORT , DateFormat.SHORT ).format ( d ) );

			fb.setFileName ( arr [i] );
			fb.setSize ( FindFileSize ( file ) );
			fb.setSizeInBytes ( file.length () );

			// logger.warn ( fb.toString () );

			list.addElement ( fb );
		}
		return ( FileBean [] ) list.toArray ( new FileBean[0] );
	}

	/**
	 * Get the File Size
	 * 
	 * @param PathName
	 * @param FileName
	 * @return
	 * @throws Exception
	 */
	public static long GetFileLength ( String PathName , String FileName )
																			throws Exception
	{
		File f = new File ( PathName + FileName );
		return ( f.length () );
	}

	/**
	 * gets list of files within a zip file.
	 * 
	 * @param zipFileName
	 * @return
	 */
	public static String [] getFileNameFromZipFile ( String zipFileName )
	{
		String filesInZip[] = null;
		try
		{
			ZipFile zf = new ZipFile ( zipFileName );
			int counter = 0;
			// Enumerate each entry
			for ( Enumeration entries = zf.entries () ; entries.hasMoreElements () ; )
			{
				// Get the entry name
				String zipEntryName = ( ( ZipEntry ) entries.nextElement () ).getName ();
				filesInZip [counter] = zipEntryName;
				counter++;
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace ();
		}
		return filesInZip;
	}

	/**
	 * 
	 * @param Path
	 * @param FileName
	 * @return
	 */
	public static long getFileSize ( String Path , String FileName )
	{
		File f = null;
		long size = 0;
		try
		{
			f = new File ( Path + FileName );
			size = f.length ();
		}
		catch ( Exception e )
		{

		}
		return size;
	}

	/**
	 * 
	 * @param decimalVal
	 * @return
	 */
	private static String getRoundedValue ( double decimalVal )
	{
		// System.out.println ( "\nThe first call......." + decimalVal );

		long beforeDecimalValue = decimalTokenize ( decimalVal , 1 );
		long afterDecimalValue = decimalTokenize ( decimalVal , 2 );
		long decimalValueLength = String.valueOf ( afterDecimalValue ).length ();
		long dividerVal = divider ( decimalValueLength - 1 );
		long dividedValue = afterDecimalValue / dividerVal;
		String finalResult = String.valueOf ( beforeDecimalValue ) + "." + String.valueOf ( dividedValue );

		// System.out.println ( "\nfinalResult......." + finalResult );

		return finalResult;
	}

	/**
	 * 
	 * @param b
	 * @return
	 */
	private static String getYesNo ( boolean b )
	{
		return ( b ? "Yes" : "No" );
	}

	public static void main ( String args[] ) throws Exception
	{
		FileBean fb[] = getFileInfoFromDirectory ( "C:/alljars" );
		for ( int i = 0 ; i < fb.length ; i++ )
		{
			System.out.println ( fb [i].getFileName () + " - " + fb [i].getSize () + " - " + fb [i].getSizeInBytes () + " - " + fb [i].getLastModified () );
		}

		long size = FileUtils.sizeOfDirectory ( new File ( "C:/alljars" ) );
		System.out.println ( size );
		System.out.println ( FileUtils.byteCountToDisplaySize ( size ) );
	}

	/**
	 * 
	 * @param PathFileName
	 * @return
	 * @throws Exception
	 */
	public static String ReadFile ( String PathFileName ) throws Exception
	{
		String returnString = "";
		String str = "";
		BufferedReader in = new BufferedReader ( new FileReader ( PathFileName ) );
		while ( ( str = in.readLine () ) != null )
		{
			returnString += str;
		}

		return returnString;
	}

	/**
	 * 
	 * @param Path
	 * @param FileName
	 * @return
	 * @throws Exception
	 */
	public static String ReadFile ( String Path , String FileName )
																	throws Exception
	{
		String returnString = "";
		String str = "";
		BufferedReader in = new BufferedReader ( new FileReader ( Path + FileName ) );
		while ( ( str = in.readLine () ) != null )
		{
			returnString += str;
		}

		return returnString;
	}

}