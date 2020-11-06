package intranet;

import interfaces.ObservableCelsiusSensor;
import java.util.Collection;

public class Leitstand extends Observer {

    private Collection<ObservableCelsiusSensor> allObservableSensors;

    public Leitstand(Collection<ObservableCelsiusSensor> allObservableSensors) {
        super(allObservableSensors);
    }

    @Override
    public void update(String sensorId, double temperature) {
        System.out.println("[Leitstand] Sensor "+sensorId+": "+temperature);
    }

}
