package com.abner.practicecollect.jni;

public class JniHelper {
    static {
        System.loadLibrary("jni-lib");
        System.loadLibrary("jni-lib");
    }
    //C调用Java 空参数方法
    public void helloFromJava(){
        System.out.println("helloFromJava");
    }
    //C调用Java int类型参数方法
    public int jianfa(int a,int b){
        return a-b;
    }
    //C调用Java String 类型参数方法
    public void helloFromJava(String string){
        System.out.println(string);
    }
    //通过native关键字，声明一个本地方法，该方法不用实现，需要用JNI调用c的代码来实现
    public native String helloJNI();
    //两个数相加，返回给Java
    public native int add(int a,int b);
    //对字符串操作+1 让后返回操作后的字符串
    public native String sysHelloInC(String string);
    //传递一个int类型数组
    public native int[] arrayElementsIncrease(int[] array);

    //调用这个方法，回调Java空方法
    public native void callbackVoid();
    //调用这个方法，回调Java int 类型参数空方法
    public native void callbackInt();
    //调用这个方法，回调Java String 类型参数方法
    public native void callbackString();
}
