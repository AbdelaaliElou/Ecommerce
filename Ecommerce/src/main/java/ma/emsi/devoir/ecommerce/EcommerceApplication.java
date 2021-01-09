package ma.emsi.devoir.ecommerce;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.service.IArticleService;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
	ApplicationContext	applicationContext = SpringApplication.run(EcommerceApplication.class, args);
		
	IArticleService iArticleService= applicationContext.getBean(IArticleService.class);	
	ArticleVO articleVO= ArticleVO.builder().reference("TestReference7").price(10).designation("TestDesignation7").build();
	iArticleService.saveOrUpdate(articleVO);
	ArrayList<ArticleVO> artList = (ArrayList<ArticleVO>) iArticleService.findAll();
	artList.forEach(art -> System.err.println("Ref: "+art.getReference()+" Price: "+art.getPrice()+" Design: "+art.getDesignation()));
	}

}
