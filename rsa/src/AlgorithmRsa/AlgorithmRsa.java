package AlgorithmRsa;

import java.math.BigInteger;
//import java.security.SecureRandom;
    

public class AlgorithmRsa {
   private final static BigInteger one      = new BigInteger("1");
 //  private final static SecureRandom random = new SecureRandom();

   private BigInteger privateKey;
   private BigInteger publicKey;
   private BigInteger modulus;

   // generate an N-bit (roughly) public and private key
   AlgorithmRsa(int N , String publ, BigInteger pp, BigInteger qq) {
      BigInteger p = pp;
      BigInteger q = qq;
      BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

      modulus    = p.multiply(q);                                  
      publicKey  = new BigInteger(publ);     // common value in practice = 2^16 + 1
      privateKey = publicKey.modInverse(phi);
    // privateKey = new BigInteger("8462903");
    // System.out.println(phi);
   }


   BigInteger encrypt(BigInteger message) {
      return message.modPow(publicKey, modulus);
   }

   BigInteger decrypt(BigInteger encrypted) {
      return encrypted.modPow(privateKey, modulus);
   }

   public String toString() {
      String s = "";
      s += "public  = " + publicKey  + "\n";
      s += "private = " + privateKey + "\n";
      s += "modulus = " + modulus;
      return s;
   }
 
   public static void main(String[] args) {
     new RSA ();
   }
}