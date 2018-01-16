package controller;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnector {

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        try {
            String driver =("com.mysql.jbdc.Driver");
            String url ="jbdc:mysql//dbtropa.cohjnbb8mlur.eu-west-3.rds.amazonaws.com:3306/tropa";
            String username= "peter";
            String password= "tropa1337";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("It worked");
            return connection;
        }catch (Exception e){ System.out.println(e);}
        return null;
    }

}
