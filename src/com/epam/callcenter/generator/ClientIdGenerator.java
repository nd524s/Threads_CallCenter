package com.epam.callcenter.generator;

/**
 * Created by Никита on 09.12.2015.
 */
public class ClientIdGenerator {
    private static int id;

    public ClientIdGenerator() {
    }

    public static int generate(){
        return ++id;
    }
}
