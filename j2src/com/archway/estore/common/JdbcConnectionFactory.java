package com.archway.estore.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
 * File Name               : JdbcConnectionFactory.java 
 * Package Name            : com.archway.estore.common
 * 
 * Date                    : Jan 20, 2014 9:00:10 PM
 * 
 * Change Date             : Jan 20, 2014 9:00:10 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class JdbcConnectionFactory
{

	/**
	 * Reference to the singleton instance of this
	 * <code>JdbcConnectionFactory</code> class.
	 */
	private static JdbcConnectionFactory	me				= null;

	/**
	 * Cache of <code>DataSource</code> objects previously looked up by this
	 * factory instance. Caching is performed to increase performance.
	 */
	private HashMap							myDataSources	= new HashMap ();

	private static final Logger				logger			= Logger.getLogger ( JdbcConnectionFactory.class );

	/**
	 * Default constructor for the the <code>JdbcConnectionFactory</code>
	 * class.
	 */
	private JdbcConnectionFactory ()
	{
		super ();
	}

	/**
	 * Member method used to obtain a reference to a <code>DataSource</code>
	 * object based on a JNDI name. The cache will be searched first and if an
	 * instance is found, it will be returned. Otherwise, a JNDI lookup is
	 * initiated and then the results of that lookup are returned.
	 * 
	 * @param aJndiDataSourceName
	 *            name under which the desired <code>DataSource</code> is
	 *            registered with JNDI.
	 * @return a reference to the desired <code>DataSource</code> object.
	 * @throws SQLException
	 *             if a <code>DataSource</code> registered to the given JNDI
	 *             name cannot be found.
	 */
	private DataSource getDataSource ( String aJndiDataSourceName )
																	throws SQLException
	{
		logger.entering ( "getDataSource(String)" );
		DataSource ds = ( DataSource ) myDataSources.get ( aJndiDataSourceName );
		if ( ds == null )
		{
			initDataSource ( aJndiDataSourceName );
			ds = ( DataSource ) myDataSources.get ( aJndiDataSourceName );
		}
		logger.exiting ( "getDataSource(String)" );
		return ds;
	}

	/**
	 * Member method that performs a JNDI lookup and caches the
	 * <code>DataSource</code> object returned.
	 * 
	 * @param aJndiDataSourceName
	 *            name under which the desired <code>DataSource</code> is
	 *            registered with JNDI.
	 * @throws SQLException
	 *             if a <code>DataSource</code> registered to the given JNDI
	 *             name cannot be found.
	 */
	private void initDataSource ( String aJndiDataSourceName )
																throws SQLException
	{
		logger.entering ( "initDataSource(String)" );
		try
		{
			InitialContext initCtx = new InitialContext ();
			DataSource ds = null;
			try
			{
				// first try tomcat setting.
				ds = ( DataSource ) initCtx.lookup ( "java:comp/env/" + aJndiDataSourceName );
			}
			catch ( javax.naming.NamingException ine )
			{
				// OK. tomcat context failed, it must be using oc4j.
				ds = ( DataSource ) initCtx.lookup ( aJndiDataSourceName );
			}
			myDataSources.put ( aJndiDataSourceName , ds );
		}
		catch ( javax.naming.NamingException ne )
		{
			throw new SQLException ( "Unable to find a DataSource for " + aJndiDataSourceName + " due to " + ne.getExplanation () );
		}
		logger.exiting ( "initDataSource(String)" );
	}

	/**
	 * Static member method used to obtain a reference to the singleton instance
	 * of the <code>JdbcConnectionFactory</code> class.
	 * 
	 * @return a reference to the singleton instance of this class.
	 */
	private static JdbcConnectionFactory getInstance ()
	{
		if ( me == null )
		{
			me = new JdbcConnectionFactory ();
		}
		return me;
	}

	/**
	 * Static utility method used to lookup a {@link java.sql.Connection 
	 * Connection} from a <code>DataSource</code> registered with JNDI. The
	 * connection obtained with this method will not be secured with
	 * Database-level security.
	 * 
	 * @param aJndiDataSourceName
	 *            name under which the desired <code>DataSource</code> is
	 *            registered with JNDI.
	 * @return a JDBC connection
	 * @throws SQLException
	 *             when an error occurs obtaining the JDBC connection.
	 */
	public static final Connection getConnection ( String aJndiDataSourceName )
																				throws SQLException
	{
		logger.entering ( "getConnection(String)" );
		logger.debug ( "Obtaining connection from DataSource: JNDI mapping=" + aJndiDataSourceName );
		Connection conn = getInstance ().getDataSource ( aJndiDataSourceName ).getConnection ();
		if ( IConstants.DB_SECURITY_ENABLED )
		{
			logger.warn ( "An unsecure connection has been requested " + "with Database-level security enabled." );
		}
		conn.setAutoCommit ( true );
		logger.exiting ( "getConnection(String)" );
		return conn;
	}

	/**
	 * Static utility method used to lookup a {@link java.sql.Connection 
	 * Connection} from a <code>DataSource</code> registered with JNDI. The
	 * connection obtained with this method will be secured with Database-level
	 * security as long as the loginId provided is valid.
	 * 
	 * @param aJndiDataSourceName
	 *            name under which the desired <code>DataSource</code> is
	 *            registered with JNDI.
	 * @param aLoginId
	 *            name of the database user to use for securing this connection.
	 * @return a JDBC connection
	 * @throws SQLException
	 *             when an error occurs obtaining the JDBC connection.
	 */
	public static final Connection getConnection (
													String aJndiDataSourceName ,
													String aLoginId )
																		throws SQLException
	{
		/*
		 * logger.entering ( "getConnection(String, String)" ); logger.debug (
		 * "Obtaining connection from DataSource: JNDI mapping=" +
		 * aJndiDataSourceName ); Connection conn = getInstance ().getDataSource (
		 * aJndiDataSourceName ).getConnection (); if (
		 * IConstants.DB_SECURITY_ENABLED ) { if ( null == aLoginId ||
		 * "null".equals ( aLoginId ) ) { logger.warn ( "Obtaining a secure
		 * connection with an " + "invalid user account" ); } setGEMUser ( conn ,
		 * aLoginId ); } conn.setAutoCommit ( true ); logger.exiting (
		 * "getConnection(String, String)" );
		 */

		Connection conn = null;
		try
		{

			Context initContext = new InitialContext ();
			Context envContext = ( Context ) initContext.lookup ( "java:/comp/env" );
			DataSource ds = ( DataSource ) envContext.lookup ( aJndiDataSourceName );
			conn = ds.getConnection ();
			setGEMUser ( conn , aLoginId );
		}
		catch ( NamingException x )
		{
			logger.fatal ( "NamingException :" + x.getMessage () );
			System.out.println ( "NamingException :" + x.getMessage () );
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
		}

		return conn;
	}

	/**
	 * Sets the current User in GEM so that GEM security built into views will
	 * function. Currently logged on user will then have only their own
	 * permissions on data.
	 * 
	 * @param aConn
	 *            the connection to set the security user on.
	 * @param aLoginId
	 *            name of the database user to use for securing this connection.
	 * @return an int indicating 0 for failure and 1 for success.
	 */
	private static final int setGEMUser ( Connection aConn , String aLoginID )
	{
		logger.entering ( "setGEMUser(Connection, String)" );
		CallableStatement cstmt = null;
		String sql = "call gem_security_logon_pkg.setLoginId(?)";
		try
		{
			cstmt = aConn.prepareCall ( sql );
			cstmt.setString ( 1 , aLoginID );
			logger.debug ( "Executing SQL: " + sql );
			cstmt.execute ();
		}
		catch ( SQLException sqe )
		{
			return 0; // 0 is false
		}
		finally
		{
			// Do not close connection because it is managed by calling method.
			JdbcHelper.close ( null , cstmt , null );
		}
		logger.exiting ( "setGEMUser(Connection, String)" );
		return 1;
	}
}