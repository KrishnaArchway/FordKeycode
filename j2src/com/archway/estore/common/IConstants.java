package com.archway.estore.common;

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
 * File Name               : IConstants.java 
 * Package Name            : com.archway.estore.common
 * 
 * Date                    : May 8, 2013 10:17:08 AM
 * 
 * Change Date             : May 8, 2013 10:17:08 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public interface IConstants
{

	public static final String		ADMIN_EMAIL_ADDRESS_PARM					= "ADMIN_EMAIL_ADDRESS";

	public final static int			ADVANCE_KEY_ERROR							= 57;

	public final static int			AUTHENTICATION_FAILED						= 101;

	public static final String		CLIENT_ID_PARM								= "CLIENT_ID";

	public static final String		ClientID									= "1";

	public static final String		Control_Question							= "What is your Mother's Maiden Name";

	//error msgs
	public static final String		DB_ERROR_MSG								= "Error retrieving data.  Please try again later.";

	// Order history to the
	// last 6 months
	//database cache constants
	public static final String		DB_JNDI_DATASOURCE_NAME						= "DB_JNDI_DATASOURCE_NAME";

	public static final boolean		DB_SECURITY_ENABLED							= true;

	public final static int			DELETE_ERROR								= 56;

	public static final String		PROP_FILE									= "npc.estore.app.properties.txt";

	public static final String		DEV_APP_PROP_FILE							= "dev.npc.estore.app.properties.txt";

	public static final String		END_OF_FILE_CODE							= "ORA-03113";

	public static final String		END_OF_FILE_MSG								= "end of file on communication channel";

	public static final String		ERROR_EMAIL_ADDRESS_PARM					= "ERROR_EMAIL_ADDRESS";

	public static final String		ERROR_SUBJECT_PARM							= "ERROR_SUBJECT";

	public static final String		ERROR_TEXT_MESSAGE_PARM						= "ERROR_TEXT_MESSAGE";

	//error codes
	public static final int			FATAL_ERROR									= 1000;

	//  DATABASE ERRORS 50 TO 99
	public final static int			GET_DB_CONNECTION_ERROR						= 50;

	//E-Mail Constants
	public static final String		HELP_EMAIL_PARM								= "HELP_EMAIL";

	public final static String		INCORRECT_PASSWORD_ERROR					= "Your Password is incorrect, please correct the error and login again";

	//login errors
	public final static String		INCORRECT_USERID_ERROR						= "Your Login ID is incorrect, please correct the error and login again";

	public static final String		JSERV_LOG_FILE								= "jserv_log";

	public static final String		JSP_DIRECTORY_PARM							= "JSP_DIRECTORY";

	public static final String		LOCAL_APP_PROP_FILE							= "local.npc.estore.app.properties.txt";

	//E-Mail Error
	public final static int			MAIL_ERROR									= 1002;

	public static final String		MAIL_HOST_PARM								= "MAIL_HOST";

	public final static int			MISSING_PARAMETERS_ERROR					= 1001;

	public static final String		NOT_CONNECTED_CODE							= "ORA-03114";

	/** Database Disconnect Messages watched by ConnectionProxy */
	public static final String		NOT_CONNECTED_MSG							= "Not Connected to Oracle";

	//  THE DEFAULT STATUS, NO ERROR
	public final static int			OK											= 0;

	public static final int			ORDER_HIST_DATE_LIMIT						= - 6;																							//set the limit on

	//This value is used in showProduct.jsp to diplsy or not to display add
	// item to the template order functionality.
	public static final String		Parent_Category_Desc						= "DWD CATALOG ITEM TYPE";

	public static final String		PAYMENT_BILLME_TYPE							= "B";

	public static final String		PAYMENT_BILLME_TYPE_DISPLAY_TEXT			= "Invoice";

	/** Database Payment type constants and conversions */
	public static final String		PAYMENT_COOP_CATEGORY						= "COOP";

	public static final String		PAYMENT_COOP_TYPE							= "CO";

	public static final String		PAYMENT_COOP_TYPE_DISPLAY_TEXT				= "Budget";

	public static final String		PAYMENT_CREDIT_CARD_CATEGORY				= "CREDITCARD";

	public static final String		PAYMENT_CREDITCARD_CATEGORY_DISPLAY_TEXT	= "Credit Card";

	public static final String		PAYMENT_INTERNAL_CATEGORY					= "INTERNAL";

	public static final String		PAYMENT_INTERNAL_DEPT_TYPE					= "ID";

	public static final String		PAYMENT_INTERNAL_DEPT_TYPE_DISPLAY_TEXT		= "Internal Department";

	public static final String		PAYMENT_INVOICE_CATEGORY					= "INVOICE";

	public static final String		PAYMENT_LACR_TYPE							= "LA";

	public static final String		PAYMENT_LACR_TYPE_DISPLAY_TEXT				= "LACR";

	public static final String		PAYMENT_PAID_INTERNALLY_TYPE				= "PI";

	public static final String		PAYMENT_PAID_INTERNALLY_TYPE_DISPLAY_TEXT	= "Paid Internally";

	public static final String		PAYMENT_PAID_PER_ORDER_TYPE					= "OP";

	public static final String		PAYMENT_PAID_PER_ORDER_TYPE_DISPLAY_TEXT	= "Cost Center";

	public static final String		PAYMENT_PURCHASE_ORDER_TYPE					= "PO";

	public static final String		PAYMENT_PURCHASE_ORDER_TYPE_DISPLAY_TEXT	= "Purchase Order";

	public final static int			POPULATE_DATA_ERROR							= 52;

	public static final String		PRD_APP_PROP_FILE							= "prd.npc.estore.app.properties.txt";

	public static final String		QA_APP_PROP_FILE							= "qa.npc.estore.app.properties.txt";

	public final static int			RELEASE_DB_CONNECTION_ERROR					= 51;

	public static final String []	requiredAppProps							=
																					{ "DB_JNDI_DATASOURCE_NAME" , "HELP_EMAIL" , "MAIL_HOST" , "CLIENT_ID" , "JSP_DIRECTORY" };

	public final static int			RESULT_SET_CLOSE_ERROR						= 53;

	public final static int			ROLLBACK_ERROR								= 58;

	public final static int			SELECT_ERROR								= 55;

	public static final String		SESSION_KILLED_CODE							= "ORA-00028";

	public static final String		SESSION_KILLED_MSG							= "Your session has been killed";

	public static final String		STANDARD_PAYMENT_TYPE						= PAYMENT_BILLME_TYPE;

	public final static int			STMT_CLOSE_ERROR							= 54;

	public static final String		UNKNOWN_ERROR								= "UNKNOWN_ERROR";

	public final static int			UPDATE_ERROR								= 59;

	//	AUTHENTICATION AND SESSION MGMT. 100 TO 199
	//	LogonBean
	public final static int			USER_NOT_FOUND								= 100;

	public static final int			WARNING										= 1001;

	public final static int			WRONG_PASSWORD_ERROR						= 102;
}