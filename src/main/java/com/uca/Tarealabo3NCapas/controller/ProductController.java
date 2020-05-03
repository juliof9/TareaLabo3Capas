package com.uca.Tarealabo3NCapas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.Tarealabo3NCapas.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "Call of Duty","50"));
		productos.add(new Product(1, "God of War","75"));
		productos.add(new Product(2, "Fortnite","150"));
		productos.add(new Product(3, "FIFA20","200"));
		productos.add(new Product(4, "The last of us 1","99"));
		productos.add(new Product(5, "The last of us 2","5"));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		
		return mav;
		
	}
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		if(Integer.parseInt(product.getCantidad()) <= Integer.parseInt(productos.get(product.getId()).getCantidad())){
			mav.setViewName("compra");
			mav.addObject("anyproducts", productos.get(product.getId()).getNombre());
			return mav;
		}
		else {
			mav.setViewName("error");
			mav.addObject("anyproducts", productos.get(product.getId()).getNombre());
			return mav;
		}
	}

}
