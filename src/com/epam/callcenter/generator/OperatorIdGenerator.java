package com.epam.callcenter.generator;

/**
 * Created by Никита on 09.12.2015.
 */
public class OperatorIdGenerator {
        private static int id;

        private OperatorIdGenerator(){}

        public static int generate(){
            return ++id;
        }
}
