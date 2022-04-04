package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */


import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity)  {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(entity.getBytes());
			// compute the hash of the input 'entity'
			byte[] digest = md.digest();
			// convert the hash into hex format
			StringBuffer sb = new StringBuffer();
			// convert the hex into BigInteger
			for(byte b: digest) {
				sb.append(String.format("%02X", b & 0xff));
			}
			hashint = new BigInteger(sb.toString(), 16);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hashint;
		
	}
	
	public static BigInteger addressSize() {
		 
		
		BigInteger addressSize = null;
		
		try {
			// Task: compute the address size of MD5
			int digestLenght = MessageDigest.getInstance("MD5").getDigestLength();
			// get the digest length
			// compute the number of bits = digest length * 8
			digestLenght = digestLenght * 8;
			// compute the address size = 2 ^ number of bits
			BigInteger bi = new BigInteger("2");
			addressSize = bi.pow(digestLenght);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return addressSize;
	
	}
	
	public static int bitSize()  {
		
		int digestlength = 0;
		
		// find the digest length
		
		try {
			digestlength = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return digestlength*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
