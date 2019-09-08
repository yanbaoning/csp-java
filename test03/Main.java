package test03;

import java.util.Scanner;

/**
 * ��ʮ�ĵ�����
 *<p>Title:Main.java</p>
 *<p>Description:
 *	������ʽ�������������24���бȽϣ����ϵĻ������true
 *</p>
 * @author YBN
 * @date: 2019��9��8��
 */
public class Main {
	
	public static void main(String[] args) {
		//�ӱ�׼�����������
		Scanner sc = new Scanner(System.in);
		//��һ������һ������n
		int n = sc.nextInt();
		//��2��n+1��ÿ������һ��7λ���ȵ��ַ���
		//����һ���ַ������飬�������ÿ��������ַ���,��СΪn
		String[] s = new String[n];
		for(int i = 0;i < n; i++) {
			s[i] = sc.next();
		}
		for(int j = 0;j < n;j++) {
			judge(s[j]);
		}
	}

	private static void judge(String s) {
		//���������ַ�������Ϊ7
		//��������λ��index
		int index = 0;
		//��ȡ�ĵ����ַ�
		char ch = ' ';
		//����ѭ������
		boolean loop = true;
		//��������ջ������ջ�ͷ���ջ
		int[] numStack = new int[10];
		char[] operStack = new char[10];
		//������ջ��top����
		int top1 = -1;
		int top2 = -1;
		//��������������������
		int num1 = 0;
		int num2 = 0;
		int sum = 0;
		while(loop) {
			ch = s.charAt(index);
			//���Ϊ�������Ļ�������
			if(isOper(ch)) {
				if(isEmpty(operStack, top2)) {
					operStack[++top2] = ch;
					
				}else {
					//������գ����ж���ջ��Ԫ�ص����ȼ��Ƚ�
					int priority = priority(ch, top2, operStack);
					switch (priority) {
					case 0:
						num2 = numStack[top1];
						num1 = numStack[--top1];
						sum = total(num1, num2, operStack[top2]);
						numStack[top1] = sum;
						operStack[top2] = ch;
						break;
					case 1:
						operStack[++top2] = ch;
						break;
					default:
						break;
					}
				}
			}else {		//���������Ϊ���֣�ֱ����ջ
				//�ж�ջ�պ�ջ��,Ϊtrue��ʾ���Բ�������
				if(isEmpty(numStack, top1)) {
					//charΪ�ַ�����ӦASCII���Ӧ��ȥ48��
					numStack[++top1] = ch-48;
				}else {
					System.out.println("ջ��");
				}
			}
			index++;
			if(index >= s.length()) {
				loop = false;
			}
		}
		//����ջ
		/*for(int i:numStack) {
			System.out.println(i);
		}
		for(char c:operStack) {
			System.out.println(c);
		}*/
		sum = 0;
		while(top1 != 0) {
			num2 = numStack[top1];
			num1 = numStack[--top1];
			numStack[top1] = total(num1, num2, operStack[top2--]);
		}
		if(numStack[0]==24) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	//�Ƿ�Ϊ������
	public static boolean isOper(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}else {
			return false;
		}
	}
	//�ж�����ջ�գ�
	public static boolean isEmpty(int[] num,int top) {
		if(top>num.length) {
			return false;
		}else {
			return true;
		}
	}
	//�ж�operationջ�Ƿ�գ�
	public static boolean isEmpty(char[] c,int top) {
		if(top==-1) {
			return true;
		}else {
			return false;
		}
	}
	//�ж����ȼ���Ϊ0��ͣ�Ϊ1���
	public static int priority(char ch,int top2,char[] oper) {
		switch (ch) {
		case '*':
		case '/':
		case '+':
		case '-':
			if(oper[top2] == '*' || oper[top2] == '/') {
				return 0;
			}else {
				return 1;
			}
		default:
			throw new RuntimeException("����������");
		}
	}
	//������
	public static int total(int num1,int num2,char op) {
		switch (op) {
		case '+':
			return num1+num2;
		case '-':
			return num1-num2;
		case '*':
			return num1*num2;
		case '/':
			return num1/num2;
		default:
			return 0;
		}
	}
}
