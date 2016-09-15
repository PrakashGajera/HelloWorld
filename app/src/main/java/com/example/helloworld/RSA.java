package com.example.helloworld;

import android.annotation.SuppressLint;
import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by phoenix-pc3 on 15/9/16.
 */

public class RSA {
    @SuppressLint({"TrulyRandom"})
    public static String URL;
    static byte[] f6a;

    static {
        URL = "http://www.traceuniverse.com/android/hitesh/phpfile/amd/s_amd.php";
    }

    public static String decrypt(String cyphertext) {
        try {
            byte[] encodedKey = Base64.decode("QLUVmEORdls=", 0);
            SecretKey myDesKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DES");
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(2, myDesKey);
            return new String(desCipher.doFinal(Base64.decode(cyphertext, 0)));
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (NoSuchPaddingException e2) {
            return null;
        } catch (InvalidKeyException e3) {
            return null;
        } catch (IllegalBlockSizeException e4) {
            return null;
        } catch (BadPaddingException e5) {
            return null;
        }
    }
}
