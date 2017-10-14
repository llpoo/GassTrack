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
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o fornecedor");
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Fornecedor fornecedor) {
        String sql = "update fornecedor set nome=?,email=?,cnpj=?,telefone=?, endereco_id=? where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,fornecedor.getNome());
            pst.setString(2,fornecedor.getEmail());
            pst.setString(3,fornecedor.getCnpj());
            pst.setString(4,fornecedor.getTelefone());  
            
            Endereco endereco = new Endereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
            endereco = enderecoDAO.buscar(fornecedor.getEndereco());
            
            if(endereco.getId() < 1){
                enderecoDAO.alterar(fornecedor.getEndereco());
                endereco = enderecoDAO.buscar(fornecedor.getEndereco());
            }
            
            fornecedor.getEndereco().setId(endereco.getId());
            
            pst.setInt(5, fornecedor.getEndereco().getId());
            pst.setInt(6,fornecedor.getId());
            
            pst.execute();
            pst.close(); 
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o fornecedor");
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean excluir(Fornecedor fornecedor) {
        String sql = "delete from fornecedor where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, fornecedor.getId());
            
            Endereco e = fornecedor.getEndereco();
            
            pst.execute();
            pst.close(); 
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            if(eDao.existeEmFornecedor(e) == false){
                eDao.excluir(e);
            }
            return true;
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o fornecedor");
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Fornecedor buscar(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*String sql = "SELECT * FROM fornecedor WHERE cnpj= ?";
        
        Fornecedor f = new Fornecedor();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, fornecedor.getCnpj());
            
            rs = pst.executeQuery();
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                Endereco e = new Endereco();
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
		
                e.setId(rs.getInt("endereco_id"));
                
                f.setEndereco(eDao.buscarById(e.getId()));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o fornecedor");
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return f;*/
    }

    @Override
    public ArrayList<Fornecedor> listar() {
        String sql="select * from fornecedor order by nome";
        PreparedStatement pst;
        ArrayList<Fornecedor> listaFornecedor =new ArrayList<Fornecedor>();
        
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
		    
           while(rs.next()){		 	
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
		Endereco e =new Endereco();
                e.setId(rs.getInt("endereco_id"));
                
                fornecedor.setEndereco(eDao.buscarById(e.getId()));
                
		listaFornecedor.add(fornecedor);
	    }
		    
            rs.close();
            pst.close();
		    
            return listaFornecedor;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os fornecedores");
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return listaFornecedor;
        }
    }

    @Override
    public ArrayList<Fornecedor> pesquisar(String nome) {
        ArrayList<Fornecedor> buscaFornecedor = new ArrayList<Fornecedor>(); 
	PreparedStatement pst;
        String sql="select * from fornecedor where nome ilike ?";
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            pst.setString(1,"%" + nome + "%"); 
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
	
            while(rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
		Endereco e =new Endereco();
                e.setId(rs.getInt("endereco_id"));
                
                fornecedor.setEndereco(eDao.buscarById(e.getId()));      
                
		buscaFornecedor.add(fornecedor);
            }

            rs.close();
            pst.close();
            return buscaFornecedor;
	}catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o fornecedor");
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return buscaFornecedor;
        }
    }

    Fornecedor buscarById(int id) {
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
        
        Fornecedor f = new Fornecedor();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
		
                Endereco e =new Endereco();
                e.setId(rs.getInt("endereco_id"));
                
                f.setEndereco(eDao.buscarById(e.getId())); 
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return f;
    }
    
}
