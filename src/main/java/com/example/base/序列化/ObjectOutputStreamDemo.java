package com.example.base.序列化;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo { //序列化

    //序列化（Serialization）是将对象的状态信息转化为可以存储或者传输的形式的过程，
    // 一般将一个对象存储到一个储存媒介，例如档案或记忆体缓冲等，
    // 在网络传输过程中，可以是字节或者XML等格式；而字节或者XML格式的可以还原成完全相等的对象，这个相反的过程又称为反序列化；
    public static void main(String[] args) throws Exception {
        //序列化后生成指定文件路径
        File file = new File("D:" + File.separator + "person.ser");
        ObjectOutputStream oos = null;
        //装饰流（流）
        oos = new ObjectOutputStream(new FileOutputStream(file));

        //实例化类
        Person per = new Person("张三", 30);
        oos.writeObject(per); //把类对象序列化
        oos.close();
    }
}