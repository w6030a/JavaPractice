package problems.test;

import static org.junit.Assert.*;

import org.junit.Test;

import problems.InterestedTimeProblem;

public class InterestedTimeProblemTest {

	@Test
	public void testTimeWithMultipleLeadingZeros() {
		String startTime = "00:00:00";
		String endTime = "00:00:01";
		assertEquals(2, InterestedTimeProblem.solution(startTime, endTime));
	}
	
	@Test
	public void testTimeWithOneLeadingZeros() {
		String startTime = "11:23:45";
		String endTime = "11:24:01";
		assertEquals(0, InterestedTimeProblem.solution(startTime, endTime));
	}

	@Test
	public void testTimeWithNormalInput() {
		String startTime = "11:11:11";
		String endTime = "11:12:12";
		assertEquals(21, InterestedTimeProblem.solution(startTime, endTime));
	}
	
	@Test
	public void testTimeWithGivenExample1() {
		String startTime = "15:15:00";
		String endTime = "15:15:12";
		assertEquals(1, InterestedTimeProblem.solution(startTime, endTime));
	}
	
	@Test
	public void testTimeWithGivenExample2() {
		String startTime = "22:22:21";
		String endTime = "22:22:23";
		assertEquals(3, InterestedTimeProblem.solution(startTime, endTime));
	}
}
