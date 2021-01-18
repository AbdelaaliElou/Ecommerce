package ma.emsi.devoir.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.emsi.devoir.ecommerce.service.IArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private IArticleService iArticleService;
	
	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("articles", iArticleService.findAll());
		return "article/list";
	}
	//http://localhost:8090/article/1/details
	@GetMapping("/{id}")
	public String findById(Model model, @PathVariable Long id) {
		//System.out.println(id);
		model.addAttribute("article", iArticleService.findById(id));
		return "article/details";
	}
//	@GetMapping("/{id}")
//	public String deleteById(Model model, @PathVariable Long id) {
//		model.addAttribute("article", iArticleService.delete(id));
//		return "article/details";
//	}
}
