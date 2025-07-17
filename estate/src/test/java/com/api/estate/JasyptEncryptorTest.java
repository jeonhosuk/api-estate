package com.api.estate;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptEncryptorTest {
    public static void main(String[] args) {
        StringEncrypt("jdbc:log4jdbc:mariadb://218.237.65.224:3306/modubiz");    // URL
        StringEncrypt("rfs_app");                              // Username
        StringEncrypt("P5PGWJhSHRC3S0R");                          // Password
    }

    private static void StringEncrypt(String plainText) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("r114"); // 암호화 키 - JasyptConfig에서 사용할 비밀번호
        encryptor.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘은 Config와 동일하게

        String encrypted = encryptor.encrypt(plainText);
        System.out.println("원문: " + plainText);
        System.out.println("암호화: ENC(" + encrypted + ")");
        System.out.println("----------------------------------");
    }
}
