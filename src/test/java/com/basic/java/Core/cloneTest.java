package com.basic.java.Core;

import com.basic.java.Core.clone.Student;
import com.basic.java.Core.clone.Class;

import junit.framework.TestCase;

public class cloneTest extends TestCase {
	
	public void testCloneObject(){
		
		try {
			Student st = new Student(12,"amit");
			Student st1 = (Student)st.clone();
			assertEquals(12, st1.getRollNo());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testDeepCloneObject(){
		try{
			Student st = new Student(12,"amit");
			Class original = new Class("first",st);
			Class cloned = (Class)original.clone();
			cloned.getStudent().setName("anuj");
			
			assertEquals("amit", original.getStudent().getName());
			
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
	}

}
