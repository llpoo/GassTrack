/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Funcionario;
import br.com.gt.model.Item;
import br.com.gt.model.PessoaFisica;
import br.com.gt.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class VendaDAO implements DAO<Venda>{

    Connection connection;

    public VendaDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public boolean inserir(Venda venda) {
       String sql = "insert into venda (descricao,dataabertura,datapagamento,desconto,situacao,valormaodeobra,valortotal,funcionario_id,cliente_id) values (?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pst;
        ResultSet rs;
        
        if(validarCampos(venda)==true){
            try {
                pst = connection.prepareStatement(sql);

                pst.setString(1, venda.getDescricao());

                java.sql.Date dataAtualSql = new java.sql.Date(venda.getDataAbertura().getTime());

                pst.setDate(2, dataAtualSql);
                pst.setDate(3, null);
                pst.setDouble(4, venda.getDesconto());
                pst.setBoolean(5, venda.getSituacao());
                pst.setDouble(6, venda.getValorMaoDeObra());
                pst.setDouble(7, venda.getValorTotal());
                pst.setInt(8, venda.getFuncionario().getId());
                pst.setInt(9, venda.getCliente().getId());
                pst.execute();
                pst.close();

                sql ="select max(id) from venda";

                pst = connection.prepareStatement(sql);
                rs = pst.executeQuery();

                Integer ultimoId = new Integer(0);

                while(rs.next()){
                    ultimoId = rs.getInt("max");
                }

                venda.setId(ultimoId);

                rs.close();
                pst.close();


                sql = "insert into venda_tem_itens (venda_id,item_id,quantidade_item) values (?,?,?)";
                pst = connection.prepareStatement(sql);

                for(int i=0; i<venda.getItens().size(); i++){
                    pst.setInt(1, venda.getId());
                    pst.setInt(2, venda.getItens().get(i).getId());
                    pst.setDouble(3, venda.getQuantidades().get(i));

                    pst.execute();
                }

                pst.close();
                JOptionPane.showMessageDialog(null, "Venda encaminhada com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a venda");
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos da venda");
            return false;
        }
        return false;    
    }

    @Override
    public boolean alterar(Venda venda) {
        String sql = "update venda set descricao = ?,datapagamento = ?,desconto = ?,situacao = ?,valormaodeobra = ?,valortotal = ?,funcionario_id = ?,cliente_id = ? where id = ?";
        
        PreparedStatement pst;
        ResultSet rs;
        
        if(validarCampos(venda)==true){
            try {
                pst = connection.prepareStatement(sql);

                pst.setString(1, venda.getDescricao());

                pst.setDate(2, null);
                pst.setDouble(3, venda.getDesconto());
                pst.setBoolean(4, venda.getSituacao());
                pst.setDouble(5, venda.getValorMaoDeObra());
                pst.setDouble(6, venda.getValorTotal());
                pst.setInt(7, venda.getFuncionario().getId());
                pst.setInt(8, venda.getCliente().getId());
                pst.setInt(9, venda.getId());
                pst.execute();
                pst.close();


                sql = "delete from venda_tem_itens where venda_id = ?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, venda.getId());

                pst.execute();
                pst.close();

                sql = "insert into venda_tem_itens (venda_id,item_id,quantidade_item) values (?,?,?)";
                pst = connection.prepareStatement(sql);

                for(int i=0; i<venda.getItens().size(); i++){
                    pst.setInt(1, venda.getId());
                    pst.setInt(2, venda.getItens().get(i).getId());
                    pst.setDouble(3, venda.getQuantidades().get(i));

                    pst.execute();
                }

                pst.close();
                JOptionPane.showMessageDialog(null, "Venda alterada com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar a venda");
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos da venda");
            return false;
        }
        return false;    
    }

    @Override
    public boolean excluir(Venda venda) {
        String sql = "delete from venda_tem_itens where venda_id = ?";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, venda.getId());
            
            pst.execute();
            pst.close();
            
            sql = "delete from venda where id = ?";
            
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, venda.getId());
            
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Venda buscar(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venda> listar() {
        String sql = "SELECT * FROM venda order by dataabertura";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            FuncionarioDAO fDao = new FuncionarioDAO(this.connection);
            ClienteDAO cDao = new ClienteDAO(this.connection);
            
            while(rs.next()){
                ArrayList<Item> itens = new ArrayList<>();
                ArrayList<Double> quantidades = new ArrayList<>();
                
                Venda v = new Venda();
                Funcionario f = new Funcionario();
                PessoaFisica c = new PessoaFisica();
                
                v.setId(rs.getInt("id"));
                v.setDescricao(rs.getString("descricao"));
                v.setDataAbertura(rs.getDate("dataabertura"));
                v.setDesconto(rs.getDouble("desconto"));
                v.setSituacao(rs.getBoolean("situacao"));
                v.setValorMaoDeObra(rs.getDouble("valormaodeobra"));
                v.setValorTotal(rs.getDouble("valortotal"));
                
                f.setId(rs.getInt("funcionario_id"));
                c.setId(rs.getInt("cliente_id"));
                
                f = fDao.buscarById(f.getId());
                v.setFuncionario(f);
                
                c = cDao.buscar(c);
                v.setCliente(c);
                
                v.setDataPagamento(rs.getDate("datapagamento"));
                
                this.buscarItensQuantidades(v, itens, quantidades);
                
                v.setItens(itens);
                v.setQuantidades(quantidades);
                
                vendas.add(v);
            }
            
            rs.close();
            pst.close();
            return vendas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Venda> pesquisar(String nomeCliente) {
        String sql = "SELECT * from venda INNER JOIN cliente ON cliente.id = venda.cliente_id and cliente.nome ~* ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, nomeCliente);
            
            rs = pst.executeQuery();
            
            FuncionarioDAO fDao = new FuncionarioDAO(this.connection);
            ClienteDAO cDao = new ClienteDAO(this.connection);
            
            while(rs.next()){
                ArrayList<Item> itens = new ArrayList<>();
                ArrayList<Double> quantidades = new ArrayList<>();
                
                Venda v = new Venda();
                Funcionario f = new Funcionario();
                PessoaFisica c = new PessoaFisica();
                
                v.setId(rs.getInt("id"));
                v.setDescricao(rs.getString("descricao"));
                v.setDataAbertura(rs.getDate("dataabertura"));
                v.setDesconto(rs.getDouble("desconto"));
                v.setSituacao(rs.getBoolean("situacao"));
                v.setValorMaoDeObra(rs.getDouble("valormaodeobra"));
                v.setValorTotal(rs.getDouble("valortotal"));
                
                f.setId(rs.getInt("funcionario_id"));
                c.setId(rs.getInt("cliente_id"));
                
                f = fDao.buscarById(f.getId());
                v.setFuncionario(f);
                
                c = cDao.buscar(c);
                v.setCliente(c);
                
                v.setDataPagamento(rs.getDate("datapagamento"));
                
                this.buscarItensQuantidades(v, itens, quantidades);
                
                v.setItens(itens);
                v.setQuantidades(quantidades);
                
                vendas.add(v);
            }
            
            rs.close();
            pst.close();
            return vendas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Venda> listarVendasEmAberto(){
        String sql = "SELECT * FROM venda where situacao = false order by dataabertura";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            FuncionarioDAO fDao = new FuncionarioDAO(this.connection);
            ClienteDAO cDao = new ClienteDAO(this.connection);
            
            while(rs.next()){
                ArrayList<Item> itens = new ArrayList<>();
                ArrayList<Double> quantidades = new ArrayList<>();
                
                Venda v = new Venda();
                Funcionario f = new Funcionario();
                PessoaFisica c = new PessoaFisica();
                
                v.setId(rs.getInt("id"));
                v.setDescricao(rs.getString("descricao"));
                v.setDataAbertura(rs.getDate("dataabertura"));
                v.setDesconto(rs.getDouble("desconto"));
                v.setSituacao(rs.getBoolean("situacao"));
                v.setValorMaoDeObra(rs.getDouble("valormaodeobra"));
                v.setValorTotal(rs.getDouble("valortotal"));
                
                f.setId(rs.getInt("funcionario_id"));
                c.setId(rs.getInt("cliente_id"));
                
                f = fDao.buscarById(f.getId());
                v.setFuncionario(f);
                
                c = cDao.buscar(c);
                v.setCliente(c);
                
                v.setDataPagamento(rs.getDate("datapagamento"));
                
                this.buscarItensQuantidades(v, itens, quantidades);
                
                v.setItens(itens);
                v.setQuantidades(quantidades);
                
                vendas.add(v);
            }
            
            rs.close();
            pst.close();
            return vendas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void buscarItensQuantidades(Venda venda,ArrayList<Item> itens, ArrayList<Double> quantidades){
        String sql = "SELECT * FROM venda_tem_itens where venda_id = ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ItemDAO iDao = new ItemDAO(this.connection);
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, venda.getId());
            
            rs = pst.executeQuery();
            
            
            
            while(rs.next()){
                Item i = new Item();
                Double q = new Double(0);
                
                q = rs.getDouble("quantidade_item");
                
                i.setId(rs.getInt("item_id"));
                i = iDao.buscarById(i.getId());
                
                itens.add(i);
                quantidades.add(q);
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void baixaEstoque(Venda venda){
        String sql = "update item set quantidadeatual = ? where id = ?";
        
        PreparedStatement pst;
        
        try {
            for(int i=0; i<venda.getItens().size(); i++){
                pst = connection.prepareStatement(sql);
                pst.setDouble(1, venda.getItens().get(i).getQuantidadeAtual()-venda.getQuantidades().get(i));
                pst.setInt(2, venda.getItens().get(i).getId());
                
                pst.execute();
                pst.close();
            }
            
            sql = "update venda set situacao = true, datapagamento = ? where id = ?";
            
            pst = connection.prepareStatement(sql);
            
            Date data = new Date();
            java.sql.Date dataAtualSql = new java.sql.Date(data.getTime());
            pst.setDate(1, dataAtualSql);
            
            pst.setInt(2, venda.getId());
            
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o funcionário");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Venda> pesquisarEmAberto(String nomeCliente){
        String sql = "SELECT * from venda INNER JOIN cliente ON cliente.id = venda.cliente_id and cliente.nome ~* ? and venda.situacao = false";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, nomeCliente);
            
            rs = pst.executeQuery();
            
            FuncionarioDAO fDao = new FuncionarioDAO(this.connection);
            ClienteDAO cDao = new ClienteDAO(this.connection);
            
            while(rs.next()){
                ArrayList<Item> itens = new ArrayList<>();
                ArrayList<Double> quantidades = new ArrayList<>();
                
                Venda v = new Venda();
                Funcionario f = new Funcionario();
                PessoaFisica c = new PessoaFisica();
                
                v.setId(rs.getInt("id"));
                v.setDescricao(rs.getString("descricao"));
                v.setDataAbertura(rs.getDate("dataabertura"));
                v.setDesconto(rs.getDouble("desconto"));
                v.setSituacao(rs.getBoolean("situacao"));
                v.setValorMaoDeObra(rs.getDouble("valormaodeobra"));
                v.setValorTotal(rs.getDouble("valortotal"));
                
                f.setId(rs.getInt("funcionario_id"));
                c.setId(rs.getInt("cliente_id"));
                
                f = fDao.buscarById(f.getId());
                v.setFuncionario(f);
                
                c = cDao.buscar(c);
                v.setCliente(c);
                
                v.setDataPagamento(rs.getDate("datapagamento"));
                
                this.buscarItensQuantidades(v, itens, quantidades);
                
                v.setItens(itens);
                v.setQuantidades(quantidades);
                
                vendas.add(v);
            }
            
            rs.close();
            pst.close();
            return vendas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Venda> pesquisarByFuncionario(String nomeFuncionario){
        String sql = "SELECT * from venda INNER JOIN funcionario ON funcionario.id = venda.funcionario_id and funcionario.nome ~* ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, nomeFuncionario);
            
            rs = pst.executeQuery();
            
            FuncionarioDAO fDao = new FuncionarioDAO(this.connection);
            ClienteDAO cDao = new ClienteDAO(this.connection);
            
            while(rs.next()){
                ArrayList<Item> itens = new ArrayList<>();
                ArrayList<Double> quantidades = new ArrayList<>();
                
                Venda v = new Venda();
                Funcionario f = new Funcionario();
                PessoaFisica c = new PessoaFisica();
                
                v.setId(rs.getInt("id"));
                v.setDescricao(rs.getString("descricao"));
                v.setDataAbertura(rs.getDate("dataabertura"));
                v.setDesconto(rs.getDouble("desconto"));
                v.setSituacao(rs.getBoolean("situacao"));
                v.setValorMaoDeObra(rs.getDouble("valormaodeobra"));
                v.setValorTotal(rs.getDouble("valortotal"));
                
                f.setId(rs.getInt("funcionario_id"));
                c.setId(rs.getInt("cliente_id"));
                
                f = fDao.buscarById(f.getId());
                v.setFuncionario(f);
                
                c = cDao.buscar(c);
                v.setCliente(c);
                
                v.setDataPagamento(rs.getDate("datapagamento"));
                
                this.buscarItensQuantidades(v, itens, quantidades);
                
                v.setItens(itens);
                v.setQuantidades(quantidades);
                
                vendas.add(v);
            }
            
            rs.close();
            pst.close();
            return vendas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Venda> pesquisarByData(Date data){
        String sql = "SELECT * from venda where datapagamento = ? or dataabertura = ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            java.sql.Date dataCorreta = new java.sql.Date(data.getTime());
            
            pst.setDate(1, dataCorreta);
            pst.setDate(2, dataCorreta);
            
            rs = pst.executeQuery();
            
            FuncionarioDAO fDao = new FuncionarioDAO(this.connection);
            ClienteDAO cDao = new ClienteDAO(this.connection);
            
            while(rs.next()){
                ArrayList<Item> itens = new ArrayList<>();
                ArrayList<Double> quantidades = new ArrayList<>();
                
                Venda v = new Venda();
                Funcionario f = new Funcionario();
                PessoaFisica c = new PessoaFisica();
                
                v.setId(rs.getInt("id"));
                v.setDescricao(rs.getString("descricao"));
                v.setDataAbertura(rs.getDate("dataabertura"));
                v.setDesconto(rs.getDouble("desconto"));
                v.setSituacao(rs.getBoolean("situacao"));
                v.setValorMaoDeObra(rs.getDouble("valormaodeobra"));
                v.setValorTotal(rs.getDouble("valortotal"));
                
                f.setId(rs.getInt("funcionario_id"));
                c.setId(rs.getInt("cliente_id"));
                
                f = fDao.buscarById(f.getId());
                v.setFuncionario(f);
                
                c = cDao.buscar(c);
                v.setCliente(c);
                
                v.setDataPagamento(rs.getDate("datapagamento"));
                
                this.buscarItensQuantidades(v, itens, quantidades);
                
                v.setItens(itens);
                v.setQuantidades(quantidades);
                
                vendas.add(v);
            }
            
            rs.close();
            pst.close();
            return vendas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private boolean validarCampos(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
