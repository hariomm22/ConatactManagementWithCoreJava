package com.contact.model;

public class Contact {

	private Integer id;
	private String cName;
	private String contactNo;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param cName
	 * @param contactNo
	 */
	public Contact(Integer id, String cName, String contactNo) {
		super();
		this.id = id;
		this.cName = cName;
		this.contactNo = contactNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", cName=" + cName + ", contactNo=" + contactNo + "]";
	}
	
	

}
