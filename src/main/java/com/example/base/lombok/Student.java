package com.example.base.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
// 类继承父类的时候需要设置callSuper = true
@EqualsAndHashCode(callSuper = false)
public class Student {

    private String name;

    private Integer age;

    private String sex;


}
