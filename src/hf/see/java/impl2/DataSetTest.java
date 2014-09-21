package hf.see.java.impl2;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class DataSetTest extends TestCase {

	protected List<IMeasurable> TestData = new ArrayList<>();
	protected DataSet DataSet = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		TestData.add(new QuizResult("Hans", 5));
		TestData.add(new QuizResult("Mark", 9));
		TestData.add(new QuizResult("Ueli", 3));
		TestData.add(new QuizResult("Martin", 6));
		TestData.add(new QuizResult("Lisa", 4));
		TestData.add(new QuizResult("Andrea", 4));
		TestData.add(new QuizResult("Susi", 8));
		TestData.add(new QuizResult("Tina", 6));
		DataSet = new DataSet(TestData);
	}
	
	public void testPointsAvgCalc()
	{
		double result = DataSet.getAvgPointsResult();
		assertEquals(5.625, result);
	}
	
	public void testPointsMaxCalc()
	{
		int result = DataSet.getMaxPointsResult();
		assertEquals(9, result);
	}
	
	public void testGetWinnerNameCalc()
	{
		String result = DataSet.getNameOfWinner();
		assertEquals("Mark", result);
	}
	
	public void testNameAvgLen()
	{
		double result = DataSet.getAvgNameLength();
		assertEquals(4.5,result);
	}

}
