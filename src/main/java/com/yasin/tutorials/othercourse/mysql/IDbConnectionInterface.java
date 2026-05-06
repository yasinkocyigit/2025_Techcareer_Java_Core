package com.yasin.tutorials.othercourse.mysql;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDbConnectionInterface<T> {

    void create(T t);

    void update(T t);

    void delete(T t);

    ArrayList<T> list();

    // gövdeli method
    default Connection getInterfaceConnection() {
        DBConnection connection = new DBConnection();
        return connection.connectionMethod();
    };

}