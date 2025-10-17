package com.archway.estore.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

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
 * File Name               : JakartaFtpWrapper.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:29 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:29 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class JakartaFtpWrapper extends FTPClient
{

	/** Use ASCII mode for file transfers */
	public boolean ascii () throws IOException
	{
		return setFileType ( FTP.ASCII_FILE_TYPE );
	}

	/** Use Binary mode for file transfers */
	public boolean binary () throws IOException
	{
		return setFileType ( FTP.BINARY_FILE_TYPE );
	}

	/** A convenience method for connecting and logging in */
	public boolean connectAndLogin (
									String host ,
									String userName ,
									String password )
														throws IOException ,
														UnknownHostException ,
														FTPConnectionClosedException
	{
		boolean success = false;
		connect ( host );
		success = login ( userName , password );
		if ( ! success ) disconnect ();
		return success;
	}

	/** Download a file from the server, and save it to the specified local file */
	public boolean downloadFile ( String serverFile , String localFile )
																		throws IOException ,
																		FTPConnectionClosedException
	{
		FileOutputStream out = new FileOutputStream ( localFile );
		boolean result = retrieveFile ( serverFile , out );
		out.close ();
		return result;
	}

	/**
	 * Get the list of files in the current directory as a Vector of Strings
	 * (excludes subdirectories)
	 */
	public Vector listFileNames ()
									throws IOException ,
									FTPConnectionClosedException
	{
		FTPFile [] files = listFiles ();
		Vector v = new Vector ();
		for ( int i = 0 ; i < files.length ; i++ )
		{
			if ( ! files [i].isDirectory () )
												v.addElement ( files [i].getName () );
		}
		return v;
	}

	/**
	 * 
	 * @param prefix
	 * @return
	 * @throws IOException
	 * @throws FTPConnectionClosedException
	 */
	public Vector listFileNames ( String prefix )
													throws IOException ,
													FTPConnectionClosedException
	{
		FTPFile [] files = listFiles ();
		Vector v = new Vector ();
		for ( int i = 0 ; i < files.length ; i++ )
		{
			if ( ! files [i].isDirectory () )
			{
				if ( files [i].getName ().startsWith ( prefix ) )
				{
					v.addElement ( files [i].getName () );
				}
			}
		}
		return v;
	}

	public String [] listFileNamesx ( String prefix )
														throws IOException ,
														FTPConnectionClosedException
	{
		FTPFile [] files = listFiles ();
		String returnString = "";
		for ( int i = 0 ; i < files.length ; i++ )
		{
			if ( ! files [i].isDirectory () )
			{
				if ( files [i].getName ().startsWith ( prefix ) )
				{
					// v.addElement ( files [i].getName () );
					returnString += files [i].getName () + "|";
				}
			}
		}
		return returnString.split ( "\\|" );
	}

	/**
	 * Get the list of files in the current directory as a single Strings,
	 * delimited by \n (char '10') (excludes subdirectories)
	 */
	public String listFileNamesString ()
										throws IOException ,
										FTPConnectionClosedException
	{
		return vectorToString ( listFileNames () , "\n" );
	}

	/**
	 * Get the list of subdirectories in the current directory as a Vector of
	 * Strings (excludes files)
	 */
	public Vector listSubdirNames ()
									throws IOException ,
									FTPConnectionClosedException
	{
		FTPFile [] files = listFiles ();
		Vector v = new Vector ();
		for ( int i = 0 ; i < files.length ; i++ )
		{
			if ( files [i].isDirectory () )
											v.addElement ( files [i].getName () );
		}
		return v;
	}

	/**
	 * Get the list of subdirectories in the current directory as a single
	 * Strings, delimited by \n (char '10') (excludes files)
	 */
	public String listSubdirNamesString ()
											throws IOException ,
											FTPConnectionClosedException
	{
		return vectorToString ( listSubdirNames () , "\n" );
	}

	/**
	 * Turn passive transfer mode on or off. If Passive mode is active, a PASV
	 * command to be issued and interpreted before data transfers; otherwise, a
	 * PORT command will be used for data transfers. If you're unsure which one
	 * to use, you probably want Passive mode to be on.
	 */
	public void setPassiveMode ( boolean setPassive )
	{
		if ( setPassive )
			enterLocalPassiveMode ();
		else
			enterLocalActiveMode ();

	}

	/** Upload a file to the server */
	public boolean uploadFile ( String localFile , String serverFile )
																		throws IOException ,
																		FTPConnectionClosedException
	{
		FileInputStream in = new FileInputStream ( localFile );
		boolean result = storeFile ( serverFile , in );
		in.close ();
		return result;
	}

	/** Convert a Vector to a delimited String */
	private String vectorToString ( Vector v , String delim )
	{
		StringBuffer sb = new StringBuffer ();
		String s = "";
		for ( int i = 0 ; i < v.size () ; i++ )
		{
			sb.append ( s ).append ( ( String ) v.elementAt ( i ) );
			s = delim;
		}
		return sb.toString ();
	}

}
