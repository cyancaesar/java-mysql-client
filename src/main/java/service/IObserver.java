package service;

import model.Event;
import model.IConnectionListener;

public interface IObserver {
    void registerObserver(Event event, IConnectionListener listener);
    void unregisterObserver(Event event, IConnectionListener listener);
    void notifyObservers(Event event);
}
