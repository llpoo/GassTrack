/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.main;

import br.com.gt.controller.LoginController;
import javax.swing.JOptionPane;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;



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
        Configuration cfg = new Configuration();
        cfg.configure();
        SchemaUpdate se = new SchemaUpdate(cfg);
        se.execute(true, true);
        
        LoginController controleLogin = new LoginController();
    }
    
}
