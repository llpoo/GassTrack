package br.com.gt.controller;



import br.com.gt.dao.UsuarioDAO;
import br.com.gt.model.Usuario;
import br.com.gt.view.acesso.login.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class LoginController implements ActionListener{

    private LoginView telaLogin;
    Connection connection;
    Usuario usuario;
    
    public LoginController(Connection con) {
        connection = con;
        usuario = new Usuario();
        telaLogin = new LoginView();
        adicionaEventos();
        this.telaLogin.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaLogin.getUsuarioTxt()) ||
           evento.getSource().equals(this.telaLogin.getSenhaTxt()) ||
           evento.getSource().equals(this.telaLogin.getEntrarBtn())){
            
            this.usuario.setSenha(this.telaLogin.getSenhaTxt().getText());
            this.usuario.setUsuario(this.telaLogin.getUsuarioTxt().getText());
            
            UsuarioDAO uDao = new UsuarioDAO(this.connection);
            this.usuario = uDao.buscar(usuario);
            
            
            
           if(this.usuario.getId() > 0){
               this.telaLogin.dispose();
                if(this.usuario.getIsIsGerente() == true){
                    PrincipalGerenteController principalGerenteController = new PrincipalGerenteController(this.connection);
                }else{
                    PrincipalFuncionarioController principalFuncionarioController = new PrincipalFuncionarioController(this.connection,this.usuario);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorreto(s)");
            }
        }
        
        if(evento.getSource().equals(this.telaLogin.getCancelarBtn())){
            this.telaLogin.dispose();
        }
    }
    
    private void adicionaEventos(){
        this.telaLogin.getUsuarioTxt().addActionListener(this);
        this.telaLogin.getSenhaTxt().addActionListener(this);
        this.telaLogin.getEntrarBtn().addActionListener(this);
        this.telaLogin.getCancelarBtn().addActionListener(this);
    }
}
