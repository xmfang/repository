/**
 * 
 */
package com.nafu.dsm.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author xmfang
 *
 */
public class DateAddNumberTest {

	@Test
	public void generateSerialNumberTest() {
		DateAddNumber dateAddNumber = new DateAddNumber();
		dateAddNumber.generateSerialNumber("2011090912");
		
		assertEquals(dateAddNumber.gererateDateNumber() + "23", dateAddNumber.generateSerialNumber("2011090915"));
		assertEquals(dateAddNumber.gererateDateNumber() + "20", dateAddNumber.generateSerialNumber("2011090912"));
		assertEquals(dateAddNumber.gererateDateNumber() + "08", dateAddNumber.generateSerialNumber("2011090900"));
		assertEquals(dateAddNumber.gererateDateNumber() + "00", dateAddNumber.generateSerialNumber(""));
	}

}
