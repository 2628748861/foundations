package com.plugin.foundation.library.util;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * Created by cample on 2018/6/14.
 */

public class DesUtil {


    public static String encodeAll(String data)
    {
        String decStr="";
        try
        {
            String key="gvgcn_tbb00000000000000000000000";
            String iv="gvgcntbb";
            decStr=decode(data,key,iv);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return decStr;
    }


    public static final String encoding="utf-8";

    public  static  String  encode(String  plainText,  String  secretKey,  String  iv)  throws  Exception  {
        Key  deskey  =  null;
        DESedeKeySpec  spec  =  new  DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory  keyfactory  =  SecretKeyFactory.getInstance("desede");
        deskey  =  keyfactory.generateSecret(spec);

        Cipher  cipher  =  Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec  ips  =  new  IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE,  deskey,  ips);
        byte[]  encryptData  =  cipher.doFinal(plainText.getBytes(encoding));
        return  Base64.encode(encryptData);
    }

    /**
     *  3DES解密
     *
     *  @param  encryptText  加密文本
     *  @param  secretKey      秘钥
     *  @param  iv                    向量
     *  @return
     *  @throws  Exception
     */
    public  static  String  decode(String  encryptText,  String  secretKey,  String  iv)  throws  Exception  {
        Key  deskey  =  null;
        DESedeKeySpec  spec  =  new  DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory  keyfactory  =  SecretKeyFactory.getInstance("desede");
        deskey  =  keyfactory.generateSecret(spec);
        Cipher  cipher  =  Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec  ips  =  new  IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE,  deskey,  ips);

        byte[]  decryptData  =  cipher.doFinal(Base64.decode(encryptText));

        return  new  String(decryptData,  encoding);
    }

}
