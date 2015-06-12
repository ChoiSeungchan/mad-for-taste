package org.kosta.madfortaste.user.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class OwnerForm {
	@Size(min = 6, max = 16)
	private String ownerId;
	@Size(min = 6, max = 16)
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String tel;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String brNo;
	@NotEmpty
	private String businessName;
	@NotEmpty
	private String address;
	@NotEmpty
	private String tastyTel;

	public OwnerForm() {
		super();
	}

	public OwnerForm(String ownerId, String password, String name, String tel,
			String email, String brNo, String businessName, String address,
			String tastyTel) {
		super();
		this.ownerId = ownerId;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.brNo = brNo;
		this.businessName = businessName;
		this.address = address;
		this.tastyTel = tastyTel;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTastyTel() {
		return tastyTel;
	}

	public void setTastyTel(String tastyTel) {
		this.tastyTel = tastyTel;
	}

	@Override
	public String toString() {
		return "OwnerForm [ownerId=" + ownerId + ", password=" + password
				+ ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", brNo=" + brNo + ", businessName=" + businessName
				+ ", address=" + address + ", tastyTel=" + tastyTel + "]";
	}

}
