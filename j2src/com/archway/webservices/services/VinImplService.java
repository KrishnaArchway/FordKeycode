/**
 * VinImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.archway.webservices.services;

public interface VinImplService extends javax.xml.rpc.Service
{

	public java.lang.String getvalidateVinAddress ();

	public com.archway.webservices.services.VinImpl getvalidateVin ()
																		throws javax.xml.rpc.ServiceException;

	public com.archway.webservices.services.VinImpl getvalidateVin (
																	java.net.URL portAddress )
																								throws javax.xml.rpc.ServiceException;
}
