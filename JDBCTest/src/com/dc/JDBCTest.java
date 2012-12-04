package com.dc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date: 2012/03/20
 * <p/>
 * The source, with you may it be old master.
 */
public class JDBCTest {

    public static void main(String[] args) {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName("jboss");
        ds.setUser("jboss");
        ds.setPassword("jboss");
        Connection conn = null;
        try {
            conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(conn);

    }

}
