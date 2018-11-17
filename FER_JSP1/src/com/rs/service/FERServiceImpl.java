package com.rs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rs.bean.Address;
import com.rs.bean.Expense;
import com.rs.bean.PersonalInfo;
import com.rs.bean.User;
import com.rs.util.DBUtil;

public class FERServiceImpl implements FERService {

	private static final Logger logger = Logger.getLogger(FERServiceImpl.class);
	
	// private Statement statement;
	// private Connection connection;
	@Override
	public boolean registration(User user) {
		
		/*logger.info("registartion Start:: user: "+user);
		logger.debug("password: "+user.getPassword());*/
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isRegister = false;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement(
					"insert into user(firstName,middleName,lastName,email,userName,password,mobileNumber) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.geteMail());
			preparedStatement.setString(5, user.getUserName());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getMobileNumber());

			isRegister = preparedStatement.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			/*logger.error("Exception: "+e.getMessage());*/
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		/*logger.info("registartion End:: isRegister: "+isRegister);*/
		
		return isRegister;

	}

	@Override
	public boolean addExpense(Expense expense) {
		//int isadded=0;
		boolean isExpenseFlag=true;
		logger.info("addExpense Start:: expense: "+isExpenseFlag);
		//logger.debug("price: "+expense.getPrice());
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement(
					"insert into expense(expenseType,from_date,price,numberOfItems,totalAccount,byWhom,userid) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, expense.getExpenseType());
			preparedStatement.setString(2, expense.getFrom_date());
			preparedStatement.setFloat(3, expense.getPrice());
			preparedStatement.setFloat(4, expense.getNumberOfItems());
			preparedStatement.setFloat(5, expense.getTotalAccount());
			preparedStatement.setString(6, expense.getByWhom());
			preparedStatement.setInt(7, expense.getUserid());

			 int isregistered = preparedStatement.executeUpdate();
			if (isregistered > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("addExpense End:: isExpenseFlag: "+isExpenseFlag);
		return isExpenseFlag;
	}

	@Override
	public boolean editExpense(Expense expense) {

		boolean isExpenseFlag=true;
		logger.info("editExpense Start:: expense: "+isExpenseFlag);
		//logger.debug("price: "+expense.getPrice());
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement("update expense set byWhom=? ,expenseType=? where id=?");

			preparedStatement.setString(1, expense.getByWhom());
			preparedStatement.setString(2, expense.getExpenseType());
			preparedStatement.setInt(3, expense.getId());

			int isregistered = preparedStatement.executeUpdate();
			System.out.println(isregistered);
			if (isregistered > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("editExpense End:: isExpenseFlag: "+isExpenseFlag);
		return isExpenseFlag;
	}

	@Override
	public boolean deleteExpense(Expense expense) {
		
		boolean isExpenseFlag=true;
		logger.info("deleteExpense Start:: expense: "+isExpenseFlag);
		//logger.debug("price: "+expense.getPrice());
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement("delete from expense where id=?");
			preparedStatement.setInt(1, expense.getId());

			int isregistered = preparedStatement.executeUpdate();
			System.out.println(isregistered);
			if (isregistered > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("deleteExpense End:: isExpenseFlag: "+isExpenseFlag);
		return false;
	}

	@Override
	public boolean login(String userName, String password) {
		
		logger.info("login Start:: user: "+userName);
		logger.debug("password: "+password);
		
		Connection connection = null;
		boolean isValidUser = false;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("select * from user where userName=? and password=?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				isValidUser = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());

		} finally {
			DBUtil.closeConnection(connection);
		}
		
		logger.info("login End:: isValidUser: "+isValidUser);
		return isValidUser;
	}

	public boolean resetPassword(String userName, String currentpassword, String newpassword) {
		logger.info("resetPassword Start:: user: "+userName);
		logger.debug("password: "+currentpassword);
		boolean isValidUser = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			System.out.println(connection);
			preparedStatement = connection
					.prepareStatement("update user set password=? where userName=? and password=? ");
			preparedStatement.setString(1, newpassword);
			preparedStatement.setString(2,userName);
			preparedStatement.setString(3, currentpassword);

			int noOfRec = preparedStatement.executeUpdate();
			System.out.println("The NoOfRec:" + noOfRec);
			return (noOfRec > 0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}

		logger.info("resetPassword End:: isValidUser: "+isValidUser);
		return isValidUser;

	}

	@Override
	public Expense getExpense(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Expense expense = null;
		try {
            
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("select * from expense where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();
				
				expense.setId(resultSet.getInt("id"));
				expense.setExpenseType(resultSet.getString("expenseType"));
				expense.setFrom_date(resultSet.getString("from_date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfItems(resultSet.getFloat("numberOfItems"));
				expense.setTotalAccount(resultSet.getFloat("totalAccount"));
				expense.setByWhom(resultSet.getString("byWhom"));
				expense.setUserid(resultSet.getInt("userid"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;
	}

	@Override
	public List<Expense> getExpenses() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// Expense expense = null;
		List<Expense> expenses = new ArrayList<Expense>();

		try {

			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement("select * from expense");

			ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
			Expense expense = null;
			while (resultSet.next()) {
				expense = new Expense();

				expense.setExpenseType(resultSet.getString("expenseType"));
				expense.setFrom_date(resultSet.getString("from_date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfItems(resultSet.getFloat("numberOfItems"));
				expense.setTotalAccount(resultSet.getFloat("totalAccount"));
				expense.setByWhom(resultSet.getString("byWhom"));
				expense.setId(resultSet.getInt("id"));

				expenses.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;

	}

	@Override
	public List<Expense> getExpenseReport(String expenseType, String fromDate, String toDate) {
		boolean isExpenseFlag=true;
		logger.info("expenseReport Start:: expense: "+isExpenseFlag);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Expense> expenses = new ArrayList<Expense>();
		try {

			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM expense WHERE expensetype=? AND from_date BETWEEN ? AND ?");
//					"select * from expense where expensetype='" + expenseType
//					+ "'and from_date between '" + fromDate + "' and '" + toDate + "'");
			preparedStatement.setString(1, expenseType);
			preparedStatement.setString(2, fromDate);
			preparedStatement.setString(3, toDate);
			//preparedStatement.setInt(4, userId);

			ResultSet resultset = (ResultSet) preparedStatement.executeQuery();

			Expense expense = null;
			while (resultset.next()) {
				expense = new Expense();

				expense.setId(resultset.getInt("id"));
				expense.setExpenseType(resultset.getString("expenseType"));
				expense.setFrom_date(resultset.getString("from_date"));
				expense.setPrice(resultset.getFloat("price"));
				expense.setNumberOfItems(resultset.getFloat("numberOfItems"));
				expense.setTotalAccount(resultset.getFloat("totalAccount"));
				expense.setByWhom(resultset.getString("byWhom"));
				//expense.setUserid(resultset.getInt("userid"));
				
				expenses.add(expense);
System.out.println(expenses);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("expenseReport End:: isExpenseFlag: "+isExpenseFlag);
		return expenses;
	}

	@Override
	public PersonalInfo getPersonalInfo(String username) {

		PersonalInfo persanlInfo = new PersonalInfo();
		Connection connection = (Connection) DBUtil.getConnection();
		PreparedStatement preparesatement;
		try {
			preparesatement = connection.prepareStatement(
					"select u.*, a.* from user u left join address a on u.id=a.userid where u.username='" + username + "'");/* W */
			ResultSet resultset = (ResultSet) preparesatement.executeQuery();

			while (resultset.next()) {
				User user = new User();

				user.setId(resultset.getInt(1));
				user.setFirstName(resultset.getString(2));
				user.setMiddleName(resultset.getString(3));
				user.setLastName(resultset.getString(4));
				user.seteMail(resultset.getString(5));
				user.setUserName(resultset.getString(6));
				user.setPassword(resultset.getString(7));
				user.setMobileNumber(resultset.getString(8));

				

				Address address = new Address();

				address.setId(resultset.getInt(9));
				address.setAddressLine1(resultset.getString(10));
				address.setAddressLine2(resultset.getString(11));
				address.setCity(resultset.getString(12));
				address.setState(resultset.getString(13));
				address.setCountry(resultset.getString(14));
				address.setUserid(resultset.getInt(15));

				persanlInfo.setUser(user);
				persanlInfo.setAddress(address);

				// System.out.println(persanlInfo.getUser().getFirstName());

				// System.out.println(persanlInfo.getAddress().getCity());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);

		}

		return persanlInfo;
	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {

		boolean isUserUpdate = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);

			String updateUserQuery = "update user set Firstname=?, Lastname=?, Middlename=?, email=?, mobileNumber=? where id=?";

			preparedStatement = connection.prepareStatement(updateUserQuery);

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getMiddleName());
			preparedStatement.setString(4, user.geteMail());
			preparedStatement.setString(5, user.getMobileNumber());
			preparedStatement.setInt(6, user.getId());

			int numOfUserRecsUpdated = preparedStatement.executeUpdate();

			System.out.println("numOfUserRecsUpdated: " + numOfUserRecsUpdated);

			if (numOfUserRecsUpdated > 0) {
				String addressQuery = "";
				if (address.getId() > 0) {
					addressQuery = "update address set addressline1=?, addressline2=?, city=?, state=?, country=?,  userid=? where id=?";
				} else {
					addressQuery = "insert into address (addressline1, addressline2, city, state, country, userid, id) values (?, ?, ?, ?, ?, ?, ?,?)";
				}
				preparedStatement = connection.prepareStatement(addressQuery);

				preparedStatement.setString(1, address.getAddressLine1());
				preparedStatement.setString(2, address.getAddressLine2());
				preparedStatement.setString(3, address.getCity());
				preparedStatement.setString(4, address.getState());
				preparedStatement.setString(5, address.getCountry());
				preparedStatement.setInt(6, address.getUserid());
				preparedStatement.setInt(7, address.getId());

				int numOfAddrRecsUpdated = preparedStatement.executeUpdate();

				System.out.println("numOfAddrRecsUpdated: " + numOfAddrRecsUpdated);

				isUserUpdate = numOfAddrRecsUpdated > 0;
			}

			if (isUserUpdate) {
				connection.commit();
			} else {
				connection.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isUserUpdate;
	}

	

}


