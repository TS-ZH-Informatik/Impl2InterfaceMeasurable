package hf.see.java.impl2;

public class QuizResult implements IMeasurable {
	private int Points;
	private String Name;
	public QuizResult(String Name, int Points)
	{
		this.Points = Points;
		this.Name = Name;
	}
	public int getPoints() {
		return Points;
	}
	public String getName() {
		return Name;
	}
	
}
