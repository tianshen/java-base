package com.example.base.基础.equalsandhashcode;

public class User {

    private String name;

    private String sex;

    public User() {

    }

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

//    @Override
//    public int hashCode(){
//        int nameHash =  name.toUpperCase().hashCode();
//        int sexHash = sex.toUpperCase().hashCode();
//        return nameHash ^ sexHash;
//    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        //如果是同一个对象返回true，反之返回false
        if (this == obj) {
            return true;
        }

        //判断是否类型相同
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;
        return name.equals(user.name) && sex.equals(user.sex);
    }
}
