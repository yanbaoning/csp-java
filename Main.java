package test02;

import java.util.Scanner;

public class Main {
	public static int road(int t) {
		return t;
	}
	public static int red(int t) {
		return t;
	}
	public static int green() {
		return 0;
	}
	public static int yellow(int t,int r) {
		return t+r;
	}
	/*
	 * ����ĵ�һ�а����ո�ָ������������� r��y��g����ʾ���̵Ƶ����á����������������� 106��
��������ĵڶ��а���һ�������� n��n �� 100������ʾС���ܹ������ĵ�·�����Ϳ����ĺ��̵���Ŀ��
	
������������ n �У�ÿ�а����ո�ָ����������� k��t��k=0 ��ʾ������һ�ε�·����ʱ t �룬�˴� t ������ 106��
	k=1��2��3 ʱ���ֱ��ʾ������һ����ơ��Ƶơ��̵ƣ��ҵ���ʱ��ʾ������ʾ�������� t���˴� t �ֱ𲻻ᳬ�� r��y��g��
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//������ʱ��
		int sumtime=0;
		//ͬ��ʱ��
		int currenttime=0;
		//������ r��y��g����ʾ���̵Ƶ�����
		int r = sc.nextInt();
		int y = sc.nextInt();
		int g = sc.nextInt();
		int T=r+y+g;
		//n��ʾС���ܹ������ĵ�·�����Ϳ����ĺ��̵���Ŀ
		int n = sc.nextInt();
		//k=0 ��ʾ������һ�ε�·����ʱ t ��
		//k=1��2��3 ʱ���ֱ��ʾ������һ����ơ��Ƶơ��̵�
		//�ҵ���ʱ��ʾ������ʾ�������� t
		for(int i=1;i<=n;i++) {
			int k = sc.nextInt();
			int t = sc.nextInt();
			currenttime=sumtime%T;
			switch(k) {
			case 0:		//0��ʾ����t��·
				sumtime+=road(t);
				break;
			case 1:		//1��ʾ���t��
				if(currenttime>t && currenttime<t+g) {
					
				}else if(currenttime<t) {
					sumtime+=t-sumtime;
				}else if(currenttime>=t+g) {
					sumtime+=t+g+y+r-currenttime;
				}
				break;
			case 2:		//2��ʾ�Ƶ�t��
				if(currenttime>=t+r&&currenttime<t+r+g) {
					
				}else if(currenttime<t+r) {
					sumtime+=t+r-currenttime;
				}else if(currenttime>=t+r+g) {
					sumtime+=t+r+g+y+r-currenttime;
				}
				break;
			case 3:		//3��ʾ�̵�t��
				//sumtime+=green();
				if(sumtime>=t && sumtime<t+y+r) {
					sumtime+=t+y+r-sumtime;
				}
				break;
			}
		}
		System.out.println(sumtime);
	}

}
