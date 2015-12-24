package com.basic.java.Core.Seriallization.externallizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Vehicle implements Externalizable{
	
	private String model;
	private String color;
	private String company;
	private int speed;
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
     * This methods read the variables from stream
     */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		model=String.valueOf(in.readObject());
		color= String.valueOf(in.readObject());
		company = String.valueOf(in.readObject());
		speed = in.readInt();
		
	}
	
	/**
     * This method writes the desired variables in the file.
     */
    public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(model);
		out.writeObject(color);
		out.writeObject(company);
		out.writeInt(speed);
	}
	
	

}
