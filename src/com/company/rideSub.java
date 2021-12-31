package com.company;

public interface rideSub {
    public void subscribe(driverAndRideObserver ob);
    public void unsubscribe(driverAndRideObserver ob);
    public void Notify();
}
