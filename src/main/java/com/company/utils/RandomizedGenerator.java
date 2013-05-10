package com.company.utils;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomizedGenerator implements IRandomizedGenerator {
    // public instance methods
    public ImmutableList<Integer> randomizeListFor(int size) {
        List<Integer> results = GenerateListFrom(size);
        Collections.shuffle(results);
        return ImmutableList.copyOf(results);
    }

    /** Returns a list of length +size with values of 1 to +size
     *
     */
    private List<Integer> GenerateListFrom(final int size)
    {
        List<Integer> list = new ArrayList<Integer>(size);
        for (int i = 1; i <= size; i++) { list.add(i); }
        return list;
    }
}
