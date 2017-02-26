package problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class InterestedTimeProblem {

	/**
	 * @param s, start time in HH:MM:SS format
	 * @param t, termination time in HH:MM:SS format
	 * 
	 * @return n, the number of interesting time within s and t
	 * 
	 * Assumption 1: t > s
	 * Assumption 2: t and s are in the same day
	 * Assumption 3: 00 <= HH <= 23, 00 <= MM <= 59, 00 <= SS <= 59
	 **/
	static public int solution(String s, String t) {
		String[] digits = s.split(":");
		int startHour = Integer.parseInt(digits[0]);
		int startMin = Integer.parseInt(digits[1]);
		int startSec = Integer.parseInt(digits[2]);
		
		digits = t.split(":");
		int endHour = Integer.parseInt(digits[0]);
		int endMin = Integer.parseInt(digits[1]);
		int endSec = Integer.parseInt(digits[2]);
		
		int numOfInterestingTime = 0;
		for(int i = startHour; i <= endHour; i++) {
			for(int j = startMin; (j <= endMin && i == endHour) || (j <= 59 && i != endHour); j++) {
				for(int k = startSec; (k <= endSec && j == endMin) || (k <= 59 && j != endMin); k++) {
					HashSet<Character> bucket = new HashSet<Character>();
					
					if(i < 10 || j < 10 || k < 10)
						bucket.add('0');
					
					String allTheDigits = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
					bucket.addAll(stringToCharList(allTheDigits));
					if(bucket.size() <= 2) {
						numOfInterestingTime++;
						//System.out.println(bucket.toString());
						System.out.println(String.format("%d, %d, %d", i, j, k));
					}
				}
			}
		}
		
		return numOfInterestingTime;
	}

	private static Collection<? extends Character> stringToCharList(String s) {
		ArrayList<Character> charList = new ArrayList<Character>();
		for(char digit : s.toCharArray()) {
			charList.add(digit);
		}
		
		return charList;
	}
}
