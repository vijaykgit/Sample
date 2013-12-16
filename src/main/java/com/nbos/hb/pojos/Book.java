package com.nbos.hb.pojos;


import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private int bid;
	private String bname;
	private boolean isRemoved;
	private Long isbn;

	public Book() {
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public boolean getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

}
