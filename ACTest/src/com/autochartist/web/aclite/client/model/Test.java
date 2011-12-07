package com.autochartist.web.aclite.client.model;
import java.io.Serializable;
import java.util.ArrayList;


public class Test implements Serializable {
	
	
	private static ArrayList<Long> getPatterns(long patternId) {
		ArrayList<Long> patterns = new ArrayList<Long>();
		long sum = patternId;
		while (sum > 0) {
			long pattern = getMaxPow2(sum);
			patterns.add(pattern);
			sum = sum - pattern;
		}
		return patterns;
	}
	
	public static long getMaxPow2(long x) {
		int twoToThePowerOf = 0;
		long power = (long)Math.pow(2, twoToThePowerOf);
		while (power <= x) {
			twoToThePowerOf ++;
			power = (long)Math.pow(2, twoToThePowerOf);
		}
		return (long) Math.pow(2,(twoToThePowerOf - 1));
	}
	
	public static void main(String[] args) {
		ArrayList<Long> patterns = getPatterns((long)Math.pow(2, 3) + (long)Math.pow(2, 5) + (long)Math.pow(2, 0));
		System.out.println(patterns);
	}

}
