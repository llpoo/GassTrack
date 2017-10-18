/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.ClienteDAO;
import br.com.gt.model.Endereco;
import br.com.gt.model.PessoaFisica;
import br.com.gt.view.cliente.AlterarClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class AlterarClienteController implements ActionListener{
    
    Connection connection;
    AlterarClienteView telaAlterar;
    PessoaFisica cliente;
    Endereco endereco;
    
    public AlterarClienteController(Connection connection, PessoaFisica c) {
        this.connection = connection;
        this.cliente = new PessoaFisica();
        this.endereco = new Endereco();
        this.telaAlterar = new AlterarClienteView(null,true);
        adicionaEventos();
        preencheCampos(c);
        this.telaAlterar.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getCancelarBtn())){
            this.telaAlterar.dispose();
        }
        
        if(evento.getSource().equals(this.telaAlterar.getSalvarBtn())){
            this.cliente.setCpf(this.telaAlterar.getCpfTxt().getText());
            this.cliente.setEmail(this.telaAlterar.getEmailTxt().getText());
            this.cliente.setNome(this.telaAlterar.getNomeTxt().getText());
            this.cliente.setRg(this.telaAlterar.getRgTxt().getText());
            
            if(this.telaAlterar.getMasculinoRadio().isSelected()){
                this.cliente.setSexo("Masculino");
            }else{
                if(this.telaAlterar.getFemininoRadio().isSelected()){
                    this.cliente.setSexo("Feminino");
                }
            }
            
            this.cliente.setTelefone(this.telaAlterar.getTelefoneTxt().getText());
            
            this.endereco.setBairro(this.telaAlterar.getBairroTxt().getText());
            this.endereco.setCep(this.telaAlterar.getCepTxt().getText());
            this.endereco.setCidade(this.telaAlterar.getCidadeTxt().getText());
            this.endereco.setEstado(this.telaAlterar.getEstadoComboBox().getSelectedItem().toString());
            this.endereco.setNumero(this.telaAlterar.getNumeroTxt().getText());
            this.endereco.setRua(this.telaAlterar.getRuaTxt().getText());
            
            this.cliente.setEndereco(this.endereco);
            
            ClienteDAO clienteDao = new ClienteDAO(this.connection);
            clienteDao.alterar(this.cliente);
            
            if(clienteDao.alterar(this.cliente) == true){
                this.telaAlterar.dispose();
            }
        }
    }

    private void adicionaEventos() {
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    private void preencheCampos(PessoaFisica c) {
        this.cliente.setId(c.getId());
        this.endereco.setId(c.getEndereco().getId());
        this.telaAlterar.getNomeTxt().setText(c.getNome());
        this.telaAlterar.getRgTxt().setText(c.getRg());
        this.telaAlterar.getCpfTxt().setText(c.getCpf());
        this.telaAlterar.getEmailTxt().setText(c.getEmail());
        this.telaAlterar.getTelefoneTxt().setText(c.getTelefone());
        
        if(c.getSexo().equalsIgnoreCase("Masculino")){
            this.telaAlterar.getMasculinoRadio().setSelected(true);
        }else{
            if(c.getSexo().equalsIgnoreCase("Feminino")){
                this.telaAlterar.getFemininoRadio().setSelected(true);
            }
        }
        
        this.telaAlterar.getEstadoComboBox().setSelectedItem(c.getEndereco().getEstado());
        this.telaAlterar.getCepTxt().setText(c.getEndereco().getCep());
        this.telaAlterar.getCidadeTxt().setText(c.getEndereco().getCidade());
        this.telaAlterar.getBairroTxt().setText(c.getEndereco().getBairro());
        this.telaAlterar.getRuaTxt().setText(c.getEndereco().getRua());
        this.telaAlterar.getNumeroTxt().setText(c.getEndereco().getNumero());
    }
    
}
