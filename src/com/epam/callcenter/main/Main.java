package com.epam.callcenter.main;

import com.epam.callcenter.creator.ClientCreator;
import com.epam.callcenter.creator.OperatorCreator;
import com.epam.callcenter.entity.Operator;
import com.epam.callcenter.generator.ClientIdGenerator;
import com.epam.callcenter.pool.OperatorPool;
import com.epam.callcenter.thread.Client;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.LinkedList;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        OperatorCreator operatorCreator = new OperatorCreator();
        OperatorPool pool = new OperatorPool(operatorCreator.getOperatorList());
        ClientCreator clientCreator = new ClientCreator();

        for (int i = 0; i < 8; i++) {
            clientCreator.clientRunner(ClientIdGenerator.generate(), pool);
        }
    }
}
