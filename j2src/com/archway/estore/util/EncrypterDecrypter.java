package com.archway.estore.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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
 * File Name               : EncrypterDecrypter.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:02 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:02 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class EncrypterDecrypter
{

	public static String	algorithm			= "PBEWithMD5AndDES";

	public static int		count				= 23;

	public static char []	encryptionPassword	= "Order Number efullfillment code developed in 2005 by archway marketing servives.".toCharArray ();									// ConfigurationServlet.getApplicationProperty (

	// "PASS_PHRASE" ).toCharArray ();

	public static byte []	salt				=
													{ ( byte ) 0x67 , ( byte ) 0x7b , ( byte ) 0xa1 , ( byte ) 0x85 , ( byte ) 0x6b , ( byte ) 0xd1 , ( byte ) 0xfe , ( byte ) 0x91 };

	/**
	 * Decrypts a given string depending on the parsephrase specifies in
	 * properties file.
	 * 
	 * @param toDecrypt
	 * @return
	 */
	public static String Decrypt ( String toDecrypt ) throws Exception
	{
		EncrypterDecrypter ed = new EncrypterDecrypter ();
		return ed.decryptWebPassword ( toDecrypt );
	}

	public static String decryptString ( String toDecrypt ) throws Exception
	{
		byte [] myIV =
			{ ( byte ) 60 , ( byte ) 61 , ( byte ) 62 , ( byte ) 63 , ( byte ) 64 , ( byte ) 65 , ( byte ) 66 , ( byte ) 67 };
		byte [] tdesKeyData =
			{ ( byte ) 0xC2 , ( byte ) 0xA1 , ( byte ) 0x57 , ( byte ) 0x21 , ( byte ) 0xBC , ( byte ) 0x2B , ( byte ) 0x11 , ( byte ) 0xE3 , ( byte ) 0x54 , ( byte ) 0xAA , ( byte ) 0xC1 , ( byte ) 0x80 , ( byte ) 0xA2 , ( byte ) 0x3C , ( byte ) 0xD2 , ( byte ) 0x12 , ( byte ) 0x3E , ( byte ) 0x45 , ( byte ) 0xC1 , ( byte ) 0x8A , ( byte ) 0x41 , ( byte ) 0xF2 , ( byte ) 0xBB , ( byte ) 0x32 };

		byte [] encData = new sun.misc.BASE64Decoder ().decodeBuffer ( toDecrypt );
		
		//Base64.getDecoder();
		Cipher decipher = Cipher.getInstance ( "DESede/CBC/PKCS5Padding" );
		// byte[] tdesKeyData = tdesKeyData;
		SecretKeySpec myKey = new SecretKeySpec ( tdesKeyData , "DESede" );
		IvParameterSpec ivspec = new IvParameterSpec ( myIV );
		decipher.init ( Cipher.DECRYPT_MODE , myKey , ivspec );
		byte [] plainText = decipher.doFinal ( encData );
		return ( new String ( plainText ) );
	}

	/**
	 * Encrypts a given string depending on the parsephrase specifies in
	 * properties file.
	 * 
	 * @param toEncrypt
	 * @return
	 */
	public static String Encrypt ( String toEncrypt ) throws Exception
	{
		EncrypterDecrypter ed = new EncrypterDecrypter ();
		return ed.encryptWebPassword ( toEncrypt.getBytes () );
	}

	public static String encryptString ( String plainText ) throws Exception
	{
		// ---- Use specified 3DES key and IV from other source --------------
		byte [] plaintext = plainText.getBytes ();

		byte [] myIV =
			{ ( byte ) 60 , ( byte ) 61 , ( byte ) 62 , ( byte ) 63 , ( byte ) 64 , ( byte ) 65 , ( byte ) 66 , ( byte ) 67 };
		byte [] tdesKeyData =
			{ ( byte ) 0xC2 , ( byte ) 0xA1 , ( byte ) 0x57 , ( byte ) 0x21 , ( byte ) 0xBC , ( byte ) 0x2B , ( byte ) 0x11 , ( byte ) 0xE3 , ( byte ) 0x54 , ( byte ) 0xAA , ( byte ) 0xC1 , ( byte ) 0x80 , ( byte ) 0xA2 , ( byte ) 0x3C , ( byte ) 0xD2 , ( byte ) 0x12 , ( byte ) 0x3E , ( byte ) 0x45 , ( byte ) 0xC1 , ( byte ) 0x8A , ( byte ) 0x41 , ( byte ) 0xF2 , ( byte ) 0xBB , ( byte ) 0x32 };
		Cipher c3des = Cipher.getInstance ( "DESede/CBC/PKCS5Padding" );
		SecretKeySpec myKey = new SecretKeySpec ( tdesKeyData , "DESede" );
		IvParameterSpec ivspec = new IvParameterSpec ( myIV );
		c3des.init ( Cipher.ENCRYPT_MODE , myKey , ivspec );
		byte [] cipherText = c3des.doFinal ( plaintext );
		sun.misc.BASE64Encoder obj64 = new sun.misc.BASE64Encoder ();
		return obj64.encode ( cipherText );
	}

	public static void main ( String args[] ) throws Exception
	{
		String str = "ford-keycode-by-amar bhatt";
		System.out.println ( EncrypterDecrypter.Encrypt ( str ) );
		System.out.println ( EncrypterDecrypter.Decrypt ( EncrypterDecrypter.Encrypt ( str ) ) );
	}

	private PBEKeySpec	encPass;

	/** Creates a new instance of EncryptionMachine */
	public EncrypterDecrypter ()
	{
		Provider sunJCE = new com.sun.crypto.provider.SunJCE ();
		Security.addProvider ( sunJCE );

		// set the encryption password. Must have this class in order to decrypt
		// the password.
		this.encPass = new PBEKeySpec ( encryptionPassword );
	}

	/**
	 * Convenience method to convert a byte array to a hex string.
	 * 
	 * @param data
	 *            the byte[] to convert
	 * @return String the converted byte[]
	 */
	private String bytesToHex ( byte [] data )
	{
		StringBuffer buf = new StringBuffer ();
		for ( int i = 0 ; i < data.length ; i++ )
		{
			buf.append ( byteToHex ( data [i] ) );
		}
		return ( buf.toString () );
	}

	/**
	 * Convenience method to convert a byte to a hex string.
	 * 
	 * @param data
	 *            the byte to convert
	 * @return String the converted byte
	 */
	private String byteToHex ( byte data )
	{
		StringBuffer buf = new StringBuffer ();
		buf.append ( toHexChar ( ( data >>> 4 ) & 0x0F ) );
		buf.append ( toHexChar ( data & 0x0F ) );
		return buf.toString ();
	}

	public byte [] decryptPassword ( byte [] input )
	{
		Cipher pbeCipher = getCipher ( Cipher.DECRYPT_MODE );
		try
		{
			return pbeCipher.doFinal ( input );
		}
		catch ( IllegalBlockSizeException illegalBlockSz )
		{
			System.out.println ( "Illegal Block Size" );
		}
		catch ( BadPaddingException badPad )
		{
			System.out.println ( "BadPaddingException thrown" );
		}
		return null;
	}

	public String decryptWebPassword ( String input ) throws IOException
	{
		// return the hex string to it's byte form
		byte [] b = hexToByteArray ( input );
		byte [] output = decryptPassword ( b );
		ByteArrayOutputStream bos = new ByteArrayOutputStream ();
		try
		{
			bos.write ( output );
		}
		catch ( IOException ioEx )
		{
			throw new IOException ( "Unable to write bytes to output stream." );
		}

		return bos.toString ();
	}

	public byte [] encryptPassword ( byte [] input )
	{
		Cipher pbeCipher = getCipher ( Cipher.ENCRYPT_MODE );
		try
		{
			return pbeCipher.doFinal ( input );
		}
		catch ( IllegalBlockSizeException illegalBlockSz )
		{
			System.out.println ( "Illegal Block Size" );
		}
		catch ( BadPaddingException badPad )
		{
			System.out.println ( "BadPaddingException thrown" );
		}
		return null;
	}

	/**
	 * Instead of simply returning an encrypted string of text this method will
	 * return a hex variation of the encrypted string.
	 * 
	 * @param input
	 *            A byte array containing the password to be
	 */
	public String encryptWebPassword ( byte [] input )
	{
		byte [] encodedPassword = encryptPassword ( input );
		String output = bytesToHex ( encodedPassword );
		return output;
	}

	private Cipher getCipher ( int mode )
	{
		try
		{
			PBEParameterSpec pbeParamSpec;
			SecretKeyFactory keyFac;

			// Create PBE parameter set
			pbeParamSpec = new PBEParameterSpec ( salt , count );
			// set up algorithm

			keyFac = SecretKeyFactory.getInstance ( algorithm , "SunJCE" );
			SecretKey pbeKey = keyFac.generateSecret ( this.encPass );
			// create Cipher
			Cipher pbeCipher = Cipher.getInstance ( algorithm );
			pbeCipher.init ( mode , pbeKey , pbeParamSpec );
			return pbeCipher;
		}
		catch ( NoSuchAlgorithmException nsAlgEx )
		{
			System.out.println ( "NoSuchAlgorithmException thrown: " + nsAlgEx.toString () );
		}
		catch ( NoSuchProviderException nsProvEx )
		{
			System.out.println ( "NoSuchProviderException thrown: " + nsProvEx.toString () );
		}
		catch ( InvalidKeySpecException invalidKeySpec )
		{
			System.out.println ( "InvalidKeySpecException thrown: " + invalidKeySpec.toString () );
		}
		catch ( InvalidKeyException invalidKey )
		{
			System.out.println ( "InvalidKeyException thrown: " + invalidKey.toString () );
		}
		catch ( InvalidAlgorithmParameterException iape )
		{
			System.out.println ( "InvalidAlgorithmParameterException thrown: " + iape.toString () );
		}
		catch ( NoSuchPaddingException nsPad )
		{
			System.out.println ( "NoSuchPaddingException thrown: " + nsPad.toString () );
		}
		return null;
	}

	public byte [] hexToByteArray ( String string )
													throws NumberFormatException
	{
		byte [] bytes = new byte[string.length () / 2];
		for ( int i = 0 ; i < bytes.length ; i++ )
		{
			bytes [i] = ( byte ) Integer.parseInt ( string.substring ( i * 2 , ( i * 2 ) + 2 ) , 16 );
		}
		return bytes;
	}

	/**
	 * Convenience method to convert an int to a hex char.
	 * 
	 * @param i
	 *            the int to convert
	 * @return char the converted char
	 */
	private char toHexChar ( int i )
	{
		if ( ( 0 <= i ) && ( i <= 9 ) )
			return ( char ) ( '0' + i );
		else
			return ( char ) ( 'a' + ( i - 10 ) );
	}

}