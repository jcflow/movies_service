package com.juan.movies.model;

public enum Rate {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private final String name;

    Rate(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
