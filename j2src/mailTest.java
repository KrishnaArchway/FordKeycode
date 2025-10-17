import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : mailTest.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Mar 21, 2014 1:59:16 PM
 * 
 * Change Date             : Mar 21, 2014 1:59:16 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class mailTest
{

	public static boolean SendHtmlEmailWithFileAttachment (
															String from ,
															String to[] ,
															String cc[] ,
															String bcc[] ,
															String subject ,
															String fileName[] ,
															String htmlText ,
															String plainText )
																				throws Exception
	{
		System.out.println ( "SendHtmlEmailWithFileAttachment(String, String[], String [], String[], String,String[],String,String)" );
		boolean returnFlag = false;
		try
		{

			HtmlEmail email = new HtmlEmail ();
			email.setHostName ( "mplex02r.trade.archway.com" );
			email.setFrom ( from , from );
			email.setBounceAddress ( from );
			email.addReplyTo ( from , from );

			// START sets the emails address depending on which Database the
			// email job is running againts.
			//String ENVIRONMENT = Environment.getEnv ();
			String emailAlwaysBcc = "";

			for ( int i = 0 ; i < to.length ; i++ )
			{
				email.addTo ( to [i] , to [i] );
			}
			if ( cc != null )
			{
				for ( int i = 0 ; i < cc.length ; i++ )
				{
					email.addCc ( cc [i] , cc [i] );
				}
			}
			if ( bcc != null )
			{
				for ( int i = 0 ; i < bcc.length ; i++ )
				{
					email.addBcc ( bcc [i] , bcc [i] );
				}
			}
			email.setSubject ( "No Subject" );

			// Create the attachment if any....
			if ( fileName != null )
			{
				for ( int i = 0 ; i < fileName.length ; i++ )
				{
					if ( ! isStringBlank ( fileName [i] ) )
					{

						EmailAttachment attachment = new EmailAttachment ();
						attachment.setPath ( fileName [i] );
						attachment.setDisposition ( EmailAttachment.ATTACHMENT );
						attachment.setDescription ( Splitter ( fileName [i] ) );
						attachment.setName ( "" );
						// add the attachment
						email.attach ( attachment );
					}
				}
			}
			// set the character set
			email.setCharset ( "iso-8859-1" );
			// set the html message
			email.setHtmlMsg ( ( htmlText ) );
			// set the alternative message
			email.setTextMsg ( plainText );
			// send the email
			email.send ();
			returnFlag = true;

		}
		catch ( Exception e )
		{
			returnFlag = false;
			System.out.println ( "Exception encountered Email.java " + e.getMessage () );
			System.out.println ( "Exception encountered Email.java " + e.getMessage () );
		}
		System.out.println ( "SendHtmlEmailWithFileAttachment(String, String[], String [], String[], String, String[],String ,String)" );
		return returnFlag;
	}

	public static String Splitter ( String str )
	{
		int maxLength = 0;

		if ( ! isStringBlank ( str ) )
		{
			// str=str.replaceAll("\\\","/");
			String [] temp = str.split ( "/" );
			maxLength = temp.length;
			return temp [maxLength - 1];
		}
		else
		{
			return "";
		}
	}

	public static boolean isStringBlank ( String string )
	{
		return ( string == null || string.trim ().length () == 0 || string.trim ().equalsIgnoreCase ( "null" ) );
	}

	public static void main ( String [] args ) throws Exception
	{
		// String x = getFileContents ( "c:/in.txt" );
		// System.out.println(x);
		// System.out.println ( print ( x , "158.60.140.112" , 9100 ) );

		//String a = "1234567890";
		//System.out.println ( a.length () );

		String from = "amar_bhatt@archway.com";
		String to = "amar_bhatt@archway.com";
		String cc = "amar_bhatt@archway.com";
		String bcc = "amar_bhatt@archway.com";
		String subject = "test from 10.12.4.11 email relay";
		String body = "test from 10.12.xxxxxxxxxxxxxxxxxxxxxxxxx4.11 email relay";
		String text = "test from 10.12.xxxxxxxxxxxxxxxxxxxxxxxxx4.11 email relay";
		SendHtmlEmailWithFileAttachment ( from , to.split ( "\\," ) , to.split ( "\\," ) , to.split ( "\\," ) , subject , null , body , text );

	}

}
