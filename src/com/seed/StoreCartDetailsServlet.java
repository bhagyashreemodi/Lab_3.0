package com.seed;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.seed.beans.ShoppingCart;

//TODO:0	Modification required
//@WebServlet("/storeDetails")
public class StoreCartDetailsServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ShoppingCart cartRef = null;
//		TODO:1	Obtain session created for client
//		if session is not created, ask container to create it.
//		TODO:2	Retrieve attribute named as "shoppingCart" in session scope
//		assign it to "cartRef" local variable (you need casting to ShoppingCart) 
//		TODO:3 If "shoppingCart" does not exist, create object of com.seed.beans.ShoppingCart referenced by "cartRef"
//		and assign "shoppingCart" as attribute name for this newly created ShoppingCart
//		TODO:4	Read product ids from request parameter named as "bookID"
//		TODO:5 add these product ids in the ShoppingCart object referenced by "cartRef" local variable
//		TODO:6	if the user clicks "Shop More?" in "bookCatelogue.html", 
//		then redirect web-client to resource named as "categories.html"
//		TODO:7	if the user clicks "Check Out" in "bookCatelogue.html", 
//		then redirect web-client to resource named as "displayDetails"
//		Add mapping for resource "displayDetails" in WEB.XML

		HttpSession session = request.getSession();
		cartRef = (ShoppingCart) session.getAttribute("shoppingCart");
		String productIds[];
		if(cartRef == null){
			cartRef = new ShoppingCart();
			productIds = request.getParameterValues("bookID");
			cartRef.setProductList(productIds);
			session.setAttribute("shoppingCart", cartRef);
			
		}
		else{
			productIds = request.getParameterValues("bookID");
			cartRef.setProductList(productIds);
			session.setAttribute("shoppingCart", cartRef);
		}
		if(request.getParameter("continue") != null){
			response.sendRedirect(request.getContextPath()+"/categories.html");
		}
		else{
			RequestDispatcher dispalyDetails = request.getRequestDispatcher("displayDetails");
			dispalyDetails.forward(request, response);
		}
	}
	
}









