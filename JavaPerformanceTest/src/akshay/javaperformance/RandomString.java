package akshay.javaperformance;

import java.util.Random;

public class RandomString {
	
	private String s;
	private int num;

	public RandomString(int i, int j){
    Random r = new Random();
    long l = Math.abs(r.nextLong());
    this.s = java.lang.Long.toString(l,36);
    this.num = i + j;
	}
	
	public int getNum() {
		return num;
	}

	public String getS() {
		return s;
	}
}