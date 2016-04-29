package com.homework.dog;

/**
  学生类是用来创建学生对象的，学生对象是用来存储该学生的信息的
*/
public class Dog{
	private long no;
	private String name;
	private int age;

	
	public Dog(long no,String name,int age){
		this.no = no;
		this.name = name;
		this.age = age;
	}
	public void setNo(long no){
		this.no = no;
	}
	public long getNo(){
		return this.no;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}

	public String toString(){
		return "Dog[no:"+this.no+",name:"+this.name+",age:"+this.age+"]";
	}
}