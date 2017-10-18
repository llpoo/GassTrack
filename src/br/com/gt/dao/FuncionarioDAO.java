/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Endereco;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
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
public class FuncionarioDAO implements DAO<Funcionario>{

    private Connection connection;
    
    public FuncionarioDAO(Connection con){
        this.connection = con;
    }
    
    @Override
    public boolean inserir(Funcionario funcionario) {
        String sql = "insert into funcionario (email,nome,telefone,cpf,rg,dataadmissao,endereco_id,usuario_id,sexo) values (?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pst;
        
        if(validarCampos(funcionario)==true){
            try {
                pst = connection.prepareStatement(sql);

                pst.setString(1, funcionario.getEmail());
                pst.setString(2, funcionario.getNome());
                pst.setString(3, funcionario.getTelefone());
                pst.setString(4, funcionario.getCpf());
                pst.setString(5, funcionario.getRg());

                java.sql.Date dataSql = new java.sql.Date(funcionario.getDataAdmissao().getTime());

                pst.setDate(6, dataSql);


                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
                endereco = enderecoDAO.buscar(funcionario.getEndereco());

                if(endereco.getId() < 1){
                    enderecoDAO.inserir(funcionario.getEndereco());
                    endereco = enderecoDAO.buscar(funcionario.getEndereco());
                }

                funcionario.getEndereco().setId(endereco.getId());

                pst.setInt(7, funcionario.getEndereco().getId());

                Usuario usuario = new Usuario();
                UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

                usuarioDAO.inserir(funcionario.getUsuario());
                usuario = usuarioDAO.buscar(funcionario.getUsuario());

                funcionario.getUsuario().setId(usuario.getId());

                pst.setInt(8, funcionario.getUsuario().getId());

                pst.setString(9, funcionario.getSexo());

                pst.execute();
                pst.close();
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o funcionário");
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do funcionário");
            return false;
        }
        return false;
    }

    @Override
    public boolean alterar(Funcionario funcionario) {
        String sql = "update funcionario set email = ?, nome = ?, telefone = ?, cpf = ?, rg = ?, dataadmissao = ?, endereco_id = ?, sexo = ? where id = ?";
        
        PreparedStatement pst;
        
        if(validarCampos(funcionario)==true){
            try {
                pst = connection.prepareStatement(sql);

                pst.setString(1, funcionario.getEmail());
                pst.setString(2, funcionario.getNome());
                pst.setString(3, funcionario.getTelefone());
                pst.setString(4, funcionario.getCpf());
                pst.setString(5, funcionario.getRg());

                java.sql.Date dataSql = new java.sql.Date(funcionario.getDataAdmissao().getTime());

                pst.setDate(6, dataSql);


                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
                endereco = enderecoDAO.buscar(funcionario.getEndereco());

                if(endereco.getId() < 1){
                    enderecoDAO.alterar(funcionario.getEndereco());
                    endereco = enderecoDAO.buscar(funcionario.getEndereco());
                }

                funcionario.getEndereco().setId(endereco.getId());

                pst.setInt(7, funcionario.getEndereco().getId());

                UsuarioDAO usuarioDAO = new UsuarioDAO(this.connection);
                usuarioDAO.alterar(funcionario.getUsuario());

                pst.setString(8, funcionario.getSexo());

                pst.setInt(9, funcionario.getId());

                pst.execute();
                pst.close();
                JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o funcionário");
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do funcionário");
            return false;
        }
        return false;
    }

    @Override
    public boolean excluir(Funcionario funcionario) {
        String sql = "delete from funcionario where id = ?";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, funcionario.getId());
            
            UsuarioDAO uDao = new UsuarioDAO(this.connection);
            uDao.excluir(funcionario.getUsuario());
            
            Endereco e = funcionario.getEndereco();
            
            pst.execute();
            pst.close();
            
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            if(eDao.existeEmFuncionario(e) == false){
                eDao.excluir(e);
            }
            
            JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o funcionário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Funcionario buscarById(int id){
        String sql = "SELECT * FROM funcionario where id = ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        Funcionario fun = new Funcionario();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            
            UsuarioDAO uDao = new UsuarioDAO(this.connection);
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                Endereco e = new Endereco();
                Usuario u = new Usuario();
                
                f.setId(rs.getInt("Id"));
                f.setCpf(rs.getString("cpf"));
                f.setDataAdmissao(rs.getDate("dataadmissao"));
                f.setEmail(rs.getString("email"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setTelefone(rs.getString("telefone"));
                
                e.setId(rs.getInt("endereco_id"));
                u.setId(rs.getInt("usuario_id"));
                
                f.setEndereco(eDao.buscarById(e.getId()));
                f.setUsuario(uDao.buscarById(u.getId()));
                
                fun = f;
            }
            
            rs.close();
            pst.close();
            return fun;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o funcionário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Funcionario buscar(Funcionario funcionario) {
        String sql = "SELECT * FROM funcionario where usuario_id = ? order by nome";
                
        PreparedStatement pst;
        ResultSet rs;
        
        Funcionario fun = new Funcionario();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, funcionario.getUsuario().getId());
            
            rs = pst.executeQuery();
            
            UsuarioDAO uDao = new UsuarioDAO(this.connection);
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                Endereco e = new Endereco();
                Usuario u = new Usuario();
                
                f.setId(rs.getInt("Id"));
                f.setCpf(rs.getString("cpf"));
                f.setDataAdmissao(rs.getDate("dataadmissao"));
                f.setEmail(rs.getString("email"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setTelefone(rs.getString("telefone"));
                
                e.setId(rs.getInt("endereco_id"));
                u.setId(rs.getInt("usuario_id"));
                
                f.setEndereco(eDao.buscarById(e.getId()));
                f.setUsuario(uDao.buscarById(u.getId()));
                
                fun = f;
            }
            
            rs.close();
            pst.close();
            return fun;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Funcionario> listar() {
        String sql = "SELECT * FROM funcionario order by nome";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            UsuarioDAO uDao = new UsuarioDAO(this.connection);
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                Endereco e = new Endereco();
                Usuario u = new Usuario();
                
                f.setId(rs.getInt("Id"));
                f.setCpf(rs.getString("cpf"));
                f.setDataAdmissao(rs.getDate("dataadmissao"));
                f.setEmail(rs.getString("email"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setTelefone(rs.getString("telefone"));
                
                e.setId(rs.getInt("endereco_id"));
                u.setId(rs.getInt("usuario_id"));
                
                f.setEndereco(eDao.buscarById(e.getId()));
                f.setUsuario(uDao.buscarById(u.getId()));
                
                funcionarios.add(f);
            }
            
            rs.close();
            pst.close();
            return funcionarios;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Funcionario> pesquisar(String nome) {
        String sql = "SELECT * FROM funcionario where nome ~* ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, nome);
            
            rs = pst.executeQuery();
            
            UsuarioDAO uDao = new UsuarioDAO(this.connection);
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                Endereco e = new Endereco();
                Usuario u = new Usuario();
                
                f.setId(rs.getInt("Id"));
                f.setCpf(rs.getString("cpf"));
                f.setDataAdmissao(rs.getDate("dataadmissao"));
                f.setEmail(rs.getString("email"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setTelefone(rs.getString("telefone"));
                
                e.setId(rs.getInt("endereco_id"));
                u.setId(rs.getInt("usuario_id"));
                
                f.setEndereco(eDao.buscarById(e.getId()));
                f.setUsuario(uDao.buscarById(u.getId()));
                
                funcionarios.add(f);
            }
            
            rs.close();
            pst.close();
            return funcionarios;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o funcionário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private boolean validarCampos(Funcionario funcionario) {
        if(funcionario.getNome()!=null && funcionario.getEmail()!=null && 
            funcionario.getCpf()!=null && funcionario.getRg()!=null && 
            funcionario.getSexo()!=null && funcionario.getTelefone()!=null && 
            funcionario.getDataAdmissao()!=null){
                EnderecoDAO eDao = new EnderecoDAO(this.connection);
                UsuarioDAO uDao =new UsuarioDAO(this.connection);
                if(eDao.validarCampos(funcionario.getEndereco()) == true &&
                   uDao.validarCampos(funcionario.getUsuario())==true){
                    return true;
                }else{
                    return false;
                }
        }else{
            return false;
        }
    }
    
}
