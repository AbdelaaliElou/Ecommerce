package ma.emsi.devoir.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

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
import ma.emsi.devoir.ecommerce.domaine.PanierVO;
import ma.emsi.devoir.ecommerce.domaine.UserVO;
import ma.emsi.devoir.ecommerce.service.IPanierService;
import ma.emsi.devoir.ecommerce.service.mapper.UserMapper;

@Controller
public class PanierController {
	
	@Autowired
	private IPanierService panierService;
	@Autowired
	private UserMapper userMapper;
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
	   public String edit(Model model, @RequestParam(value = "id", defaultValue = "") Long id) {
		   if (id != null) {
			   ArticleVO articleVO = ArticleVO.builder().id(id).build();
			   List<ArticleVO> listArtVO = (ArrayList<ArticleVO>) model.getAttribute("listArt");
			   PanierVO panierVO = PanierVO.builder().build();//id logged user security 
			   UserVO userVO = UserVO.builder().id(1L).build();
			   panierVO.setUser(userMapper.toEntity(userVO));
			   
	         if (panierVO != null) {
	   	      model.addAttribute("panierVO", panierVO);
	   	      model.addAttribute("articleVO", articleVO);
	         }
	      }else {
	    	  model.addAttribute("panierVO", new PanierVO());
	      }
	      return "panier/add";
	   }
	 
	   // POST: Save panier
	   @RequestMapping(value = { "/panier/edit" }, method = RequestMethod.POST)
	   public String save(Model model, //
	         @ModelAttribute("panierVO") PanierVO panierVO, //
	         final RedirectAttributes redirectAttributes) {
	      try {
	    	  panierService.saveOrUpdate(panierVO);
	      } catch (Exception e) {
	         System.err.println(e.getMessage());
	      }
	      return "redirect:/panier";
	   }
}
