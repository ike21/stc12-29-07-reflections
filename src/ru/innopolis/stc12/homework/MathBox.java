package ru.innopolis.stc12.homework;

import java.util.*;

@Logged

public class MathBox extends ObjectBox implements Box {
    private Set<? extends Number> set = new TreeSet<>();

    public MathBox(Number[] array) throws WrongObjectArgument {
        super(array);
        set.addAll(super.getSet());
    }

    @ClearData
    public Set getSet() {
        return set;
    }

    @ClearData
    public Double summator() {
        Double sum = 0.0;
        for (Number o : set) {
            sum += o.doubleValue();
        }
        return sum;
    }

    @ClearData
    public List splitter(Number denominator) {
        List<Number> split = new LinkedList<>();
        for (Number o : set) {
            if (denominator.doubleValue() != 0) {
                split.add(o.doubleValue() / denominator.doubleValue());
            }
        }
        return split;
    }

}
