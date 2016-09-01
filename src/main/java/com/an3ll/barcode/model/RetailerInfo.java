package com.an3ll.barcode.model;

import java.util.ArrayList;
import java.util.List;

public class RetailerInfo {

  private List<String> info;

  public List<String> getInfo() {
    return info;
  }

  public void setInfo(List<String> info) {
    this.info = info;
  }

  public void addInfo(String toAdd) {
    if (null == info) {
      info = new ArrayList<>();
    }
    info.add(toAdd);
  }

  public List<String> withInfo(String newInfo) {
    info.add(newInfo);
    return info;
  }
}
