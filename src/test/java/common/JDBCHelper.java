package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author preetham
 */
public class JDBCHelper
{
   private static Connection connection;

   static
   {
      try
      {
         Class.forName( com.home.jdbc.helpers.JDBCConstants.DRIVER_NAME );
      }
      catch ( ClassNotFoundException e )
      {
         System.out.println( "Driver class not found" );
      }
   }

   public static Connection getConnection() throws SQLException
   {
      connection = DriverManager.getConnection( com.home.jdbc.helpers.JDBCConstants.URL, com.home.jdbc.helpers.JDBCConstants.USERNAME, com.home.jdbc.helpers.JDBCConstants.PASSWORD );
      return connection;
   }

   public static void closeConnection( Connection con ) throws SQLException
   {
      if ( con != null )
      {
         con.close();
      }
   }

   public static void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
   {
      if ( stmt != null )
      {
         stmt.close();
      }
   }

   public static void closeResultSet( ResultSet rs ) throws SQLException
   {
      if ( rs != null )
      {
         rs.close();
      }
   }

}
