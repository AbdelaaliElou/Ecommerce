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

import ma.emsi.devoir.ecommerce.domaine.RoleVO;
import ma.emsi.devoir.ecommerce.service.IRoleService;

@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	
	@GetMapping("/role")
	public String findAll(Model model) {
		model.addAttribute("roles", model);
		return "role/list";
	}
	
	@GetMapping("/role/{id}")
	public String findById(Model model, @PathVariable Long id) {
		model.addAttribute("role", roleService.findById(id));
		return "role/details";
	}
	@GetMapping("/role/del/{id}")
	public String deleteById(Model model, @PathVariable Long id) {
		roleService.delete(id);
		return "redirect:/role";
	}
	
	
	// GET: Show role.
	   @RequestMapping(value = { "/role/edit" }, method = RequestMethod.GET)
	   public String product(Model model, @RequestParam(value = "id", defaultValue = "") Long id) {
		   if (id != null) {
	         RoleVO roleVO = roleService.findById(id);
	         if (roleVO != null) {
	   	      model.addAttribute("roleVO", roleVO);
	         }
	      }else {
	    	  model.addAttribute("roleVO", new RoleVO());
	      }
	      return "role/add";
	   }
	 
	   // POST: Save role
	   @RequestMapping(value = { "/role/edit" }, method = RequestMethod.POST)
	   public String productSave(Model model, //
	         @ModelAttribute("roleVO") RoleVO roleVO, //
	         final RedirectAttributes redirectAttributes) {
	      try {
	    	  roleService.saveOrUpdate(roleVO);
	      } catch (Exception e) {
	         System.err.println(e.getMessage());
	      }
	      return "redirect:/role";
	   }
}
