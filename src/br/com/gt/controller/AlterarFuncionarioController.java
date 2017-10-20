/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.EnderecoDAO;
import br.com.gt.model.Endereco;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
import br.com.gt.view.funcionario.AlterarFuncionarioView;
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
 * @author lucas
 */
public class AlterarFuncionarioController implements ActionListener{

    Connection connection;
    AlterarFuncionarioView telaAlterar;
    Funcionario funcionario;
    MaskFormatter mascaraRG;
    MaskFormatter mascaraCPF;
    MaskFormatter mascaraTelefone;
    MaskFormatter mascaraCEP;
    public AlterarFuncionarioController(Connection con, Funcionario f){
        this.connection = con;
        this.funcionario = f;
        this.telaAlterar = new AlterarFuncionarioView(null, true);
        adicionaEventos();
        inicializaMascaras();
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
            
            Endereco auxEndereco = new Endereco();
            auxEndereco = this.funcionario.getEndereco();
            
            
            fun.setEndereco(end);
            
            Usuario usu = new Usuario();
            
            usu.setUsuario(this.funcionario.getUsuario().getUsuario());
            usu.setSenha(this.funcionario.getUsuario().getSenha());
            usu.setIsGerente(this.funcionario.getUsuario().getIsIsGerente());
            usu.setId(this.funcionario.getUsuario().getId());
            
            fun.setUsuario(usu);
            
            this.telaAlterar.setVisible(false);
            AlterarUsuarioController alterarUsuarioController = new AlterarUsuarioController(this.connection,fun,this.telaAlterar);
            
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            if(eDao.existeEmFuncionario(auxEndereco)==false){
                eDao.excluir(auxEndereco);
            }
            
            this.telaAlterar.dispose();
        }
    }

    private void preencheCampos() {
        String aux = "";
        this.telaAlterar.getNomeTxt().setText(this.funcionario.getNome());
        aux = (String) this.funcionario.getRg().subSequence(0, 2) + (String) this.funcionario.getRg().subSequence(3, 6)+
              (String) this.funcionario.getRg().subSequence(7, 10) + (String) this.funcionario.getRg().subSequence(11, 13);
        this.telaAlterar.getRgTxt().setText(aux);
        
        aux = "";
        aux = (String) this.funcionario.getCpf().subSequence(0, 3) + (String) this.funcionario.getCpf().subSequence(4, 7) +
              (String) this.funcionario.getCpf().subSequence(8, 11) + (String) this.funcionario.getCpf().subSequence(12, 14);
        this.telaAlterar.getCpfTxt().setText(aux);
        this.telaAlterar.getEmailTxt().setText(this.funcionario.getEmail());
        aux = "";
        aux = (String) this.funcionario.getTelefone().subSequence(1, 3) + (String) this.funcionario.getTelefone().subSequence(4, 9) +
              (String) this.funcionario.getTelefone().subSequence(10, 14);
        this.telaAlterar.getTelefoneTxt().setText(aux);
        if(this.funcionario.getSexo().equalsIgnoreCase("masculino")){
            this.telaAlterar.getRadioMasculino().setSelected(true);
        }else{
            if(this.funcionario.getSexo().equalsIgnoreCase("feminino")){
                this.telaAlterar.getRadioFeminino().setSelected(true);
            }
        }
        this.telaAlterar.getDataAdmissaoCalendar().setDate(this.funcionario.getDataAdmissao());
        this.telaAlterar.getEstadoComboBox().setSelectedItem(this.funcionario.getEndereco().getEstado());
        aux = "";
        aux = (String) this.funcionario.getEndereco().getCep().subSequence(0, 5) + (String) this.funcionario.getEndereco().getCep().subSequence(6, 9);
        this.telaAlterar.getCepTxt().setText(aux);
        this.telaAlterar.getCidadeTxt().setText(this.funcionario.getEndereco().getCidade());
        this.telaAlterar.getBairroTxt().setText(this.funcionario.getEndereco().getBairro());
        this.telaAlterar.getRuaTxt().setText(this.funcionario.getEndereco().getRua());
        this.telaAlterar.getNumeroTxt().setText(this.funcionario.getEndereco().getNumero());
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
