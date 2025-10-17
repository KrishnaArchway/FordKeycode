package com.archway.estore.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
 * File Name               : JdbcHelper.java 
 * Package Name            : com.archway.estore.common
 * 
 * Date                    : Jan 20, 2014 9:00:18 PM
 * 
 * Change Date             : Jan 20, 2014 9:00:18 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class JdbcHelper
{

	private static final Logger	logger	= Logger.getLogger ( JdbcHelper.class );

	/**
	 * Utility method used to rollback transactions.
	 * 
	 * @param aConn
	 *            the connection to attempt a transaction rollback on.
	 */
	public static void rollbackTransaction ( Connection aConn )
	{
		logger.entering ( "rollbackTransaction(Connection)" );
		logger.debug ( "Exception occurred in transaction" );
		try
		{
			logger.debug ( "Attempting to rollback changes" );
			aConn.rollback ();
			logger.debug ( "Changes rolled back successfully" );
		}
		catch ( SQLException sqle )
		{
			logger.error ( "Unable to rollback transaction" , sqle );
		}
		logger.exiting ( "rollbackTransaction(Connection)" );
	}

	/**
	 * Utility method used to assist with JDBC cleanup in the finally clause of
	 * a try/catch statement. Any one of the parameters can be <code>null</code>
	 * and all <code>SQLException</code>'s are caught and ignored.
	 * 
	 * @param aConn
	 *            a <code>Connection</code> to close. This paremeter can be
	 *            <code>null</code>.
	 * @param aStmt
	 *            a <code>Statement</code> to close. This parameter can be
	 *            <code>null</code>.
	 * @param aRst
	 *            a <code>ResultSet</code> to close. This parameter can be
	 *            <code>null</code>.
	 */
	public static void close (
								Connection aConn ,
								Statement aStmt ,
								ResultSet aRst )
	{
		logger.entering ( "close(Connection, Statement, ResultSet)" );
		if ( aRst != null )
		{
			try
			{
				logger.debug ( "Closing ResultSet" );
				aRst.close ();
				logger.debug ( "ResultSet closed successfully" );
			}
			catch ( SQLException sqle )
			{
				logger.error ( "Unable to close ResultSet" , sqle );
			}
		}
		if ( aStmt != null )
		{
			try
			{
				logger.debug ( "Closing Statement" );
				aStmt.close ();
				logger.debug ( "Statement closed successfully" );
			}
			catch ( SQLException sqle )
			{
				logger.error ( "Unable to close Statement" , sqle );
			}
		}
		if ( aConn != null )
		{
			try
			{
				logger.debug ( "Closing Connection" );
				aConn.close ();
				logger.debug ( "Connection closed successfully" );
			}
			catch ( SQLException sqle )
			{
				logger.error ( "Unable to close Connection" , sqle );
			}
		}
		logger.exiting ( "close(Connection, Statement, ResultSet)" );
	}

	/**
	 * Utility method used to obtain the next value from a database sequence.
	 * 
	 * @param sequenceName
	 *            the name of the sequence to use.
	 * @param jndiDatasourceName
	 *            the name under which the <code>DataSource</code> is
	 *            registered with JNDI that this sequence should be called in.
	 * @return the next value of the given sequence.
	 * @throws SQLException
	 *             in any database level errors occur obtaining the next value
	 *             of the sequence.
	 */
	public static int getNextSequence (
										String sequenceName ,
										String jndiDatasourceName )
																	throws SQLException
	{
		logger.entering ( "getNextSequence(String, String)" );
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		String sql = "SELECT " + sequenceName + ".nextval FROM dual";
		int nextVal = 0;
		try
		{
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			stmt = conn.createStatement ();
			logger.debug ( "Executing SQL: " + sql );
			rst = stmt.executeQuery ( sql );
			rst.next ();
			nextVal = rst.getInt ( 1 );
		}
		finally
		{
			close ( conn , stmt , rst );
		}
		logger.exiting ( "getNextSequence(String, String)" );
		return nextVal;
	}

	/**
	 * Utility method used to obtain the next value from a database sequence.
	 * 
	 * @param conn
	 *            database connection to use for obtaining the next sequence
	 *            value.
	 * @param sequenceName
	 *            the name of the sequence to use.
	 * @return the next value of the given sequence.
	 * @throws SQLException
	 *             in any database level errors occur obtaining the next value
	 *             of the sequence.
	 */
	public static int getNextSequence ( Connection conn , String sequenceName )
																				throws SQLException
	{
		logger.entering ( "getNextSequence(Connection, String)" );
		Statement stmt = null;
		ResultSet rst = null;
		String sql = "SELECT " + sequenceName + ".nextval FROM dual";
		int nextVal = 0;
		try
		{
			stmt = conn.createStatement ();
			logger.debug ( "Executing SQL: " + sql );
			rst = stmt.executeQuery ( sql );
			rst.next ();
			nextVal = rst.getInt ( 1 );
		}
		finally
		{
			close ( null , stmt , rst );
		}
		logger.exiting ( "getNextSequence(Connection, String)" );
		return nextVal;
	}

	/**
	 * Get connection.
	 * 
	 * @return the Connection object.
	 * @throws GageException
	 */
	public static Connection getConnection () throws GageException
	{
		logger.entering ( "insertListName(ListName)" );
		Connection conn = null;
		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			conn.setAutoCommit ( false );

			return conn;
		}
		catch ( Exception e )
		{
			// catch SQLExceptions and throw a GageException with the
			// appropriate
			// error code
			throw new GageException ( "Failed to get connection" , IConstants.SELECT_ERROR , e );
		}
	}
}