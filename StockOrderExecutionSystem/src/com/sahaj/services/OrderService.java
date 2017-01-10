package com.sahaj.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.sahaj.module.Order;
import com.sahaj.serviceInterface.OrderServiceInterface;

public class OrderService implements OrderServiceInterface {

	/**
	   * @method result
	   * @return ArrayList<Order> 
	   * @param ArrayList<Order>
	*/
	@Override
	public ArrayList<Order> compute(ArrayList<Order> orders) {
		for(int i=0;i<orders.size();i++){
			for(int j=0;j<orders.size();j++){	
				if((!(orders.get(i).getSide()).equals(orders.get(j).getSide())) && ((orders.get(i).getCompany()).equals(orders.get(j).getCompany()))){
					if(orders.get(i).getNewQuantity()>orders.get(j).getNewQuantity())
						orders= assignValue(orders,i,j);
					else						
						orders= assignValue(orders,j,i);
				}
			}
		}return orders;
	}
	
	/**
	   * @method assignValue
	   * @return ArrayList<Order> 
	   * @param ArrayList<Order>
	   * @param int
	   * @param int
	*/
	@Override
	public ArrayList<Order> assignValue(ArrayList<Order> orders, int orderIndexA, int orderIndexB) {
		orders.get(orderIndexA).setNewQuantity((orders.get(orderIndexA).getNewQuantity())-(orders.get(orderIndexB).getNewQuantity()));
		orders.get(orderIndexA).setQuantityRemaining(orders.get(orderIndexA).getNewQuantity());
		orders.get(orderIndexB).setNewQuantity(0);
		orders.get(orderIndexB).setQuantityRemaining(orders.get(orderIndexB).getNewQuantity());
		orders.get(orderIndexB).setStatus("Closed");
		return orders;
	}
	
	/**
	   * @method sortOrders
	   * @return ArrayList<Order> 
	   * @param ArrayList<Order>
	*/
	@Override
	public ArrayList<Order> sortOrders(ArrayList<Order> orders) {
		for(int i=0;i<orders.size()-1;i++){
			for(int j=0;j<orders.size()-2;j++){
				if(orders.get(j).getOrderId() > orders.get(j+1).getOrderId()){
					orders= swapOrders(orders,j,j+1);
				}
			}
		}return orders;
	}

	/**
	   * @method swapOrders
	   * @return ArrayList<Order> 
	   * @param ArrayList<Order>
	   * @param int
	   * @param int
	*/
	@Override
	public ArrayList<Order> swapOrders(ArrayList<Order> orders, int orderIndexI, int orderIndexJ) {
		Order temp1=null,temp2=null;
		temp1=orders.get(orderIndexI);
		temp2=orders.get(orderIndexJ);
		orders.set(orderIndexI, temp2);
		orders.set(orderIndexJ, temp1);
		return orders;
	}
	
	/**
	   * @method copyOrders
	   * @return ArrayList<Order> 
	   * @param ArrayList<Order>
	*/
	@Override
	public ArrayList<Order> copyOrders(ArrayList<Order> orders) {
		ArrayList<Order> temp = new ArrayList<Order>();
			for(Order order : orders){
				Order newOrder =new Order();
				newOrder.setOrderId(order.getOrderId());
				newOrder.setStatus(order.getStatus());
				newOrder.setCompany(order.getCompany());
				newOrder.setQuantity(order.getQuantity());
				newOrder.setNewQuantity(order.getQuantity());
				newOrder.setQuantityRemaining(order.getQuantityRemaining());
				newOrder.setSide(order.getSide().equalsIgnoreCase("Buy")?"BUY":"SELL");
				temp.add(newOrder);
			}return temp;	
	}

