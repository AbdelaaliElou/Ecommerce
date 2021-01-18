package ma.emsi.devoir.ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.service.IArticleService;
import ma.emsi.devoir.ecommerce.service.mapper.ArticleMapper;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private IArticleService iArticleService;
	@Autowired
	private ArticleMapper articleMapper;
	
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
	
	// GET: Show product.
	   @RequestMapping(value = { "/admin/article" }, method = RequestMethod.GET)
	   public String product(Model model, @RequestParam(value = "id", defaultValue = "") Long id) {
	      if (id != null) {
	         ArticleVO articleVO = iArticleService.findById(id);
	         if (articleVO != null) {
	   	      model.addAttribute("articleVO", articleVO);
	         }
	      }
	      return "admin/article/add";
	   }
	 
	   // POST: Save product
	   @RequestMapping(value = { "/admin/article" }, method = RequestMethod.POST)
	   public String productSave(Model model, //
	         @ModelAttribute("articleVO") @Validated ArticleVO articleVO, //
	         BindingResult result, //
	         final RedirectAttributes redirectAttributes) {
	      if (result.hasErrors()) {
	         return "admin/article";
	      }
	      try {
	         iArticleService.saveOrUpdate(articleVO);
	      } catch (Exception e) {
	         Throwable rootCause = NestedExceptionUtils.getRootCause(e);
	         String message = rootCause.getMessage();
	         model.addAttribute("errorMessage", message);
	         // Show product form.
	         return "product";
	      }
	      return "redirect:/admin/article";
	   }
}
