package com.epam.callcenter.pool;

import com.epam.callcenter.entity.Operator;
import com.epam.callcenter.exception.ResourceException;
import com.epam.callcenter.thread.Client;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ������ on 06.12.2015.
 */
public class OperatorPool {
    private LinkedList<Operator> operators = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    static Logger log = Logger.getLogger(OperatorPool.class);

    public OperatorPool() {
    }

    public OperatorPool(LinkedList<Operator> operators){
        this.operators.addAll(operators);
    }

    public Operator getOperator(Client client) throws ResourceException {
        lock.lock();
        Operator availableOperator = null;

        if (operators.isEmpty()) {
            lock.unlock();
            throw new ResourceException("Data not found in collection-'operators'");
        }

        for (Operator operator : operators) {
            if (operator.isAvailable()) {
                availableOperator = operator;
            }
        }

        if (availableOperator != null) {
            availableOperator.setIsAvailable(false);
            log.info("Client " + client.getClientId() + " took operator " + availableOperator.getOperatorId());
        } else {
            log.info("Client " + client.getClientId() + " doesn't took operator ");
        }

        lock.unlock();
        return availableOperator;
    }

    public LinkedList<Operator> getOperators() {
        LinkedList<Operator> list = new LinkedList<>();

        for (Operator client : operators) {
            list.add(client);
        }
        return list;
    }

    public void setOperators(LinkedList<Operator> operators) {
        this.operators = operators;
    }
}
