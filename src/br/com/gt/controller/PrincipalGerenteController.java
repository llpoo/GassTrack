package br.com.gt.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gt.view.principal.PrincipalGerenteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class PrincipalGerenteController implements ActionListener{

    private PrincipalGerenteView telaPrincipal;
    
    public PrincipalGerenteController() {
        telaPrincipal = new PrincipalGerenteView();
        adicionaEventos();
        telaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getSairBtn())){
            this.telaPrincipal.dispose();
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getVendas_filtrarPorVendedorBtn())){
            if(this.telaPrincipal.getVendas_vendedorTxt().getText().isEmpty() == false){
                JOptionPane.showMessageDialog(null, "Inserir metodo de busca aqui");
            }else{
                JOptionPane.showMessageDialog(null, "Por favor preencha o campo de busca");
            }
        }
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
        this.telaPrincipal.getAcessorio_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getAlterarClienteBtn().addActionListener(this);
        this.telaPrincipal.getAlterarFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getAlterarVendedorBtn().addActionListener(this);
        this.telaPrincipal.getClientes_clienteBuscaBtn().addActionListener(this);
        this.telaPrincipal.getClientes_clienteTxt().addActionListener(this);
        this.telaPrincipal.getExcluirClienteBtn().addActionListener(this);
        this.telaPrincipal.getExcluirFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getExcluirVendedorBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorBuscaBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorTxt().addActionListener(this);
        this.telaPrincipal.getMaterialBuscaBtn().addActionListener(this);
        this.telaPrincipal.getMaterialTxt().addActionListener(this);
        this.telaPrincipal.getMaterial_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getNovoCleinteBtn().addActionListener(this);
        this.telaPrincipal.getNovoFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getNovoVendedorBtn().addActionListener(this);
        this.telaPrincipal.getVendas_clienteBuscaBtn().addActionListener(this);
        this.telaPrincipal.getVendas_clienteTxt().addActionListener(this);
        this.telaPrincipal.getFiltrarVendasBtn().addActionListener(this);
        this.telaPrincipal.getVendas_vendedorTxt().addActionListener(this);
        this.telaPrincipal.getVendedores_vendedorBuscaBtn().addActionListener(this);
        this.telaPrincipal.getVendedores_vendedorTxt().addActionListener(this);
        this.telaPrincipal.getDataChooser().addActionListener(this);
        this.telaPrincipal.getVendas_filtrarPorVendedorBtn().addActionListener(this);
        this.telaPrincipal.getVendas_filtrarPorClienteBtn().addActionListener(this);
        this.telaPrincipal.getVendas_FiltrarPorDataBtn().addActionListener(this);
    }
}