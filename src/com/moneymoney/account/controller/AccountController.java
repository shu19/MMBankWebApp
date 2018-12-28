package com.moneymoney.account.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.dao.SavingsAccountDAO;
import com.moneymoney.account.dao.SavingsAccountDAOImpl;
import com.moneymoney.exception.AccountNotFoundException;

/**
 * Servlet implementation class AccountController
 */
//@WebServlet("/AccountController")
@WebServlet("*.mm")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
    public AccountController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		
		switch(path){
		case "/addNewSA.mm":
			response.sendRedirect("openNewAccount.html");
			
			
			System.out.println("Add new SA");
			break;
		case "/addNewAccount.mm":
			String accounHolderName=request.getParameter("txtAccHN");
			double accountBalance=Double.parseDouble(request.getParameter("txtBal"));
			
			boolean salary=true;
			SavingsAccountDAO savingsAccountDAO=new SavingsAccountDAOImpl();
			SavingsAccount s=new SavingsAccount(accounHolderName, accountBalance, salary);
			try {
				savingsAccountDAO.createNewAccount(s);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "/closeSA.mm":
			response.sendRedirect("closeAccount.html");
			System.out.println("close SA");
			break;
		case "/closeAccount":
			SavingsAccountDAO savingsAccountDAO1=new SavingsAccountDAOImpl();
			int accountNumber=Integer.parseInt(request.getParameter("accountNumber"));
			System.out.println(accountNumber);
			try {
				savingsAccountDAO1.deleteAccount(accountNumber);
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
