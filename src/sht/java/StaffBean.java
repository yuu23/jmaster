package sht.java;

import java.io.Serializable;

public class StaffBean implements Serializable {
	//	インスタンス変数（フィールド）
	private String name;
	private int age;
	private String department;

	// 引数なしのコンストラクタ
	public StaffBean() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public StaffBean(String name,int age,String department) {
		this.name = name;
		this.age = age;
		this.department = department;
	}

	StaffBean bean1 = new StaffBean("山田",20,"営業部");
	StaffBean bean2 = new StaffBean("田中",22,"管理部");

}
