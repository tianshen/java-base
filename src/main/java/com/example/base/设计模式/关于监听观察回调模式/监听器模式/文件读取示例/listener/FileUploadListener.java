package com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.listener;


import com.example.base.设计模式.关于监听观察回调模式.监听器模式.文件读取示例.event.FileUploadEvent;

public class FileUploadListener implements ApplicationListener<FileUploadEvent> {
    @Override
    public void onEvnt(FileUploadEvent evnt) {
        double i1 = evnt.getFileSize();
        double d = evnt.getReadSize()/i1;
//                map.put("文件ID",d*100);
//                map.remove("文件ID")
        System.out.println("当前文件上传进度百分比:"+d*100+"%");
    }
}
