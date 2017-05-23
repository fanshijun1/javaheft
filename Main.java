/*package heft;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int[][] matrix=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int start=0;
        while(col>start*2&&row>start*2){
            PrintMatrixInCircle(matrix,row,col,start);
            start++;
        }
        
    }
    public static void PrintMatrixInCircle(int[][] matrix,int row,int col,int start){
        int endX=col-1-start;
        int endY=row-1-start;
        
        for(int i=start;i<=endX;++i){
            System.out.print(matrix[start][i]+" ");
        }
        
        if(start<endY){
            for(int i=start+1;i<=endY;i++){
                System.out.print(matrix[i][endX]+" ");
            }
        }
        
        if(start<endX&&start<endY){
            for(int i=endX-1;i>=start;i--){
                System.out.print(matrix[endY][i]+" ");
            }
        }
        
        if(start<endX&&start<endY-1){
            for(int i=endY-1;i>=start+1;i--){
                System.out.print(matrix[i][start]+" ");
            }
        }
    }
}*/
package heft;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int num=0;
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        if(len==1)
        	num=1;
       int start=0;
        while(len>1&&start!=(-1)){
            start=find(arr,start);
            num+=1;
        }
        System.out.println(num);
    }
    public  static int find(int[] arr,int start){

        int cur=arr[start];
        int result;
   	    if(start==(arr.length-1))
   	    	result=-1;
   	    else
        start+=1;
        
        int next=arr[start];
        while(start<(arr.length-1)&&next==cur){
            start+=1;
            next=arr[start];
            if(start==(arr.length-1))
               result=-1;
        }
        if(start<(arr.length-1)&&next>start){
            while(start<(arr.length-1)&&next>=start){
                start+=1;
                next=arr[start];
            }
            if(start==(arr.length-1))
               result=-1;
            else
            result=start+1;
            
        }
        else{
            while(start<(arr.length-1)&&next<=start){
                start+=1;
                next=arr[start];
            }
            if(start==(arr.length-1))
               result=-1;
            else   
            result=start+1;
        }
        return result;
    }
}