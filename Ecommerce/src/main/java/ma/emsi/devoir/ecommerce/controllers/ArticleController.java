package ma.emsi.devoir.ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.service.IArticleService;

@Controller
public class ArticleController {

	@Autowired
	private IArticleService iArticleService;
//	@Autowired
//	private ArticleMapper articleMapper;
	
	@GetMapping("/article")
	public String findAll(Model model) {
		model.addAttribute("articles", iArticleService.findAll());
		return "article/list";
	}
	//http://localhost:8090/article/1/details
	@GetMapping("/article/{id}")
	public String findById(Model model, @PathVariable Long id) {
		model.addAttribute("article", iArticleService.findById(id));
		return "article/details";
	}
	@GetMapping("/article/del/{id}")
	public String deleteById(Model model, @PathVariable Long id) {
		iArticleService.delete(id);
		return "redirect:/article";
	}
	
	// GET: Show article
	   @RequestMapping(value = { "/article/edit" }, method = RequestMethod.GET)
	   public String edit(Model model, @RequestParam(value = "id", defaultValue = "") Long id) {
		   if (id != null) {
	         ArticleVO articleVO = iArticleService.findById(id);
	         if (articleVO != null) {
	   	      model.addAttribute("articleVO", articleVO);
	         }
	      }else {
	    	  model.addAttribute("articleVO", new ArticleVO());
	      }
	      return "article/add";
	   }
	 
	   // POST: Save article
	   @RequestMapping(value = { "/article/edit" }, method = RequestMethod.POST)
	   public String save(Model model, //
	         @ModelAttribute("articleVO") ArticleVO articleVO, //
	         final RedirectAttributes redirectAttributes) {
	      try {
	         iArticleService.saveOrUpdate(articleVO);
	      } catch (Exception e) {
	         System.err.println(e.getMessage());
	      }
	      return "redirect:/article";
	   }
	   
	   // action admin dashboard
}
