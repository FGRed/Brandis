/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yrityspeli_package;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Timo
 */
public class JDBC {
    String driver = "org.sqlite.JDBC";// Luodaan String muuttuja driver 
    String url = "jdbc:sqlite:OTuote.db";// Luodaan String muuttuja url
    
    Connection getConnection() throws ClassNotFoundException, SQLException {// Metodi tietokanta yhteyden muodostamista varten
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url);
        con.setAutoCommit(true);
        return con;
    }
    
    void putData(String sql) throws ClassNotFoundException, SQLException {// Metodi datan lisäämiseen tietokantaan
        Connection con = getConnection();
        Statement state = con.createStatement();
        state.executeUpdate(sql);
        state.close();
    }
    
    public Statement state;
    public ResultSet getData(String sql) throws ClassNotFoundException, SQLException {// Metodi datan hakemiseen tietokannasta
        Connection con = getConnection();
        state = con.createStatement();
        ResultSet rset = state.executeQuery(sql);
        return rset;

}}
