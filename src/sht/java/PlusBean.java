package sht.java;

import java.io.Serializable;

public class PlusBean implements Serializable {
	private int value1;
	private int value2;
	private int answer;

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}
	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public PlusBean() {

	}

	public PlusBean(int vaue1,int value2,int answer) {
		this.value1 = value1;
		this.value2 = value2;
		this.answer = answer;
	}
}