package com.mike.util;

/**
 * Created by michaelbrennan on 9/12/15.
 */
public class Queries {

    private static final String LIMIT = " LIMIT :n";

    public static final String INSERT_SQL = "INSERT INTO block (color, pattern, shape) VALUES (:color, :pattern, :shape)";
    public static final String QUERY_WITH_ID = "SELECT id, color, pattern, shape FROM block WHERE id=:id";
    public static final String ALL_BY_COLOR = "SELECT DISTINCT id, color, pattern, shape FROM block WHERE color = :color";
    public static final String ALL_BY_PATTERN = "SELECT DISTINCT id, color, pattern, shape FROM block WHERE pattern = :pattern";
    public static final String ALL_BY_SHAPE = "SELECT DISTINCT id, color, pattern, shape FROM block WHERE shape= :shape";

    public static final String ALL_BY_COLOR_LIMIT = "SELECT DISTINCT id, color, pattern, shape FROM block WHERE color = :color" + LIMIT;
    public static final String ALL_BY_PATTERN_LIMIT = "SELECT DISTINCT id, color, pattern, shape FROM block WHERE pattern = :pattern" + LIMIT;
    public static final String ALL_BY_SHAPE_LIMIT = "SELECT DISTINCT id, color, pattern, shape FROM block WHERE shape= :shape" + LIMIT;
}
