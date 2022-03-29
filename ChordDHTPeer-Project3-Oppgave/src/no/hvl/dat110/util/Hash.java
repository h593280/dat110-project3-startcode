package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) throws NoSuchAlgorithmException {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
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
		// return the BigInteger
		 
		return hashint;
	}
	
	public static BigInteger addressSize() throws NoSuchAlgorithmException {
		
		// Task: compute the address size of MD5
		MessageDigest md = MessageDigest.getInstance("MDS");
		// get the digest length
		int digestLenght = md.getDigestLength();
		// compute the number of bits = digest length * 8
		digestLenght = digestLenght*8;
		// compute the address size = 2 ^ number of bits
		digestLenght = (int)Math.pow(2, digestLenght);
		// return the address size
		String adress = ""+digestLenght;
		
		return new BigInteger(adress);
	}
	
	public static int bitSize() throws NoSuchAlgorithmException {
		
		int digestlen = 0;
		
		// find the digest length
		MessageDigest md = MessageDigest.getInstance("MD5");
		digestlen = md.getDigestLength();
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
