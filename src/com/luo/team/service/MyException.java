package com.luo.team.service;

public class MyException extends Exception{
    static final long serialVersionUID = -7034897193246939L;

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}
