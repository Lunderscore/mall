package com.ou.mall.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	private int code;
	private String message;
	private Map<String, String> content = new HashMap<String, String>();
	
	public Msg add(String key, String value){
		this.getContent().put(key, value);
		
		return this;
	}
	
	public static Msg success(){
		Msg msg = new Msg();
		msg.setCode(0);
		msg.setMessage("操作成功");
		
		return msg;
	}
	
	public static Msg failure(){
		
		Msg msg = new Msg();
		msg.setCode(1);
		msg.setMessage("操作失败");
		
		return msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getContent() {
		return content;
	}
	public void setContent(Map<String, String> content) {
		this.content = content;
	}
	
}
