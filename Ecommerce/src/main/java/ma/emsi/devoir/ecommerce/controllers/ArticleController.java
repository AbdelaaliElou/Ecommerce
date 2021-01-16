package ma.emsi.devoir.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}
