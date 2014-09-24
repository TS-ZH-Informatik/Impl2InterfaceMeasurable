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
	

	
	//--- Auswertungen
	
	/**
	 * Ermittelt den Durchschnitt aller Messobjekte
	 * @param accessor Beschreibt welcher Wert der Messobjekte summiert werden soll
	 * @return Durchschnitt der summierten Messobjekte
	 */
	public double calcAvg(IValueAccessor accessor) {
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
	public IMeasurable calcMax(IValueAccessor accessor)
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

}
