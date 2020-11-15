package solving;

import java.util.ArrayList;
import java.util.List;

public class SumOfDiagonals {
	
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(11);
		list1.add(2);
		list1.add(4);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(10);
		list3.add(8);
		list3.add(-12);
		
		list.add(list1);
		list.add(list2);
		list.add(list3);
		
		System.out.println(diagonalDifference(list));;
	}
	
	public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int primeDiagSum = 0;
        int secondDiagSum = 0;

        for(int i=0; i<arr.size(); i++){

            List<Integer> list = arr.get(i);

            primeDiagSum += list.get(i);
            secondDiagSum += list.get(list.size()-i-1);
            
        }

        return Math.abs(primeDiagSum-secondDiagSum);
    }
	
}
