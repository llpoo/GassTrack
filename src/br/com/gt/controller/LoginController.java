package br.com.gt.controller;



import br.com.gt.view.acesso.login.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class LoginController implements ActionListener{

    private LoginView telaLogin;
    Connection connection;
    
    public LoginController(Connection con) {
        connection = con;
        telaLogin = new LoginView();
        adicionaEventos();
        this.telaLogin.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(botaoEntrarOuTeclaEnter(evento)){
            verificaUsuario(this.telaLogin.getUsuarioTxt().getText(),this.telaLogin.getSenhaTxt().getText());
        }
        
        if(botaoCancelar(evento)){
            this.telaLogin.dispose();
        }
    }
    
    private void adicionaEventos(){
        this.telaLogin.getUsuarioTxt().addActionListener(this);
        this.telaLogin.getSenhaTxt().addActionListener(this);
        this.telaLogin.getEntrarBtn().addActionListener(this);
        this.telaLogin.getCancelarBtn().addActionListener(this);
    }
    
    private void verificaUsuario(String usuario, String senha){
        if(usuario.equals("func") && senha.equals("func")){
                this.telaLogin.dispose();
                PrincipalFuncionarioController controleVendas = new PrincipalFuncionarioController();
            }else{
                if(usuario.equals("admin") && senha.equals("admin")){
                    this.telaLogin.dispose();
                    PrincipalGerenteController controleGerencia = new PrincipalGerenteController(this.connection);
                }else{
                    this.telaLogin.getMensagemErroLb().setVisible(true);
                }
            }
    }
    
    private boolean botaoEntrarOuTeclaEnter(ActionEvent evento){
        if(evento.getSource().equals(this.telaLogin.getUsuarioTxt()) ||
           evento.getSource().equals(this.telaLogin.getSenhaTxt()) ||
           evento.getSource().equals(this.telaLogin.getEntrarBtn())){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean botaoCancelar(ActionEvent evento){
        if(evento.getSource().equals(this.telaLogin.getCancelarBtn())){
            return true;
        }else{
            return false;
        }
    }
}
