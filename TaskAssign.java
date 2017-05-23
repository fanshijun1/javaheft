package heft;

import java.util.*;

//自己创建自己需要的数据结构的能力，对应179行之后的代码
//java 容器的缺点就是一个节点只能存储一个元素，所以将这个元素弄成类
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
	//toString 就是打印列表，如果列表有后继节点，那么就会就整个列表都打印出来。。。。
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
	//内部类 表示工作流，和任务；
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//基本信息录入		
		double B=Math.pow(10, 6);//System.out.println(B);1000000
		double Scu=Math.pow(10, 5);
		int K=10;
		double Sap=Scu/K;
		//前后驱节点信息,相当于将工作流图表录入
		//WF1的前驱
		Map<Integer,int[]> pre1=new HashMap<Integer,int[]>();
		int[] pn11=null;    pre1.put(1, pn11);//pn表示preNode,第一个1表示第一个工作流，第二个1表示第一个节点；
		int[] pn12={1};     pre1.put(2, pn12);//System.out.println(pre1.get(2).length);
		int[] pn13={1};     pre1.put(3, pn13);
		int[] pn14={1};     pre1.put(4, pn14);
		int[] pn15={1};     pre1.put(5, pn15);
		int[] pn16={2,4};   pre1.put(6, pn16);
		int[] pn17={3,4};   pre1.put(7, pn17);
		int[] pn18={2,4,5}; pre1.put(8, pn18);
		int[] pn19={6,7,8}; pre1.put(9, pn19);
		int[] pn110={9};    pre1.put(10, pn110);
		//WF1的后驱succ1
		Map<Integer,int[]> succ1=new HashMap<Integer,int[]>();
		int[] sn11={2,3,4,5}; succ1.put(1, sn11);//sn表示succNode
		int[] sn12={6,8};     succ1.put(2, sn12);
		int[] sn13={7};       succ1.put(3, sn13);
		int[] sn14={6,7,8};   succ1.put(4, sn14);
		int[] sn15={8};       succ1.put(5, sn15);
		int[] sn16={9};		  succ1.put(6, sn16);
		int[] sn17={9};	 	  succ1.put(7, sn17);
		int[] sn18={9};		  succ1.put(8, sn18);
		int[] sn19={10};      succ1.put(9, sn19);
		int[] sn110=null;     succ1.put(10, sn110);
		//WF2的前驱pre2
		Map<Integer,int[]> pre2=new HashMap<Integer,int[]>();
		int[] pn21=null;    pre2.put(1, pn21);//pn表示preNode,第一个1表示第一个工作流，第二个1表示第一个节点；
		int[] pn22={1};	    pre2.put(2, pn22);//System.out.println(pre1.get(2).length);
		int[] pn23={1}; 	pre2.put(3, pn23);
		int[] pn24={1}; 	pre2.put(4, pn24);
		int[] pn25={3,4};   pre2.put(5, pn25);
		int[] pn26={2,3,4}; pre2.put(6, pn26);
		int[] pn27={4};   	pre2.put(7, pn27);
		int[] pn28={5,6}; 	pre2.put(8, pn28);
		int[] pn29={5,7};   pre2.put(9, pn29);
		int[] pn210={8,9};  pre2.put(10, pn210);
		//WF2的后驱
		Map<Integer,int[]> succ2=new HashMap<Integer,int[]>();
		int[] sn21={2,3,4};   succ2.put(1, sn21);//sn表示succNode
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
			
		//计算量录入
		int[] I1={0,1339000,1383000,1336000,1378000,1037000,1059000,1088000,1755000,0};
		int[] I2={0,1215000,1473000,1512000,1394000,1798000,1032000,1154000,1192000,0};
		ArrayList<int[]> I=new ArrayList<int[]>();
		I.add(I1);
		I.add(I2);
		//传输量录入,d1表示无法wf1的传输量，d2表示wf2的传输量
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
		//CU的连接方式全联通
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
		//结果容器设计 
		//
