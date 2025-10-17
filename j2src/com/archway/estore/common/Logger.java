package com.archway.estore.common;

import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
 * File Name               : Logger.java 
 * Package Name            : com.archway.estore.common
 * 
 * Date                    : Jan 20, 2014 9:00:28 PM
 * 
 * Change Date             : Jan 20, 2014 9:00:28 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class Logger
{

	private static Boolean	logging	= new Boolean ( false );

	static
	{
		if ( ! isLogging () )
		{
			init ();
		}
	}

	public static Logger getLogger ( Class clazz )
	{
		return new Logger ( clazz );
	}

	public static Logger getLogger ( String className )
	{
		return new Logger ( className );
	}

	private static void init ()
	{
		InputStream propertiesFile = null;
		try
		{
			propertiesFile = Logger.class.getClassLoader ().getResourceAsStream ( "log4j.properties" );
			Properties logProperties = new Properties ();
			logProperties.load ( propertiesFile );
			PropertyConfigurator.configure ( logProperties );
			synchronized ( logging )
			{
				logging = new Boolean ( true );
			}
			org.apache.log4j.Logger.getLogger ( Logger.class ).info ( "Logging has been initialized" );
		}
		catch ( IOException ioe )
		{
			System.out.println ( "Logger initialization failed due to: " + ioe );
		}
		finally
		{
			if ( null != propertiesFile )
			{
				try
				{
					propertiesFile.close ();
				}
				catch ( Exception e )
				{
				}
			}
		}
	}

	private static boolean isLogging ()
	{
		synchronized ( logging )
		{
			return logging.booleanValue ();
		}
	}

	private org.apache.log4j.Logger	adapter	= null;

	private Logger ( Class clazz )
	{
		adapter = org.apache.log4j.Logger.getLogger ( clazz );
	}

	private Logger ( String className )
	{
		adapter = org.apache.log4j.Logger.getLogger ( className );
	}

	public void debug ( Object object )
	{
		adapter.debug ( object );
	}

	public void debug ( Object object , Throwable throwable )
	{
		adapter.debug ( object , throwable );
	}

	public void entering ( String methodName )
	{
		debug ( "Entering " + methodName );
	}

	public void error ( Object object )
	{
		adapter.error ( object );
	}

	public void error ( Object object , Throwable throwable )
	{
		adapter.error ( object , throwable );
	}

	public void exiting ( String methodName )
	{
		debug ( "Exiting " + methodName );
	}

	public void fatal ( Object object )
	{
		adapter.fatal ( object );
	}

	public void fatal ( Object object , Throwable throwable )
	{
		adapter.fatal ( object , throwable );
	}

	public void info ( Object object )
	{
		adapter.info ( object );
	}

	public void info ( Object object , Throwable throwable )
	{
		adapter.info ( object , throwable );
	}

	public boolean isDebugEnabled ()
	{
		return adapter.isDebugEnabled ();
	}

	public boolean isInfoEnabled ()
	{
		return adapter.isInfoEnabled ();
	}

	/**
	 * 
	 * @param in
	 */
	public void logBean ( String in )
	{
		String arr[] = in.split ( "," );
		for ( int i = 0 ; i <= arr.length ; i++ )
		{
			String innerArr[] = arr [i].split ( "=" );
			debug ( innerArr [0] + " = " + innerArr [1] );
		}

	}

	public void logToString ( Class cls , String str2Log )
	{
		String a = str2Log.replaceAll ( "=," , "=&nbsp;," ).replaceAll ( ", " , "," );
		String arr[] = a.split ( "," );
		// System.out.println(arr.length);
		warn ( " " );
		warn ( "<<<<<<<<<<<<< S T A R T >>>>>>>>>>>>> " + cls.getPackage () + " " + cls.getName () );
		for ( int i = 0 ; i < arr.length ; i++ )
		{
			String inner[] = arr [i].split ( "=" );
			warn ( inner [0] + "  -  " + inner [1] );
		}
		warn ( "<<<<<<<<<<<<< E N D >>>>>>>>>>>>> " + cls.getPackage () + " " + cls.getName () );
		warn ( " " );

	}

	public void logToString ( String className , String str2Log )
	{
		String a = str2Log.replaceAll ( "=," , "=&nbsp;," ).replaceAll ( ", " , "," );
		String arr[] = a.split ( "," );
		// System.out.println(arr.length);
		warn ( " " );
		warn ( "<<<<<<<<<<<<< S T A R T >>>>>>>>>>>>> " + className );
		for ( int i = 0 ; i < arr.length ; i++ )
		{
			String inner[] = arr [i].split ( "=" );
			warn ( inner [0] + "  -  " + inner [1] );
		}
		warn ( "<<<<<<<<<<<<< E N D >>>>>>>>>>>>> " + className );
		warn ( " " );

	}

	public void warn ( Object object )
	{
		adapter.warn ( object );
	}

	public void warn ( Object object , Throwable throwable )
	{
		adapter.warn ( object );
	}

}