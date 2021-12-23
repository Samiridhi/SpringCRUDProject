package com.harman.dto;

public class ErrorMsg {

	private String msg;
	private String errCode;
	
	public ErrorMsg(String msg, String errCode) {
		super();
		this.msg = msg;
		this.errCode = errCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
}
