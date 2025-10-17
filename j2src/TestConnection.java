import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection
{

	/**
	 * @param args
	 */
	public static void main ( String [] args )
	{
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		CallableStatement cstmt = null;
		boolean returnFlag = false;

		try
		{
			Class.forName ( "oracle.jdbc.driver.OracleDriver" );
			String url = "jdbc:oracle:thin:@autodev:1521:autodev"; //"jdbc:oracle:thin:@autodev:1521:autodev";
			conn = DriverManager.getConnection ( url , "fordkeycode_prod" , "fkcpd_2012" );
			String sql = "select sysdate from dual";
			String sql2 = "{call keycode_pkg_temp.Get_vin_registration(?,?,?,?)}";

			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// String url = "jdbc:oracle:thin:@corona:1521:auto11qa";
			// conn = DriverManager.getConnection(url, "wins_prod",
			// "wins_prod");

			//stmt = conn.createStatement();
			cstmt = conn.prepareCall ( sql2 );

			cstmt.setString ( 1 , "12131" );
			cstmt.registerOutParameter ( 2 , java.sql.Types.VARCHAR );
			cstmt.registerOutParameter ( 3 , java.sql.Types.NUMERIC );
			cstmt.registerOutParameter ( 4 , java.sql.Types.VARCHAR );
			cstmt.execute ();

			String yesNo = cstmt.getString ( 2 );

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

			System.out.println ( "sqlCode 		:" + cstmt.getInt ( 3 ) + "| yesNo = " + yesNo );
			System.out.println ( "sqlMessage 	:" + cstmt.getString ( 4 ) );
			System.out.println ( "returnFlag 	:" + returnFlag );

			/*//rset = stmt.executeQuery(sql);
			 // System.out.println(rset.getString(1));
			 while (rset.next()) {
			 System.out.println(rset.getString(1));
			 }*/

			// close the result set, the statement and connect
		}

		catch ( Exception sqe )
		{
			sqe.printStackTrace ();

		}
		finally
		{
			try
			{
				rset.close ();
				stmt.close ();
				conn.close ();
			}
			catch ( Exception e )
			{
			}
		}

	}

}
