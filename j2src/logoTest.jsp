<%@ page language="java"%>
<%@ page import="javax.mail.*,
				javax.mail.internet.*,
				java.util.Properties,
				javax.activation.*,
				java.io.*, java.util.*,org.apache.commons.mail.EmailAttachment,org.apache.commons.mail.HtmlEmail" 
%>


 

Testing : 1


<%
try{
HtmlEmail email = new HtmlEmail ();
email.setHostName ( "mplex02r.trade.archway.com" );
email.setFrom ( "amar_bhatt@archway.com" , "amar_bhatt@archway.com" );
email.setBounceAddress ( "amar_bhatt@archway.com" );
email.addReplyTo ( "amar_bhatt@archway.com" , "amar_bhatt@archway.com" );



email.addTo("amar_bhatt@archway.com","amar_bhatt@archway.com");
email.addCc("shrinivas_jagtap@archway.com","shrinivas_jagtap@archway.com");
email.addBcc("amar_bhatt@archway.com","amar_bhatt@archway.com");


email.setSubject ("No Subject");

// set the character set
email.setCharset ( "iso-8859-1" );
// set the html message
email.setHtmlMsg (  ( "No Subject" ) );
// set the alternative message
email.setTextMsg ( "No Subject" );
// send the email
email.send ();


}
catch ( Exception e )
{
	out.println ( "Exception encountered Email.java " + e.getMessage () );
}


%>