	/**
	   * @method convertTextfileToArrayList
	   * @return ArrayList<Order> 
	   * @param BufferedReader
	*/
	@Override
	public ArrayList<Order> convertTextfileToArrayList(BufferedReader br) {
		ArrayList<Order> tempOrders = new ArrayList<Order>();
		try{
			String str = br.readLine();
			str = br.readLine();
			while (str != null){	
				Order newOrder = new Order();
				String[] temp = str.split(",");
				newOrder.setOrderId(Long.parseLong(temp[0]));
				newOrder.setSide(temp[1]);
				newOrder.setCompany(temp[2]);
				newOrder.setQuantity(Long.parseLong(temp[3]));
				newOrder.setQuantityRemaining(newOrder.getQuantity());
				newOrder.setNewQuantity(newOrder.getQuantity());
				tempOrders.add(newOrder);
				str = br.readLine();
			}
		}
		catch(NumberFormatException n){
			System.out.println(n);
		}
		catch(IOException io){
			System.out.println(io);
		}
		finally{
				try{
					if(br!=null)
						br.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
		}return tempOrders;
	}

	/**
	   * @method displayInputError
	   * @return String 
	   * @param ArrayList<Order>
	*/
	@Override
	public String displayInputError(ArrayList<Order> orders) {
		String error = new String();
		int count=0;
		for (Order newOrder : orders){
			count++;
			if(newOrder.getOrderId() <= 0)
				error +="Order "+count+" Invalid Stock ID"+"\r\n";
			if(!((newOrder.getSide().equalsIgnoreCase("BUY"))||(newOrder.getSide().equalsIgnoreCase("SELL"))))
				error +="Order "+count+" Invalid Side"+"\r\n";
			if(newOrder.getNewQuantity() <=0)
				error +="Order "+count+" Invalid Quantity"+"\r\n";
		}return error;
	}

	/**
	   * @method convertArrayListToString
	   * @return String 
	   * @param ArrayList<Order>
	*/
	@Override
	public String convertArrayListToString(ArrayList<Order> orders) {
		String temp =new String("OrderId,Side,Company,Quantity,Remaining,Status\n");
		for (Order order : orders){
			temp += (order.getOrderId()+"\t"+order.getSide()+"\t"+order.getCompany()+"\t"+order.getQuantity()+"\t"+order.getQuantityRemaining()+"\t"+order.getStatus()+"\n");
		}return temp;
	}

	/**
	   * @method isOrderIdUnique
	   * @return boolean 
	   * @param ArrayList<Order>
	*/
	@Override
	public boolean isOrderIdUnique(ArrayList<Order> orders) {
		for(int i=0;i<orders.size();i++){
			for(int j=i+1;j<orders.size();j++){
				if(orders.get(i).getOrderId()==orders.get(j).getOrderId()){
					return false;
				}
			}
		}
		return true;
	}

	/**
	   * @method isOrderInputValid
	   * @return boolean 
	   * @param ArrayList<Order>
	*/
	@Override
	public boolean isOrderInputValid(ArrayList<Order> orders) {
		for (Order tempOrder : orders){
			if(tempOrder.getOrderId()<0)
				return false;
			if(!((tempOrder.getSide().equalsIgnoreCase("BUY"))||(tempOrder.getSide().equalsIgnoreCase("SELL"))))
				return false;
			if(tempOrder.getNewQuantity()<0)
				return false;
		}return true;
	}

	/**
	   * @method writeArratListToTextfile
	   * @return void 
	   * @param ArrayList<Order>
	   * @param BufferedWriter
	*/
	@Override
	public void writeArratListToTextfile(ArrayList<Order> orders, BufferedWriter bw) {
		try{
			bw.write("OrderId,Side,Company,Quantity,Remaining,Status\n");
			bw.newLine();
			for (Order order : orders){
				bw.write(order.getOrderId()+"\t"+order.getSide()+"\t"+order.getCompany()+"\t"+order.getQuantity()+"\t"+order.getQuantityRemaining()+"\t"+order.getStatus());
				bw.newLine();
			} 		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
