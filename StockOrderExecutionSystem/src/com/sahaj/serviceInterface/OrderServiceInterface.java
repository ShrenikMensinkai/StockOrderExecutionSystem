package com.sahaj.serviceInterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import com.sahaj.module.Order;

public interface OrderServiceInterface{
	public ArrayList<Order> compute(ArrayList<Order> orders);
	public ArrayList<Order> sortOrders(ArrayList<Order> orders);
	public ArrayList<Order> swapOrders(ArrayList<Order> orders,int orderIndexI,int orderIndexJ);
	public ArrayList<Order> copyOrders(ArrayList<Order> orders);
	public ArrayList<Order> convertTextfileToArrayList(BufferedReader br);
	public ArrayList<Order> assignValue(ArrayList<Order> orders,int orderIndexI,int orderIndexJ);
	public String displayInputError(ArrayList<Order> orders);
	public String convertArrayListToString(ArrayList<Order> orders);
	public boolean isOrderIdUnique(ArrayList<Order> orders);
	public boolean isOrderInputValid(ArrayList<Order> orders);
	public void writeArratListToTextfile(ArrayList<Order> orders,BufferedWriter bw);			
}
