package intranet;

import interfaces.ObservableCelsiusSensor;
import java.util.Collection;

public class InternetSeite extends Observer {

    private Collection<ObservableCelsiusSensor> allObservableSensors;

    public InternetSeite(Collection<ObservableCelsiusSensor> allObservableSensors) {
        super(allObservableSensors);
    }

    @Override
    public void update(String sensorId, double temperature) {
        System.out.println("[InternetSeite] Sensor "+sensorId+": "+temperature);
    }
}
