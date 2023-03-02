package com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.event;

public class FileUploadEvent extends ApplicationEvnt {


    private int fileSize;

    private int readSize;


    public FileUploadEvent(int fileSize, int readSize) {
        this.fileSize =  fileSize;
        this.readSize = readSize;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getReadSize() {
        return readSize;
    }

    public void setReadSize(int readSize) {
        this.readSize = readSize;
    }
}
