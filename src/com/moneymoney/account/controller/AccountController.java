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
import com.moneymoney.account.service.SavingsAccountService;
import com.moneymoney.account.service.SavingsAccountServiceImpl;
import com.moneymoney.account.util.DBUtil;
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
		SavingsAccountService savingsAccountService=new SavingsAccountServiceImpl();
		
		switch(path){
		case "/addNewSA.mm":
			response.sendRedirect("openNewAccount.html");
			
			
			System.out.println("Add new SA");
			break;
		case "/addNewAccount.mm":
			String accounHolderName=request.getParameter("txtAccHN");
			double accountBalance=Double.parseDouble(request.getParameter("txtBal"));
			boolean salary=request.getParameter("rgSalary").equalsIgnoreCase("yes")?true:false;

			try {
				savingsAccountService.createNewAccount(accounHolderName, accountBalance, salary);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			break;
		case "/closeSA.mm":
			response.sendRedirect("closeAccount.html");
			System.out.println("close SA");
			break;
		case "/closeAccount.mm":
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
		case "/withdrawSA.mm":
			response.sendRedirect("withdraw.html");
			
			break;
		case "/withdrawForm.mm":
			int accountNo=Integer.parseInt(request.getParameter("txtAccNo"));
			double withdrawAmount=Double.parseDouble(request.getParameter("txtAmount"));
			try {
				savingsAccountService.withdraw(savingsAccountService.getAccountById(accountNo), withdrawAmount);
				DBUtil.commit();
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case "/depositSA.mm":
			response.sendRedirect("deposit.html");
			
			break;
		case "/depositForm.mm":
			
			int depositAccountNo=Integer.parseInt(request.getParameter("txtAccNo"));
			double depositAmount=Double.parseDouble(request.getParameter("txtAmount"));
			try {
				savingsAccountService.deposit(savingsAccountService.getAccountById(depositAccountNo), depositAmount);
				DBUtil.commit();
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		
		case "/fundTransfer.mm":
			response.sendRedirect("fundTransfer.html");
			
			break;
		case "/fundTransferForm.mm":
			
			int senderAccountNo=Integer.parseInt(request.getParameter("txtSenderAccNo"));
			int receiverAccountNo=Integer.parseInt(request.getParameter("txtReceiverAccNo"));
			double transferAmount=Double.parseDouble(request.getParameter("txtAmount"));
			try {
				SavingsAccount sender=savingsAccountService.getAccountById(senderAccountNo);
				SavingsAccount receiver=savingsAccountService.getAccountById(receiverAccountNo);
				
				savingsAccountService.fundTransfer(sender, receiver, transferAmount);
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
