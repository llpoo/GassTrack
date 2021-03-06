/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Endereco;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Funcionario;
import br.com.gt.model.PessoaFisica;
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
 * @author lucas
 */
public class EnderecoDAO implements DAO<Endereco>{
    Connection connection;

    public EnderecoDAO(Connection con) {
        this.connection = con;
    }

    @Override
    public boolean inserir(Endereco endereco) {
        String sql = "insert into endereco (cep,cidade,estado,numero,rua,bairro) values (?,?,?,?,?,?)";
        
        PreparedStatement pst;
        
        //if(validarCampos(endereco)==true){
            try {
                pst = connection.prepareStatement(sql);

                pst.setString(1, endereco.getCep());
                pst.setString(2, endereco.getCidade());
                pst.setString(3, endereco.getEstado());
                pst.setString(4, endereco.getNumero());
                pst.setString(5, endereco.getRua());
                pst.setString(6, endereco.getBairro());

                pst.execute();
                pst.close();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço");
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}else{
        //    JOptionPane.showMessageDialog(null, "Preencha todos os campos de endereço");
        //    return false;
        //}
        return false;
    }

    @Override
    public boolean alterar(Endereco endereco) {
        String sql = "update endereco set cep = ?, cidade= ?, estado= ?, numero= ?, rua= ?, bairro = ? where id = ?";
        
        PreparedStatement pst;
                
        if(validarCampos(endereco)==true){          
            try {
                pst = connection.prepareStatement(sql);

                pst.setString(1, endereco.getCep());
                pst.setString(2, endereco.getCidade());
                pst.setString(3, endereco.getEstado());
                pst.setString(4, endereco.getNumero());
                pst.setString(5, endereco.getRua());
                pst.setString(6, endereco.getBairro());
                pst.setInt(7, endereco.getId());

                pst.execute();
                pst.close();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o endereço");
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do endereço");
            return false;
        }    
        return false;
    }

    @Override
    public boolean excluir(Endereco endereco) {
        String sql = "delete from endereco where id = ?";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, endereco.getId());
            
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereço");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean existeEmCliente(Endereco endereco){
        String sql = "SELECT * FROM cliente WHERE endereco_id = ?";
        
        PessoaFisica cliente = new PessoaFisica();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, endereco.getId());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                cliente.setId(rs.getInt("id"));
            }
            
            rs.close();
            pst.close();
            
            if(cliente.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean existeEmFuncionario(Endereco endereco){
        String sql = "SELECT * FROM funcionario WHERE endereco_id = ?";
        
        Funcionario funcionario = new Funcionario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, endereco.getId());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                funcionario.setId(rs.getInt("id"));
            }
            
            rs.close();
            pst.close();
            
            if(funcionario.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Endereco buscarById(int idEndereco){
        String sql = "SELECT * FROM endereco WHERE id = ?";
        
        Endereco e = new Endereco();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, idEndereco);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                e.setId(rs.getInt("id"));
                e.setBairro(rs.getString("bairro"));
                e.setCep(rs.getString("cep"));
                e.setCidade(rs.getString("cidade"));
                e.setEstado(rs.getString("estado"));
                e.setNumero(rs.getString("numero"));
                e.setRua(rs.getString("rua"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }

    @Override
    public Endereco buscar(Endereco endereco) {
        String sql = "SELECT * FROM endereco WHERE rua ~* ? AND numero like ? AND cep like ? AND estado = ?";
        
        Endereco e = new Endereco();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getNumero());
            pst.setString(3, endereco.getCep());
            pst.setString(4, endereco.getEstado());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                e.setId(rs.getInt("id"));
                e.setBairro(rs.getString("bairro"));
                e.setCep(rs.getString("cep"));
                e.setCidade(rs.getString("cidade"));
                e.setEstado(rs.getString("estado"));
                e.setNumero(rs.getString("numero"));
                e.setRua(rs.getString("rua"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }

    @Override
    public ArrayList<Endereco> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Endereco> pesquisar(String objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existeEmFornecedor(Endereco endereco) {
        String sql = "SELECT * FROM fornecedor WHERE endereco_id = ?";
        
        Fornecedor fornecedor = new Fornecedor();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, endereco.getId());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                fornecedor.setId(rs.getInt("id"));
            }
            
            rs.close();
            pst.close();
            
            if(fornecedor.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    boolean validarCampos(Endereco endereco) {
        if(endereco.getBairro().length() != 0 && endereco.getCep().length() != 0 &&
            endereco.getCidade().length() != 0 && endereco.getEstado().length() !=0 &&
            endereco.getNumero().length() != 0 && endereco.getRua().length() != 0){
                return true;
        }else{
            return false;
        }
    }
    
}
