package ma.emsi.devoir.ecommerce;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.service.IPanierService;

@SpringBootApplication
public class EcommerceApplication {
	

	public static void main(String[] args) {
	ApplicationContext	applicationContext = SpringApplication.run(EcommerceApplication.class, args);
		
	IPanierService iPanierService= applicationContext.getBean(IPanierService.class);
	Map<ArticleVO, Integer> mapArticle = new HashMap<ArticleVO, Integer>();
	mapArticle.put(ArticleVO.builder().id(1l).build(), 10);
	mapArticle.put(ArticleVO.builder().id(5l).build(), 1);
	
	iPanierService.saveOrUpdate(mapArticle);
	/*
	 * ArticleVO articleVO=
	 * ArticleVO.builder().reference("TestReference4").price(10).designation(
	 * "TestDesignation4").build(); iArticleService.saveOrUpdate(articleVO);
	 * ArrayList<ArticleVO> artList = (ArrayList<ArticleVO>)
	 * iArticleService.findAll(); artList.forEach(art ->
	 * System.err.println("Ref: "+art.getReference()+" Price: "+art.getPrice()
	 * +" Design: "+art.getDesignation()));
	 */
	}

}
