package com.abner.caculater.utils;

public class StringUtil {

    public static boolean isAdd(String string){
        return  string.contains("+");
    }
    public static boolean isjanfa(String string){
        return  string.contains("-");
    }
    public static boolean chengfa(String string){
        return  string.contains("*");
    }
    public static boolean chufa(String string){
        return  string.contains("\\");
    }
}
