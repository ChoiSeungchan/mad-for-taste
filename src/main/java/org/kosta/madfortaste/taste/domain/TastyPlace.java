package org.kosta.madfortaste.taste.domain;

public class TastyPlace {
	private String brNo;
	private String businessName;
	private String address;
	private String tastyTel;
	private String contractFlag;
	private String ownerId;
	public TastyPlace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TastyPlace(String brNo, String businessName, String address,
			String tastyTel, String contractFlag, String ownerId) {
		super();
		this.brNo = brNo;
		this.businessName = businessName;
		this.address = address;
		this.tastyTel = tastyTel;
		this.contractFlag = contractFlag;
		this.ownerId = ownerId;
	}
	@Override
	public String toString() {
		return "TastyPlace [brNo=" + brNo + ", businessName=" + businessName
				+ ", address=" + address + ", tastyTel=" + tastyTel
				+ ", contractFlag=" + contractFlag + ", ownerId=" + ownerId
				+ "]";
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
	public String getContractFlag() {
		return contractFlag;
	}
	public void setContractFlag(String contractFlag) {
		this.contractFlag = contractFlag;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
}
