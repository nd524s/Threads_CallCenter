package com.epam.callcenter.creator;

import com.epam.callcenter.entity.Operator;
import com.epam.callcenter.pool.OperatorPool;
import com.epam.callcenter.thread.Client;

import java.util.LinkedList;

/**
 * Created by Никита on 06.12.2015.
 */
public class ClientCreator {

    public void clientRunner(int clientId, OperatorPool pool){
        new Client(clientId,pool).start();
    }
}
