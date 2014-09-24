package hf.see.java.impl2;

/**
 * Methoden die Berechnungen mit den Messobjekten durchführen, können mithilfe dieses Interfaces Werte abfragen
 * Ähnlich dem Command-Pattern
 * @author Elia Seikritt
 *
 */
interface IValueAccessor {
	int getValue(IMeasurable result);
}

/**
 * Enthält mögliche Implementationen von IValueAccessor
 * @author Elia Seikritt
 *
 */
class PreDefinedValueAccessors
{
	/**
	 * Gibt die Punkte eines Messobjekts zurück
	 */
	private static IValueAccessor byPoints = new IValueAccessor() {
		@Override
		public int getValue(IMeasurable result) {
			return result.getPoints();
		}
	};
	
	/**
	 * Gibt die Stringlänge des Namens eines Messobjekts zurück
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




