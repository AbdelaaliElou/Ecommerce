package ma.emsi.devoir.ecommerce.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.emsi.devoir.ecommerce.dao.UserRepository;
import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.entity.User;
import ma.emsi.devoir.ecommerce.service.IPanierService;

@Controller
public class PanierController {
	
	@Autowired
	private IPanierService panierService;
//	@Autowired
//	private PanierMapper panierMapper;
//	@Autowired
//	private UserMapper userMapper;
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private PanierArticleRepository PanierArticleRepository;
//	@Autowired
//	private IUserService userService;
//	@Autowired
//	private ArticleMapper articleMapper;
	
	@GetMapping("/panier")
	public String findAll(Model model) {
		model.addAttribute("paniers", model);
		return "panier/list";
	}
	
	@GetMapping("/panier/{id}")
	public String findById(Model model, @PathVariable Long id) {
		model.addAttribute("panier", panierService.findById(id));
		return "panier/details";
	}
	@GetMapping("/panier/del/{id}")
	public String deleteById(Model model, @PathVariable Long id) {
		panierService.delete(id);
		return "redirect:/panier";
	}
	
	
	// GET: Show panier.
	   @RequestMapping(value = { "/panier/edit" }, method = RequestMethod.GET)
	   public String edit(Model model, @RequestParam(value = "id", defaultValue = "") Long id){
		   if (id != null) {
			   //User user = userRepository.findByUserName(auth.getName());
			   ArticleVO articleVO = ArticleVO.builder().id(id).build();
			   
			   //PanierArticleVO panierArticleVO = PanierArticleVO.builder().build();
			   //PanierVO panierVO = PanierVO.builder().build();//id logged user security 
			   //UserVO userVO = UserVO.builder().id().build();
			   //panierVO.setUser(user);
			   //panierArticleVO.setPanier(panierMapper.toEntity(panierVO));
			   //panierArticleVO.setArticle(articleMapper.toEntity(articleVO));
			   //int amount = 1;
			   model.addAttribute("articleVO", articleVO);
			   //model.addAttribute("amount", amount);
//	         if (panierVO != null) {
//	   	      model.addAttribute("panierVO", panierVO);
//	   	      model.addAttribute("articleVO", articleVO);
//	         }
//	      }else {
//	    	  model.addAttribute("panierVO", new PanierVO());
	      }
	      return "panier/add";
	      }
	 
	   // POST: Save panier
	   @RequestMapping(value = { "/panier/edit" }, method = RequestMethod.POST)
	   public String save(Model model, 
			   @ModelAttribute("articleVO") ArticleVO articleVO, 
			   @ModelAttribute("amount") int amount,
			   @AuthenticationPrincipal Authentication auth, 
			   final RedirectAttributes redirectAttributes) {
			   auth = SecurityContextHolder.getContext().getAuthentication();
			   User user = userRepository.findByUserName(auth.getName());
	      try {
	    	  Map<ArticleVO, Integer> articleMap = new HashMap<>();
	    	  articleMap.put(articleVO, amount);
	    	  panierService.saveOrUpdate(articleMap, user.getId());
	      } catch (Exception e) {
	         System.err.println(e.getMessage());
	      }
	      return "redirect:/panier";
	   }
}
