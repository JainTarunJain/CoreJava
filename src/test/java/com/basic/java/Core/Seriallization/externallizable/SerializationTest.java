package com.basic.java.Core.Seriallization.externallizable;

import junit.framework.TestCase;

public class SerializationTest extends TestCase {
	
	public void testSeriallizeObject(){
		Car car = new Car();
        car.setCcOfEngine(1000);
        car.setLicenseNumber("AW-23-6528");
        car.setNumberOfDoors(4);
        car.setColor("Black");
        car.setCompany("Mercedes");
        car.setModel("Mercedez- Benz -Q");
        
        try {
            /**
             * Serializing the object
             */
            SeriallizationUtil.serialize(car, "serialization.txt");
 
            /**
             * Deserializing the object
             */
            Car carOutput = (Car) SeriallizationUtil
                    .deserialize("serialization.txt");
            assertEquals("Black", carOutput.getColor());
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
