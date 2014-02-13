/**
 * 
 */
package com.xebia.test.common.tags;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.xebia.test.product.service.ProductService;
import com.xebia.test.product.valueObject.ProductDetail;

/**
 * @author CAPTAIN
 *
 */
public class ProductDropDownTag extends RequestContextAwareTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1055139682675407104L;

	private String className;

	private String name;

	private String value;

	private String selected;

	ProductService productService;


	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the selected
	 */
	public String getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(String selected) {
		this.selected = selected;
	}

	@Override
	protected int doStartTagInternal() throws Exception {
		JspWriter out=pageContext.getOut();
		String htmlTag="";
		htmlTag+="<select class='"+className+"' name='"+name+"'>";
		
		WebApplicationContext applicationContext=getRequestContext().getWebApplicationContext();
		productService =(ProductService)applicationContext.getBean("productServiceImpl");
		htmlTag+="<option value='' ></option>";
		List<ProductDetail> productDetails=productService.getAllProducts();
 		for (Iterator iterator = productDetails.iterator(); iterator.hasNext();) {
			ProductDetail codeTable = (ProductDetail) iterator.next();
			if(String.valueOf(codeTable.getId()).equals(selected))
				htmlTag+="<option value='"+codeTable.getId()+"' selected='"+selected +"' >"+codeTable.getProductName()+"</option>";
			htmlTag+="<option value='"+codeTable.getId()+"' >"+codeTable.getProductName()+"</option>";
		}
		htmlTag+="</select>";
		out.print(htmlTag);
		return SKIP_BODY;
	}

}
