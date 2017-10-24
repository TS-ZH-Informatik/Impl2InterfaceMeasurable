package hf.see.java.impl2;

/**
 * Methoden die Berechnungen mit den Messobjekten durchführen, können mithilfe dieses Interfaces Werte abfragen
 * Ähnlich dem Command-Pattern
 *
 */
interface IValueAccessor {
	int getValue(IMeasurable result);
}

/**
 * Enthält mögliche Implementationen von IValueAccessor
 *
 */
class PreDefinedValueAccessors
{
	/**
	 * Gibt die Punkte eines Messobjekts zurück
	 */
	private static IValueAccessor byScore = new IValueAccessor() {
		@Override
		public int getValue(IMeasurable result) {
			return result.getScore();
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
	
	public static IValueAccessor byScore()
	{
		return byScore;
	}
	
	
	public static IValueAccessor byNameLen()
	{
		return byNameLen;
	}
	
}




