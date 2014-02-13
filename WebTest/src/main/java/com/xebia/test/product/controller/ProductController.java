package com.xebia.test.product.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xebia.test.login.command.LoginCommand;
import com.xebia.test.product.command.ProductCommand;
import com.xebia.test.product.service.ProductService;
import com.xebia.test.product.valueObject.ProductDetail;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String showformView(Locale locale, Model model,HttpServletRequest request){

		ProductCommand productCommand = new ProductCommand();
		model.addAttribute(productCommand);
		List<ProductDetail> details=productService.getAllProducts();

		model.addAttribute("productList", details);
		return "products";
	}
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String processRequest(Locale locale,
			@Valid ProductCommand productCommand, BindingResult result,
			Model model, HttpServletRequest request,
			HttpServletResponse response ) {

		String nextPage="";
		if (result.hasErrors()) {
			return "products";
		}
		productService.addProduct(convertCommandToVO(productCommand));
		
		nextPage="redirect:/products";
		return nextPage;
	}

	private ProductDetail convertCommandToVO(ProductCommand command){
		ProductDetail detail = new ProductDetail();
		detail.setAvgPrice(Double.parseDouble(command.getAvgPrice()));
		detail.setLowestPrice(Double.parseDouble(command.getLowestPrice()));
		detail.setHighestPrice(Double.parseDouble(command.getHighestPrice()));
		detail.setProductName(command.getProductName());
		detail.setDescription(command.getDescription());
		return detail;
		
	}

}
