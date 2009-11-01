package akshay.javaperformance;

import java.util.ArrayList;

public class StoreString {

	public static int binarySearch(ArrayList<RandomString> list, int first, int upto, String key) {
		if (first < upto) {
			int mid = first + (upto - first) / 2;  // Compute mid point.
			if (Integer.parseInt(key) < list.get(mid).getNum()) {
				return binarySearch(list, first, mid, key);		            
			} else if (Integer.parseInt(key) > list.get(mid).getNum()) {
				return binarySearch(list, mid+1, upto , key);		            
			} else {
				return mid;   // Found it.
			}
		}
		return -(first + 1);  // Failed to find key
	}

	public static ArrayList<RandomString> quicksort(ArrayList<RandomString> list) {
		if (list.size() <= 1)
			return list;
		int pivot = list.size() / 2;
		ArrayList<RandomString> lesser = new ArrayList<RandomString>();
		ArrayList<RandomString> greater = new ArrayList<RandomString>();
		int sameAsPivot = 0;
		for (RandomString number : list) {
			if (number.getNum() > list.get(pivot).getNum())
				greater.add(number);
			else if (number.getNum() < list.get(pivot).getNum())
				lesser.add(number);
			else
				sameAsPivot++;
		}
		lesser = quicksort(lesser);
		for (int i = 0; i < sameAsPivot; i++)
			lesser.add(list.get(pivot));
		greater = quicksort(greater);
		ArrayList<RandomString> sorted = new ArrayList<RandomString>();
		for (RandomString number : lesser)
			sorted.add(number);
		for (RandomString number: greater)
			sorted.add(number);
		return sorted;
	}
}
