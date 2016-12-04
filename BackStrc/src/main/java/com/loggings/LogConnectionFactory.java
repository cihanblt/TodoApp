package com.loggings;


import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by cihanblt on 10/21/2016.
 */
public class LogConnectionFactory {

    private static Properties prop = new Properties();

    private InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");

    {
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final String DB_URL = prop.getProperty("spring.datasource.url");

    private final String DB_USER = prop.getProperty("spring.datasource.username");

    private final String DB_PASS = prop.getProperty("spring.datasource.password");

    private static interface Singleton {
        final LogConnectionFactory INSTANCE = new LogConnectionFactory();
    }

    private final DataSource dataSource;

    private LogConnectionFactory() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.dataSource = setupDataSource(DB_URL);
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }

    public DataSource setupDataSource(String connectURI) {
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectURI, DB_USER, DB_PASS);
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
        ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory);
        poolableConnectionFactory.setPool(connectionPool);
        PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(connectionPool);

        return dataSource;
    }
}
