package test01;

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
		//������ r��y��g����ʾ���̵Ƶ�����
		int r = sc.nextInt();
		int y = sc.nextInt();
		int g = sc.nextInt();
		//n��ʾС���ܹ������ĵ�·�����Ϳ����ĺ��̵���Ŀ
		int n = sc.nextInt();
		//k=0 ��ʾ������һ�ε�·����ʱ t ��
		//k=1��2��3 ʱ���ֱ��ʾ������һ����ơ��Ƶơ��̵�
		//�ҵ���ʱ��ʾ������ʾ�������� t
		for(int i=1;i<=n;i++) {
			int k = sc.nextInt();
			int t = sc.nextInt();
			switch(k) {
			case 0:		//0��ʾ����t��·
				sumtime+=road(t);
				break;
			case 1:		//1��ʾ���t��
				sumtime+=red(t);
				break;
			case 2:		//2��ʾ�Ƶ�t��
				sumtime+=yellow(t,r);
				break;
			case 3:		//3��ʾ�̵�t��
				sumtime+=green();
				break;
			}
		}
		System.out.println(sumtime);
	}

}