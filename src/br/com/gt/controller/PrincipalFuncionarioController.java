/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.view.principal.PrincipalFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lucas
 */
public class PrincipalFuncionarioController implements ActionListener{

    private PrincipalFuncionarioView telaPrincipal;
    
    public PrincipalFuncionarioController() {
        telaPrincipal = new PrincipalFuncionarioView();
        adicionaEventos();
        telaPrincipal.setVisible(true);
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getSairBtn())){
            this.telaPrincipal.dispose();
        }
    }
    
}
