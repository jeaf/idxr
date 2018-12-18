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
    }

    private void initTables(Connection c) throws SQLException
    {
        log.info("Initializing DB tables");
        String sql =
            "CREATE TABLE IF NOT EXISTS doc("                                +
            "id           INTEGER PRIMARY KEY,"                              +
            "type         INTEGER NOT NULL CHECK (type IN (1, 2, 3)),"       +
            "path         TEXT NOT NULL UNIQUE,"                             +
            "ctime        INTEGER NOT NULL,"                                 +
            "ctime_db     INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))," +
            "mtime        INTEGER NOT NULL,"                                 +
            "mtime_db     INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))," +
            "md5          BLOB NOT NULL,"                                    +
            "size         INTEGER NOT NULL,"                                 +
            "mime_type    TEXT,"                                             +
            "mime_subtype TEXT,"                                             +
            "width        INTEGER,"                                          +
            "height       INTEGER,"                                          +
            "duration     INTEGER,"                                          +
            "date_taken   INTEGER);";
        Statement stmt = c.createStatement();
        stmt.execute(sql);
        sql =
            "CREATE TRIGGER IF NOT EXISTS doc_mtime_db_trigger "             +
            "AFTER UPDATE ON doc FOR EACH ROW BEGIN "                        +
            "UPDATE doc SET mtime_db = (strftime('%s', 'now')) "             +
            "WHERE id = old.id;"                                             +
            "END";
        stmt = c.createStatement();
        stmt.execute(sql);
        sql =
            "CREATE TABLE IF NOT EXISTS color_moments("                      +
            "id           INTEGER PRIMARY KEY,"                              +
            "doc_id       INTEGER NOT NULL REFERENCES doc(id),"              +
            "frame_num    INTEGER NOT NULL DEFAULT 0,"                       +
            "mean_h       REAL NOT NULL,"                                    +
            "mean_s       REAL NOT NULL,"                                    +
            "mean_v       REAL NOT NULL,"                                    +
            "stddev_h     REAL NOT NULL,"                                    +
            "stddev_s     REAL NOT NULL,"                                    +
            "stddev_v     REAL NOT NULL,"                                    +
            "skew_h       REAL NOT NULL,"                                    +
            "skew_s       REAL NOT NULL,"                                    +
            "skew_v       REAL NOT NULL,"                                    +
            "UNIQUE(doc_id, frame_num));";
        stmt = c.createStatement();
        stmt.execute(sql);
        sql =
            "CREATE TABLE IF NOT EXISTS match("                              +
            "word        TEXT NOT NULL,"                                     +
            "doc_id      INTEGER NOT NULL REFERENCES doc(id),"               +
            "path_score  INTEGER NOT NULL DEFAULT 0,"                        +
            "text_score  INTEGER NOT NULL DEFAULT 0,"                        +
            "PRIMARY KEY (word, doc_id)) WITHOUT ROWID;";
        stmt = c.createStatement();
        stmt.execute(sql);
    }

    private String path;
    private final static Logger log = Logger.getLogger(Db.class.getName());
}

