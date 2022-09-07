package com.example.util;

public class strIsEmpty {
    public static boolean isEmpty(String str){
        if(str==null||"".equals(str.trim())){
            return true;
        }
        return false;
    }
}
