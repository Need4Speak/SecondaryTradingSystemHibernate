package com.servlet;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodDAO;
import com.dao.OrderDAO;
import com.dao.UserDAO;
import com.entity.Good;
import com.entity.Order;
import com.entity.OrderDetial;
import com.entity.User;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String dispatchUrl = null;

		if (request.getSession().getAttribute("userName") == null) {
			dispatchUrl = "/login.jsp";
		} else {
			int goodId = Integer.parseInt(request.getParameter("goodId"));

			GoodDAO goodDAO = new GoodDAO();
			UserDAO userDAO = new UserDAO();
			OrderDAO orderDAO = new OrderDAO();

			Good good = goodDAO.findById(goodId);
			User seller = good.getUser();
			User buyer = userDAO.findByUserName(request.getSession()
					.getAttribute("userName"));
			Order order = new Order(goodId, buyer.getUserId(),
					seller.getUserId(), new Date(), good.getFreight());

			orderDAO.save(order);
			// Add object orderDetial in request, send this object to placeOrder.jsp
			OrderDetial orderDetial = new OrderDetial(order.getOrderId(),
					good.getName(), buyer.getUserName(), seller.getUserName(),
					order.getCreationTime(), order.getFreight());
			request.setAttribute("orderDetial", orderDetial);
			System.out.println(order);
			dispatchUrl = "/placeOrder.jsp";
		}

		request.getRequestDispatcher(dispatchUrl).forward(request, response);

	}

}
