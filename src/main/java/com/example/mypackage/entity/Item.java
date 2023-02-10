package com.example.mypackage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="ItemName" , nullable=false)
	private String ItemName;
	
	@Column(name="Price" , nullable=false)
	private long Price;
//	@Column(name="ActualPrice" , nullable=false)
//	private long ActualPrice;
//	
//	public long getActualPrice() {
//		return ActualPrice;
//	}
//	public void setActualPrice(long actualPrice) {
//		ActualPrice = actualPrice;
//	}
	@Column(name="CurrentStock" , nullable=false)
	private long CurrentStock;
	@Column(name="image" , nullable=true,length=64)
	private String image;
	public Item() {
		
	}
	public Item(String ItemName, long Price, long CurrentStock) {
		super();
		this.ItemName = ItemName;
		this.Price = Price;
		this.CurrentStock = CurrentStock;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	public long getCurrentStock() {
		return CurrentStock;
	}
	public void setCurrentStock(long currentStock) {
		CurrentStock = currentStock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
