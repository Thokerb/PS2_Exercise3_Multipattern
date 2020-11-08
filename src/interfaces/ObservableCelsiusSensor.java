package interfaces;

//TODO: use an interface naming convention IObservableCelsiusSensor
public interface ObservableCelsiusSensor extends CelsiusSensor {

    //TODO: add observer in methods
    void registerObserver(IIntranetObserver observer);
    void unregisterObserver(IIntranetObserver observer);
    void notifyObserver();
	/** TODO add methods for registerObserver and unregisterObserver ? **/

}
