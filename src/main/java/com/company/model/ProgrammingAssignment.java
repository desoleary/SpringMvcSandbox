package com.company.model;

import com.company.utils.IRandomizedGenerator;
import com.company.utils.RandomizedGenerator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: desoleary
 * Date: 2013-05-03
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProgrammingAssignment {
    private final int size;
    private final int binSize;
    private final ImmutableList<Integer> bins;
    private final ImmutableList<Integer> randomisedList;
    private final ImmutableList<Integer> firstHalf;

    // Constructors

    /**
     * Delegate chain constructor
     */
    public ProgrammingAssignment(){
        this(20);
    }

    /**
     * Delegate chain constructor
     * @param size array size to be generated
     */
    public ProgrammingAssignment(int size){

        this(size, new RandomizedGenerator());

    }

    /**
     * Main constructor that instantiates the main logic to allow for getting methods
     * to effectively cache the response in each instance.
     * @param size   array size to be generated
     * @param random randomised generator that randomizes sequential list
     */
    public ProgrammingAssignment(int size, IRandomizedGenerator random){
        if (size < 20)      throw new IllegalArgumentException("Size must be >= 20");
        if (size % 2 != 0)  throw new IllegalArgumentException(String.format("Size '%s' must be an even number", size));
        if (size % 20 != 0) throw new IllegalArgumentException(String.format("Size '%s' is not divisible by 20", size));

        this.size           = size;
        this.binSize        = sizeDivTwo() / 10;
        this.randomisedList = random.randomizeListFor(size);
        this.firstHalf      = this.randomisedList.subList(0, sizeDivTwo());
        this.bins           = separateIntoBins();
    }

    // Properties
    public int getSize() {
        return size;
    }

    // public instance methods
    protected ImmutableList<Integer> getBins(){
        return bins;
    }

    // protected properties
    protected int getBinSize()
    {
        return binSize;
    }

    protected ImmutableList<Integer> getFirstHalf()
    {
        return firstHalf;
    }

    protected ImmutableList<Integer> getRandomisedList()
    {
        return randomisedList;
    }

    // private instance methods

    /**
     * Separates randomized first half of sequential list into appropriate bins
     * based range tolerance
     * @return  list of bins with each having the number of random numbers that we're in range for each bin
     */
    private ImmutableList<Integer> separateIntoBins()
    {
        int halfSize = sizeDivTwo();
        List<Integer> bins = Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        for (int randomNumber : getFirstHalf()) {
            if (randomNumber <= halfSize){
                int binIndex = (randomNumber - 1) / getBinSize();
                bins.set(binIndex, bins.get(binIndex) + 1);
            }
        }
        return ImmutableList.copyOf(bins);
    }

    private int sizeDivTwo()
    {
        return size/2;
    }
}
