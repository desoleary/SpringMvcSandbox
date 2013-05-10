package com.company.utils;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: desoleary
 * Date: 2013-05-06
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IRandomizedGenerator {
    public ImmutableList<Integer> randomizeListFor(int size);
}
