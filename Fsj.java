package heft;

import java.util.*;
/*
ʵ�ֽ���v���,ʵ��compare�ӿ�;
ʵ�ֽ�������λ�õ�Ԫ��
ʵ�ֶ������ҳ����ļ�����


*/

public class Fsj {
	public static void main(String[] args){
		int[] arr={1,2,2,3,4,3,4,2};
		int[][] arr2={{1,2,2,3},
					 {4,3,4,2},
					 {4,3,4,2}};
		//System.out.println(findInt(arr,2,6,3)[0]);
		//System.out.print(Arrays.toString(arr));
		printTwoDimenArray(arr2);
	}
	
	//��ӡ��ά����
	public static void printTwoDimenArray(int[][] arr){
		int row=arr.length;//��
		int col=arr[0].length;
		System.out.print("{");
		for(int i=0;i<row-1;i++){
			System.out.print(Arrays.toString(arr[i]));
			System.out.print(" , ");
		}
		System.out.println(Arrays.toString(arr[row-1])+"}");
	}
	
	//ת��ArrayList<Integer> to int[],���Ϊ�գ�����-1
	public static int[] ArrayListToInt(ArrayList<Integer> al){
		int[] result=new int[al.size()];
		if(al.isEmpty()){
			result[0]=-1;//���ǻ����쳣
		}
		else{//ArrayList<Integer>�޷�ֱ��ת��Ϊint[],String �ǿ��Եģ�����ֻ��ѭ����
			for(int i=0;i<al.size();i++){
				result[i]=al.get(i);
			}
		}
		return result;
	}
	
    /*��������[beg,end)���ҵ����е���val��Ԫ�ص��±�
    */
	public static int[] findInt(int[] arr,int beg,int end,int val){
		ArrayList<Integer> al=new ArrayList<Integer>();
		//�ҵ�val���ŵ�al��
		for(int i=beg;i<end;i++){
			if(arr[i]==val){
				al.add(i);
			}
		}
		int[] result=new int[al.size()];
		result=ArrayListToInt(al);
		return  result;
	}
	
}
