package com.archway.estore.common;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;

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
 * File Name               : ConfigurationServlet.java 
 * Package Name            : com.archway.estore.common
 * 
 * Date                    : Apr 10, 2013 9:58:42 PM
 * 
 * Change Date             : Apr 10, 2013 9:58:42 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class ConfigurationServlet extends HttpServlet
{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long	serialVersionUID	= 1L;

	public static Properties	properties			= null;

	/**
	 * ConfigurationServlet constructor.
	 */
	public ConfigurationServlet ()
	{
		super ();
	}

	/**
	 * Initializes any application classes that need it based on init parameters.
	 * 
	 * @param ServeltConfig object from which servlet settings are retrieved.
	 */
	public void init ( ServletConfig config ) throws ServletException
	{
		super.init ( config );
	}

	/** Performs servlet and application cleanup */
	public void destroy ()
	{
		//csLog ( "destroy called" );
	}

	/**
	 * Converts servlet initialization parameters to a properties file usable by
	 * ConnectionManager.
	 * 
	 * @param config is the ServletConfig used to populate properties file.
	 * @return Properties file containing name-value pairs extracted from
	 *         ServletConfig
	 */
	private Properties convertToProps ( ServletConfig config )
	{
		Enumeration xenum = config.getInitParameterNames ();
		Properties props = new Properties ();
		String name = null;
		String value = null;
		while ( xenum.hasMoreElements () )
		{
			name = ( String ) xenum.nextElement ();
			value = config.getInitParameter ( name );
			props.setProperty ( name , value );
		}
		Cookie cookie = new Cookie("adfs_relay", "https://wwwqa.ownerverification.dealerconnection.com/keycode/adfs.jsp");
        cookie.setMaxAge(60 * 60 * 24); // 1 day
        cookie.setDomain("wwwqa.ownerverification.dealerconnection.com");
        cookie.setValue("https://wwwqa.ownerverification.dealerconnection.com/keycode/adfs.jsp");

        // Add the cookie to the response
       
		
		
		return props;
		
		
	}

	/**
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String getSystemProperty ( String key ) throws Exception
	{
		return System.getProperty ( key );
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getEnvFileName () throws Exception
	{
		//get the environment where the site is being deployed.

		String environmentFileName = "";
		environmentFileName = "keycode.app.properties.txt";
		return environmentFileName;
	}

	/**
	 * Loads application properties file if found. Otherwise returns empty
	 * properties object. This method is intended for Jserv, not Tomcat or Oracle
	 * Servlet Engine use. When the servlet engine is upgraded, the J2EE standard
	 * web.xml configuration file should be used. The method was placed in this
	 * unused servlet in order to locate a commonly used method in the object
	 * that is intended to perform this functionality as a startup servlet once
	 * the upgrade occurs.
	 * 
	 * @return application properties file if found, otherwise empty object.
	 */
	public static synchronized Properties getApplicationPropertiesFile ()
	{
		properties = new Properties ();
		try
		{
			InputStream is = Class.forName ( "com.archway.estore.common.ConfigurationServlet" ).getResourceAsStream ( getEnvFileName () );
			properties.load ( is );
			is.close ();
			checkRequiredProperties ( properties );
			logProperties ( properties );
		}
		catch ( Exception e )
		{/* Not much you can do to notify user unfortunately. */
		}
		return properties;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Properties testPropertiesFile () throws Exception
	{
		Properties properties = new Properties ();
		InputStream is = Class.forName ( "com.archway.estore.common.ConfigurationServlet" ).getResourceAsStream ( getEnvFileName () );
		properties.load ( is );
		logProperties ( properties );
		is.close ();
		return properties;
	}

	/**
	 * Simply logs the properties in use.
	 * 
	 * @param Properties file containing application property values.
	 */
	public static void logProperties ( Properties props )
	{
		if ( props == null )
		{
			//csLog ( "props is null" );
			return;
		}
		Enumeration xenum = props.propertyNames ();
		while ( xenum.hasMoreElements () )
		{
			String name = ( String ) xenum.nextElement ();
			//csLog ( "Prop Name: " + name + " Value: " + props.get ( name ) );
		}
	}

	/**
	 * Simply logs the properties in use.
	 * 
	 * @param Properties file containing application property values.
	 */
	public static void checkRequiredProperties ( Properties props )
	{
		if ( props == null )
		{
			//csLog ( "Application properties does not exist" );
			return;
		}
		//csLog ( "check required." );
		for ( int i = 0 ; i < IConstants.requiredAppProps.length ; i++ )
		{
			if ( props.getProperty ( IConstants.requiredAppProps [i] ) == null )
			{
				//csLog ( "Application Property: " + IConstants.requiredAppProps [i] + " DOES NOT EXIST!" );
				//csLog ( "Please check <application root>/WEB-INF/classes/com/gage/estore/common/" + IConstants.APP_PROP_FILE + " for the specified property." );
			}
		}
	}

	/**
	 * Convenience method for retrieving a specific property value.
	 * 
	 * @param String defining the property requested
	 * @return String containing the value or a null if none exists.
	 */
	public static synchronized String getApplicationProperty (
																String propertyName )
	{
		//csLog ( "getApplicationProperty called." );
		if ( properties == null )
		{
			properties = getApplicationPropertiesFile ();
		}
		String ret = properties.getProperty ( propertyName );
		if ( ret == null )
		{
			//csLog ( "Requested Application property " + propertyName + " not found." );
		}
		return ret;
	}

	/**
	 * Convenience method for retrieving a specific property value.
	 * 
	 * @param String defining the property requested
	 * @param String defining a value to default to if property doesn't exist.
	 * @return String containing the value or a null if none exists.
	 */
	public static synchronized String getApplicationProperty (
																String propertyName ,
																String defaultValue )
	{
		if ( properties == null )
		{
			properties = getApplicationPropertiesFile ();
		}
		String ret = properties.getProperty ( propertyName );
		if ( ret == null )
		{
			//csLog ( "Requested Application property " + propertyName + " not found.  Using default value." );
			ret = defaultValue;
		}
		return ret;
	}

	/**
	 * 
	 * @param msg
	 */
	public static void csLog ( String msg )
	{
		Writer writer = null;
		try
		{
			//File file = new File("cslog.txt");
			File file = new File ( ".." + File.separator + "Jserv" + File.separator + "logs" , "jserv.log" );
			String path = file.getAbsolutePath ();
			if ( ! file.exists () )
			{
				file = new File ( "logs" , "error_log" ); //Can't log to jserv.log? Try
				// apache's log file.
				path = file.getAbsolutePath ();
				if ( ! file.exists () )
				{
					file.createNewFile ();
				}
			}
			writer = new FileWriter ( path , true );
			writer.write ( new Date ().toString () + "   ConfigurationServlet: " + msg + "\r\n" );
		}
		catch ( Exception e )
		{
		}
		finally
		{
			try
			{
				writer.flush ();
				writer.close ();
			}
			catch ( Exception ee )
			{
			}
		}
	}
}