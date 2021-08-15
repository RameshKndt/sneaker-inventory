package com.xrg.sneakerinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "inventory")
public class Inventory {
	  protected Inventory() {
		  
	  }
	  public static InventoryBuilder builder() {
	        return new InventoryBuilder();
	    }
	  private Inventory( String brand, String model, String nickname, String size, String type, String storeId,
			String state, String color, String accent1Color, String accent2Color, String soleColor, String description,
			double price, double purchasePrice) {
		super();
		
		this.brand = brand;
		this.model = model;
		this.nickname = nickname;
		this.size = size;
		this.type = type;
		this.storeId = storeId;
		this.state = state;
		this.color = color;
		this.accent1Color = accent1Color;
		this.accent2Color = accent2Color;
		this.soleColor = soleColor;
		this.description = description;
		this.price = price;
		this.purchasePrice = purchasePrice;
	}
      @Id
	  @Column(name = "id")
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String id;
	  private String brand;
	  private String model;
	  private String nickname;
	  private String size;
	  private String type;
	  private String storeId;
	  private String state;// (e.g., New, Mint, Very Good, Good, Fair)
	  private String color;
	  private String accent1Color;
	  private String accent2Color;
	  private String soleColor;
	  private String description;
	  private double price;
	  private double purchasePrice;
	public String getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getNickname() {
		return nickname;
	}
	public String getSize() {
		return size;
	}
	public String getType() {
		return type;
	}
	public String getStoreId() {
		return storeId;
	}
	public String getState() {
		return state;
	}
	public String getColor() {
		return color;
	}
	public String getAccent1Color() {
		return accent1Color;
	}
	public String getAccent2Color() {
		return accent2Color;
	}
	public String getSoleColor() {
		return soleColor;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	  
	public static class InventoryBuilder{

		  private String brand;
		  private String model;
		  private String nickname;
		  private String size;
		  private String type;
		  private String storeId;
		  private String state;// (e.g., New, Mint, Very Good, Good, Fair)
		  private String color;
		  private String accent1Color;
		  private String accent2Color;
		  private String soleColor;
		  private String description;
		  private double price;
		  private double purchasePrice;
		  public InventoryBuilder setBrand(final String brand) {
				this.brand = brand;
			return this ; }
			public InventoryBuilder setModel(final String model) {
				this.model = model;
			return this ; }
			public InventoryBuilder setNickname(final String nickname) {
				this.nickname = nickname;
			return this ; }
			public InventoryBuilder setSize(final String size) {
				this.size = size;
			return this ; }
			public InventoryBuilder setType(final String type) {
				this.type = type;
			return this ; }
			public InventoryBuilder setStoreId(final String storeId) {
				this.storeId = storeId;
			return this ; }
			public InventoryBuilder setState(final String state) {
				this.state = state;
			return this ; }
			public InventoryBuilder setColor(final String color) {
				this.color = color;
			return this ; }
			public InventoryBuilder setAccent1Color(final String accent1Color) {
				this.accent1Color = accent1Color;
			return this ; }
			public InventoryBuilder setAccent2Color(final  String accent2Color) {
				this.accent2Color = accent2Color;
			return this ; }
			public InventoryBuilder setSoleColor(final String soleColor) {
				this.soleColor = soleColor;
			return this ; }
			public InventoryBuilder setDescription(final String description) {
				this.description = description;
			return this ; }
			public InventoryBuilder setPrice(final double price) {
				this.price = price;
			return this ; }
			public InventoryBuilder setPurchasePrice(final double purchasePrice) {
				this.purchasePrice = purchasePrice;
			return this ; }
			public  Inventory build() {
				return new Inventory( brand, model, nickname, size, type, storeId,
						state, color, accent1Color, accent2Color, soleColor, description,
						 price,  purchasePrice);
				}
			
		  
	}  
	  
}
