/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
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
public class UsuarioDAO implements DAO<Usuario>{
    private Connection connection;

    public UsuarioDAO(Connection con) {
        this.connection = con;
    }

    @Override
    public boolean inserir(Usuario usuario) {
        String sql = "insert into usuario (senha, usuario,isgerente) values (?,?,?)";
        
        PreparedStatement pst;
        
        if(validarCampos(usuario)==true){
            if(existe(usuario)==false){
                try {
                    pst = connection.prepareStatement(sql);

                    pst.setString(1, usuario.getUsuario());
                    pst.setString(2, usuario.getSenha());
                    pst.setBoolean(3, false);

                    pst.execute();
                    pst.close();
                    return true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível salvar o usuário");
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
               JOptionPane.showMessageDialog(null, "Já existe um login com este usuário");
               return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "preencha todos os campos");
            return false;
        }
        return false;
    }

    @Override
    public boolean alterar(Usuario usuario) {
        String sql = "update usuario set usuario = ?, senha = ?, isgerente = ? where id = ?";
        
        PreparedStatement pst;
        
        if(validarCampos(usuario)==true){
            if(existeAlterar(usuario)==false){    
                try {
                    pst = connection.prepareStatement(sql);


                    pst.setString(1, usuario.getUsuario());
                    pst.setString(2, usuario.getSenha());
                    pst.setBoolean(3, usuario.getIsIsGerente());
                    pst.setInt(4, usuario.getId());

                    pst.execute();
                    pst.close();
                    return true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível alterar o usuário");
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Já existe um login com este usuário");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "preencha todos os campos");
            return false;
        }
        return false;    
    }

    @Override
    public boolean excluir(Usuario usuario) {
        String sql="update funcionario set usuario_id = 0 where usuario_id = ?";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, usuario.getId());
            
            pst.execute();
            pst.close();
            
            sql = "delete from usuario where id = ?";
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, usuario.getId());
            
            pst.execute();
            pst.close();
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Usuario buscarById(int idUsuario){
        String sql = "SELECT * FROM usuario WHERE id = ?";
        
        Usuario u = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, idUsuario);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                u.setIsGerente(rs.getBoolean("isgerente"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE usuario like ? and senha like ?";
        
        Usuario u = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getSenha());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                u.setIsGerente(rs.getBoolean("isgerente"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;
    }

    @Override
    public ArrayList<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> pesquisar(String objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean validarCampos(Usuario usuario) {
        if(usuario.getUsuario().length() > 0 && usuario.getUsuario().length() > 0){
                return true;
        }else{
            return false;
        }
    }
    
    public boolean existe(Usuario usuario){
        String sql = "SELECT * FROM usuario where usuario like ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        Usuario usu = new Usuario();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, usuario.getUsuario());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                usu.setId(rs.getInt("Id"));
            }
            
            rs.close();
            pst.close();
            
            if(usu.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuario");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean existeAlterar(Usuario usuario){
        String sql = "SELECT * FROM usuario where usuario like ? and id != ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        Usuario usu = new Usuario();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, usuario.getUsuario());
            pst.setInt(2, usuario.getId());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                usu.setId(rs.getInt("Id"));
            }
            
            rs.close();
            pst.close();
            
            if(usu.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuario");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
