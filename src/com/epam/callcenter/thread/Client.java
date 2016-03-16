package com.epam.callcenter.thread;

import com.epam.callcenter.entity.Operator;
import com.epam.callcenter.exception.ResourceException;
import com.epam.callcenter.pool.OperatorPool;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Никита on 06.12.2015.
 */
public class Client extends Thread {
    static Logger log = Logger.getLogger(Client.class);
    private int clientId;
    private OperatorPool pool;

    public Client(){}

    public Client(int clientId, OperatorPool pool){
        this.clientId = clientId;
        this.pool = pool;
    }

    private void talking(){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            log.warn("Error of waiting time", e);
        }
    }

    private void waiting(){
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            log.warn("Error of waiting time",e);
        }
    }

    public void run(){
        boolean flag = true;
        Operator operator = null;

        while (flag) {
            try {
                operator = pool.getOperator(this);
            } catch (ResourceException e) {
                log.error("Error", e);
            }

            if (operator != null) {
                flag = false;
            } else {
                waiting();
            }
        }
        talking();
        log.info("Client " + this.getClientId() + " free operator " + operator.getOperatorId());
        operator.setIsAvailable(true);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public OperatorPool getPool() {
        return pool;
    }

    public void setPool(OperatorPool pool) {
        this.pool = pool;
    }
}
