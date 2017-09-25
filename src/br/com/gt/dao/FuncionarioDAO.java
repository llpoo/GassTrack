/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Endereco;
import br.com.gt.model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class FuncionarioDAO implements DAO<Funcionario>{

    private Connection connection;
    
    @Override
    public void inserir(Funcionario funcionario) {
        String sql = "insert into funcionario (email,nome,telefone,cpf,rg,dataadmissao,endereco_id,usuario_id) values (?,?,?,?,?,?,?,?)";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, funcionario.getEmail());
            pst.setString(2, funcionario.getNome());
            pst.setString(3, funcionario.getTelefone());
            pst.setString(4, funcionario.getCpf());
            pst.setString(5, funcionario.getRg());
            pst.setDate(6, (Date) funcionario.getDataAdmissao());
            
            Endereco endereco = new Endereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            endereco = enderecoDAO.buscar(funcionario.getEndereco());
            
            if(endereco == null){
                enderecoDAO.inserir(funcionario.getEndereco());
                endereco = enderecoDAO.buscar(funcionario.getEndereco());
            }
            
            funcionario.getEndereco().setId(endereco.getId());
            
            pst.setInt(7, funcionario.getEndereco().getId());
            pst.setInt(8, funcionario.getUsuario().getId());
            
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o funcionário");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario buscar(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> pesquisar(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
