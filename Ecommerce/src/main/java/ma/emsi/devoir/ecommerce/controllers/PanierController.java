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

import ma.emsi.devoir.ecommerce.domaine.PanierVO;
import ma.emsi.devoir.ecommerce.service.IPanierService;

@Controller
public class PanierController {
	
	@Autowired
	private IPanierService panierService;
	
	
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
	   public String product(Model model, @RequestParam(value = "id", defaultValue = "") Long id) {
		   if (id != null) {
	         PanierVO panierVO = panierService.findById(id);
	         if (panierVO != null) {
	   	      model.addAttribute("panierVO", panierVO);
	         }
	      }else {
	    	  model.addAttribute("panierVO", new PanierVO());
	      }
	      return "panier/add";
	   }
	 
	   // POST: Save panier
	   @RequestMapping(value = { "/panier/edit" }, method = RequestMethod.POST)
	   public String productSave(Model model, //
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
