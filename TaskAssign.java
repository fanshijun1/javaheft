package heft;

import java.util.*;

//�Լ������Լ���Ҫ�����ݽṹ����������Ӧ179��֮��Ĵ���
//java ������ȱ�����һ���ڵ�ֻ�ܴ洢һ��Ԫ�أ����Խ����Ԫ��Ū����
class ListNode{
	public int WF;
	public int task;
	public boolean isRead=false;
	public ListNode next=null;
	ListNode(){}
	ListNode(int WF,int task){
		this.WF=WF;
		this.task=task;
	}
	//toString ���Ǵ�ӡ�б�����б��к�̽ڵ㣬��ô�ͻ�������б���ӡ������������
	public String toString(){
		ListNode temp=new ListNode();
		temp=this;
		String result=new String();
		result="["+temp.WF+" , "+temp.task+"]";
		while(temp.next!=null){
			temp=temp.next;
			result+=", ["+temp.WF+" , "+temp.task+"]";
		}
		return result;
		//return "["+ WF+" , "+task+"]";
	}
}
public class TaskAssign {
	//�ڲ��� ��ʾ��������������
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������Ϣ¼��		
		double B=Math.pow(10, 6);//System.out.println(B);1000000
		double Scu=Math.pow(10, 5);
		int K=10;
		double Sap=Scu/K;
		//ǰ�����ڵ���Ϣ,�൱�ڽ�������ͼ��¼��
		//WF1��ǰ��
		Map<Integer,int[]> pre1=new HashMap<Integer,int[]>();
		int[] pn11=null;    pre1.put(1, pn11);//pn��ʾpreNode,��һ��1��ʾ��һ�����������ڶ���1��ʾ��һ���ڵ㣻
		int[] pn12={1};     pre1.put(2, pn12);//System.out.println(pre1.get(2).length);
		int[] pn13={1};     pre1.put(3, pn13);
		int[] pn14={1};     pre1.put(4, pn14);
		int[] pn15={1};     pre1.put(5, pn15);
		int[] pn16={2,4};   pre1.put(6, pn16);
		int[] pn17={3,4};   pre1.put(7, pn17);
		int[] pn18={2,4,5}; pre1.put(8, pn18);
		int[] pn19={6,7,8}; pre1.put(9, pn19);
		int[] pn110={9};    pre1.put(10, pn110);
		//WF1�ĺ���succ1
		Map<Integer,int[]> succ1=new HashMap<Integer,int[]>();
		int[] sn11={2,3,4,5}; succ1.put(1, sn11);//sn��ʾsuccNode
		int[] sn12={6,8};     succ1.put(2, sn12);
		int[] sn13={7};       succ1.put(3, sn13);
		int[] sn14={6,7,8};   succ1.put(4, sn14);
		int[] sn15={8};       succ1.put(5, sn15);
		int[] sn16={9};		  succ1.put(6, sn16);
		int[] sn17={9};	 	  succ1.put(7, sn17);
		int[] sn18={9};		  succ1.put(8, sn18);
		int[] sn19={10};      succ1.put(9, sn19);
		int[] sn110=null;     succ1.put(10, sn110);
		//WF2��ǰ��pre2
		Map<Integer,int[]> pre2=new HashMap<Integer,int[]>();
		int[] pn21=null;    pre2.put(1, pn21);//pn��ʾpreNode,��һ��1��ʾ��һ�����������ڶ���1��ʾ��һ���ڵ㣻
		int[] pn22={1};	    pre2.put(2, pn22);//System.out.println(pre1.get(2).length);
		int[] pn23={1}; 	pre2.put(3, pn23);
		int[] pn24={1}; 	pre2.put(4, pn24);
		int[] pn25={3,4};   pre2.put(5, pn25);
		int[] pn26={2,3,4}; pre2.put(6, pn26);
		int[] pn27={4};   	pre2.put(7, pn27);
		int[] pn28={5,6}; 	pre2.put(8, pn28);
		int[] pn29={5,7};   pre2.put(9, pn29);
		int[] pn210={8,9};  pre2.put(10, pn210);
		//WF2�ĺ���
		Map<Integer,int[]> succ2=new HashMap<Integer,int[]>();
		int[] sn21={2,3,4};   succ2.put(1, sn21);//sn��ʾsuccNode
		int[] sn22={6};       succ2.put(2, sn22);
		int[] sn23={5,6};     succ2.put(3, sn23);
		int[] sn24={5,6,7};   succ2.put(4, sn24);
		int[] sn25={8,9};     succ2.put(5, sn25);
		int[] sn26={8};		  succ2.put(6, sn26);
		int[] sn27={9};	 	  succ2.put(7, sn27);
		int[] sn28={10};	  succ2.put(8, sn28);
		int[] sn29={10};      succ2.put(9, sn29);
		int[] sn210=null;     succ2.put(10, sn210);
		ArrayList<Map<Integer,int[]>>  pre=new ArrayList<Map<Integer,int[]>>();
		ArrayList<Map<Integer,int[]>> succ=new ArrayList<Map<Integer,int[]>>();
		pre.add(pre1);
		pre.add(pre2);
		succ.add(succ1);
		succ.add(succ2);
			
