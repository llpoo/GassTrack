/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Endereco;
import br.com.gt.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Júnior
 */
public class FornecedorDAO implements DAO<Fornecedor>{
    
    private Connection connection;
    
    public FornecedorDAO(Connection con){
        this.connection = con;
    }

    @Override
    public void inserir(Fornecedor fornecedor) {
        String sql = "insert into fornecedor (email,nome,telefone,cnpj,endereco_id) values (?,?,?,?,?)";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, fornecedor.getEmail());
            pst.setString(2, fornecedor.getNome());
            pst.setString(3, fornecedor.getTelefone());
            pst.setString(4, fornecedor.getCnpj());
            
            Endereco endereco = new Endereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
            endereco = enderecoDAO.buscar(fornecedor.getEndereco());
            
            if(endereco.getId() < 1){
                enderecoDAO.inserir(fornecedor.getEndereco());
                endereco = enderecoDAO.buscar(fornecedor.getEndereco());
            }
            
            fornecedor.getEndereco().setId(endereco.getId());
            
            pst.setInt(5, fornecedor.getEndereco().getId());
            
            
            pst.execute();
            pst.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o funcionário");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Fornecedor fornecedor) {
        String sql = "update fornecedor set nome=?,email=?,cnpj=?,telefone=? where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,fornecedor.getNome());
            pst.setString(2,fornecedor.getEmail());
            pst.setString(3,fornecedor.getCnpj());
            pst.setString(4,fornecedor.getTelefone());  
            
            EnderecoDAO en= new EnderecoDAO(connection);
            en.alterar(fornecedor.getEndereco());
            
            pst.setInt(5,fornecedor.getId());
            
            pst.execute();
            pst.close(); 
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o funcionário");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean excluir(Fornecedor fornecedor) {
        String sql = "delete from fornecedor where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, fornecedor.getId());
            
            pst.execute();
            pst.close(); 
            return true;
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o funcionário");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Fornecedor buscar(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fornecedor> listar() {
        String sql="select * from fornecedor order by nome";
        PreparedStatement pst;
        ArrayList<Fornecedor> listaFornecedor =new ArrayList<Fornecedor>();
        
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
		    
           while(rs.next()){		 	
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
		//CRIAR ENDERECO: BUSCAR POR ID;    
                
                
		listaFornecedor.add(fornecedor);
	    }
		    
            rs.close();
            pst.close();
		    
            return listaFornecedor;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os funcionário");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return listaFornecedor;
        }
    }

    @Override
    public ArrayList<Fornecedor> pesquisar(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
