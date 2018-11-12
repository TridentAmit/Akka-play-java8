package model;

import java.io.Serializable;

public class ErrorResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	private String type;
	
	public ErrorResponse(String errorCode,String errorMsg,String type){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.type = type;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
