package org.example.lv3.calculator;

import java.util.List;

public interface Find<T extends Number> {
    List<T> find(List<T> resultList, double standardValue);
}
