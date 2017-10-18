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
    public boolean inserir(Fornecedor fornecedor) {
         String sql = "insert into fornecedor (email,nome,telefone,cnpj,endereco_id) values (?,?,?,?,?)";
        
        PreparedStatement pst;
        if(validarCampos(fornecedor)==true){
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
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o fornecedor");
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return false;
        }
        return false;
    }

    @Override
    public boolean alterar(Fornecedor fornecedor) {
        String sql = "update fornecedor set nome=?,email=?,cnpj=?,telefone=?, endereco_id=? where id=?";
        PreparedStatement pst;
        
        if(validarCampos(fornecedor)==true){        
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
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível editar o fornecedor");
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return false;
        }    
        return false;
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
        String sql = "SELECT * FROM fornecedor WHERE nome= ?";
        
        Fornecedor f = new Fornecedor();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, fornecedor.getNome());
            
            rs = pst.executeQuery();
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                Endereco e = new Endereco();
                f.setId(rs.getInt("id"));
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
        
        return f;
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
        String sql="select * from fornecedor where nome ~* ?";
        try{
            pst= connection.prepareStatement(sql);
            pst.setString(1, nome); 
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

    public Fornecedor buscarById(int id) {
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
    
    public Fornecedor buscarByNome(String nome) {
        String sql = "SELECT * FROM fornecedor WHERE nome = ?";
        
        Fornecedor f = new Fornecedor();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, nome);
            
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

    private boolean validarCampos(Fornecedor fornecedor) {
        if(fornecedor.getEmail()!=null && fornecedor.getCnpj()!=null && 
                fornecedor.getNome()!=null && fornecedor.getTelefone()!= null){
           EnderecoDAO eDao = new EnderecoDAO(this.connection);
           if(eDao.validarCampos(fornecedor.getEndereco()) == true){
               return true;
           }else{
               return false;
           } 
        }else{
            return false;
        }
    }
    
}
