/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.EnderecoDAO;
import br.com.gt.dao.FornecedorDAO;
import br.com.gt.model.Endereco;
import br.com.gt.model.Fornecedor;
import br.com.gt.view.fornecedor.AlterarFornecedorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Luciano Júnior
 */
public class AlterarFornecedorController implements ActionListener{
    Connection connection;
    AlterarFornecedorView telaAlterar;
    Fornecedor fornecedor;
    MaskFormatter mascaraCNPJ;
    MaskFormatter mascaraTelefone;
    MaskFormatter mascaraCEP;
   
    public AlterarFornecedorController(Connection con, Fornecedor f){
        this.connection = con;
        this.fornecedor = f;
        this.telaAlterar = new AlterarFornecedorView(null, true);
        adicionaEventos();
        inicializaMascaras();
        preencheCampos();
        this.telaAlterar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getCancelarBtn())){
            this.telaAlterar.dispose();
        }
        
        if(evento.getSource().equals(this.telaAlterar.getSalvarBtn())){
            this.fornecedor.setCnpj(this.telaAlterar.getCnpjTxt().getText());
            this.fornecedor.setEmail(this.telaAlterar.getEmailTxt().getText());
            this.fornecedor.setNome(this.telaAlterar.getNomeTxt().getText());
            this.fornecedor.setTelefone(this.telaAlterar.getTelefoneTxt().getText());
            
            Endereco auxEndereco = new Endereco();
            auxEndereco.setId(this.fornecedor.getEndereco().getId());
            auxEndereco.setBairro(this.fornecedor.getEndereco().getBairro());
            auxEndereco.setCep(this.fornecedor.getEndereco().getCep());
            auxEndereco.setCidade(this.fornecedor.getEndereco().getCidade());
            auxEndereco.setEstado(this.fornecedor.getEndereco().getEstado());
            auxEndereco.setNumero(this.fornecedor.getEndereco().getNumero());
            auxEndereco.setRua(this.fornecedor.getEndereco().getRua());
            
            this.fornecedor.getEndereco().setBairro(this.telaAlterar.getBairroTxt().getText());
            this.fornecedor.getEndereco().setCep(this.telaAlterar.getCepTxt().getText());
            this.fornecedor.getEndereco().setCidade(this.telaAlterar.getCidadeTxt().getText());
            this.fornecedor.getEndereco().setEstado(this.telaAlterar.getEstadoComboBox().getSelectedItem().toString());
            this.fornecedor.getEndereco().setNumero(this.telaAlterar.getNumeroTxt().getText());
            this.fornecedor.getEndereco().setRua(this.telaAlterar.getRuaTxt().getText());
                        
            FornecedorDAO fornecedorDAO = new FornecedorDAO(this.connection);
            
            if(fornecedorDAO.alterar(this.fornecedor)==true){
                EnderecoDAO eDao = new EnderecoDAO(this.connection);
                if(eDao.existeEmFornecedor(auxEndereco)==false){
                    eDao.excluir(auxEndereco);
                }
                this.telaAlterar.dispose();
            }
        }
    }

    private void adicionaEventos() {
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    private void preencheCampos() {
        String aux = "";
        this.telaAlterar.getNomeTxt().setText(this.fornecedor.getNome());
        aux = "";
        aux = (String) this.fornecedor.getCnpj().subSequence(0, 2) + (String) this.fornecedor.getCnpj().subSequence(3, 6) +
              (String) this.fornecedor.getCnpj().subSequence(7, 10) + (String) this.fornecedor.getCnpj().subSequence(11, 15) +
              (String) this.fornecedor.getCnpj().subSequence(16, 18);
        this.telaAlterar.getCnpjTxt().setText(this.fornecedor.getCnpj());
        this.telaAlterar.getEmailTxt().setText(this.fornecedor.getEmail());
        aux = "";
        aux = (String) this.fornecedor.getTelefone().subSequence(1, 3) + (String) this.fornecedor.getTelefone().subSequence(4, 9) +
              (String) this.fornecedor.getTelefone().subSequence(10, 14);
        this.telaAlterar.getTelefoneTxt().setText(aux);
        this.telaAlterar.getTelefoneTxt().setText(this.fornecedor.getTelefone());
        this.telaAlterar.getEstadoComboBox().setSelectedItem(this.fornecedor.getEndereco().getEstado());
        aux = "";
        aux = (String) this.fornecedor.getEndereco().getCep().subSequence(0, 5) + (String) this.fornecedor.getEndereco().getCep().subSequence(6, 9);
        this.telaAlterar.getCepTxt().setText(aux);
        this.telaAlterar.getCepTxt().setText(this.fornecedor.getEndereco().getCep());
        this.telaAlterar.getCidadeTxt().setText(this.fornecedor.getEndereco().getCidade());
        this.telaAlterar.getBairroTxt().setText(this.fornecedor.getEndereco().getBairro());
        this.telaAlterar.getRuaTxt().setText(this.fornecedor.getEndereco().getRua());
        this.telaAlterar.getNumeroTxt().setText(this.fornecedor.getEndereco().getNumero());
    }

    private void inicializaMascaras() {
        try{
            this.mascaraCEP = new MaskFormatter("#####-###");
            this.mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
            this.mascaraTelefone = new MaskFormatter("(##) ####-####");
            
            this.telaAlterar.getCnpjTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));
            this.telaAlterar.getTelefoneTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
            this.telaAlterar.getCepTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraCEP));
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
    
}
