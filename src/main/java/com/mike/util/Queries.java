package com.mike.util;

/**
 * Created by michaelbrennan on 9/12/15.
 */
public class Queries {

    public static final String INSERT_SQL = "INSERT INTO block (color, pattern, shape) VALUES (:color, :pattern, :shape)";
    public static final String QUERY_WITH_ID = "SELECT id, color, pattern, shape FROM block where id=:id";
}
