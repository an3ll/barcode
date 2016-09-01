package com.an3ll.barcode.model.command;

/**
 * Created by joaane on 2016-08-20.
 */
public class AddRetailerInfoCommand {

  private String id;
  private String retailerInfo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setRetailerInfo(String retailerInfo) {
    this.retailerInfo = retailerInfo;
  }

  public String getRetailerInfo() {
    return retailerInfo;
  }
}
