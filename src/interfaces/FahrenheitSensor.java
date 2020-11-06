package interfaces;

//TODO: use an interface naming convention IFahrenheitSensor
public interface FahrenheitSensor {
	/** gibt die Temperatur in Fahrenheit zurück **/
	public double getCurrentFahrenheit();
	
	/** gibt eine eindeutige Id des Sensors zurück **/
    public String getSensorId();
}
