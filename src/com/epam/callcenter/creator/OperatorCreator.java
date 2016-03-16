package com.epam.callcenter.creator;

import com.epam.callcenter.entity.Operator;
import com.epam.callcenter.generator.OperatorIdGenerator;

import java.util.LinkedList;

/**
 * Created by Никита on 06.12.2015.
 */
public class OperatorCreator {
    private LinkedList<Operator> operatorList = new LinkedList<>();
    {
        operatorList.add(new Operator(OperatorIdGenerator.generate(), true));
        operatorList.add(new Operator(OperatorIdGenerator.generate(), true));
        operatorList.add(new Operator(OperatorIdGenerator.generate(), true));
        operatorList.add(new Operator(OperatorIdGenerator.generate(), true));
    }

    public OperatorCreator() {
    }

    public LinkedList<Operator> getOperatorList() {
        LinkedList<Operator> list = new LinkedList<>();
        for (Operator client : operatorList) {
            list.add(client);
        }
        return list;
    }

    public void addOperator(Operator operator){
        operatorList.add(operator);
    }

    public void removeOperator(Operator operator){
        operatorList.remove(operator);
    }

    public Operator getOperator(int index){
        return operatorList.get(index);
    }

    public void setOperatorList(LinkedList<Operator> operators) {
        this.operatorList = operators;
    }

}
