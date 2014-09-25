package hf.see.java.impl2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	
	private static List<IMeasurable> TestData = new ArrayList<>();
	private static DataSet DataSet = null;

	public static void main(String[] args) {

		TestData.add(new QuizResult("Hans", 5));
		TestData.add(new QuizResult("Mark", 9));
		TestData.add(new QuizResult("Ueli", 3));
		TestData.add(new QuizResult("Martin", 6));
		TestData.add(new QuizResult("Lisa", 4));
		TestData.add(new QuizResult("Andrea", 4));
		TestData.add(new QuizResult("Susi", 8));
		TestData.add(new QuizResult("Tina", 6));
		DataSet = new DataSet(TestData);
		
		System.out.println("Dies sind die Quizresultate:");
		for(Iterator<IMeasurable> i = TestData.iterator();i.hasNext();)
		{
			IMeasurable currentQuizResult = i.next();
			System.out.println(currentQuizResult.getName() + " mit " + currentQuizResult.getScore() + " Punkten");
		}
		System.out.println();
		
		IMeasurable winner = 		DataSet.calcMax(PreDefinedValueAccessors.byScore());
		IMeasurable longestName = 	DataSet.calcMax(PreDefinedValueAccessors.byNameLen());
		double avgPoints = 			DataSet.calcAvg(PreDefinedValueAccessors.byScore());
		double avgNameLen = 		DataSet.calcAvg(PreDefinedValueAccessors.byNameLen());
		
		System.out.printf( "Der Gewinner heisst %s und hat %d Punkt(e)%n", winner.getName(), winner.getScore() );
		System.out.printf( "Der längste Name ist %s und hat %d Buchstaben%n", longestName.getName(), longestName.getName().length() );
		System.out.println("Der Durchschnitt der Punktzahl ist " + avgPoints);
		System.out.println("Die durchschnittliche Namenslänge ist " + avgNameLen + " Buchstaben");
		System.out.println();
		
		TestData.clear();
		TestData.add(new MeasurableString("dfsdfsdfd"));
		TestData.add(new MeasurableString("oigg"));
		TestData.add(new MeasurableString("dwee"));
		TestData.add(new MeasurableString("attrdc"));
		TestData.add(new MeasurableString("xcvxcv"));
		TestData.add(new MeasurableString("rttzzertrr"));
		DataSet = new DataSet(TestData);
		
		System.out.println("Dies sind die Strings:");
		for(Iterator<IMeasurable> i = TestData.iterator();i.hasNext();)
		{
			IMeasurable currentQuizResult = i.next();
			System.out.println(currentQuizResult.getName() + " mit " + currentQuizResult.getScore() + " Buchstaben");
		}
		System.out.println();
		
		longestName = 	DataSet.calcMax(PreDefinedValueAccessors.byScore());
		avgNameLen = 	DataSet.calcAvg(PreDefinedValueAccessors.byScore());
		
		System.out.printf( "Der längste String ist '%s' und hat %d Buchstaben%n", longestName.getName(), longestName.getName().length() );
		System.out.printf("Die durchschnittliche Stringlänge ist %.3f Buchstaben%n", avgNameLen);
		System.out.println();
	}

}
