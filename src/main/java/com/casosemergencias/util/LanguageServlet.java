package com.casosemergencias.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		// Recuperar la url para modificarla
		StringBuffer url = request.getRequestURL();
		int index = url.indexOf("changLang.do");
		url = url.delete(index, url.length());

		// no me cambia la url pero si cambia el idioma
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
	}
}