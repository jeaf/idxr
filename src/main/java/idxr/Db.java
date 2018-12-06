package idxr;

import java.sql.*;

public class Db
{
    public Db(String p)
    {
        path = p;
    }

    public Connection connect()
    {
        Connection conn = null;
        try
        {
            // db parameters
            //String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
            String url = "jdbc:sqlite::memory:";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        return conn;
    }

    private String path;
}

