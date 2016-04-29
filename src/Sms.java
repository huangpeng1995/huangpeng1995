package com.homework.dog;

import java.util.Scanner;
/**
	ѧ����Ϣ����ϵͳ
	����ѧ����Ϣ�ģ���ɾ�Ĳ飩
	����ѧ����Ϣ���浽���	ѧ������
	���е�ѧ����Ϣ���浽���	������
*/
public class Sms{
	private Dog[] dogs = new Dog[3];//���ڱ��湷����
	private int index;	//��¼������ʵ�ʹ��ĸ���

	/**
	 * ��ӹ���Ϣ
	   save 
	     stus[0] = stu;  index = 1
		 stus[1] = stu;  index = 2
		 stus[2] = stu;	 index = 3
		 stus[3]
	 */
	public void save(Dog dog){
		if(index >= dogs.length){
			//�������չ
			Dog[] demo = new Dog[dogs.length+3];
			System.arraycopy(dog,0,demo,0,index);
			dogs = demo;
		}
		dogs[index++] = dog;
	}

    /**
	 *�޸�ѧ����Ϣ
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
	 *ɾ��ѧ����Ϣ
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
	 *��ѯ����ѧ����Ϣ
	 */
	public Dog[] queryAll(){
		Dog[] demo = new Dog[index];
		System.arraycopy(dogs,0,demo,0,index);
		return demo;
	}

	/**
	 *ͨ��id����ѧ����Ϣ

	 */
	public Dog queryByNo(long no){
		int num = getIndexByNo(no);
		return num==-1?null:dogs[num];
	}

	/**
	 ����ѧ�������id��ȡ��ѧ�������������е�����
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
	 * �˵�
  	 */
	public void menu(){
		System.out.println("********����Ϣ����ϵͳ********");
		System.out.println("*1 ��ѯ���й���Ϣ");
		System.out.println("*2 ¼�빷��Ϣ");
		System.out.println("*3 ɾ������Ϣ");
		System.out.println("*4 ͨ����Ų��ҹ���Ϣ");
		System.out.println("*5 �޸Ĺ���Ϣ");
		System.out.println("*exit �˳�ϵͳ��");
		System.out.println("*help ��ȡ����");
		System.out.println("********************************");
	}

	public static void main(String[] args){
		Sms sms = new Sms();
		sms.menu();
		//ɨ��������
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("*�������Ӧָ��:");
			String option = sc.nextLine();
			switch(option){
				case "1":	//��ѯ����
					System.out.println("���������й�����Ϣ��");
					Dog[] dog1 = sms.queryAll();
					for(Dog in : dog1){
						System.out.println(dog1);
					}
					System.out.println("�ܹ���ѯ��"+sms.index+"����");
					break;
				case "2":	//¼��
					while(true){
						System.out.println("�����빷����Ϣ��no#name#age�������롾break��������һ��Ŀ¼");
						String dogStr = sc.nextLine();
						if(dogStr.equals("break")){
							break;//���ص���һ��Ŀ¼
						}
						//stuStr 1001#terry#12�ַ��� ->����->����
						String[] dogArr = dogStr.split("#");
						//�������и�Ԫ��ת��Ϊѧ����������Ҫ����������
						long no  = Long.parseLong(dogArr[0]);
						String name = dogArr[1];
						int price = Integer.parseInt(dogArr[2]);
						//��װ����
						//Dog dogs = new Dog(no,name,age);
						//Sms.save(dog[]);//
						System.out.println("����ɹ���");
					}
					break;
				case "3":	//ɾ��
					while(true){
						System.out.println("������Ҫɾ�����ı��,��������break������һ��Ŀ¼");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//��ѯҪɾ����ѧ����Ϣ�Ƿ����
						Dog dog = sms.queryByNo(no);
						if(dog==null){
							System.out.println("��Ҫɾ���Ĺ���Ϣ�����ڣ�");
							continue;
						}
						sms.deleteByNo(no);
						System.out.println("ɾ���ɹ���");
					}	
					break;
				case "4":	//ͨ��id��ȡ
					while(true){
						System.out.println("������Ҫ���ҹ���no,��������break������һ��Ŀ¼");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						Dog dog = sms.queryByNo(no);
						System.out.println(dog==null?"sorry,not found!":dog);
					}	
					break;
				case "5":	//�޸�
					while(true){
						System.out.println("������Ҫ�޸Ĺ��ı��,��������break������һ��Ŀ¼");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//��ѯҪɾ����ѧ����Ϣ�Ƿ����
						Dog dog = sms.queryByNo(no);
						if(dog==null){
							System.out.println("��Ҫ�޸ĵĹ���Ϣ�����ڣ�");
							continue;
						}
						System.out.println("ԭ��ϢΪ��"+dog);
						System.out.println("����������Ϣ��name#age����");
						// tom#12
						String str = sc.nextLine();
						String[] dogArr = str.split("#");
						String name = dogArr[0];
						int age = Integer.parseInt(dogArr[1]);
						Dog newDog = new Dog(no,name,age);
						sms.update(newDog);
						System.out.println("�޸ĳɹ���");
					}	
					break;
				case "exit":
					System.out.println("bye bye,��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
				case "help":
					sms.menu();
					break;
				default:
					System.out.println("�������");

			}
		}
	}
}