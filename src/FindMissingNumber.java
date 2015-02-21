import java.lang.reflect.Array;
import java.util.ArrayList;


public class FindMissingNumber {
	
	static int bitLen = 8;
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		list.add(transformIntegerToBinary(0));
		list.add(transformIntegerToBinary(1));
		list.add(transformIntegerToBinary(2));
		list.add(transformIntegerToBinary(3));
		list.add(transformIntegerToBinary(4));
		list.add(transformIntegerToBinary(5));
		
		list.add(transformIntegerToBinary(6));
		list.add(transformIntegerToBinary(7));
		list.add(transformIntegerToBinary(9));
		list.add(transformIntegerToBinary(10));
		list.add(transformIntegerToBinary(11));
		list.add(transformIntegerToBinary(12));
		list.add(transformIntegerToBinary(13));
		
		System.out.println(list);
		
		System.out.println(findMissingNumber(list));
		
	}
	
	public static int findMissingNumber(ArrayList<ArrayList<Integer>> list){
		return findMissingNumber(list, 0); 
	}
	
	public static int findMissingNumber(ArrayList<ArrayList<Integer>> list, int index){
		
		//终止条件
		if(index >= bitLen){
			return 0;
		}
		
		//存储bit为0的数
		ArrayList<ArrayList<Integer>> oneBit = new ArrayList<ArrayList<Integer>>();
		
		//存储bit为1的数
		ArrayList<ArrayList<Integer>> zeroBit = new ArrayList<ArrayList<Integer>>();
		
		//为oneBie和zeroBit赋值
		for(ArrayList<Integer> bit:list){
			if(fetch(bit, index) == 0){
				zeroBit.add(bit);
			}
			else{
				oneBit.add(bit);
			}
		}
		
		//分情况讨论
		if(zeroBit.size() <= oneBit.size()){
			//recursive function
			int v = findMissingNumber(zeroBit, index + 1);
			return (v<<1) | 0;
		}
		else{
			//recursive function
			int v = findMissingNumber(oneBit, index + 1);
			return (v<<1) | 1;
		}
	}
	
	public static int fetch(ArrayList<Integer> list, int i){
		return list.get(list.size() - i - 1);
	}
	
	public static int transformBinaryToInteger(ArrayList<Integer> list){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=list.size() - 1;i>=0;i--){
			temp.add(list.get(i));
		}
		
		int result = 0;
		for(int i=0;i<temp.size();i++){
			result += Math.pow(2, i) * temp.get(i);
		}
		
		return result;
	}
	
	public static ArrayList<Integer> transformIntegerToBinary(int num){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while(num != 0){
			result.add(num%2);
			num = num/2;
		}
		
		//fill the empty with 0
		for(int i=result.size();i<bitLen;i++){
			result.add(0);
		}
		
		ArrayList<Integer> finalResult = new ArrayList<Integer>();
		
		for(int i=result.size() - 1;i>=0;i--){
			finalResult.add(result.get(i));
		}
		
		return finalResult;
	}
	
	public static int getIntegerBitLength(int num){
		int count = 0;
		while(num != 0){
			num = num/2;
			count++;
		}
		return count;
	}
}
