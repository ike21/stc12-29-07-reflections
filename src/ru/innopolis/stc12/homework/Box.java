package ru.innopolis.stc12.homework;

import java.util.List;
import java.util.Set;

public interface Box {
    Set getSet();

    Double summator();

    List splitter(Number denominator);
}
