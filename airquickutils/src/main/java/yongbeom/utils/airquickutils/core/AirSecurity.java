package yongbeom.utils.airquickutils.core;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import yongbeom.utils.airquickutils.AirQuickUtils;

/**
 * AirSecurity
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirSecurity {

    /**
     * CBC mode, PKCS5 Padding.
     *
     * @param plain
     *            The target to encrypt. Uncreated state.
     * @param key
     * @param initializationVector
     *            CBC requires an initialization vector.
     * @return Encrypted array
     */
    public byte[] encrypt(byte[] plain , byte[] key, byte[] initializationVector) {
        try {
            Cipher ecipher = null;
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(initializationVector);
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ecipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);

            return ecipher.doFinal(plain);
        } catch (Exception e) {
            AirQuickUtils.log.e("AesCipher" , e);
        }
        return null;
    }

    /**
     * CBC mode, PKCS5 Padding.
     *
     * @param encoded
     *            Decode target, Encrypted state.
     * @param key
     * @param initializationVector
     *            CBC requires an initialization vector.
     * @return decrypt array
     */
    public byte[] decrypt(byte[] encoded , byte[] key, byte[] initializationVector) {
        try {
            Cipher dcipher = null;
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(initializationVector);
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

            dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            dcipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);

            return dcipher.doFinal(encoded);
        } catch (Exception e) {
            AirQuickUtils.log.e("AesCipher" , e);
        }
        return null;
    }

    /**
     * Encode in base64
     *
     * @param toEncode String to be encoded
     * @param flags flags to encode the String
     * @return encoded String in base64
     */
    public static String encodeBase64(String toEncode, int flags) {
        return privateBase64Encoder(toEncode, flags);

    }

    /**
     * Encode in base64
     *
     * @param toEncode String to be encoded
     * @return encoded String in base64
     */
    public static String encodeBase64(String toEncode) {
        return privateBase64Encoder(toEncode, -1);
    }

    /**
     * private Encoder in base64
     *
     * @param toEncode String to be encoded
     * @param flags flags to encode the String
     * @return encoded String in base64
     */
    private static String privateBase64Encoder(String toEncode, int flags) {
        byte[] data = null;
        try {
            data = toEncode.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        if (flags == -1) {
            flags = Base64.DEFAULT;
        }

        return Base64.encodeToString(data, flags);
    }

    /**
     * Decode in base64
     *
     * @param toDecode String to be encoded
     * @return decoded String in base64
     */
    public static String decodeBase64(String toDecode) {
        return privateBase64Decoder(toDecode, -1);
    }

    /**
     * Decode in base64
     *
     * @param toDecode String to be encoded
     * @param flags flags to decode the String
     * @return decoded String in base64
     */
    public static String decodeBase64(String toDecode, int flags) {
        return privateBase64Decoder(toDecode, flags);
    }

    /**
     * Private decoder in base64
     *
     * @param toDecode String to be encoded
     * @param flags flags to decode the String
     * @return decoded String in base64
     */
    private static String privateBase64Decoder(String toDecode, int flags) {
        if (flags == -1) {
            flags = Base64.DEFAULT;
        }

        byte[] data1 = Base64.decode(toDecode, flags);
        String decodedBase64 = null;
        try {
            decodedBase64 = new String(data1, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return decodedBase64;
    }

    /**
     * Calculate the MD5 of a given String
     *
     * @param string String to be MD5'ed
     * @return MD5'ed String
     */
    public static String calculateMD5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);

        for (byte b : hash) {
            int i = (b & 0xFF);
            if (i < 0x10)
                hex.append('0');
            hex.append(Integer.toHexString(i));
        }

        return hex.toString();
    }

    /**
     * Calculate the SHA-1 of a given String
     *
     * @param string String to be SHA1'ed
     * @return SHA1'ed String
     */
    public static String calculateSHA1(String string) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            AirQuickUtils.log.e("NoSuchAlgorithmException", e);
        }
        try {
            md.update(string.getBytes("iso-8859-1"), 0, string.length());
        } catch (UnsupportedEncodingException e) {
            AirQuickUtils.log.e("UnsupportedEncodingException", e);

        }
        byte[] sha1hash = md.digest();
        return convertToHex(sha1hash);
    }

    /**
     *  convert, byte[] to Hex
     *
     * @param data
     * @return
     */
    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }


    /**
     * Get byte[] to hex String
     *
     * @param raw
     * @return
     */
    public static String getHexString(byte[] raw) {
        byte[] HEX_STRING_TABLE = { (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7', (byte) '8', (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f' };
        byte[] hex = new byte[2 * raw.length];
        int index = 0;

        for (byte b : raw) {
            int v = b & 0xFF;
            hex[index++] = HEX_STRING_TABLE[v >>> 4];
            hex[index++] = HEX_STRING_TABLE[v & 0xF];
        }
        try {
            return new String(hex, "ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * hex To bytArray
     *
     * @param hex hex String value
     * @return byte[]
     */
    public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }

        byte[] ba = new byte[hex.length() / 2];
        try {
            for (int i = 0; i < ba.length; i++) {
                ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
            }
        } catch (NumberFormatException e) {
			/*
			 * added check for play store crash issue 13-dec-2013.
			 * cause :java.lang.NumberFormatException Invalid int: "nu"
			 */
            AirQuickUtils.log.e("AesCipher , hexToByteArray() input string param hex format not proper");
            AirQuickUtils.log.e("AesCipher" , e);
            return null;
        }
        return ba;
    }


    /**
     * Get the AES key
     *
     * @param hexKey key string
     * @return byte[]
     */
    public static byte[] getAESKey(String hexKey) {
        byte[] setKey = hexToByteArray(hexKey);

        if (setKey == null) {
            AirQuickUtils.log.e("key value is null, AesCipher");
            return "".getBytes();
        }

        byte[] key = new byte[setKey.length / 2];
        System.arraycopy(setKey, 0, key, 0, setKey.length / 2);
        return key;
    }


    /**
     * Obtain the AES encryption Initialization parameter value.
     *
     * @param hexKey
     * @return
     */
    public static byte[] getInitializationVector(String hexKey) {
        byte[] setKey = hexToByteArray(hexKey);

        if (setKey == null) {
            Log.d("ERROR", "setKey value is null , AesCipher");
            return "".getBytes();
        }

        byte[] initializationVector = new byte[setKey.length / 2];
        System.arraycopy(setKey, 16, initializationVector, 0, setKey.length / 2);
        return initializationVector;
    }


    /**
     * Encrypts with SHA-256
     *
     * @param value String to encrypt
     * @return
     */
    private static String getSHA256(String value){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(value.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception e){
            AirQuickUtils.log.e("ERROR" , e);
            return "";
        }
    }
}
