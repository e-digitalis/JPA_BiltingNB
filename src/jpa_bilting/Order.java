/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_bilting;

/**
 *
 * @author User
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order")
	private List<OrderLine> orderLines;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Person customer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	public Person getCustomer() {
		return customer;
	}
	public void setCustomer(Person customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [" + orderLines + ", customer=" + customer + "]";
	}

}

