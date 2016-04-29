package com.homework.dog;

import java.util.Scanner;
/**
	学生信息管理系统
	管理学生信息的（增删改查）
	单个学生信息保存到哪里？	学生对象
	所有的学生信息保存到哪里？	数组中
*/
public class Sms{
	private Dog[] dogs = new Dog[3];//用于保存狗对象
	private int index;	//记录数组中实际狗的个数

	/**
	 * 添加狗信息
	   save 
	     stus[0] = stu;  index = 1
		 stus[1] = stu;  index = 2
		 stus[2] = stu;	 index = 3
		 stus[3]
	 */
	public void save(Dog dog){
		if(index >= dogs.length){
			//数组的扩展
			Dog[] demo = new Dog[dogs.length+3];
			System.arraycopy(dog,0,demo,0,index);
			dogs = demo;
		}
		dogs[index++] = dog;
	}

    /**
	 *修改学生信息
	 stus = {
		1001 terry,
		1003 tom3,
		1004 tom4,
		1005 tom5,
		1006 tom6,
		null
	 }
		1006 terry
	 */
	public void update(Dog dog){
		for(int i=0;i<index;i++){
			if(dog.getNo() == dogs[i].getNo()){
				dogs[i].setName(dog.getName());
			}
		}
	}

	/**
	 *删除学生信息
	 stus = new Student[6];
	 stus = {
		1001 terry,
		1003 tom3,
		1004 tom4,
		1005 tom5,
		1006 tom6,
		null
	 }
	 index = 6;
	 1002    num = 1;
	 for(int i=1;i<5;i++){
		stus[i] = stus[i+1]
		//stus[4] = stus[5]

	 }
	 */
    public void deleteByNo(long no){
		int num = getIndexByNo(no);
		for(int i=num ;i<index-1;i++){
			dogs[i] = dogs[i+1];
		}
		dogs[--index] = null;
	}

	/**
	 *查询所有学生信息
	 */
	public Dog[] queryAll(){
		Dog[] demo = new Dog[index];
		System.arraycopy(dogs,0,demo,0,index);
		return demo;
	}

	/**
	 *通过id查找学生信息

	 */
	public Dog queryByNo(long no){
		int num = getIndexByNo(no);
		return num==-1?null:dogs[num];
	}

	/**
	 根据学生对象的id获取该学生对象在数组中的索引
	 stus = new Student[3];
	 1001 terry
	 1002 larry
	 null 

	 1003
	*/
	private int getIndexByNo(long no){
		int num = -1;
		for(int i=0;i<index;i++){
			if(dogs[i].getNo() == no){
				num = i;
				break;
			}
		}
		return num;
	}

	/**
	 * 菜单
  	 */
	public void menu(){
		System.out.println("********狗信息管理系统********");
		System.out.println("*1 查询所有狗信息");
		System.out.println("*2 录入狗信息");
		System.out.println("*3 删除狗信息");
		System.out.println("*4 通过编号查找狗信息");
		System.out.println("*5 修改狗信息");
		System.out.println("*exit 退出系统！");
		System.out.println("*help 获取帮助");
		System.out.println("********************************");
	}

	public static void main(String[] args){
		Sms sms = new Sms();
		sms.menu();
		//扫描器对象
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("*请输入对应指令:");
			String option = sc.nextLine();
			switch(option){
				case "1":	//查询所有
					System.out.println("以下是所有狗的信息：");
					Dog[] dog1 = sms.queryAll();
					for(Dog in : dog1){
						System.out.println(dog1);
					}
					System.out.println("总共查询到"+sms.index+"个狗");
					break;
				case "2":	//录入
					while(true){
						System.out.println("请输入狗的信息【no#name#age】或输入【break】返回上一级目录");
						String dogStr = sc.nextLine();
						if(dogStr.equals("break")){
							break;//返回到上一级目录
						}
						//stuStr 1001#terry#12字符串 ->对象->数组
						String[] dogArr = dogStr.split("#");
						//将数组中个元素转换为学生属性所需要的数据类型
						long no  = Long.parseLong(dogArr[0]);
						String name = dogArr[1];
						int price = Integer.parseInt(dogArr[2]);
						//封装对象
						//Dog dogs = new Dog(no,name,age);
						//Sms.save(dog[]);//
						System.out.println("保存成功！");
					}
					break;
				case "3":	//删除
					while(true){
						System.out.println("请输入要删除狗的编号,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//查询要删除的学生信息是否存在
						Dog dog = sms.queryByNo(no);
						if(dog==null){
							System.out.println("您要删除的狗信息不存在！");
							continue;
						}
						sms.deleteByNo(no);
						System.out.println("删除成功！");
					}	
					break;
				case "4":	//通过id获取
					while(true){
						System.out.println("请输入要查找狗的no,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						Dog dog = sms.queryByNo(no);
						System.out.println(dog==null?"sorry,not found!":dog);
					}	
					break;
				case "5":	//修改
					while(true){
						System.out.println("请输入要修改狗的编号,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//查询要删除的学生信息是否存在
						Dog dog = sms.queryByNo(no);
						if(dog==null){
							System.out.println("您要修改的狗信息不存在！");
							continue;
						}
						System.out.println("原信息为："+dog);
						System.out.println("请输入新信息【name#age】：");
						// tom#12
						String str = sc.nextLine();
						String[] dogArr = str.split("#");
						String name = dogArr[0];
						int age = Integer.parseInt(dogArr[1]);
						Dog newDog = new Dog(no,name,age);
						sms.update(newDog);
						System.out.println("修改成功！");
					}	
					break;
				case "exit":
					System.out.println("bye bye,欢迎再次使用！");
					System.exit(0);
				case "help":
					sms.menu();
					break;
				default:
					System.out.println("输入错误！");

			}
		}
	}
}