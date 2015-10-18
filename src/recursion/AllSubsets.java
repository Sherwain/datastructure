package recursion;

import java.awt.List;
import java.util.HashSet;
import java.util.ArrayList;

public class AllSubsets {
	public static void main(String[] args){
		System.out.println(subsets("abcde".toCharArray(), "", new HashSet<String>()).size());
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(getSubsets(list, 0));
	}
	
	public static HashSet<String> subsets(char[] inputStr, String ap, HashSet<String> set){
		if (inputStr.length == 0){
			set.add(ap);
			return set;
		}
		set.add(ap + new String( inputStr));
		subsets(new String(inputStr).substring(1).toCharArray(), ap, set).addAll(subsets(new String(inputStr).substring(1).toCharArray(), ap + new String(inputStr).substring(0, 1), set));
		return set;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if (set.size() == index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else{
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
}
