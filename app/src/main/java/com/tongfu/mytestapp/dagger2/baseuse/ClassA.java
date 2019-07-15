package com.tongfu.mytestapp.dagger2.baseuse;

import javax.inject.Inject;

public class ClassA {
    @Inject
    public ClassA(){
    }
    public String toString(){
        return "ClassA注入成功！" ;
    }
}
