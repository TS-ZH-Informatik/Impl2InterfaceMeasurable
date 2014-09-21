package hf.see.java.impl2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Führt Berechnungen mit einer Liste von Messobjekten durch
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
	 * Methoden die Berechnungen mit den Messobjekten durchführen, können mithilfe dieses Interfaces Werte abfragen
	 * Ähnlich dem Command-Pattern
	 * @author Elia Seikritt
	 *
	 */
	private interface IValueAccessor {
		int getValue(IMeasurable result);
	}
	
	/**
	 * Gibt die Punkte eines Messobjekts zurück
	 */
	private IValueAccessor byPoints = new IValueAccessor() {
		@Override
		public int getValue(IMeasurable result) {
			return result.getPoints();
		}
	};
	
	/**
	 * Gibt die Stringlänge des Namens eines Messobjekts zurück
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
	 * Ermittelt das Messobjekt mit dem grössten Wert
	 * @param accessor Beschreibt welcher Wert der Messobjekte vergliechen werden soll
	 * @return Das Messobjekt mit dem grössten ermittelten Wert
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
	
	//--- Öffentliche Methoden

	/**
	 * 
	 * @return Punkte des Messobjekts, dass den grössten Punktewert hat
	 */
	public int getMaxPointsResult()
	{
		return calcMax(byPoints).getPoints();
	}
	
	/**
	 * 
	 * @return Namenlänge des Messobjekts, dass den längsten Namen hat
	 */
	public double getMaxNameLength()
	{
		return calcMax(byNameLen).getName().length();
	}
	
	/**
	 * 
	 * @return Name des Messobjekts, dass den grössten Punktewert hat
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
	 * Durchschnittslänge aller Namen der Messobjekte
	 */
	public double getAvgNameLength()
	{			
		return calcAvg(byNameLen);
	}

}
