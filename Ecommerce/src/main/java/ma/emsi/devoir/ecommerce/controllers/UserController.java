package ma.emsi.devoir.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ma.emsi.devoir.ecommerce.service.IUserService;

@Controller
public class UserController {
	
	
	@Autowired
	private IUserService iUserService;
}
