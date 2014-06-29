package com.slgerkamp.mkjavaalgorithm.recursive;

public class Loop {
	public static void main(String[] args) {
		int [] numArray = {0,1,2,3,4};
		for(int i : numArray){
			for(int j : numArray){
				for(int k : numArray){
					for(int l : numArray){
						System.out.println(i + " " + j + " " + k + " " + l + " ");
					}	
				}	
			}			
		}
	}
}
