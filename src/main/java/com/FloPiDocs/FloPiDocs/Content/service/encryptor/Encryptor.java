package com.FloPiDocs.FloPiDocs.Content.service.encryptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * The type Encryptor.
 */
//GUILLE , esto se puede hacer mejor?
@Component
public class Encryptor {
    /**
     * The Key.
     */
    @Value("${encryptor.key}")
    String key;

    /**
     * Encrypt string.
     *
     * @param strClearText the str clear text
     * @return the string
     * @throws Exception the exception
     */
    public String encrypt(String strClearText) throws Exception{

        String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(key.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted=cipher.doFinal(strClearText.getBytes());
            strData=new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }

    /**
     * Decrypt string.
     *
     * @param strEncrypted the str encrypted
     * @param strKey       the str key
     * @return the string
     * @throws Exception the exception
     */
//TODO use this method to let user change the password
    public String decrypt(String strEncrypted,String strKey) throws Exception{
        String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(key.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
            strData=new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }
}
