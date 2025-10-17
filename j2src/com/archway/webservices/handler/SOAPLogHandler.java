package com.archway.webservices.handler;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : GMWebServices
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : SOAPLogHandler.java 
 * Package Name            : com.archway.webservices.handler
 * 
 * Date                    : Feb 24, 2014 9:06:19 PM
 * 
 * Change Date             : Feb 24, 2014 9:06:19 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.log4j.Logger;

public class SOAPLogHandler extends BasicHandler
{

	public static final Logger	logger				= Logger.getLogger ( "soapRequestResponse" );

	private static final long	serialVersionUID	= 1L;

	public void invoke ( MessageContext msgContext ) throws AxisFault
	{
		if ( msgContext.getResponseMessage () != null && msgContext.getResponseMessage ().getSOAPPart () != null )
		{
			logger.warn ( " Response = " + msgContext.getResponseMessage ().getSOAPPartAsString () );
		}
		else
		{
			if ( msgContext.getRequestMessage () != null && msgContext.getRequestMessage ().getSOAPPartAsString () != null )
			{
				logger.warn ( " Request = " + msgContext.getRequestMessage ().getSOAPPartAsString () );

			}
		}
	}
}