		//������¼��
		int[] I1={0,1339000,1383000,1336000,1378000,1037000,1059000,1088000,1755000,0};
		int[] I2={0,1215000,1473000,1512000,1394000,1798000,1032000,1154000,1192000,0};
		ArrayList<int[]> I=new ArrayList<int[]>();
		I.add(I1);
		I.add(I2);
		//������¼��,d1��ʾ�޷�wf1�Ĵ�������d2��ʾwf2�Ĵ�����
		int[][] d1={{0,1,1,1,1, 0,0,0,0,0},
				    {0,0,0,0,0, 8334624,0,8873456,0,0},
				    {0,0,0,0,0, 0,8517569,0,0,0},
				    {0,0,0,0,0, 7511132,8340796,8324756,0,0},
				    {0,0,0,0,0, 0,0,7853276,0,0},
				    
				    {0,0,0,0,0, 0,0,0,8326168,0},
				    {0,0,0,0,0, 0,0,0,8861129,0},
				    {0,0,0,0,0, 0,0,0,8315294,0},
				    {0,0,0,0,0, 0,0,0,0,1},
				    {0,0,0,0,0, 0,0,0,0,0}
				    };
		
		int[][] d2={{0,1,1,1,0, 0,0,0,0,0},
				    {0,0,0,0,0, 7853564,0,0,0,0},
				    {0,0,0,0,7792472, 8793454,0,0,0,0},
				    {0,0,0,0,8522662, 8411597,8030566,0,0,0},
				    {0,0,0,0,0, 0,0,7562431,7943122,0},
				
				    {0,0,0,0,0, 0,0,7743154,0,0},
				    {0,0,0,0,0, 0,0,0,8182919,0},
				    {0,0,0,0,0, 0,0,0,0,1},
				    {0,0,0,0,0, 0,0,0,0,1},
				    {0,0,0,0,0, 0,0,0,0,0}
				   };
		ArrayList<int[][]> d=new ArrayList<int[][]>();
		d.add(d1);
		d.add(d2);
		//CU�����ӷ�ʽȫ��ͨ
		int[][] CULink={
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1},
						
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1},
						{1,1,1,1,1, 1,1,1,1,1}
				       };
		//���������� 
		//
/*		ArrayList test=new ArrayList();
		test.add(1);
		test.add(4);
		test.add(7);
		System.out.println(test.get(0));*/
		//ArrayList�±���㿪ʼ  timeCU.get(i-1)��ʾ��i��cu����Ϣ,����cu��ʱ�����Integer��ʾ˳�����
		//double[] �а����ĸ�ά�ȣ��ֱ��ʾ,��������ţ������ţ� ��ʼʱ�䣬����ʱ�䣬��ÿһ��CU��ʾһ��ʱ�����Ȼ����ArrayList����������timeCU
		ArrayList<Map<Integer,double[]>> CUtime=new ArrayList<Map<Integer,double[]>>(); 
        CUtime.add(new TreeMap<Integer,double[]>());//TreeMap���ּ�һֱ��������״̬
        CUtime.add(new TreeMap<Integer,double[]>());
        CUtime.add(new TreeMap<Integer,double[]>());
        CUtime.add(new TreeMap<Integer,double[]>());
        CUtime.add(new TreeMap<Integer,double[]>());
        
        CUtime.add(new TreeMap<Integer,double[]>());
        CUtime.add(new TreeMap<Integer,double[]>());
        CUtime.add(new TreeMap<Integer,double[]>());
        CUtime.add(new TreeMap<Integer,double[]>());
        CUtime.add(new TreeMap<Integer,double[]>());
		System.out.println("CUtime: "+CUtime.get(0).keySet().isEmpty());
        //double[]�б�ʾ cu���룬����׼��֮�䣬��Դ׼��ʱ�䣬����ʼʱ�䣬�������ʱ�䡣���ά��,taskAs.get(0)��ʾWF1;taskAs.get(0).get(i-1)��ʾ��WF1�ĵ�i������
        //Integer��ʾ�������
        ArrayList<Map<Integer,double[]>> taskAs=new ArrayList<Map<Integer,double[]>>();
        taskAs.add(new HashMap<Integer,double[]>());
        taskAs.add(new HashMap<Integer,double[]>());
        
		//rankֵ¼��
		double[] rank1={438.2686,435.3888,437.0787,434.5401,438.2686,287.5262,290.2611,292.6153,175.5000,0};
		double[] rank2={462.5548,432.2967,459.0366,462.5548,266.5431,302.9432,230.5829,115.4000,119.2000,0};
		//rank�ϲ�������
		ArrayList<Double> rank=new ArrayList<Double>();
		for(int i=0;i<rank1.length;i++){
			rank.add(rank1[i]);
		}
		for(int i=0;i<rank2.length;i++){
			rank.add(rank2[i]);
		}
		Collections.sort(rank);//��С���������
		Collections.reverse(rank);//��Ϊ�ɴ�С����
		System.out.println("rankֵ��"+rank.toString());
		
