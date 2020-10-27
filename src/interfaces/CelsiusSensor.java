package interfaces;

public interface CelsiusSensor {
	/** gibt die Temperatur in Celsius zurück **/
	public double getCurrentCelsius();
	
	/** gibt eine eindeutige Id des Sensors zurück **/
    public String getSensorId();
}
