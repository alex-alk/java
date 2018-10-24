package beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Named
@SessionScoped
public class MainBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	JPAEntityFactoryBean entityFactoryBean;
	public List<Article> getAllArticles(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Article> articolQuery = em.createNamedQuery("Article.findAll", Article.class);
		List<Article> articles = articolQuery.getResultList();
		em.close();
		return articles;
	}
}
