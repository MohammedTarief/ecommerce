package com.jsp.ecommerce.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.jsp.ecommerce.dto.MerchantProductForm;
import com.jsp.ecommerce.dto.UserDto;
import com.jsp.ecommerce.entity.Product;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

public interface MerchantService {

	String register(UserDto userDto, Model model);

	String register(UserDto userDto, BindingResult result, HttpSession session);

	String sumbitOtp(int otp, HttpSession session);

	String loadHome(HttpSession session);

	String loadAddProduct(MerchantProductForm productDto, Model model, HttpSession session);

	String addProduct(@Valid MerchantProductForm productDto, BindingResult result, HttpSession session,
			Model model);

	String manageProducts(HttpSession session, Model model);

	String editProduct(Long id, Model model, HttpSession session);

	String updateProduct(Long id, @Valid MerchantProductForm productDto, BindingResult result, Model model,
			HttpSession session);

	String deleteById(Long id, HttpSession session);

    String manageProfile(HttpSession session, Model model);

    String manageProfile(HttpSession session, UserDto dto);


}
