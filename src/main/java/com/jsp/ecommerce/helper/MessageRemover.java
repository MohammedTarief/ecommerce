package com.jsp.ecommerce.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class MessageRemover {

	/** Clears one-shot session flash keys; returns empty string for safe use in Thymeleaf th:text. */
	public String remove() {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = attributes.getRequest();
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "";
		}
		session.removeAttribute("pass");
		session.removeAttribute("fail");
		return "";
	}
}
