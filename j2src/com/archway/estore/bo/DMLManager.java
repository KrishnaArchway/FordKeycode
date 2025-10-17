package com.archway.estore.bo;

import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.GageException;
import com.archway.estore.common.IConstants;
import com.archway.estore.common.JdbcConnectionFactory;
import com.archway.estore.common.JdbcHelper;
import com.archway.estore.common.Logger;
import com.archway.estore.entities.ReportEntity;
import com.archway.estore.formbean.BlockedPACodeBean;
import com.archway.estore.formbean.EditRegistrationVINBean;
import com.archway.estore.formbean.VINRegisterBean;
import com.archway.estore.session.SessionBean;
import com.archway.estore.util.StringUtility;

import oracle.jdbc.driver.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : DMLManager.java 
 * Package Name            : com.archway.estore.bo
 * 
 * Date                    : Apr 16, 2013 2:28:02 PM
 * 
 * Change Date             : Apr 16, 2013 2:28:02 PM
 * 							 Apr 20, 2013 2:43:53 PM
 * 							 Jun 3, 2013 8:58:30 AM
 * 							 Apr 7, 2014 8:55:56 AM
 * 							 May 14, 2014 9:16:28 PM
 * 							 Aug 18, 2014 2:13:49 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class DMLManager
{

	private static Logger	logger	= Logger.getLogger ( DMLManager.class );

	/**
	 * 
	 * @param vin
	 * @return
	 */
	public static boolean authincateVIn ( String vin ) throws Exception
	{
		String methodName = "DMLManager.java authincateVIn ( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		boolean returnFlag = false;

		String sql = "{call keycode_pkg.Get_vin_registration(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , vin );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			String yesNo = cstmt.getString ( 2 );

			logger.debug ( "yesNo : " + yesNo );

			if ( yesNo != null && yesNo.equalsIgnoreCase ( "Y" ) )
			{
				// if Yes then the vin is already into system
				returnFlag = true;
			}
			else
			{
				// if No then the vin is not in the system, allow data capture
				returnFlag = false;
			}

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 3 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 4 ) );
			logger.warn ( "returnFlag 	:" + returnFlag );

		}
		catch ( Exception e )
		{

			returnFlag = false;
			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	public static boolean authincateVinNew ( String vin ) throws Exception
	{
		String methodName = "DMLManager.java authincateVinNew ( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		boolean returnFlag = false;

		String sql = "{call keycode_pkg.get_new_vin_registration(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , vin );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			String yesNo = cstmt.getString ( 2 );

			logger.debug ( "yesNo : " + yesNo );

			if ( yesNo != null && yesNo.equalsIgnoreCase ( "Y" ) )
			{
				// if Yes then the vin is already into system
				returnFlag = true;
			}
			else
			{
				// if No then the vin is not in the system, allow data capture
				returnFlag = false;
			}

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 3 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 4 ) );
			logger.warn ( "returnFlag 	:" + returnFlag );

		}
		catch ( Exception e )
		{

			returnFlag = false;
			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	public static String getAuthenticatedVIN ( String vin ) throws Exception
	{

		String methodName = "DMLManager.java getAuthenticatedVIN ( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String authenticatedVIN = null;
		String sql = "{call keycode_pkg.authentification_vin(?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , vin );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );

			cstmt.execute ();

			authenticatedVIN = cstmt.getString ( 2 );

			logger.debug ( "authenticatedVIN : " + authenticatedVIN );

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return authenticatedVIN;

	}

	/**
	 * 
	 * @param vin
	 * @param pacode
	 * @return
	 * @throws Exception
	 */
	public static String getAuthNewVinRegistration4WebService (
																String vin ,
																String pacode )
																				throws Exception
	{

		String methodName = "DMLManager.java getAuthNewVinRegistration4WebService ( String , String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String returnFlag = "";

		String sql = "{call keycode_pkg.New_Authentification_request(?,?,?,?,?)}";

		try
		{

			logger.warn ( "vin 		:" + vin );
			logger.warn ( "pacode 		:" + pacode );

			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , vin );
			cstmt.setString ( 2 , pacode );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 5 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			String yesNo = cstmt.getString ( 3 );
			returnFlag = yesNo;
			logger.debug ( "yesNo : " + yesNo );

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 4 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 5 ) );
			logger.warn ( "returnFlag 	:" + yesNo );

		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @param vin
	 * @param pacode
	 * @return
	 * @throws Exception
	 */
	public static String getAuthVinRegistration4WebService (
															String vin ,
															String pacode )
																			throws Exception
	{

		String methodName = "DMLManager.java getVinRegistration4WebService ( String , String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String returnFlag = "";

		String sql = "{call keycode_pkg.Authentification_request(?,?,?,?,?)}";

		try
		{

			logger.warn ( "vin 		:" + vin );
			logger.warn ( "pacode 		:" + pacode );

			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , vin );
			cstmt.setString ( 2 , pacode );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 5 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			String yesNo = cstmt.getString ( 3 );
			returnFlag = yesNo;
			logger.debug ( "yesNo : " + yesNo );

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 4 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 5 ) );
			logger.warn ( "returnFlag 	:" + yesNo );

		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static BlockedPACodeBean [] getBlockedPACode () throws Exception
	{
		String methodName = "DMLManager.java getBlockedPACode()";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		ArrayList aList = new ArrayList ();
		String sql = "{call keycode_pkg.Get_blocked_PA_LIST(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );
			cstmt.registerOutParameter ( 1 , OracleTypes.CURSOR );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.NUMERIC );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			int sqlCode = cstmt.getInt ( 3 );
			String sqlMsg = cstmt.getString ( 4 );

			logger.warn ( "sqlCode 		:" + sqlCode );
			logger.warn ( "sqlMessage 	:" + sqlMsg );

			if ( sqlCode == 0 )
			{
				rs = ( ResultSet ) cstmt.getObject ( 1 );
				while ( rs.next () )
				{
					BlockedPACodeBean obj = new BlockedPACodeBean ();
					obj.setBlockedPaId ( rs.getString ( "blocked_pa_id" ) );
					obj.setPaCode ( rs.getString ( "pa_code" ) );
					obj.setDealerShipName ( rs.getString ( "dealership_name" ) );
					obj.setBlockedFalg ( rs.getString ( "blocked" ) );
					aList.add ( obj );
				}
			}
			logger.warn ( "aList.size 	:" + aList.size () );
		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );
			throw new GageException ( e.getMessage () , 0 , e );
		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return ( BlockedPACodeBean [] ) aList.toArray ( new BlockedPACodeBean[0] );
	}

	/**
	 * 
	 * @param parts_account
	 * @return
	 * @throws Exception
	 */
	public static int getCounterNewVehicle ( String parts_account )
																	throws Exception
	{

		String methodName = "DMLManager.java getCounterNewVehicle ( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		int counter = 0;

		String sql = "{call keycode_pkg.Count_registrations(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , parts_account );
			cstmt.registerOutParameter ( 2 , java.sql.Types.INTEGER );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			counter = cstmt.getInt ( 2 );

			logger.debug ( "counter : " + counter );

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 3 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 4 ) );

		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return counter;
	}

	/**
	 * 
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	public static String getNewVinRegistration4WebService ( String vin )
																		throws Exception
	{

		String methodName = "DMLManager.java getNewVinRegistration4WebService ( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String returnFlag = "";

		String sql = "{call keycode_pkg.Get_new_vin_registration(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , vin );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			String yesNo = cstmt.getString ( 2 );
			returnFlag = yesNo;
			logger.debug ( "yesNo : " + yesNo );

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 3 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 4 ) );
			logger.warn ( "returnFlag 	:" + yesNo );

		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static ReportEntity [] getReportData (
													String startDate ,
													String endDate )
	{
		String methodName = "DMLManager.java getReportData(String , String)";
		logger.entering ( methodName );

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		ArrayList aList = new ArrayList ();
		String sql = "{call keycode_pkg.Get_Vin_exceptions(?,?,?,?,?,?)}";
		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , startDate );
			cstmt.setString ( 2 , endDate );
			cstmt.registerOutParameter ( 3 , OracleTypes.CURSOR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 5 , java.sql.Types.NUMERIC );
			cstmt.registerOutParameter ( 6 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			int sqlCode = cstmt.getInt ( 5 );
			String sqlMsg = cstmt.getString ( 6 );

			logger.warn ( "sqlCode 		:" + sqlCode );
			logger.warn ( "sqlMessage 	:" + sqlMsg );

			if ( sqlCode == 0 ) 
			{
				rs = ( ResultSet ) cstmt.getObject ( 3 );
				while ( rs.next () )
				{
					ReportEntity re = new ReportEntity ();
					re.setVin ( rs.getString ( "vin" ) );
					re.setPa_code ( rs.getString ( "pa_code" ) );
					re.setPa_name ( rs.getString ( "pa_name" ) );
					re.setPa_phone ( rs.getString ( "pa_phone" ) );
					re.setFmcdealer_userid ( rs.getString ( "Fmcdealer_userid" ) );
					re.setVo_first_name ( rs.getString ( "Vo_first_name" ) );
					re.setVo_last_name ( rs.getString ( "Vo_last_name" ) );
					re.setVo_address ( rs.getString ( "Vo_address" ) );
					re.setVo_city ( rs.getString ( "Vo_city" ) );
					re.setVo_state ( rs.getString ( "Vo_state" ) );
					re.setVo_zip ( rs.getString ( "vo_zip" ) );
					re.setVo_phone ( rs.getString ( "Vo_phone" ) );
					re.setId_title ( rs.getString ( "Id_title" ) );
					re.setId_registration ( rs.getString ( "Id_registration" ) );
					re.setId_insurance ( rs.getString ( "Id_insurance" ) );
					re.setId_other ( rs.getString ( "Id_other" ) );
					re.setOther_descrip ( rs.getString ( "Other_descrip" ) );
					re.setException ( rs.getString ( "Exception" ) );
					re.setCircumstances_descrip ( rs.getString ( "Circumstances_descrip" ) );
					re.setVehicle_year ( rs.getString ( "Vehicle_year" ) );
					re.setVehicle_make ( rs.getString ( "Vehicle_make" ) );
					re.setVehicle_model ( rs.getString ( "Vehicle_model" ) );
					re.setVehicle_color ( rs.getString ( "Vehicle_color" ) );
					re.setLicense_plate_number ( rs.getString ( "License_plate_number" ) );
					re.setState_vehicle_reg ( rs.getString ( "State_vehicle_reg" ) );
					re.setOdometer ( rs.getString ( "Odometer" ) );
					re.setSubmit_first_name ( rs.getString ( "Submit_first_name" ) );
					re.setSubmit_last_name ( rs.getString ( "Submit_last_name" ) );
					re.setCreation_date ( rs.getString ( "Creation_date" ) );
					aList.add ( re );
					logger.warn(re.toString());
				}
			}
			logger.warn ( "aList.size 	:" + aList.size () );
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , rs );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return ( ReportEntity [] ) aList.toArray ( new ReportEntity[0] );
	}

	/**
	 * 
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	public static String getVinRegistration4WebService ( String vin )
																		throws Exception
	{

		String methodName = "DMLManager.java getVinRegistration4WebService ( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String returnFlag = "";

		String sql = "{call keycode_pkg.Get_vin_registration(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , vin );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			String yesNo = cstmt.getString ( 2 );
			returnFlag = yesNo;
			logger.debug ( "yesNo : " + yesNo );

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 3 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 4 ) );
			logger.warn ( "returnFlag 	:" + yesNo );

		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @param ownerBean
	 * @param userId
	 * @param paCode
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	/*public static boolean insertOwnerVerification (
	 VINRegisterBean ownerBean ,
	 String userId ,
	 String paCode ,
	 String vin )
	 throws Exception */

	public static boolean insertVerification ( SessionBean sb )
																throws Exception

	{

		boolean isInsert = false;
		String methodName = "DMLManager.java insertVerification ( SessionBean )";
		logger.entering ( methodName );

		logger.warn ( sb.toString () );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;

		String sql = "{call keycode_pkg.Ins_Verification_Registration(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		try
		{

			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			// conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName ,
			// DB_SECURITY_USERNAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );
			java.sql.Date sqlDate = null;

			VINRegisterBean ownerBean = ( VINRegisterBean ) sb.getObjVinRegisterBean ();

			String str_date = ownerBean.getLicenseExpiryDate ();
			logger.debug ( "str_date === >>:" + str_date );

			if ( ! StringUtility.isStringBlank ( str_date ) )
			{

				//String str_date = ownerBean.getLicenseExpiryDate ();
				DateFormat formatter;
				Date date;

				formatter = new SimpleDateFormat ( "MM/dd/yyyy" );
				date = ( Date ) formatter.parse ( str_date );
				sqlDate = new java.sql.Date ( date.getTime () );

			}

			String authenticatedVIN = getAuthenticatedVIN ( sb.getVin () );
			if ( StringUtility.isStringBlank ( authenticatedVIN ) )
			{
				authenticatedVIN = "";
			}

			cstmt.setString ( 1 , ownerBean.getLastName () );
			cstmt.setString ( 2 , ownerBean.getFirstName () );
			cstmt.setString ( 3 , ownerBean.getSubmitLastName () );
			cstmt.setString ( 4 , ownerBean.getSubmitFirstName () );
			cstmt.setString ( 5 , sb.getPacode () );
			cstmt.setString ( 6 , sb.getWsl () );

			String dealerShipName = DMLManager.isPACodeValid ( sb.getPacode () );
			if ( dealerShipName != null && dealerShipName.equalsIgnoreCase ( "XX" ) )
			{
				dealerShipName = "";
			}

			cstmt.setString ( 7 , dealerShipName );
			cstmt.setString ( 8 , ( StringUtility.isStringBlank ( ownerBean.getBusinessOrFleetName () ) ? "" : ownerBean.getBusinessOrFleetName () ) );

			cstmt.setString ( 9 , ownerBean.getAddress () );
			cstmt.setString ( 10 , ownerBean.getCity () );
			cstmt.setString ( 11 , ownerBean.getState () );
			cstmt.setString ( 12 , ownerBean.getZipcode () );
			cstmt.setString ( 13 , ownerBean.getPhoneNo () );
			cstmt.setString ( 14 , ownerBean.getLicenseNo () );
			cstmt.setString ( 15 , ownerBean.getLicenseState () );
			cstmt.setDate ( 16 , sqlDate );

			// choose one
			String chooseOne = StringUtility.processNullToEmpty ( ownerBean.getAdditionalIdentity () );
			String title = "";
			String registration = "";
			String insurance = "";
			String other = "";
			logger.debug ( "ChosseOne ======= : " + chooseOne );
			if ( chooseOne != null || ! chooseOne.equalsIgnoreCase ( "" ) )
			{
				if ( chooseOne.equalsIgnoreCase ( "title" ) )
				{
					title = "Y";
				}
				else if ( chooseOne.equalsIgnoreCase ( "registration" ) )
				{
					registration = "Y";
				}
				else if ( chooseOne.equalsIgnoreCase ( "insurance" ) )
				{
					insurance = "Y";
				}
				else if ( chooseOne.equalsIgnoreCase ( "other" ) )
				{
					other = "Y";
				}
			}

			long odometer = 0;

			if ( ! StringUtility.isStringBlank ( ownerBean.getVehicleOdometer () ) )
			{
				odometer = Long.parseLong ( ownerBean.getVehicleOdometer () );
			}

			cstmt.setString ( 17 , title );
			cstmt.setString ( 18 , registration );
			cstmt.setString ( 19 , insurance );
			cstmt.setString ( 20 , other );
			cstmt.setString ( 21 , ownerBean.getOtherExplain () );
			cstmt.setString ( 22 , ownerBean.getVehicleYear () );
			cstmt.setString ( 23 , ownerBean.getVehicleMake () );
			cstmt.setString ( 24 , ownerBean.getVehicleModel () );
			cstmt.setString ( 25 , ownerBean.getVehiclecolor () );
			cstmt.setString ( 26 , ownerBean.getVehiclePlateNo () );
			cstmt.setString ( 27 , ownerBean.getVehicleState () );
			cstmt.setString ( 28 , sb.getVin () );
			cstmt.setString ( 29 , authenticatedVIN );
			cstmt.setLong ( 30 , odometer );
			cstmt.setString ( 31 , (sb.getRegisteredVehicleToWhom().equalsIgnoreCase("OWNER"))?"N":"Y");
			//cstmt.setString ( 31 , "" );
			cstmt.setString ( 32 , ownerBean.getDealerTitled () );
			cstmt.setString ( 33 , ownerBean.getDealerPosses () );
			cstmt.setString ( 34 , ownerBean.getDealerSell () );
			cstmt.setString ( 35 , ownerBean.getNoAdditionalIdentity().equalsIgnoreCase("TRUE")?"Y":"" );
			cstmt.setString ( 36 , ownerBean.getAddtionalCircumstances () );
			cstmt.setString ( 37 , ownerBean.getDescribeCircumstances () );
			cstmt.setDate ( 38 , null );
			cstmt.setString ( 39 , ownerBean.getNoAdditionalIdentity().equalsIgnoreCase("TRUE")?"Y":"" );

			cstmt.registerOutParameter ( 40 , java.sql.Types.NUMERIC );
			cstmt.registerOutParameter ( 41 , java.sql.Types.VARCHAR );

			logger.debug ( " 1  == >> : " + ownerBean.getLastName () );
			logger.debug ( " 2  == >> : " + ownerBean.getFirstName () );
			logger.debug ( " 3  == >> : " + ownerBean.getSubmitLastName () );
			logger.debug ( " 4  == >> : " + ownerBean.getSubmitFirstName () );
			logger.debug ( " 5  == >> : " + sb.getPacode () );
			logger.debug ( " 6  == >> : null" );
			logger.debug ( " 7  == >> : null" );
			logger.debug ( " 8  == >> : null" );
			logger.debug ( " 9  == >> : " + ownerBean.getAddress () );
			logger.debug ( " 10 == >> : " + ownerBean.getCity () );
			logger.debug ( " 11 == >> : " + ownerBean.getState () );
			logger.debug ( " 12 == >> : " + ownerBean.getZipcode () );
			logger.debug ( " 13 == >> : " + ownerBean.getPhoneNo () );
			logger.debug ( " 14 == >> : " + ownerBean.getLicenseNo () );
			logger.debug ( " 15 == >> : " + ownerBean.getLicenseState () );
			logger.debug ( " 16 == >> : " + sqlDate );
			logger.debug ( " 17 == >> : " + title );
			logger.debug ( " 18 == >> : " + registration );
			logger.debug ( " 19 == >> : " + insurance );
			logger.debug ( " 20 == >> : " + other );
			logger.debug ( " 21 == >> : " + ownerBean.getOtherExplain () );
			logger.debug ( " 22 == >> : " + ownerBean.getVehicleYear () );
			logger.debug ( " 23 == >> : " + ownerBean.getVehicleMake () );
			logger.debug ( " 24 == >> : " + ownerBean.getVehicleModel () );
			logger.debug ( " 25 == >> : " + ownerBean.getVehiclecolor () );
			logger.debug ( " 26 == >> : " + ownerBean.getVehiclePlateNo () );
			logger.debug ( " 27 == >> : " + ownerBean.getVehicleState () );
			logger.debug ( " 28 == >> : " + sb.getVin () );
			logger.debug ( " 29 == >> : " + authenticatedVIN );
			logger.debug ( " 30 == >> : " + odometer );
			logger.debug ( " 31 == >> : " + ( sb.getRegisteredVehicleToWhom().equalsIgnoreCase("OWNER")?"N":"Y"));
			logger.debug ( " 32 == >> : " + ownerBean.getDealerTitled () );
			logger.debug ( " 33 == >> : " + ownerBean.getDealerPosses () );
			logger.debug ( " 34 == >> : " + ownerBean.getDealerSell () );
			logger.debug ( " 35 == >> : null" );
			logger.debug ( " 36 == >> : " + ownerBean.getAddtionalCircumstances () );
			logger.debug ( " 37 == >> : " + ownerBean.getDescribeCircumstances () );
			logger.debug ( " 38 == >> : null" );
			logger.debug ( " 39 == >> : " + ownerBean.getOwnerAgreeTermsFalg () );

			cstmt.execute ();

			int sqlCode = cstmt.getInt ( 40 );

			if ( sqlCode > 0 )
			{
				isInsert = true;
			}
			logger.debug ( "sqlCode : " + sqlCode );
			logger.debug ( "Sql Error : " + cstmt.getString ( 41 ) );

			isInsert = true;

		}
		catch ( Exception e )
		{

			isInsert = false;
			logger.warn ( "Exception " + e.getMessage () );

			throw new GageException ( e.getMessage () , 0 , e );

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return isInsert;
	}

	/**
	 * 
	 * @param vin
	 * @return
	 */
	public static String isPABlocked ( String paCode ) throws Exception
	{
		String methodName = "DMLManager.java isPABlocked ( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String returnFlag = "";

		String sql = "{call keycode_pkg.IS_PA_blocked(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , paCode );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			returnFlag = cstmt.getString ( 2 );

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
			throw new GageException ( e.getMessage () , 0 , e );
		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @param paCode
	 * @return
	 * @throws Exception
	 */
	public static String isPACodeValid ( String paCode ) throws Exception
	{
		String methodName = "DMLManager.java isPACodeValid( String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String returnFlag = "";

		String sql = "{call keycode_pkg.get_dealership_name(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			cstmt.setString ( 1 , paCode );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.INTEGER );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			if ( cstmt.getInt ( 3 ) == - 1 )
				returnFlag = "XX";
			else
				returnFlag = cstmt.getString ( 2 );

			logger.debug ( "Retrun Flag ---------- : " + returnFlag );
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
			throw new GageException ( e.getMessage () , 0 , e );
		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnFlag;
	}

	/**
	 * 
	 * @param pacode
	 * @param fmcdealerId
	 * @param vin
	 * @param dealerVehicleYear
	 * @param dealerVehicleMake
	 * @param dealerVehicleModel
	 * @param dealerVehicleInfo
	 * @param agreementCheck
	 * @return
	 * @throws Exception
	 */
	public static boolean saveNewVehicleData (
												String pacode ,
												String fmcdealerId ,
												String vin ,
												String dealerVehicleYear ,
												String dealerVehicleMake ,
												String dealerVehicleModel ,
												String dealerVehicleInfo ,
												String agreementCheck ,
												String firstName ,
												String lastName )
																	throws Exception
	{

		String methodName = "DMLManager.java saveNewVehicleData ( String , String , String , String , String , String , String , String ,String , String )";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		String sql = "{call keycode_pkg.Ins_New_Registration(?,?,?,?,?,?,?,?,?,?,?)}";
		boolean flag = false;

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );

			/*
			 procedure Ins_New_Registration         (p_pa_code                 in varchar2
			 ,p_fmcdealer_userid        in varchar2
			 ,p_dealership_name         in varchar2
			 ,p_vehicle_year            in varchar2
			 ,p_vehicle_make            in varchar2
			 ,p_vehicle_model           in varchar2
			 ,p_vin                     in varchar2
			 ,p_circumstances_descrip   in varchar2
			 ,o_sqlcode                OUT number
			 ,o_sqlerrm                OUT varchar2) is
			 */
			cstmt.setString ( 1 , pacode );
			cstmt.setString ( 2 , fmcdealerId );

			cstmt.setString ( 3 , dealerVehicleYear );
			cstmt.setString ( 4 , dealerVehicleMake );
			cstmt.setString ( 5 , dealerVehicleModel );
			cstmt.setString ( 6 , vin );
			cstmt.setString ( 7 , dealerVehicleInfo );
			cstmt.setString ( 8 , firstName );
			cstmt.setString ( 9 , lastName );
			cstmt.registerOutParameter ( 10 , java.sql.Types.INTEGER );
			cstmt.registerOutParameter ( 11 , java.sql.Types.VARCHAR );

			cstmt.execute ();

			logger.warn ( "sqlCode 		:" + cstmt.getString ( 10 ) );
			logger.warn ( "sqlMessage 	:" + cstmt.getString ( 11 ) );

			flag = true;

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
			flag = false;

		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return flag;

	}

	/**
	 * 
	 * @param strPaCode
	 * @return
	 * @throws Exception
	 */
	public static String savePACode ( String strPaCode ) throws Exception
	{
		String methodName = "DMLManager.java savePACode()";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;

		String returnStatus = "";
		String sql = "{call keycode_pkg.Insert_blocked_PA(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );
			cstmt.setString ( 1 , strPaCode );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.NUMERIC );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			int sqlCode = cstmt.getInt ( 3 );
			String sqlMsg = cstmt.getString ( 4 );

			logger.warn ( "sqlCode 		:" + sqlCode );
			logger.warn ( "sqlMessage 	:" + sqlMsg );

			returnStatus = sqlCode + "|" + cstmt.getString ( 2 );

			logger.warn ( "returnStatus 	:" + returnStatus );
		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );
			throw new GageException ( e.getMessage () , 0 , e );
		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnStatus;
	}

	/**
	 * Testing the Database Connection
	 *
	 */
	public static void testConnection ()
	{
		String methodName = "DMLManager.java testConnection ()";
		logger.entering ( methodName );

		String sql = "select global_name dt from global_name";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;

		String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

		try
		{
			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			stmt = conn.createStatement ();
			rst = stmt.executeQuery ( sql );
			while ( rst.next () )
			{
				logger.warn ( rst.getString ( "dt" ) );
			}
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception  e :-" + e.getMessage () );
		}
		finally
		{
			logger.exiting ( methodName );
		}

	}

	/**
	 * 
	 * @param strPaId
	 * @return
	 * @throws Exception
	 */
	public static String updateBlockedPACode ( String strPaId )
																throws Exception
	{
		String methodName = "DMLManager.java getBlockedPACode()";
		logger.entering ( methodName );

		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;

		String returnStatus = "";
		String sql = "{call keycode_pkg.update_blocked_pa(?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );
			cstmt.setInt ( 1 , Integer.parseInt ( strPaId ) );
			cstmt.setString ( 2 , "N" );
			cstmt.registerOutParameter ( 3 , java.sql.Types.NUMERIC );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			int sqlCode = cstmt.getInt ( 3 );
			String sqlMsg = cstmt.getString ( 4 );

			logger.warn ( "sqlCode 		:" + sqlCode );
			logger.warn ( "sqlMessage 	:" + sqlMsg );

			returnStatus = sqlCode + "|" + sqlMsg;

			logger.warn ( "returnStatus 	:" + returnStatus );
		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );
			throw new GageException ( e.getMessage () , 0 , e );
		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}

		return returnStatus;
	}
	
	
	 /**
		 * 
		 * @return
		 * @throws Exception
		 */
		public static EditRegistrationVINBean [] getVinInfoPa(String searchPa, int noOfDays) throws Exception
		{
			String methodName = "DMLManager.java getVinInfoPa()";
			logger.entering ( methodName );
			logger.warn ( "searchPa 		:" + searchPa + ":noOfDays:" + noOfDays );
			// declare statement and result set
			Connection conn = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
			ArrayList aList = new ArrayList ();
			String sql = "{call keycode_pkg.get_Vin_Info_PA(?,?,?,?,?,?)}";

			try
			{
				String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

				conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
				cstmt = conn.prepareCall ( sql );
				
				cstmt.setString(1, searchPa);
				cstmt.setInt(2, noOfDays);			
				cstmt.registerOutParameter ( 3 , OracleTypes.CURSOR );
				cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
				cstmt.registerOutParameter ( 5 , java.sql.Types.NUMERIC );
				cstmt.registerOutParameter ( 6 , java.sql.Types.VARCHAR );
				logger.debug("Before execute");
				cstmt.execute ();
				logger.debug("After execute");

				int sqlCode = cstmt.getInt ( 5 );
				String sqlMsg = cstmt.getString ( 4 );

				logger.warn ( "sqlCode 		:" + sqlCode );
				logger.warn ( "sqlMessage 	:" + sqlMsg );

				if ( sqlCode == 0 )
				{
					rs = ( ResultSet ) cstmt.getObject ( 3 );
					String result = "";
					while ( rs.next () )
					{	
						EditRegistrationVINBean editRegistrationVINBean = getVinInfo(rs.getString ( "VIN" ), noOfDays);
						aList.add ( editRegistrationVINBean );
					}
				}
				logger.warn ( "aList.size 	:" + aList.size () );
			}
			catch ( Exception e )
			{

				logger.warn ( "Exception " + e.getMessage () );
				throw new GageException ( e.getMessage () , 0 , e );
			}
			finally
			{
				try
				{
					JdbcHelper.close ( conn , cstmt , null );
				}
				catch ( Exception e )
				{
					logger.warn ( "finally exception " + e.getMessage () );
				}
				logger.exiting ( methodName );
			}

			return ( EditRegistrationVINBean [] ) aList.toArray ( new EditRegistrationVINBean[0] );
		}
		
		
		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		public static EditRegistrationVINBean getVinInfo(String selectedVin, int days) throws Exception
		{
			String methodName = "DMLManager.java getVinInfo()";
			logger.entering ( methodName );

			logger.warn ( "selectedVin : " + selectedVin  + ": days:" + days);
			// declare statement and result set
			Connection conn = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
			EditRegistrationVINBean editRegistrationVINBean = null; 
			
			String sql = "{call keycode_pkg.get_vin_info(?,?,?,?,?,?)}";

			try
			{
				String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );
				conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );				
				
				cstmt = conn.prepareCall ( sql );
				
				cstmt.setString(1, selectedVin);
				if(days>0)
					cstmt.setInt(2, days);
				else
					cstmt.setNull(2, java.sql.Types.NUMERIC );
				
				cstmt.registerOutParameter ( 3 , OracleTypes.CURSOR );
				cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
				cstmt.registerOutParameter ( 5 , java.sql.Types.NUMERIC );
				cstmt.registerOutParameter ( 6 , java.sql.Types.VARCHAR );
				
				logger.debug("Before execute");
				cstmt.execute ();
				logger.debug("After execute");

				int sqlCode = cstmt.getInt ( 5 );
				String sqlMsg = cstmt.getString ( 4 );

				logger.warn ( "sqlCode 		:" + sqlCode );
				logger.warn ( "sqlMessage 	:" + sqlMsg );

				if ( sqlCode == 0 )
				{
					rs = ( ResultSet ) cstmt.getObject ( 3 );
					
					while ( rs.next () )
					{												
						logger.debug("record found");
						editRegistrationVINBean = new EditRegistrationVINBean();
						
						editRegistrationVINBean.setVin( rs.getString("vin") );
						editRegistrationVINBean.setVin_verification_id( rs.getString("vin_verification_id") );
						editRegistrationVINBean.setVehicle_make( rs.getString("vehicle_make") );
						editRegistrationVINBean.setVehicle_model( rs.getString("vehicle_model") );
						editRegistrationVINBean.setVehicle_year( rs.getString("vehicle_year") );
						editRegistrationVINBean.setAuthentification_vin( rs.getString("authentification_vin") );						
						editRegistrationVINBean.setAuthentification_date( rs.getString("authentification_date") );
						editRegistrationVINBean.setBuy_sell( rs.getString("buy_sell") );						
						editRegistrationVINBean.setCircumstances( rs.getString("circumstances") );
						editRegistrationVINBean.setCircumstances_descrip( rs.getString("circumstances_descrip") );
						editRegistrationVINBean.setDealer_owned( rs.getString("dealer_owned") );
						editRegistrationVINBean.setDealer_posess( rs.getString("dealer_posess") );
						editRegistrationVINBean.setDealer_titled( rs.getString("dealer_titled") );
						editRegistrationVINBean.setDealership_name( rs.getString("dealership_name") );
						editRegistrationVINBean.setException_terms( rs.getString("exception_terms") );
						editRegistrationVINBean.setFkc_exception( rs.getString("fkc_exception") );
						editRegistrationVINBean.setFmcdealer_userid( rs.getString("fmcdealer_userid") );
						editRegistrationVINBean.setId_insurance( rs.getString("id_insurance") );
						editRegistrationVINBean.setId_other( rs.getString("id_other") );
						editRegistrationVINBean.setId_registration( rs.getString("id_registration") );
						editRegistrationVINBean.setId_title( rs.getString("id_title") );
						editRegistrationVINBean.setLicense_plate_number( rs.getString("license_plate_number") );
						editRegistrationVINBean.setNew_vehicle( rs.getString("new_vehicle") );
						editRegistrationVINBean.setOdometer( rs.getString("odometer") );
						editRegistrationVINBean.setOther_descrip( rs.getString("other_descrip") );						
						editRegistrationVINBean.setPa_code( rs.getString("pa_code") );
						editRegistrationVINBean.setState_vehicle_reg( rs.getString("state_vehicle_reg") );
						editRegistrationVINBean.setSubmit_first_name( rs.getString("submit_first_name") );
						editRegistrationVINBean.setSubmit_last_name( rs.getString("submit_last_name") );
						editRegistrationVINBean.setVehicle_color( rs.getString("vehicle_color") );
						editRegistrationVINBean.setVo_address( rs.getString("vo_address") );
						editRegistrationVINBean.setVo_business_name( rs.getString("vo_business_name") );
						editRegistrationVINBean.setVo_city( rs.getString("vo_city") );
						editRegistrationVINBean.setVo_drivers_license( rs.getString("vo_drivers_license") );
						editRegistrationVINBean.setVo_first_name( rs.getString("vo_first_name") );
						editRegistrationVINBean.setVo_last_name( rs.getString("vo_last_name") );
						editRegistrationVINBean.setVo_license_exp_date( rs.getString("vo_license_exp_date") );
						editRegistrationVINBean.setVo_license_state( rs.getString("vo_license_state") );
						editRegistrationVINBean.setVo_phone( rs.getString("vo_phone") );
						editRegistrationVINBean.setVo_state( rs.getString("vo_state") );
						editRegistrationVINBean.setVo_zip( rs.getString("vo_zip") );						
					}
				}				
			}
			catch ( Exception e )
			{

				logger.warn ( "Exception " + e.getMessage () );
				throw new GageException ( e.getMessage () , 0 , e );
			}
			finally
			{
				try
				{
					JdbcHelper.close ( conn , cstmt , null );
				}
				catch ( Exception e )
				{
					logger.warn ( "finally exception " + e.getMessage () );
				}
				logger.exiting ( methodName );
			}

			return editRegistrationVINBean;
		}
		
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean updateVinRegistration(EditRegistrationVINBean ERVinBean) throws Exception
	{
		String methodName = "DMLManager.java updateVinRegistration()";
		logger.entering ( methodName );
		boolean recordUpdate = false;
		logger.warn ( "Bean Records are:" + ERVinBean.toString());
		// declare statement and result set
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		ArrayList aList = new ArrayList ();
		String sql = "{call keycode_pkg.update_vin_registration(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		try
		{
			String jndiDatasourceName = ConfigurationServlet.getApplicationProperty ( IConstants.DB_JNDI_DATASOURCE_NAME );

			conn = JdbcConnectionFactory.getConnection ( jndiDatasourceName );
			cstmt = conn.prepareCall ( sql );
			
			
			cstmt.setString( 1, ERVinBean.getVin_verification_id());  
			cstmt.setString( 2, ERVinBean.getVo_last_name());         
			cstmt.setString( 3, ERVinBean.getVo_first_name());        
			cstmt.setString( 4, ERVinBean.getSubmit_last_name());     
			cstmt.setString( 5, ERVinBean.getSubmit_first_name());    
			cstmt.setString( 6, ERVinBean.getPa_code());              
			cstmt.setString( 7, ERVinBean.getFmcdealer_userid());     
			cstmt.setString( 8, ERVinBean.getDealership_name());      
			cstmt.setString( 9, ERVinBean.getVo_business_name());     
			cstmt.setString(10, ERVinBean.getVo_address());           
			cstmt.setString(11, ERVinBean.getVo_city());              
			cstmt.setString(12, ERVinBean.getVo_state());             
			cstmt.setString(13, ERVinBean.getVo_zip());               
			cstmt.setString(14, ERVinBean.getVo_phone());             
			cstmt.setString(15, ERVinBean.getVo_drivers_license());   
			cstmt.setString(16, ERVinBean.getVo_license_state());     
			cstmt.setString(17, ERVinBean.getVo_license_exp_date()); 
			
			
			// choose one
			String chooseOne = StringUtility.processNullToEmpty ( ERVinBean.getAdditionalIdentity());
			String title = "";
			String registration = "";
			String insurance = "";
			String other = "";
			logger.debug ( "ChosseOne ======= : " + chooseOne );
			if ( chooseOne != null || ! chooseOne.equalsIgnoreCase ( "" ) )
			{
				if ( chooseOne.equalsIgnoreCase ( "title" ) )
				{
					title = "Y";
					ERVinBean.setOther_descrip("");
				}
				else if ( chooseOne.equalsIgnoreCase ( "registration" ) )
				{
					registration = "Y";
					ERVinBean.setOther_descrip("");
				}
				else if ( chooseOne.equalsIgnoreCase ( "insurance" ) )
				{
					insurance = "Y";
					ERVinBean.setOther_descrip("");
				}
				else if ( chooseOne.equalsIgnoreCase ( "other" ) )
				{
					other = "Y";
				}
			}
					
			cstmt.setString(18, title);             
			cstmt.setString(19, registration);      
			cstmt.setString(20, insurance);         
			cstmt.setString(21, other);
			
			/*cstmt.setString(18, ERVinBean.getId_title());             
			cstmt.setString(19, ERVinBean.getId_registration());      
			cstmt.setString(20, ERVinBean.getId_insurance());         
			cstmt.setString(21, ERVinBean.getId_other());*/
			             
			cstmt.setString(22, ERVinBean.getOther_descrip());
			
			cstmt.setString(23, ERVinBean.getVehicle_year());
			cstmt.setString(24, ERVinBean.getVehicle_make());
			cstmt.setString(25, ERVinBean.getVehicle_model());
			cstmt.setString(26, ERVinBean.getVehicle_color());
			
			cstmt.setString(27, ERVinBean.getLicense_plate_number()); 
			cstmt.setString(28, ERVinBean.getState_vehicle_reg());    
			cstmt.setString(29, ERVinBean.getOdometer());             
			cstmt.setString(30, ERVinBean.getDealer_owned());         
			cstmt.setString(31, ERVinBean.getDealer_titled());        
			cstmt.setString(32, ERVinBean.getDealer_posess());        
			cstmt.setString(33, ERVinBean.getBuy_sell());             
			cstmt.setString(34, ERVinBean.getFkc_exception());        
			cstmt.setString(35, ERVinBean.getCircumstances());        
			cstmt.setString(36, ERVinBean.getCircumstances_descrip());
			cstmt.setString(37, ERVinBean.getAuthentification_date());
			cstmt.setString(38, ERVinBean.getException_terms());      
			cstmt.setString(39, ERVinBean.getNew_vehicle()); 
			
			cstmt.registerOutParameter (40, java.sql.Types.VARCHAR );
			cstmt.registerOutParameter (41, java.sql.Types.NUMERIC );
			cstmt.registerOutParameter (42, java.sql.Types.VARCHAR );
						
			logger.debug("Before execute");
			cstmt.execute ();
			logger.debug("After execute");

			int sqlCode = cstmt.getInt ( 41 );
			String sqlMsg = cstmt.getString ( 42 );

			logger.warn ( "sqlCode 		:" + sqlCode );
			logger.warn ( "sqlMessage 	:" + sqlMsg );	
			if(sqlCode == 0)
				recordUpdate = true;
		}
		catch ( Exception e )
		{

			logger.warn ( "Exception " + e.getMessage () );
			throw new GageException ( e.getMessage () , 0 , e );
		}
		finally
		{
			try
			{
				JdbcHelper.close ( conn , cstmt , null );
			}
			catch ( Exception e )
			{
				logger.warn ( "finally exception " + e.getMessage () );
			}
			logger.exiting ( methodName );
		}
		return recordUpdate;
	}
		
	public DMLManager ()
	{

	}
}
