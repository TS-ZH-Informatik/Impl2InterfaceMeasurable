package hf.see.java.impl2;

/**
 * Methoden die Berechnungen mit den Messobjekten durchf�hren, k�nnen mithilfe dieses Interfaces Werte abfragen
 * �hnlich dem Command-Pattern
 * @author Elia Seikritt
 *
 */
interface IValueAccessor {
	int getValue(IMeasurable result);
}

/**
 * Enth�lt m�gliche Implementationen von IValueAccessor
 * @author Elia Seikritt
 *
 */
class PreDefinedValueAccessors
{
	/**
	 * Gibt die Punkte eines Messobjekts zur�ck
	 */
	private static IValueAccessor byPoints = new IValueAccessor() {
		@Override
		public int getValue(IMeasurable result) {
			return result.getPoints();
		}
	};
	
	/**
	 * Gibt die Stringl�nge des Namens eines Messobjekts zur�ck
	 */
	private static IValueAccessor byNameLen = new IValueAccessor() {
		@Override
		public int getValue(IMeasurable result) {
			return result.getName().length();
		}
	};
	
	public static IValueAccessor byPoints()
	{
		return byPoints;
	}
	
	
	public static IValueAccessor byNameLen()
	{
		return byNameLen;
	}
	
}




