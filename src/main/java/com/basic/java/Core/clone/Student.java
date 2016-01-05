package com.basic.java.Core.clone;

public class Student implements Cloneable {
private int rollNo;
private String name;

public Student(int no, String name){
	this.rollNo = no;
	this.name = name;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Object clone() throws CloneNotSupportedException{
	return super.clone();
}

}
