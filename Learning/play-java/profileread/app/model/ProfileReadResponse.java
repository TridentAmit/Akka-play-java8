package model;

import java.io.Serializable;

public class ProfileReadResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String acid;
	private String csid;
	private String fName;
	private String lName;
	private String hAddress;
	private String oAddress;
	private String mNumber;
	
	private Exception t;
	
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getCsid() {
		return csid;
	}
	public void setCsid(String csid) {
		this.csid = csid;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String gethAddress() {
		return hAddress;
	}
	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}
	public String getoAddress() {
		return oAddress;
	}
	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}
	public Exception getT() {
		return t;
	}
	public void setT(Exception t) {
		this.t = t;
	}
	
}
