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

import ma.emsi.devoir.ecommerce.domaine.UserVO;
import ma.emsi.devoir.ecommerce.service.IUserService;

@Controller
public class UserController {
	//yawinpassword
	//$2a$04$MzVXtd4o0y4DOlyHMMLMDeE4/eezrsT5Xad.2lmGr/NkCpwBgvn3e
	@Autowired
	private IUserService userService;
	
//	@Autowired
//	private UserMapper userMapper;
	
	@GetMapping("/user")
	public String findAll(Model model) {
		model.addAttribute("users", model);
		return "user/list";
	}
	
	@GetMapping("/user/{id}")
	public String findById(Model model, @PathVariable Long id) {
		model.addAttribute("user", userService.findById(id));
		return "user/details";
	}
	@GetMapping("/user/del/{id}")
	public String deleteById(Model model, @PathVariable Long id) {
		userService.delete(id);
		return "redirect:/user";
	}
	
	
	// GET: Show user.
	   @RequestMapping(value = { "/user/edit" }, method = RequestMethod.GET)
	   public String product(Model model, @RequestParam(value = "id", defaultValue = "") Long id) {
		   if (id != null) {
	         UserVO userVO = userService.findById(id);
	         if (userVO != null) {
	   	      model.addAttribute("userVO", userVO);
	         }
	      }else {
	    	  model.addAttribute("userVO", new UserVO());
	      }
	      return "user/add";
	   }
	 
	   // POST: Save user
	   @RequestMapping(value = { "/user/edit" }, method = RequestMethod.POST)
	   public String productSave(Model model, //
	         @ModelAttribute("userVO") UserVO userVO, //
	         final RedirectAttributes redirectAttributes) {
	      try {
	    	  userService.saveOrUpdate(userVO);
	      } catch (Exception e) {
	         System.err.println(e.getMessage());
	      }
	      return "redirect:/user";
	   }
}