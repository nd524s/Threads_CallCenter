package com.epam.callcenter.generator;

/**
 * Created by ������ on 09.12.2015.
 */
public class OperatorIdGenerator {
        private static int id;

        private OperatorIdGenerator(){}

        public static int generate(){
            return ++id;
        }
}
