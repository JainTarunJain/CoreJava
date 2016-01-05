package com.basic.java.Core.clone;

public class Class implements Cloneable{
	private Student student;
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	public Class(String name, Student student){
		this.name=name;
		this.student = student;
	}
	
	/*
	 * (non-Javadoc)
	 * clone method handle deep cloning
	 */
	public Object clone() throws CloneNotSupportedException{
		Class cloned = (Class)super.clone();
		cloned.setStudent((Student)cloned.getStudent().clone());
		return cloned;
	}
	
	

}
