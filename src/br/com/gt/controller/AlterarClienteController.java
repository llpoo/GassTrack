/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.ClienteDAO;
import br.com.gt.dao.EnderecoDAO;
import br.com.gt.model.Endereco;
import br.com.gt.model.PessoaFisica;
import br.com.gt.view.cliente.AlterarClienteView;
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
public class AlterarClienteController implements ActionListener{
    
    Connection connection;
    AlterarClienteView telaAlterar;
    PessoaFisica cliente;
    Endereco endereco;
    MaskFormatter mascaraRG;
    MaskFormatter mascaraCPF;
    MaskFormatter mascaraTelefone;
    MaskFormatter mascaraCEP;
    public AlterarClienteController(Connection connection, PessoaFisica c) {
        this.connection = connection;
        this.cliente = new PessoaFisica();
        this.endereco = new Endereco();
        this.telaAlterar = new AlterarClienteView(null,true);
        adicionaEventos();
        inicializaMascaras();
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
            
            Endereco auxEndereco = new Endereco();
            auxEndereco = this.cliente.getEndereco();
            
            this.endereco.setBairro(this.telaAlterar.getBairroTxt().getText());
            this.endereco.setCep(this.telaAlterar.getCepTxt().getText());
            this.endereco.setCidade(this.telaAlterar.getCidadeTxt().getText());
            this.endereco.setEstado(this.telaAlterar.getEstadoComboBox().getSelectedItem().toString());
            this.endereco.setNumero(this.telaAlterar.getNumeroTxt().getText());
            this.endereco.setRua(this.telaAlterar.getRuaTxt().getText());
            
            this.cliente.setEndereco(this.endereco);
            
            ClienteDAO clienteDao = new ClienteDAO(this.connection);
            
            if(clienteDao.alterar(this.cliente) == true){
                EnderecoDAO eDao = new EnderecoDAO(this.connection);
                if(eDao.existeEmCliente(endereco) == false){
                    eDao.excluir(endereco);
                }
                this.telaAlterar.dispose();
            }
        }
    }

    private void adicionaEventos() {
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    private void preencheCampos(PessoaFisica c) {
        String aux = "";
        this.telaAlterar.getNomeTxt().setText(c.getNome());
        aux = (String) c.getRg().subSequence(0, 2) + (String) c.getRg().subSequence(3, 6)+
              (String) c.getRg().subSequence(7, 10) + (String) c.getRg().subSequence(11, 13);
        this.telaAlterar.getRgTxt().setText(aux);
        
        aux = "";
        aux = (String) c.getCpf().subSequence(0, 3) + (String) c.getCpf().subSequence(4, 7) +
              (String) c.getCpf().subSequence(8, 11) + (String) c.getCpf().subSequence(12, 14);
        this.telaAlterar.getCpfTxt().setText(aux);
        this.telaAlterar.getEmailTxt().setText(c.getEmail());
        aux = "";
        aux = (String) c.getTelefone().subSequence(1, 3) + (String) c.getTelefone().subSequence(4, 9) +
              (String) c.getTelefone().subSequence(10, 14);
        this.telaAlterar.getTelefoneTxt().setText(aux);
        if(c.getSexo().equalsIgnoreCase("masculino")){
            this.telaAlterar.getMasculinoRadio().setSelected(true);
        }else{
            if(c.getSexo().equalsIgnoreCase("feminino")){
                this.telaAlterar.getFemininoRadio().setSelected(true);
            }
        }
        this.telaAlterar.getEstadoComboBox().setSelectedItem(c.getEndereco().getEstado());
        aux = "";
        aux = (String) c.getEndereco().getCep().subSequence(0, 5) + (String) c.getEndereco().getCep().subSequence(6, 9);
        this.telaAlterar.getCepTxt().setText(aux);
        this.telaAlterar.getCidadeTxt().setText(c.getEndereco().getCidade());
        this.telaAlterar.getBairroTxt().setText(c.getEndereco().getBairro());
        this.telaAlterar.getRuaTxt().setText(c.getEndereco().getRua());
        this.telaAlterar.getNumeroTxt().setText(c.getEndereco().getNumero());
    }

    private void inicializaMascaras() {
        try{
            this.mascaraCEP = new MaskFormatter("#####-###");
            this.mascaraCPF = new MaskFormatter("###.###.###-##");
            this.mascaraRG = new MaskFormatter("##.###.###-##");
            this.mascaraTelefone = new MaskFormatter("(##) ####-####");
            
            this.telaAlterar.getRgTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraRG));
            this.telaAlterar.getCpfTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
            this.telaAlterar.getTelefoneTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
            this.telaAlterar.getCepTxt().setFormatterFactory(new DefaultFormatterFactory(mascaraCEP));
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
    
}
