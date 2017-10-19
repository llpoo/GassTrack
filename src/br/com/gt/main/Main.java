package br.com.gt.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.gt.controller.LoginController;
import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.dao.UsuarioDAO;
import br.com.gt.jdbc.ConnectionFactory;
import br.com.gt.model.Endereco;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
import java.sql.Connection;
import java.time.Instant;
import java.util.Date;



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
