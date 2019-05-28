package com.example.blog.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public String OnlyMD5(String clearText){
         byte[] secretText = null;
         try {
             MessageDigest md = MessageDigest.getInstance("MD5");
             md.update(clearText.getBytes());
             secretText = md.digest();
         }catch (NoSuchAlgorithmException e){
             throw  new RuntimeException("没有MD5这个算法");
         }
         String md5Code = new BigInteger(1,secretText).toString(16);
         Integer md5CodeLength = md5Code.length();
         for (int i =0;i<32-md5CodeLength;i++){
             md5Code="0"+md5Code;
         }
         return md5Code;
    }
    /**
     * @saltMD5 采取密码加盐的MD5加密方式，暂时不会写，以后会了再写
     * @return
     */
    public  String saltMD5(){
        return  "";
    }
}
