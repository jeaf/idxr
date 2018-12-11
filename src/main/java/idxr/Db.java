package idxr;

import java.sql.*;
import java.util.logging.Logger;

public class Db
{
    public Db(String p)
    {
        path = p;
    }

    public Connection connect() throws SQLException
    {
        String url = String.format("jdbc:sqlite:%s", path);
        try (Connection conn = DriverManager.getConnection(url))
        {
            log.info("Connection to SQLite has been established.");
            initTables(conn);
            return conn;
        }
        //catch (SQLException e)
        //{
        //    log.severe(e.getMessage());
        //}
        //finally
        //{
        //    try
        //    {
        //        if (conn != null) conn.close();
        //        conn = null;
        //    }
        //    catch (SQLException ex)
        //    {
        //        log.severe(ex.getMessage());
        //    }
        //}

        //return conn;
    }

    private void initTables(Connection c) throws SQLException
    {
        log.info("Initializing DB tables");
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS doc(" +
               "id           INTEGER PRIMARY KEY," +
               "type         INTEGER NOT NULL," + // todo: add check constraint, 1-file, 2-webpage, 3-email, etc.
               "path         TEXT NOT NULL UNIQUE," +
               "ctime        INTEGER NOT NULL," +
               "ctime_db     INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))," + // todo: add trigger
               "mtime        INTEGER NOT NULL," +
               "mtime_db     INTEGER NOT NULL DEFAULT (strftime('%s', 'now'));" +
               "md5          BLOB NOT NULL," +
               "size         INTEGER NOT NULL," +
               "mime_type    TEXT," +
               "mime_subtype TEXT," +
               "width        INTEGER," +
               "height       INTEGER," +
               "duration     INTEGER," +
               "date_taken   INTEGER);" +
               "CREATE TABLE IF NOT EXISTS color_moments(" +
               "id           INTEGER PRIMARY KEY," +
               "doc_id       INTEGER NOT NULL REFERENCES doc(id)," +
               "frame_num    INTEGER NOT NULL DEFAULT 0," +
               "mean_h       REAL," +
               "mean_s       REAL," +
               "mean_v       REAL," +
               "stddev_h     REAL," +
               "stddev_s     REAL," +
               "stddev_v     REAL," +
               "skew_h       REAL," +
               "skew_s       REAL," +
               "skew_v       REAL," +
               "UNIQUE(doc_id, frame_num));" +
               "CREATE TABLE IF NOT EXISTS match(" +
               "word   TEXT NOT NULL," +
               "doc_id INTEGER NOT NULL REFERENCES doc(id)," +
               "flags  INTEGER NOT NULL DEFAULT 0," +
               "score  INTEGER NOT NULL DEFAULT 0);";
        Statement stmt = c.createStatement();
        stmt.execute(sql);
    }

    private String path;
    private final static Logger log = Logger.getLogger(Db.class.getName());
}

