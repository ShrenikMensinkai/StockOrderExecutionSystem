package com.sahaj.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sahaj.services.ExecutionService;

public class TestExecutionService {

	String fileSource = null;
	String fileDestination = null;
	ExecutionService executionService = new ExecutionService();
		
	@Test
	public void testID_01()
	{				
		fileSource = "C:\\Sahaj\\abc.csv";
		fileDestination = "C:\\Sahaj\\Output.txt";
		 //Input File/Path Not Found
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_02()
	{				
		fileSource = "C:\\Sahaj\\inputID_2.csv";
		fileDestination = "C:\\Sahaj\\xyz\\Output.txt";
		 //Output File Path Not Found
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_03()
	{				
		fileSource = "C:\\Sahaj\\inputID_3.csv";
		fileDestination = "C:\\Sahaj\\OutputID_3.txt";
		 //If Stock_Order Value is Less then Zero
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_04()
	{				
		fileSource = "C:\\Sahaj\\inputID_4.csv";
		fileDestination = "C:\\Sahaj\\OutputID_4.txt";
		 //If any of the order's quantity Value is  then Zero
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_05()
	{				
		fileSource = "C:\\Sahaj\\inputID_5.csv";
		fileDestination = "C:\\Sahaj\\OutputID_5.txt";
		 //If any of the order's quantity Value is less then Zero
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_06()
	{				
		fileSource = "C:\\Sahaj\\inputID_6.csv";
		fileDestination = "C:\\Sahaj\\OutputID_6.txt";
		 //If any of the order's size Value is Invalid(not BUY/SELL)
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_07()
	{				
		fileSource = "C:\\Sahaj\\inputID_7.csv";
		fileDestination = "C:\\Sahaj\\OutputID_7.txt";
		 //Stock_ID's are not Unique in the given file.
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_08()
	{				
		fileSource = "C:\\Sahaj\\inputID_8.csv";
		fileDestination = "C:\\Sahaj\\OutputID_8.txt";
		 //Unsorted Stock_ID's.
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_09()
	{				
		fileSource = "C:\\Sahaj\\inputID_9.csv";
		fileDestination = "C:\\Sahaj\\OutputID_9.txt";
		 //Invalid Stock_ID,Side and Quantity in same file for different Orders.
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_10()
	{				
		fileSource = "C:\\Sahaj\\inputID_10.csv";
		fileDestination = "C:\\Sahaj\\OutputID_10.txt";
		 //NOStock Orders in the File.
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_11()
	{				
		fileSource = "C:\\Sahaj\\inputID_11.csv";
		fileDestination = "C:\\Sahaj\\OutputID_11.txt";
		 //BlankFile.
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_12()
	{				
		fileSource = "C:\\Sahaj\\inputID_12.csv";
		fileDestination = "C:\\Sahaj\\OutputID_12.txt";
		 //For a valid Input File
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_13()
	{				
		fileSource = "C:\\Sahaj\\inputID_13.csv";
		fileDestination = "C:\\Sahaj\\OutputID_13.txt";
		 //For a valid Input File for more Orders
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_14()
	{				
		fileSource = null;
		fileDestination = "C:\\Sahaj\\Output2.txt";
		 //Input File/Path Not Found
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
	@Test
	public void testID_15()
	{				
		fileSource = "C:\\Sahaj\\abc.csv";
		fileDestination = null;
		 //Input File/Path Not Found
		 assertTrue(executionService.stockOrderExecuter(fileSource, fileDestination));
	}
}
	