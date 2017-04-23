package com.yuhao.other.exception;

public class WebInterfaceException extends Exception {

	/**
	 * 网络接口异常
	 */
	private static final long serialVersionUID = 1L;
	public WebInterfaceException(){
		super();
	}
	
	public WebInterfaceException(String message){
		super(message);
	}

}
