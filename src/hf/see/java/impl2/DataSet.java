package hf.see.java.impl2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * F�hrt Berechnungen mit einer Liste von Messobjekten durch
 * @author Elia Seikritt
 *
 */
public class DataSet {

	/**
	 * Liste der Messobjekte
	 */
	private List<IMeasurable> results = new ArrayList<>();

	public DataSet(List<IMeasurable> results) {
		this.results = results;
	}
	
	//--- IValueAccessor Implementationen
	
	/**
	 * Methoden die Berechnungen mit den Messobjekten durchf�hren, k�nnen mithilfe dieses Interfaces Werte abfragen
	 * �hnlich dem Command-Pattern
	 * @author Elia Seikritt
	 *
	 */
	private interface IValueAccessor {
		int getValue(IMeasurable result);
	}
	
	/**
	 * Gibt die Punkte eines Messobjekts zur�ck
	 */
	private IValueAccessor byPoints = new IValueAccessor() {
		@Override
		public int getValue(IMeasurable result) {
			return result.getPoints();
		}
	};
	
	/**
	 * Gibt die Stringl�nge des Namens eines Messobjekts zur�ck
	 */
	private IValueAccessor byNameLen = new IValueAccessor() {
		@Override
		public int getValue(IMeasurable result) {
			return result.getName().length();
		}
	};
	
	//--- Auswertungen
	
	/**
	 * Ermittelt den Durchschnitt aller Messobjekte
	 * @param accessor Beschreibt welcher Wert der Messobjekte summiert werden soll
	 * @return Durchschnitt der summierten Messobjekte
	 */
	private double calcAvg(IValueAccessor accessor) {
		int sum = 0;
		for (Iterator<IMeasurable> i = results.iterator(); i.hasNext();) {
			sum += accessor.getValue(i.next());
		}
		return (double)sum / results.size();
	}
	
	/**
	 * Ermittelt das Messobjekt mit dem gr�ssten Wert
	 * @param accessor Beschreibt welcher Wert der Messobjekte vergliechen werden soll
	 * @return Das Messobjekt mit dem gr�ssten ermittelten Wert
	 */
	private IMeasurable calcMax(IValueAccessor accessor)
	{
		int maxValue = 0;
		IMeasurable maxResult = null;
		for (Iterator<IMeasurable> i = results.iterator(); i.hasNext();) {
			IMeasurable currentResult = i.next();
			int currentValue = accessor.getValue(currentResult);
			if (currentValue > maxValue) {
				maxValue = currentValue;
				maxResult = currentResult;
			}
		}
		return maxResult;	
	}
	
	//--- �ffentliche Methoden

	/**
	 * 
	 * @return Punkte des Messobjekts, dass den gr�ssten Punktewert hat
	 */
	public int getMaxPointsResult()
	{
		return calcMax(byPoints).getPoints();
	}
	
	/**
	 * 
	 * @return Namenl�nge des Messobjekts, dass den l�ngsten Namen hat
	 */
	public double getMaxNameLength()
	{
		return calcMax(byNameLen).getName().length();
	}
	
	/**
	 * 
	 * @return Name des Messobjekts, dass den gr�ssten Punktewert hat
	 */
	public String getNameOfWinner()
	{
		return calcMax(byPoints).getName();
	}

	/**
	 * 
	 * @return Durchschnittswert aller Punkte der Messobjekte
	 */
	public double getAvgPointsResult() {
	
		return calcAvg(byPoints);
	}

	/**
	 * Durchschnittsl�nge aller Namen der Messobjekte
	 */
	public double getAvgNameLength()
	{			
		return calcAvg(byNameLen);
	}

}
