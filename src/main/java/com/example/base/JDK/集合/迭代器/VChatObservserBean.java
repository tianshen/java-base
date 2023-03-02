package com.example.base.JDK.集合.迭代器;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class VChatObservserBean {

    private String vid;
    private String owner;
    private List<String> momoidList;
    private Map<String, Object> extMap;

    public VChatObservserBean() {
    }


}
