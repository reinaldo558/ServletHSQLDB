package com.reinaldo;

public class Person {
	
	private int id;
	private String name;
	private int age;
	private String cod;
	
	public Person() {}
	
	/*  Common constructor */
	public Person(final int pid, final String pname, final int page, final String pcod) {
		this.id = pid;
		this.name = pname;
		this.age = page;
		this.cod = pcod;
	}
	
	/* Builder pattern  - beggining  */
	public Person id(final int pid) {
		id = pid;
		return this;
	}
	public Person name(final String pname) {
		name = pname;
		return this;
	}
	public Person age(final int page) {
		age = page;
		return this;
	}
	public Person age(final String page) {
		try {
			age = Integer.parseInt(page);
		} catch (Exception ex) {}
		return this;
	}
	public Person cod(final String pcod) {
		cod = pcod;
		return this;
	}
	/* Builder pattern  - END  */
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
	
	

}