//***************************************************************************************************************		
		//��rank���WF�͹�������Ϣ����һ��Map�ṹ�� Double��rankֵ��ListNode�Ƕ�Ӧ�Ĺ��������������
		//����˵������rank1[1]=435.3888 ��ֻҪrankWF.get(435.3888)�Ϳ��Ի��һ���б���Ӧ��[1,2]; 
		Map<Double,ListNode> rankWF=new HashMap<Double,ListNode>();
		//��һ��������
		for(int i=0;i<rank1.length;i++){
			//���rankWF���Ѿ�������rank[i]
			if(rankWF.keySet().contains(rank1[i])){
				//temp����ListNode
				ListNode temp=new ListNode();
				temp=rankWF.get(rank1[i]);
				while(temp.next!=null)
					temp=temp.next;
				//��temp��next==nullʱ
				temp.next=new ListNode(1,i+1);
			}
			else
				rankWF.put(rank1[i], new ListNode(1,i+1));
		}
		//System.out.println(rank1[0]+" , "+rankWF.get(rank1[0]).toString()+" , "+rankWF.get(rank1[0]).next.toString());
		//�ڶ���������
		for(int i=0;i<rank2.length;i++){
			if(rankWF.keySet().contains(rank2[i])){
				ListNode temp=new ListNode();
				temp=rankWF.get(rank2[i]);
				while(temp.next!=null){
					temp=temp.next;
				}
				temp.next=new ListNode(2,i+1);
			}
			else
				rankWF.put(rank2[i], new ListNode(2,i+1));
		}
		//���˳ɹ�ͨ�����ԣ������ǲ��Դ���
		System.out.println("rankWF.keySet: "+rankWF.keySet());
		Iterator<Double> iter=rankWF.keySet().iterator();
		System.out.println("rankWF:");
		while(iter.hasNext()){
			System.out.println(rankWF.get(iter.next()).toString());
		}
