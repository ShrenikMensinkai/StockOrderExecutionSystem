/**
 * 
 */
package com.sahaj.module;

/**
 * @author shren
 *
 */
public class Order 
{
	protected long orderId;
	protected long newQuantity;
	protected long quantityRemaining;
	protected long quantity;
	protected String company = new String();
	protected String status= new String("Open");
	protected String side = new String();
		
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getNewQuantity() {
		return newQuantity;
	}
	public void setNewQuantity(long newQuantity) {
		this.newQuantity = newQuantity;
	}
	public long getQuantityRemaining() {
		return quantityRemaining;
	}
	public void setQuantityRemaining(long quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
}
