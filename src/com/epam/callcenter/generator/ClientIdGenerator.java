package com.epam.callcenter.generator;

/**
 * Created by ������ on 09.12.2015.
 */
public class ClientIdGenerator {
    private static int id;

    public ClientIdGenerator() {
    }

    public static int generate(){
        return ++id;
    }
}