/*		//�������
				[1 , 10], [2 , 10]
				[2 , 3]
				[2 , 6]
				[1 , 9]
				[2 , 8]
				[1 , 4]
				[2 , 1], [2 , 4]
				[2 , 2]
				[1 , 7]
				[1 , 2]
				[2 , 9]
				[2 , 5]
				[1 , 8]
				[1 , 6]
				[1 , 3]
				[2 , 7]
				[1 , 1], [1 , 5]
*/
		//*****************************************************
		//��ʽ��ʼ��д
		//��ÿ��rankֵ
		System.out.println(rank.size());
		//i,j�������������ľֲ������������ѭ����Ҫ�ظ�ʹ��i��j����Ϊk��l��m��
		for(int i=0;i<rank.size();i++){
			double[] CUTimeVal=new double[4];
			double tempRank=rank.get(i);//����������tempRank
			//tempNodeΪҪ�����Ķ����ListNode��˳���ȡͬһ��tempRankֵ��Ӧ��ListNode�б�
			ListNode tempNode=new ListNode();
			tempNode=rankWF.get(tempRank);
			while(tempNode.isRead==true){
				tempNode=tempNode.next;
			}
			tempNode.isRead=true;
			CUTimeVal[0]=tempNode.WF;
			CUTimeVal[1]=tempNode.task;
			//��������׼��ʱ��TRT��TRT���ĸ�CU�޹أ�����ÿ������������㼴��
			double TRT=0;
			//�����ͷ���,ͷ��㲻�ü��㣬��ÿ�η��䵽����һ��CU��;
			//�����Ǵ�������
			if(pre.get(tempNode.WF-1).get(tempNode.task)==null){
				TRT=0;
				double[] end={1,0,0,0,0};
				taskAs.get(tempNode.WF-1).put(tempNode.task,end);
				//ͷ���Ŀ�ʼ����ʱ�䶼Ϊ0�����䵽��һ��cu��
				CUTimeVal[2]=0;
				CUTimeVal[3]=0;
				if(CUtime.get(0).keySet().isEmpty()){
					CUtime.get(0).put(1,CUTimeVal);
				}
				else{
					//���cu[1]ǰ��������Ļ�������ʼʱ��Ͳ���0�ˣ�
					CUTimeVal[2]=CUtime.get(0).get(((TreeMap<Integer, double[]>) CUtime.get(0)).lastKey())[3];
					CUTimeVal[3]=CUtime.get(0).get(((TreeMap<Integer, double[]>) CUtime.get(0)).lastKey())[3];
					int last=((TreeMap<Integer, double[]>) CUtime.get(0)).lastKey();
					CUtime.get(0).put(last+1,CUTimeVal);
				}
				continue;//������һ��ѭ����������һ��i
			}
			else
			{//��ÿһ��ǰ��������TRT
				//ǰ���ļ���
				int[] temPre=pre.get(tempNode.WF-1).get(tempNode.task);
				//ÿһ��ǰ����EFT���ϴ���ʱ�䣬���ȡTRTcand�е����ֵ
				double[] TRTcand=new double[temPre.length];
				for(int k=0;k<temPre.length;k++){
					TRTcand[k]=taskAs.get(tempNode.WF-1).get(temPre[k])[4]
							+d.get(tempNode.WF-1)[temPre[k]-1][tempNode.task-1]/B;
				}
				Arrays.sort(TRTcand);//��С��������
				TRT=TRTcand[temPre.length-1];//��ȡ���һ��Ҳ������Ԫ��
			}
			double[] EFTcand=new double[CUtime.size()];
			for(int j=0;j<CUtime.size();j++){
				//��ÿ��CU����RRT��EST��EFT��EFTcandҪ����¼��С�Ľ�����ڵ�CU����
				double RRT=0,EST=0;
				
				//����RRT�����ڵ�CU��j+1
				if(CUtime.get(j).keySet().isEmpty()){
					RRT=0;
				}
				else{
					RRT=CUtime.get(j).get(((TreeMap<Integer, double[]>) CUtime.get(j)).lastKey())[3];
				}
				//����ʼʱ��
				EST=Math.max(TRT, RRT);
				EFTcand[j]=EST+I.get(tempNode.WF-1)[tempNode.task-1]/Sap;
			}
			
			//�ҵ�EFT����С��Ԫ�أ��Լ����ڵ�cu����
			double min;
			int CUpoint=1;//��С��EFTcand���ڵ�cu�ı��룬��Ӧ��EFTcand[0];
			min=EFTcand[0];
			for(int j=0;j<CUtime.size();j++){
				if(min>EFTcand[j]){
					min=EFTcand[j];
					CUpoint=j+1;
				}
			}
			
			taskAs.get(tempNode.WF-1).put(tempNode.task,new double[5]);
			taskAs.get(tempNode.WF-1).get(tempNode.task)[0]=CUpoint;
			taskAs.get(tempNode.WF-1).get(tempNode.task)[4]=min;
			
		    //���������СEFT��RRT��EST������¼
			double RRT=0,EST=0;
			
			//����RRT�����ڵ�CU��j+1
			if(CUtime.get(CUpoint-1).keySet().isEmpty()){
				RRT=0;
			}
			else{
				RRT=CUtime.get(CUpoint-1).get(((TreeMap<Integer, double[]>) CUtime.get(CUpoint-1)).lastKey())[3];
			}
			//����ʼʱ��
			taskAs.get(tempNode.WF-1).get(tempNode.task)[1]=RRT;
			taskAs.get(tempNode.WF-1).get(tempNode.task)[2]=TRT;
			EST=Math.max(TRT, RRT);
			taskAs.get(tempNode.WF-1).get(tempNode.task)[3]=EST;
			CUTimeVal[2]=EST;
			CUTimeVal[3]=min;
			//�����Map����Ž�1������ͷŽ�last+1;
			if(CUtime.get(CUpoint-1).keySet().isEmpty()){
				CUtime.get(CUpoint-1).put(1,CUTimeVal);
			}
			else{
				int last=((TreeMap<Integer, double[]>) CUtime.get(CUpoint-1)).lastKey();
				CUtime.get(CUpoint-1).put(last+1,CUTimeVal);
			}
				
			
		}
			
		//������taskAS��CUtime��ֵ
		System.out.println("taskAs[0]��WF1�ķ�������� "+"\n    "+"cu���   TRT  RRT  EST  EFT");
		for(int i=1;i<=taskAs.get(0).size();i++){
			System.out.println(i+"-->"+Arrays.toString(taskAs.get(0).get(i))+"\t"); 
		}
		System.out.println("taskAs[1]��WF2�ķ�������� "+"\n    "+"cu���   TRT  RRT  EST  EFT");
		for(int i=1;i<=taskAs.get(1).size();i++){
			System.out.println(i+"-->"+Arrays.toString(taskAs.get(1).get(i))+"\t"); 
		}
		for(int i=0;i<CUtime.size();i++){
			System.out.println("CUtime["+i+"]������: ");
			for(int j=1;j<=CUtime.get(i).size();j++){
				System.out.println(j+"-->"+Arrays.toString(CUtime.get(i).get(j)));
			}
		}
	}
}
