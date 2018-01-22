package com.ejb605.assignment1;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class JdbcManager {
  private static InitialContext context = null;
  public static Connection getConnection()
    throws SQLException, NamingException {
    if (context == null) {
      context = new InitialContext();
    }
    DataSource dataSource =
      (DataSource) context.lookup("jdbc/employee");
    return dataSource.getConnection();
  }
  public static void close(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (Exception ignored) {}
    }
  }
  public static void close(Statement stmt) {
    if (stmt != null) {
      try {
        stmt.close();
      } catch (Exception ignored) {}
    }
  }
  public static void close(ResultSet rset) {
    if (rset != null) {
      try {
        rset.close();
      } catch (Exception ignored) {}
    }
  }
}
