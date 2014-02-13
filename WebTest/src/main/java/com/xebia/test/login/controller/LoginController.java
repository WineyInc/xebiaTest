package com.xebia.test.login.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xebia.test.login.command.LoginCommand;
import com.xebia.test.product.service.ProductService;
import com.xebia.test.product.valueObject.ProductDetail;

@Controller
public class LoginController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showFormView(Locale locale, Model model,
			HttpServletRequest request) {

		logger.info("inside showFormView() >>>>");

		LoginCommand loginCommand = new LoginCommand();
		model.addAttribute("loginCommand", loginCommand);
		saveProducts();
		logger.info("leaving showFormView() >>>>");
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processRequest(Locale locale,
			@Valid LoginCommand loginCommand, BindingResult result,
			Model model, HttpServletRequest request,
			HttpServletResponse response ) {
		String nextPage="";
		logger.info("inside processRequest()");
		logger.info("validating form request");

		if(loginCommand.getUserType().equals("admin")){
			if(StringUtils.isBlank(loginCommand.getPassword())){
				result.rejectValue("password", "Password cannot be blank");
			}
		}
		else{
			if(StringUtils.isBlank(loginCommand.getUserName())){
				result.rejectValue("userName", "Username cannot be blank");
			}	
		}
		if (result.hasErrors()) {

			logger.info("validating error found ");
			logger.info("redirecting to Login page........ ");
			return "login";
		}
		HttpSession session=request.getSession(true);
		session.setAttribute("userType", loginCommand.getUserType());

		if(loginCommand.getUserType().equals("user")){
			session.setAttribute("userName",loginCommand.getUserName() );	
		}
		if(loginCommand.getUserType().equals("admin")){
			nextPage="redirect:/products";
		}
		else{
			nextPage="redirect:/pricer";
		}
		return nextPage;
	}

	public void saveProducts(){
		List<ProductDetail> list=productService.getAllProducts();
		if(list==null ){
			for(int i=0;i<10;i++){
				ProductDetail p1= new ProductDetail();
				p1.setProductName("ProductName "+i);
				p1.setAvgPrice(25.20);
				p1.setBarCode("BAR"+i);
				p1.setDescription("this is Product "+i);
				p1.setHighestPrice(30.30);
				p1.setLowestPrice(20.20);
				productService.addProduct(p1);
			}
		}
	}
}
