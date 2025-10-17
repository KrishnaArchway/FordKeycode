/**
 * VinRequestEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.archway.webservices.services;

public class VinRequestEntity implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1515119551608699892L;

	private java.lang.String	KEY;

	private java.lang.String	PACODE;

	private java.lang.String	VIN;

	public VinRequestEntity ()
	{
	}

	public VinRequestEntity (
								java.lang.String KEY ,
								java.lang.String PACODE ,
								java.lang.String VIN )
	{
		this.KEY = KEY;
		this.PACODE = PACODE;
		this.VIN = VIN;
	}

	/**
	 * Gets the KEY value for this VinRequestEntity.
	 * 
	 * @return KEY
	 */
	public java.lang.String getKEY ()
	{
		return KEY;
	}

	/**
	 * Sets the KEY value for this VinRequestEntity.
	 * 
	 * @param KEY
	 */
	public void setKEY ( java.lang.String KEY )
	{
		this.KEY = KEY;
	}

	/**
	 * Gets the PACODE value for this VinRequestEntity.
	 * 
	 * @return PACODE
	 */
	public java.lang.String getPACODE ()
	{
		return PACODE;
	}

	/**
	 * Sets the PACODE value for this VinRequestEntity.
	 * 
	 * @param PACODE
	 */
	public void setPACODE ( java.lang.String PACODE )
	{
		this.PACODE = PACODE;
	}

	/**
	 * Gets the VIN value for this VinRequestEntity.
	 * 
	 * @return VIN
	 */
	public java.lang.String getVIN ()
	{
		return VIN;
	}

	/**
	 * Sets the VIN value for this VinRequestEntity.
	 * 
	 * @param VIN
	 */
	public void setVIN ( java.lang.String VIN )
	{
		this.VIN = VIN;
	}

	private java.lang.Object	__equalsCalc	= null;

	public synchronized boolean equals ( java.lang.Object obj )
	{
		if ( ! ( obj instanceof VinRequestEntity ) ) return false;
		VinRequestEntity other = ( VinRequestEntity ) obj;
		if ( obj == null ) return false;
		if ( this == obj ) return true;
		if ( __equalsCalc != null )
		{
			return ( __equalsCalc == obj );
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true && ( ( this.KEY == null && other.getKEY () == null ) || ( this.KEY != null && this.KEY.equals ( other.getKEY () ) ) ) && ( ( this.PACODE == null && other.getPACODE () == null ) || ( this.PACODE != null && this.PACODE.equals ( other.getPACODE () ) ) ) && ( ( this.VIN == null && other.getVIN () == null ) || ( this.VIN != null && this.VIN.equals ( other.getVIN () ) ) );
		__equalsCalc = null;
		return _equals;
	}

	private boolean	__hashCodeCalc	= false;

	public synchronized int hashCode ()
	{
		if ( __hashCodeCalc )
		{
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if ( getKEY () != null )
		{
			_hashCode += getKEY ().hashCode ();
		}
		if ( getPACODE () != null )
		{
			_hashCode += getPACODE ().hashCode ();
		}
		if ( getVIN () != null )
		{
			_hashCode += getVIN ().hashCode ();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc	typeDesc	= new org.apache.axis.description.TypeDesc ( VinRequestEntity.class , true );

	static
	{
		typeDesc.setXmlType ( new javax.xml.namespace.QName ( "urn:validateVin" , "VinRequestEntity" ) );
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "KEY" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "KEY" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
		elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "PACODE" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "PACODE" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
		elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "VIN" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "VIN" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc ()
	{
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer (
																		java.lang.String mechType ,
																		java.lang.Class _javaType ,
																		javax.xml.namespace.QName _xmlType )
	{
		return new org.apache.axis.encoding.ser.BeanSerializer ( _javaType , _xmlType , typeDesc );
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer (
																			java.lang.String mechType ,
																			java.lang.Class _javaType ,
																			javax.xml.namespace.QName _xmlType )
	{
		return new org.apache.axis.encoding.ser.BeanDeserializer ( _javaType , _xmlType , typeDesc );
	}

}