/*		ArrayList test=new ArrayList();
		test.add(1);
		test.add(4);
		test.add(7);
		System.out.println(test.get(0));*/
		//ArrayList下标从零开始  timeCU.get(i-1)表示第i个cu的信息,这是cu的时间带，Integer表示顺序编码
		//double[] 中包含四个维度，分别表示,工作流编号，任务编号， 开始时间，结束时间，对每一个CU表示一个时间带，然后用ArrayList链接起来，timeCU
		ArrayList<Map<Integer,double[]>> CUtime=new ArrayList<Map<Integer,double[]>>(); 
        CUtime.add(new TreeMap<Integer,double[]>());//TreeMap保持键一直处于排序状态
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
        //double[]中表示 cu编码，任务准备之间，资源准备时间，任务开始时间，任务结束时间。五个维度,taskAs.get(0)表示WF1;taskAs.get(0).get(i-1)表示第WF1的第i个任务
        //Integer表示任务编码
        ArrayList<Map<Integer,double[]>> taskAs=new ArrayList<Map<Integer,double[]>>();
        taskAs.add(new HashMap<Integer,double[]>());
        taskAs.add(new HashMap<Integer,double[]>());
        
		//rank值录入
		double[] rank1={438.2686,435.3888,437.0787,434.5401,438.2686,287.5262,290.2611,292.6153,175.5000,0};
		double[] rank2={462.5548,432.2967,459.0366,462.5548,266.5431,302.9432,230.5829,115.4000,119.2000,0};
		//rank合并及排序
		ArrayList<Double> rank=new ArrayList<Double>();
		for(int i=0;i<rank1.length;i++){
			rank.add(rank1[i]);
		}
		for(int i=0;i<rank2.length;i++){
			rank.add(rank2[i]);
		}
		Collections.sort(rank);//由小到大排序的
		Collections.reverse(rank);//变为由大到小排序
		System.out.println("rank值："+rank.toString());
		
//***************************************************************************************************************		
		//对rank添加WF和工作流信息，用一个Map结构； Double是rank值，ListNode是对应的工作流和任务编码
		//比如说，对于rank1[1]=435.3888 ，只要rankWF.get(435.3888)就可以获得一个列表，对应于[1,2]; 
		Map<Double,ListNode> rankWF=new HashMap<Double,ListNode>();
		//第一个工作流
		for(int i=0;i<rank1.length;i++){
			//如果rankWF中已经包含了rank[i]
			if(rankWF.keySet().contains(rank1[i])){
				//temp遍历ListNode
				ListNode temp=new ListNode();
				temp=rankWF.get(rank1[i]);
				while(temp.next!=null)
					temp=temp.next;
				//当temp。next==null时
				temp.next=new ListNode(1,i+1);
			}
			else
				rankWF.put(rank1[i], new ListNode(1,i+1));
		}
		//System.out.println(rank1[0]+" , "+rankWF.get(rank1[0]).toString()+" , "+rankWF.get(rank1[0]).next.toString());
		//第二个工作流
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
		//到此成功通过测试，下面是测试代码
		System.out.println("rankWF.keySet: "+rankWF.keySet());
		Iterator<Double> iter=rankWF.keySet().iterator();
		System.out.println("rankWF:");
		while(iter.hasNext()){
			System.out.println(rankWF.get(iter.next()).toString());
		}
