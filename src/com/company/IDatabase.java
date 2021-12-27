package com.company;

public interface IDatabase {
    boolean verify(String user, String pass);

    boolean verifyDriver(String user, String pass);

    boolean addUser(Customer user);

    Customer getUser(String user, String pass);

    boolean addDriver(Driver driver);

    Driver getDriver(String user, String pass);
}
