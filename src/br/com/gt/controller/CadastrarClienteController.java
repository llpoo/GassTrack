/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.ClienteDAO;
import br.com.gt.model.Endereco;
import br.com.gt.model.PessoaFisica;
import br.com.gt.view.cliente.CadastrarClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author lucas
 */
public class CadastrarClienteController implements ActionListener{
    
    Connection connection;
    CadastrarClienteView telaCadastro;
    MaskFormatter mascaraRG;
    MaskFormatter mascaraCPF;
    MaskFormatter mascaraTelefone;
    MaskFormatter mascaraCEP;
    
    public CadastrarClienteController(Connection con) {
        this.connection = con;
        telaCadastro = new CadastrarClienteView(null,true);
        adicionaEventos();
        inicializaMascaras();
        this.telaCadastro.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getCancelarBtn())){
            this.telaCadastro.dispose();
        }
        
        if(evento.getSource().equals(this.telaCadastro.getSalvarBtn())){
            PessoaFisica cliente = new PessoaFisica();
            
            cliente.setCpf(this.telaCadastro.getCpfTxt().getText());
            cliente.setEmail(this.telaCadastro.getEmailTxt().getText());
            cliente.setNome(this.telaCadastro.getNomeTxt().getText());
            cliente.setRg(this.telaCadastro.getRgTxt().getText());
            cliente.setTelefone(this.telaCadastro.getTelefoneTxt().getText());
            
            if(this.telaCadastro.getFemininoRadio().isSelected()){
                cliente.setSexo("Feminino");
            }else{
                if(this.telaCadastro.getMasculinoRadio().isSelected()){
                    cliente.setSexo("Masculino");
                }
            }
            
            Endereco endereco = new Endereco();
            
            endereco.setBairro(this.telaCadastro.getBairroTxt().getText());
            endereco.setCep(this.telaCadastro.getCepTxt().getText());
            endereco.setCidade(this.telaCadastro.getCidadeTxt().getText());
            endereco.setEstado(this.telaCadastro.getEstadoComboBox().getSelectedItem().toString());
            endereco.setNumero(this.telaCadastro.getNumeroTxt().getText());
            endereco.setRua(this.telaCadastro.getRuaTxt().getText());
            
            cliente.setEndereco(endereco);
            
            ClienteDAO clienteDAO = new ClienteDAO(this.connection);
            
            if(clienteDAO.inserir(cliente) == true){
                this.telaCadastro.dispose();
            }
        }
    }

    private void adicionaEventos() {
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
    }

    private void inicializaMascaras() {
        try{
            this.mascaraCEP = new MaskFormatter("#####-###");
            this.mascaraCPF = new MaskFormatter("###.###.###-##");
            this.mascaraRG = new MaskFormatter("##.###.###-##");
            this.mascaraTelefone = new MaskFormatter("(##) ####-####");
            
            this.telaCadastro.getRgTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraRG));
            this.telaCadastro.getCpfTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
            this.telaCadastro.getTelefoneTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
            this.telaCadastro.getCepTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraCEP));
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
    
}
