package com.epam.callcenter.entity;

import com.epam.callcenter.exception.ResourceException;
import com.epam.callcenter.thread.Client;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Никита on 06.12.2015.
 */
public class Operator {
    private int operatorId;
    private boolean isAvailable;

    public Operator() {
    }

    public Operator(int operatorId, boolean isAvailable) {
        this.operatorId = operatorId;
        this.isAvailable = isAvailable;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

