package heft;

import java.util.*;
/*
实现降序，v序的,实现compare接口;
实现交换两个位置的元素
实现堆排序，找出最大的几个数


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
	
	//打印二维数组
	public static void printTwoDimenArray(int[][] arr){
		int row=arr.length;//行
		int col=arr[0].length;
		System.out.print("{");
		for(int i=0;i<row-1;i++){
			System.out.print(Arrays.toString(arr[i]));
			System.out.print(" , ");
		}
		System.out.println(Arrays.toString(arr[row-1])+"}");
	}
	
	//转换ArrayList<Integer> to int[],如果为空，返回-1
	public static int[] ArrayListToInt(ArrayList<Integer> al){
		int[] result=new int[al.size()];
		if(al.isEmpty()){
			result[0]=-1;//考虑换成异常
		}
		else{//ArrayList<Integer>无法直接转换为int[],String 是可以的，所以只能循环了
			for(int i=0;i<al.size();i++){
				result[i]=al.get(i);
			}
		}
		return result;
	}
	
    /*给定区间[beg,end)，找到所有等于val的元素的下标
    */
	public static int[] findInt(int[] arr,int beg,int end,int val){
		ArrayList<Integer> al=new ArrayList<Integer>();
		//找到val，放到al中
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
