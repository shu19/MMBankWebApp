package com.moneymoney.account.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.service.SavingsAccountService;
import com.moneymoney.account.service.SavingsAccountServiceImpl;
import com.moneymoney.account.util.DBUtil;
import com.moneymoney.exception.AccountNotFoundException;

/**
 * Servlet implementation class AccountController
 */
// @WebServlet("/AccountController")
@WebServlet("*.mm")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
	private List<SavingsAccount> accounts;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	public AccountController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		int accountNumber;
		SavingsAccountService savingsAccountService = new SavingsAccountServiceImpl();

		switch (path) {
		case "/addNewSA.mm":

			response.sendRedirect("openNewAccount.jsp");

			break;
		case "/addNewAccount.mm":
			String accounHolderName = request.getParameter("txtAccHN");
			double accountBalance = Double.parseDouble(request
					.getParameter("txtBal"));
			boolean salary = request.getParameter("rgSalary").equalsIgnoreCase(
					"yes") ? true : false;

			try {
				savingsAccountService.createNewAccount(accounHolderName,
						accountBalance, salary);
				response.sendRedirect("viewAllSA.mm");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;

		case "/currentBal.mm":
			response.sendRedirect("CurrentBalance.jsp");
			break;
		case "/currentBalForm.mm":

			break;

		case "/closeSA.mm":
			response.sendRedirect("closeAccount.jsp");
			break;
		case "/closeAccount.mm":
			accountNumber = Integer.parseInt(request
					.getParameter("accountNumber"));
			System.out.println(accountNumber);
			try {
				savingsAccountService.deleteAccount(accountNumber);
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "/withdrawSA.mm":
			response.sendRedirect("withdraw.jsp");

			break;
		case "/withdrawForm.mm":
			accountNumber = Integer.parseInt(request.getParameter("txtAccNo"));
			double withdrawAmount = Double.parseDouble(request
					.getParameter("txtAmount"));
			try {
				savingsAccountService.withdraw(
						savingsAccountService.getAccountById(accountNumber),
						withdrawAmount);
				DBUtil.commit();
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "/depositSA.mm":
			response.sendRedirect("deposit.jsp");

			break;
		case "/depositForm.mm":

			accountNumber = Integer.parseInt(request.getParameter("txtAccNo"));
			double depositAmount = Double.parseDouble(request
					.getParameter("txtAmount"));
			try {
				savingsAccountService.deposit(
						savingsAccountService.getAccountById(accountNumber),
						depositAmount);
				DBUtil.commit();
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "/fundTransfer.mm":
			response.sendRedirect("fundTransfer.jsp");

			break;
		case "/fundTransferForm.mm":

			int senderAccountNo = Integer.parseInt(request
					.getParameter("txtSenderAccNo"));
			int receiverAccountNo = Integer.parseInt(request
					.getParameter("txtReceiverAccNo"));
			double transferAmount = Double.parseDouble(request
					.getParameter("txtAmount"));
			try {
				SavingsAccount sender = savingsAccountService
						.getAccountById(senderAccountNo);
				SavingsAccount receiver = savingsAccountService
						.getAccountById(receiverAccountNo);

				savingsAccountService.fundTransfer(sender, receiver,
						transferAmount);
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "/searchSA.mm":
			response.sendRedirect("searchAccount.jsp");

			break;
		case "/search.mm":
			accountNumber = Integer.parseInt(request
					.getParameter("txtAccountNumber"));
			try {
				SavingsAccount account = savingsAccountService
						.getAccountById(accountNumber);
				request.setAttribute("account", account);
				dispatcher = request.getRequestDispatcher("AccountDetails.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "/viewAllSA.mm":
			try {
				List<SavingsAccount> accounts = savingsAccountService
						.getAllSavingsAccount();
				request.setAttribute("accounts", accounts);
				dispatcher = request.getRequestDispatcher("AccountDetails.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "/updateSA.mm":
		
			response.sendRedirect("UpdateForm.jsp");
			break;
		case "/updateSAForm.mm":
			accountNumber=Integer.parseInt(request.getParameter("accountNumber"));
			try {
				SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
				request.setAttribute("account", account);
				dispatcher = request.getRequestDispatcher("UpdateAccount.jsp");
				dispatcher.forward(request, response);

			} catch (ClassNotFoundException | SQLException | AccountNotFoundException e1) {
				e1.printStackTrace();
			}
			break;

		case "/sortByName.mm":
			try {
				accounts = savingsAccountService
						.getAllSavingsAccount();
				Collections.sort(accounts, new Comparator<SavingsAccount>() {
					@Override
					public int compare(SavingsAccount arg0, SavingsAccount arg1) {
						return arg0
								.getBankAccount()
								.getAccountHolderName()
								.compareTo(
										arg1.getBankAccount()
												.getAccountHolderName());
					}
				});
				request.setAttribute("accounts", accounts);
				dispatcher = request.getRequestDispatcher("AccountDetails.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;

		case "/sortByAccountNumber.mm":
			try {
				List<SavingsAccount> accounts = savingsAccountService
						.getAllSavingsAccount();
				Collections.sort(accounts, new Comparator<SavingsAccount>() {
					@Override
					public int compare(SavingsAccount arg0, SavingsAccount arg1) {
						return arg0.getBankAccount().getAccountNumber()
								- arg1.getBankAccount().getAccountNumber();
					}
				});
				request.setAttribute("accounts", accounts);
				dispatcher = request.getRequestDispatcher("AccountDetails.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;

		case "/sortByBalance.mm":
			try {

				List<SavingsAccount> al = savingsAccountService
						.getAllSavingsAccount();
				Collections.sort(al, new Comparator<SavingsAccount>() {
					@Override
					public int compare(SavingsAccount arg0, SavingsAccount arg1) {
						return (int) (arg0.getBankAccount().getAccountBalance() - arg1
								.getBankAccount().getAccountBalance());
					}
				});
				request.setAttribute("accounts", al);
				dispatcher = request.getRequestDispatcher("AccountDetails.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;
		case "/sortBySalary.mm":
			try {
				Collection<SavingsAccount> accounts = savingsAccountService
						.getAllSavingsAccount();
				Set<SavingsAccount> accountSet = new TreeSet<>(
						new Comparator<SavingsAccount>() {
							@Override
							public int compare(SavingsAccount arg0,
									SavingsAccount arg1) {
								if (arg0.isSalary())
									return -1;
								else
									return +1;
							}
						});
				accountSet.addAll(accounts);
				request.setAttribute("accounts", accountSet);
				dispatcher = request.getRequestDispatcher("AccountDetails.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
