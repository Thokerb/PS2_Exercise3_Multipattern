package iot;

import interfaces.CelsiusSensor;
import interfaces.IIntranetObserver;
import interfaces.ObservableCelsiusSensor;
import utils.RepeatedPoll;

import java.util.ArrayList;

//This is the adapter class for CelsiusSensor to make it an ObservableCelsiusSensor
//TODO: naming is rather poor, change it to ObservableCelsiusSensor
public class ObservableSensor implements ObservableCelsiusSensor {


	private ArrayList<IIntranetObserver> ObserverList;
	private double oldValue;
	private CelsiusSensor celsiusSensor;

	public ObservableSensor(CelsiusSensor celsiusSensor) {
		ObserverList = new ArrayList<>();
		this.celsiusSensor = celsiusSensor;
		oldValue = getCurrentCelsius();
		RepeatedPoll.getInstance().repeat(
				() -> {
					var newValue = getCurrentCelsius();
					if (oldValue != newValue) {
						notifyObserver();
						oldValue = newValue;
					}
				}
		);
	}

	@Override
	public double getCurrentCelsius() {
		return celsiusSensor.getCurrentCelsius();
	}

	@Override
	public String getSensorId() {
		return celsiusSensor.getSensorId();
	}

	@Override
	public void registerObserver(IIntranetObserver observer) {
		ObserverList.add(observer);

	}

	@Override
	public void unregisterObserver(IIntranetObserver observer) {
		ObserverList.remove(observer);

	}

	@Override
	public void notifyObserver() {
		for (var observer: ObserverList) {
			observer.update(getSensorId(),getCurrentCelsius());
		}

	}
}