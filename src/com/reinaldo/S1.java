package com.reinaldo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1
 */
@WebServlet("/S1")
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String param = request.getParameter("param");

		switch (param) {
			case "C":
				prepareCreate(request, response);
				break;
			case "C2":
				createUser(request, response);
				break;
			case "R":
				listAll(request, response);
				break;
			case "U":
				prepareUpdate(request, response);
				break;
			case "U2":
				showUpdatePage(request, response);
				break;
			case "U3":
				updateUser(request, response);
				break;
			case "D":
				prepareDelete(request, response);
				break;
			case "D2":
				deleteUser(request, response);
				break;
			default:
				break;
		}
	}
	
	
	private void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("people", getPersonList());
		request.getRequestDispatcher("read.jsp").forward(request, response);
	}
	
	private void prepareCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("section", "1");
		request.getRequestDispatcher("create.jsp").forward(request, response);
	}
	
	private void prepareUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("people", getPersonList());
		request.setAttribute("section", "1");
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	private void prepareDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("people", getPersonList());
		request.setAttribute("section", "1");
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}
	
	private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String selectedid = request.getParameter("id");
		final Person p = getPerson(selectedid);
		
		request.setAttribute("section", "2");
		request.setAttribute("person", p);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String id = request.getParameter("id");
		final String newName = request.getParameter("name");
		final String newAge = request.getParameter("age");
		final String newCod = request.getParameter("cod");
		
		update(id, newName, newAge, newCod);
		
		request.setAttribute("section", "3");
		request.setAttribute("name", newName);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String id = request.getParameter("id");
		final Person p = getPerson(id);
		
		delete(p);
		
		request.setAttribute("section", "2");
		request.setAttribute("name", p.getName());
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}
	
	
	private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String name = request.getParameter("name");
		final String age = request.getParameter("age");
		final String cod = request.getParameter("cod");
		
		final Person p = new Person().name(name).age(age).cod(cod);
		
		create(p);
		
		request.setAttribute("section", "2");
		request.setAttribute("name", p.getName());
		request.getRequestDispatcher("create.jsp").forward(request, response);
	}
	
	
	
	
	
	
	/* --------------- DATA BASE CONNECTION ------------------- */
	
	
	private Person getPerson(final String selectedid) {
		final Person p = new Person();
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/servlet","SA","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from person where id="+selectedid);
			
			while (rs.next()) {
				p.id(rs.getInt("id"))
					.name(rs.getString("name"))
					.age(rs.getInt("age"))
					.cod(rs.getString("cod"));
				break;
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (Exception ex) { }
		return p;
	}
	
	private void update(final String id, final String name, final String age, final String cod) {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/servlet","SA","");
			Statement st = con.createStatement();
			st.executeUpdate("update PERSON set name='"+name+"' age="+age+" cod='"+cod+"' where id="+id);
			
			st.close();
			con.close();
			
		} catch (Exception ex) {} 
	}
	
	private void delete(final Person p) {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/servlet","SA","");
			Statement st = con.createStatement();
			st.executeUpdate("delete from PERSON where id = "+p.getId()+"");
			
			st.close();
			con.close();
			
		} catch (Exception ex) {} 
	}
	
	private void create(final Person p) {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/servlet","SA","");
			Statement st = con.createStatement();
			st.executeUpdate("insert into PERSON values (null, '"+p.getName()+"', "+p.getAge()+", '"+p.getCod()+"')");
			
			st.close();
			con.close();
			
		} catch (Exception ex) {} 
	}
	
	private List<Person> getPersonList() {
		final List<Person> list = new ArrayList<Person>();
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/servlet","SA","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from person");
			
			while (rs.next()) {
				list.add(
						new Person()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.age(rs.getInt("age"))
						.cod(rs.getString("cod")));
			}

			rs.close();
			st.close();
			con.close();
			
		} catch (Exception ex) {} 
		
		return list;
	}


}
