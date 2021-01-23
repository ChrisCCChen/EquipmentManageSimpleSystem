/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author ZP Chen
 */

//字符串是否为空判断工具?
public class StringUtil {
    //字符串为空
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }
        else{
            return false;
        }
    }
    //字符串不为空
    public static boolean isNotEmpty(String str){
        if((str != null) && !"".equals(str.trim())){
            return true;
        }
        else{
            return false;
        }
    }
    //判断输入的字符串是否全为数字
    public static boolean isAllNumber(String str){
//        try{
//            int num = Integer.valueOf(str);
//            return true;
//        }
//        catch (NumberFormatException e){
//            return false;
//        }
        return str.matches("[0-9]+");//正则表达式判断方法
    }
    
 //判断字符串是否为小数
    public static boolean isFloat(String str){
        if(!(getStringCount(str,".") <= 1)){
            return false;
        }
        else{
            if(str.indexOf(".") != -1 && (str.indexOf(".") == 0 || str.indexOf(".") == str.length()-1)){
                return false;
            }
            else{
                if(str != null && str.matches("^[0.0-9.0]+$"))
                    return true;
                else
                    return false;
            }
        }
    }
    
//获取一个字符串，查找这个字符串出现的次数;
    public static int getStringCount(String str, String key) {
        int count = 0;
        int index = 0;
        int num = str.indexOf(key);
        while ((index = str.indexOf(key)) != -1) {
            count++;
            str = str.substring(str.indexOf(key) + key.length());
        }
        return count;
    }
}
