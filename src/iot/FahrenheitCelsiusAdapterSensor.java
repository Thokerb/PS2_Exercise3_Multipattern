package iot;

import interfaces.CelsiusSensor;
import interfaces.FahrenheitSensor;

public class FahrenheitCelsiusAdapterSensor implements CelsiusSensor {

    private FahrenheitSensor fahrenheitSensor;

    public FahrenheitCelsiusAdapterSensor(FahrenheitSensor fahrenheitSensor){

        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getCurrentCelsius() {
        return  (( 5 *(fahrenheitSensor.getCurrentFahrenheit() - 32.0)) / 9.0);
    }

    @Override
    public String getSensorId() {
        return fahrenheitSensor.getSensorId();
    }
}
