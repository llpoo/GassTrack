/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lucas
 */
public class ConnectionFactory {
    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/gtdb"
                    , "postgres"
                    , "root");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
