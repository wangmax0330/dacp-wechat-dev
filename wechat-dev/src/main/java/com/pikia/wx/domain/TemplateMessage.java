package com.pikia.wx.domain;

import java.util.Map;

/**
 *  微信模板消息基类
 * @author methew
 */
public class TemplateMessage {
	private String template_id;
	private String touser;
	private String url;
	private String topColor;
	private Map<String,Template> data;
	
	
	public TemplateMessage template_id(String template_id){
		this.template_id=template_id;
		return this;
	}
	public TemplateMessage touser(String touser){
		this.touser=touser;
		return this;
	}
	public TemplateMessage url(String url){
		this.url=url;
		return this;
	}
	public TemplateMessage topColor(String topColor){
		this.topColor=topColor;
		return this;
	}
	public TemplateMessage data(Map<String,Template> data){
		this.data=data;
		return this;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopColor() {
		return topColor;
	}
	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}
	public Map<String, Template> getData() {
		return data;
	}
	public void setData(Map<String, Template> data) {
		this.data = data;
	}
}
