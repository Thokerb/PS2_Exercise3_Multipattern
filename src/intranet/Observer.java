package intranet;

import interfaces.IIntranetObserver;
import interfaces.ObservableCelsiusSensor;

import java.util.Collection;

abstract class Observer implements IIntranetObserver {

    Collection<ObservableCelsiusSensor> allObservableSensors;

    public Observer(Collection<ObservableCelsiusSensor> allObservableSensors){
        this.allObservableSensors = allObservableSensors;
        for (var observer:allObservableSensors) {
            observer.registerObserver(this);
        }
    }

    @Override
    public abstract void update(String sensorId, double temperature);
}
