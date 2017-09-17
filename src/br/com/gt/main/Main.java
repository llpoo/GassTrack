package br.com.gt.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.gt.controller.LoginController;
import br.com.gt.jdbc.ConnectionFactory;
import java.sql.Connection;



/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection connection = ConnectionFactory.getConnection();
        
        LoginController controleLogin = new LoginController(connection);
    }
    
}
