package model;

import java.io.Serializable;

public class ProfileReadHealthCheckResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private String version;
	private String msg;
	public ProfileReadHealthCheckResponse() {
	}
	public ProfileReadHealthCheckResponse(int status,String version,String msg) {
		this.status = status;
		this.version = version;
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
