package com.xebia.test.user.pricer.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xebia.test.product.service.ProductService;
import com.xebia.test.product.valueObject.ProductDetail;
import com.xebia.test.user.pricer.command.PricerCommand;

@Controller
public class PricerController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(PricerController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/pricer", method = RequestMethod.GET)
	public String showFormView(Locale locale, Model model,
			HttpServletRequest request) {

		logger.info("inside showFormView() >>>>");
		
		PricerCommand pricerCommand = new PricerCommand();
		model.addAttribute("pricerCommand", pricerCommand);

		List<ProductDetail> details=productService.getAllProducts();

		model.addAttribute("productList", details);
		logger.info("leaving showFormView() >>>>");
		return "pricer";
	}
	
	@RequestMapping(value = "/pricer", method = RequestMethod.POST)
	public String processRequest(Locale locale,
			@Valid PricerCommand pricerCommand, BindingResult result,
			Model model, HttpServletRequest request,
			HttpServletResponse response ) {

		logger.info("inside processRequest()");
		logger.info("validating form request");
		
		if (result.hasErrors()) {
			logger.info("validating error found ");
			logger.info("redirecting to Login page........ ");
			return "pricer";
		}
		List<Double> doubles= productService.getPricesOfProduct(Long.parseLong(pricerCommand.getProductName()));
		if(doubles!=null)
		pricerCommand.setIdealPrice(computeIdealPrice(doubles).toString());
		return "pricer";
	}
	public Double computeIdealPrice(List<Double> priceReadings) {
		List<Double> subList = null;
		int size = priceReadings.size();
		if (size > 4) {
			subList = priceReadings.subList(2, size - 2);
		} else {
			subList = priceReadings;
		}
		Double result = 0d;
		for (Double price : subList) {
			result += price;
		}
		if(subList.size()>0)
			result /= subList.size();
		result *= 1.2;
		return result;
	}
}
