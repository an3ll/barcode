package com.an3ll.barcode.model;

import org.springframework.data.mongodb.core.mapping.Document;

public class Image {

    private String fileName;
    private byte[] imageData;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}