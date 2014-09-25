package hf.see.java.impl2;

public class MeasurableString implements IMeasurable {

	private String string;
	
	public MeasurableString(String string)
	{
		this.string = string;
	}
	
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return string.length();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return string;
	}

}
