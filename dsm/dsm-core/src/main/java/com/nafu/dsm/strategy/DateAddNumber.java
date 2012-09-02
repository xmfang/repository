/**
 * 
 */
package com.nafu.dsm.strategy;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;

/**
 * 
 * 日期加号码，编号生成策略
 * @author xmfang
 *
 */
public class DateAddNumber implements SerialNumberStrategy {
	
	/*
	 * 配置文件名称
	 */
	public final static String PROPERTIES_FILE_NAME = "configuration.properties";
	
	/*
	 * 默认间隔数 8
	 */
	private int spaceNumber = 8;
	
	/*
	 * 默认日期后使用两位数字
	 */
	private int lastDigitsCount = 2;
	
	public String generateSerialNumber(String previousSerialNumber) {
		initializeSpNumberAndLdCount();
		String lastDigitsNumber = "";
		if (previousSerialNumber.isEmpty()) {
			lastDigitsNumber = initializeLastNumber(lastDigitsCount);
		} else {
			lastDigitsNumber = generateLastDigitsNumber(previousSerialNumber);
		}
		
		return gererateDateNumber()	+ lastDigitsNumber;
	}
	
	private void initializeSpNumberAndLdCount() {
		Properties configuration = new Properties();
		String filePath = getClass().getResource("/").getPath();
		
		try {
			InputStream in = new BufferedInputStream (new FileInputStream(filePath + PROPERTIES_FILE_NAME));
			configuration.load(in);
			String spaceNumberFromConf = configuration.getProperty("space.number");
			String lastDigitsCountFromConf = configuration.getProperty("last.digits.count");
			
			if (spaceNumberFromConf != null) {
				spaceNumber = Integer.parseInt(spaceNumberFromConf);
			}
			if (lastDigitsCountFromConf != null) {
				lastDigitsCount = Integer.parseInt(lastDigitsCountFromConf);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String initializeLastNumber(int lastDigitsCount) {
		String result = "";
		for (int i = 0; i < lastDigitsCount; i ++) {
			result += "0";
		}
		return result;
	}
	
	private String generateLastDigitsNumber(String previousSerialNumber) {
		int previousSerialNumberLastDigitsNumber = Integer.parseInt(previousSerialNumber.substring(previousSerialNumber.length() - lastDigitsCount));
		int lastDigitsNumberInt = previousSerialNumberLastDigitsNumber + spaceNumber;
		String lastDigitsNumber = "" + lastDigitsNumberInt;
		
		for (int i = lastDigitsCount - 1; i > 0; i --) {
			if (lastDigitsNumberInt < (int) Math.pow(10, i)) {
				lastDigitsNumber = "0" + lastDigitsNumber;
			}
		}
		return lastDigitsNumber;
	}

	protected String gererateDateNumber() {
		Calendar theDate = Calendar.getInstance();
		String year = String.valueOf(theDate.get(Calendar.YEAR));
		
		String month = "";
		if ((theDate.get(Calendar.MONTH) + 1) < 10) {
			month = "0" + (theDate.get(Calendar.MONTH) + 1);
		} else {
			month = String.valueOf(theDate.get(Calendar.MONTH) + 1);
		}

		String date = String.valueOf(theDate.get(Calendar.DATE));
		
		return year + month + date;
	}
	
}