/*		//结果如下
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
		//正式开始编写
		//对每个rank值
		System.out.println(rank.size());
		//i,j是用来计算外层的局部变量，里面的循环不要重复使用i，j，改为k，l，m等
		for(int i=0;i<rank.size();i++){
			double[] CUTimeVal=new double[4];
			double tempRank=rank.get(i);//对象就是这个tempRank
			//tempNode为要操作的对象的ListNode，顺序读取同一个tempRank值对应的ListNode列表
			ListNode tempNode=new ListNode();
			tempNode=rankWF.get(tempRank);
			while(tempNode.isRead==true){
				tempNode=tempNode.next;
			}
			tempNode.isRead=true;
			CUTimeVal[0]=tempNode.WF;
			CUTimeVal[1]=tempNode.task;
			//先算任务准备时间TRT，TRT和哪个CU无关，故在每个任务里面计算即可
			double TRT=0;
			//如果是头结点,头结点不用计算，故每次分配到到第一个CU吧;
			//不考虑传输问题
			if(pre.get(tempNode.WF-1).get(tempNode.task)==null){
				TRT=0;
				double[] end={1,0,0,0,0};
				taskAs.get(tempNode.WF-1).put(tempNode.task,end);
				//头结点的开始结束时间都为0；分配到底一个cu上
				CUTimeVal[2]=0;
				CUTimeVal[3]=0;
				if(CUtime.get(0).keySet().isEmpty()){
					CUtime.get(0).put(1,CUTimeVal);
				}
				else{
					//如果cu[1]前面有任务的话，任务开始时间就不是0了；
					CUTimeVal[2]=CUtime.get(0).get(((TreeMap<Integer, double[]>) CUtime.get(0)).lastKey())[3];
					CUTimeVal[3]=CUtime.get(0).get(((TreeMap<Integer, double[]>) CUtime.get(0)).lastKey())[3];
					int last=((TreeMap<Integer, double[]>) CUtime.get(0)).lastKey();
					CUtime.get(0).put(last+1,CUTimeVal);
				}
				continue;//跳出这一层循环，进入下一个i
			}
			else
			{//对每一个前驱，计算TRT
				//前驱的集合
				int[] temPre=pre.get(tempNode.WF-1).get(tempNode.task);
				//每一个前驱的EFT加上传输时间，最后取TRTcand中的最大值
				double[] TRTcand=new double[temPre.length];
				for(int k=0;k<temPre.length;k++){
					TRTcand[k]=taskAs.get(tempNode.WF-1).get(temPre[k])[4]
							+d.get(tempNode.WF-1)[temPre[k]-1][tempNode.task-1]/B;
				}
				Arrays.sort(TRTcand);//从小到大排序
				TRT=TRTcand[temPre.length-1];//获取最后一个也是最大的元素
			}
			double[] EFTcand=new double[CUtime.size()];
			for(int j=0;j<CUtime.size();j++){
				//对每个CU计算RRT和EST，EFT。EFTcand要最后记录做小的结果所在的CU编码
				double RRT=0,EST=0;
				
				//计算RRT，所在的CU是j+1
				if(CUtime.get(j).keySet().isEmpty()){
					RRT=0;
				}
				else{
					RRT=CUtime.get(j).get(((TreeMap<Integer, double[]>) CUtime.get(j)).lastKey())[3];
				}
				//任务开始时间
				EST=Math.max(TRT, RRT);
				EFTcand[j]=EST+I.get(tempNode.WF-1)[tempNode.task-1]/Sap;
			}
			
			//找到EFT中最小的元素，以及所在的cu编码
			double min;
			int CUpoint=1;//最小的EFTcand所在的cu的编码，对应于EFTcand[0];
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
			
		    //补充计算最小EFT的RRT和EST，作记录
			double RRT=0,EST=0;
			
			//计算RRT，所在的CU是j+1
			if(CUtime.get(CUpoint-1).keySet().isEmpty()){
				RRT=0;
			}
			else{
				RRT=CUtime.get(CUpoint-1).get(((TreeMap<Integer, double[]>) CUtime.get(CUpoint-1)).lastKey())[3];
			}
			//任务开始时间
			taskAs.get(tempNode.WF-1).get(tempNode.task)[1]=RRT;
			taskAs.get(tempNode.WF-1).get(tempNode.task)[2]=TRT;
			EST=Math.max(TRT, RRT);
			taskAs.get(tempNode.WF-1).get(tempNode.task)[3]=EST;
			CUTimeVal[2]=EST;
			CUTimeVal[3]=min;
			//如果空Map，则放进1，否则就放进last+1;
			if(CUtime.get(CUpoint-1).keySet().isEmpty()){
				CUtime.get(CUpoint-1).put(1,CUTimeVal);
			}
			else{
				int last=((TreeMap<Integer, double[]>) CUtime.get(CUpoint-1)).lastKey();
				CUtime.get(CUpoint-1).put(last+1,CUTimeVal);
			}
				
			
		}
			
		//输出结果taskAS和CUtime的值
		System.out.println("taskAs[0]即WF1的分配情况： "+"\n    "+"cu编号   TRT  RRT  EST  EFT");
		for(int i=1;i<=taskAs.get(0).size();i++){
			System.out.println(i+"-->"+Arrays.toString(taskAs.get(0).get(i))+"\t"); 
		}
		System.out.println("taskAs[1]即WF2的分配情况： "+"\n    "+"cu编号   TRT  RRT  EST  EFT");
		for(int i=1;i<=taskAs.get(1).size();i++){
			System.out.println(i+"-->"+Arrays.toString(taskAs.get(1).get(i))+"\t"); 
		}
		for(int i=0;i<CUtime.size();i++){
			System.out.println("CUtime["+i+"]的内容: ");
			for(int j=1;j<=CUtime.get(i).size();j++){
				System.out.println(j+"-->"+Arrays.toString(CUtime.get(i).get(j)));
			}
		}
	}
}
