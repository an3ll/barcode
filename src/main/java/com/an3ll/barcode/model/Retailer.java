package com.an3ll.barcode.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Retailer {

	@Id private String id;
	private String name;
	private Image qrCode;
	private RetailerInfo retailerInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Image getQrCode() {
		return qrCode;
	}

	public void setQrCode(Image qrCode) {
		this.qrCode = qrCode;
	}

	public RetailerInfo getRetailerInfo() {
		return retailerInfo;
	}

	public void setRetailerInfo(RetailerInfo retailerInfo) {
		this.retailerInfo = retailerInfo;
	}
}
