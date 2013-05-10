package com.company.util

import com.company.utils.RandomizedGenerator

/**
 * Created with IntelliJ IDEA.
 * User: desoleary
 * Date: 2013-05-06
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */
class RandomizedGeneratorTest extends GroovyTestCase{
    void testShouldRandomizeList(){
        // Initialise
        int size = 20;

        // Execution
        List<Integer> list = new RandomizedGenerator().randomizeListFor(size);

        // Assertions
        assertEquals(size, list.size())
    }
}
