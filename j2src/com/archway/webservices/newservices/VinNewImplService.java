/**
 * VinNewImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.archway.webservices.newservices;

public interface VinNewImplService extends javax.xml.rpc.Service
{

	public java.lang.String getvalidateNewVinAddress ();

	public com.archway.webservices.newservices.VinNewImpl getvalidateNewVin ()
																				throws javax.xml.rpc.ServiceException;

	public com.archway.webservices.newservices.VinNewImpl getvalidateNewVin (
																				java.net.URL portAddress )
																											throws javax.xml.rpc.ServiceException;
}
