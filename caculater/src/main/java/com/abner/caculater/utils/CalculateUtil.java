package com.abner.caculater.utils;

public class CalculateUtil {

    public static String calculate(String input){
        String result = "";
        if(StringUtil.isAdd(input)){
            String[] strings = input.split("/+");
            result = String.valueOf(Integer.valueOf(strings[0]) + Integer.valueOf(strings[1]));
        } else if(StringUtil.isjanfa(input)){
            String[] strings = input.split("/-");
            result = String.valueOf(Integer.valueOf(strings[0]) - Integer.valueOf(strings[1]));
        }else if(StringUtil.chengfa(input)){
            String[] strings = input.split("/*");
            result = String.valueOf(Integer.valueOf(strings[0]) * Integer.valueOf(strings[1]));
        }
        else if(StringUtil.chufa(input)){
            String[] strings = input.split("//");
            result = String.valueOf(Integer.valueOf(strings[0]) / Integer.valueOf(strings[1]));
        }
        return result;
    }

    public int func(int n){
        if(n ==1){
            return 1;
        } else{
            return n*func(n-1);
        }
    }
}
