package Util;

import java.security.SecureRandom;

public class RandomGenerator {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

   public static String randomStringGenerator() {

       int length = SECURE_RANDOM.nextInt(4,30);
       StringBuilder sb = new StringBuilder(length);
       for (int i = 0; i < length; i++) {
           sb.append(ALPHABET.charAt(SECURE_RANDOM.nextInt(ALPHABET.length())));
       }
       return sb.toString();
   }

}
