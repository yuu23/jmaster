package sht.bean;

import java.io.Serializable;

public class ItemBean implements Serializable {
	// cmdと同じ名前で書く
	private int code;
	private String name;
	private int price;

	public ItemBean(int code,String name,int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public ItemBean() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}