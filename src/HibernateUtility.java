

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.gt.model.Aquisicao;
import br.com.gt.model.Cliente;
import br.com.gt.model.Endereco;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Material;
import br.com.gt.model.Pessoa;
import br.com.gt.model.PessoaFisica;
import br.com.gt.model.Usuario;
import br.com.gt.model.Venda;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author lucas
 */
public class HibernateUtility {

    private static SessionFactory sessionFactory;
    
    static {
        try {
            Configuration configuration = new Configuration();
		
                
                // Mapeamento das classes
                configuration.addAnnotatedClass(Aquisicao.class);
                configuration.addAnnotatedClass(Cliente.class);
                configuration.addAnnotatedClass(Endereco.class);
                configuration.addAnnotatedClass(Fornecedor.class);
                configuration.addAnnotatedClass(Funcionario.class);
                configuration.addAnnotatedClass(Material.class);
                configuration.addAnnotatedClass(Pessoa.class);
                configuration.addAnnotatedClass(PessoaFisica.class);
		configuration.addAnnotatedClass(Usuario.class);
                configuration.addAnnotatedClass(Pessoa.class);
                configuration.addAnnotatedClass(Venda.class);
		
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}
}
