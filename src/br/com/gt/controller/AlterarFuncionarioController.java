/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Endereco;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
import br.com.gt.view.funcionario.AlterarFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class AlterarFuncionarioController implements ActionListener{

    Connection connection;
    AlterarFuncionarioView telaAlterar;
    Funcionario funcionario;
    ArrayList<Funcionario> funcionarios;
    int index;
    
    public AlterarFuncionarioController(Connection con, Funcionario f, ArrayList<Funcionario> backUpFuncionarios, int i){
        this.connection = con;
        this.funcionario = f;
        this.funcionarios = backUpFuncionarios;
        index = i;
        this.telaAlterar = new AlterarFuncionarioView(null, true);
        adicionaEventos();
        preencheCampos();
        this.telaAlterar.setVisible(true);
    }
    
    private void adicionaEventos(){
        this.telaAlterar.getProximoBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getCancelarBtn())){
            this.telaAlterar.dispose();
        }
        
        if(evento.getSource().equals(this.telaAlterar.getProximoBtn())){
            Funcionario fun = new Funcionario();
            
            fun.setId(this.funcionario.getId());
            fun.setNome(this.telaAlterar.getNomeTxt().getText());
            fun.setRg(this.telaAlterar.getRgTxt().getText());
            fun.setCpf(this.telaAlterar.getCpfTxt().getText());
            fun.setEmail(this.telaAlterar.getEmailTxt().getText());
            fun.setTelefone(this.telaAlterar.getTelefoneTxt().getText());
            
            if(this.telaAlterar.getRadioMasculino().isSelected()){
                fun.setSexo("Masculino");
            }else{
                if(this.telaAlterar.getRadioFeminino().isSelected()){
                    fun.setSexo("Feminino");
                }
            }
            
            fun.setDataAdmissao(this.telaAlterar.getDataAdmissaoCalendar().getDate());
            
            Endereco end = new Endereco();
            
            end.setEstado(this.telaAlterar.getEstadoComboBox().getSelectedItem().toString());
            end.setBairro(this.telaAlterar.getBairroTxt().getText());
            end.setCep(this.telaAlterar.getCepTxt().getText());
            end.setCidade(this.telaAlterar.getCidadeTxt().getText());
            end.setRua(this.telaAlterar.getRuaTxt().getText());
            end.setNumero(this.telaAlterar.getNumeroTxt().getText());
            end.setId(this.funcionario.getEndereco().getId());
            
            fun.setEndereco(end);
            
            Usuario usu = new Usuario();
            
            usu.setUsuario(this.funcionario.getUsuario().getUsuario());
            usu.setSenha(this.funcionario.getUsuario().getSenha());
            usu.setIsGerente(this.funcionario.getUsuario().getIsIsGerente());
            usu.setId(this.funcionario.getUsuario().getId());
            
            fun.setUsuario(usu);
            
            this.telaAlterar.setVisible(false);
            AlterarUsuarioController alterarUsuarioController = new AlterarUsuarioController(this.connection,fun,this.funcionarios,index);
            this.telaAlterar.dispose();
        }
    }

    private void preencheCampos() {
        this.telaAlterar.getNomeTxt().setText(this.funcionario.getNome());
        this.telaAlterar.getRgTxt().setText(this.funcionario.getRg());
        this.telaAlterar.getCpfTxt().setText(this.funcionario.getCpf());
        this.telaAlterar.getEmailTxt().setText(this.funcionario.getEmail());
        this.telaAlterar.getTelefoneTxt().setText(this.funcionario.getTelefone());
        if(this.funcionario.getSexo().equalsIgnoreCase("masculino")){
            this.telaAlterar.getRadioMasculino().setSelected(true);
        }else{
            if(this.funcionario.getSexo().equalsIgnoreCase("feminino")){
                this.telaAlterar.getRadioFeminino().setSelected(true);
            }
        }
        this.telaAlterar.getDataAdmissaoCalendar().setDate(this.funcionario.getDataAdmissao());
        this.telaAlterar.getEstadoComboBox().setSelectedItem(this.funcionario.getEndereco().getEstado());
        this.telaAlterar.getCepTxt().setText(this.funcionario.getEndereco().getCep());
        this.telaAlterar.getCidadeTxt().setText(this.funcionario.getEndereco().getCidade());
        this.telaAlterar.getBairroTxt().setText(this.funcionario.getEndereco().getBairro());
        this.telaAlterar.getRuaTxt().setText(this.funcionario.getEndereco().getRua());
        this.telaAlterar.getNumeroTxt().setText(this.funcionario.getEndereco().getNumero());
    }
    
}
