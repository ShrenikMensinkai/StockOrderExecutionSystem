/**
 * 
 */
package com.sahaj.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.sahaj.module.Order;
import com.sahaj.serviceInterface.ExecutionServiceInterface;

/**
 * @author shren
 *
 */
public class ExecutionService implements ExecutionServiceInterface {
	OrderService orderService=null;
	ArrayList<Order> orders = null;
	String error="";
	FileInputStream fileInput = null;
	BufferedReader bufferedReader = null;
	FileWriter fileWriter=null;
	BufferedWriter bufferedWriter=null;
	
	@Override
	public boolean stockOrderExecuter(String fileSource, String fileDestination)
	{
		try{
			if(fileSource==null||fileDestination==null)
			{
				System.out.println("FileSource or FileDestination cannot be null");
				return false;
			}
			fileInput = new FileInputStream(fileSource);
			bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
			fileWriter = new FileWriter(fileDestination,false);
			bufferedWriter = new BufferedWriter(fileWriter);
			orders = new ArrayList<Order>();
			orderService=new OrderService();
			orders= orderService.convertTextfileToArrayList(bufferedReader);
			if((orderService.isOrderInputValid(orders))&&(orderService.isOrderIdUnique(orders))){
					orders=orderService.copyOrders(orders);
					orders=orderService.sortOrders(orders);
					orders=orderService.compute(orders);
					orderService.writeArratListToTextfile(orders, bufferedWriter);
					return true;
			}
			if(!orderService.isOrderIdUnique(orders))
				error+="Stock Id Should be Unique";
			if(!orderService.isOrderInputValid(orders))		
				error+=orderService.displayInputError(orders);
			bufferedWriter.write(error);
			return true;
		}
		catch(FileNotFoundException f){
			System.out.println(f);
			return false;
		}
		catch(IOException io){
			System.out.println(io);
			return false;
		}
		finally{
			try{
				if(bufferedReader != null)
					bufferedReader.close();
				if(bufferedWriter != null)
					bufferedWriter.close();
				if(fileInput!=null)
					fileInput.close();
				if(fileWriter != null)
					fileWriter.close();
				}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
