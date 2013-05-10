package com.company.model

import com.company.decorator.ProgrammingAssignmentDecorator
import com.company.utils.RandomizedGenerator
import com.google.common.collect.ImmutableList
import org.testng.annotations.Test

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created with IntelliJ IDEA.
 * User: desoleary
 * Date: 2013-05-03
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
class ProgrammingAssignmentTest{

    @Test
    void testShouldReturnFirstHalfOfRandomizedList(){
        // Initialize
        int size                             = 20
        ImmutableList<Integer> randomNumbers = ImmutableList.copyOf([10,1,15,6,13,5,12,2,18,16,20,9,14,3,8,4,7,11,19,17]);
        List<Integer> expectedRandomNumbers  = [10,1,15,6,13,5,12,2,18,16];

        // Stubbing
        RandomizedGenerator mockRandom = mock(RandomizedGenerator.class)
        when(mockRandom.randomizeListFor(size)).thenReturn(randomNumbers)

        // Execution
        ProgrammingAssignment assignment = new ProgrammingAssignment(size, mockRandom);
        ImmutableList<Integer> actual = assignment.getFirstHalf()

        // Assertions
        GroovyTestCase.assertEquals(10, actual.size())
        GroovyTestCase.assertEquals(expectedRandomNumbers, actual)
    }

    @Test
    void testShouldSeparateSimpleRandomizedListIntoAppropriateBins(){
        // Initialize
        int size                             = 20
        ImmutableList<Integer> randomNumbers = ImmutableList.copyOf([10,1,15,6,13,5,12,2,18,16,20,9,14,3,8,4,7,11,19,17]);
        List<Integer> expectedBinList        = [1,1,0,0,1,1,0,0,0,1];

        // Stubbing
        RandomizedGenerator mockRandom = mock(RandomizedGenerator.class)
        when(mockRandom.randomizeListFor(size)).thenReturn(randomNumbers)

        // Execution
        ProgrammingAssignment assignment = new ProgrammingAssignment(size, mockRandom);
        ImmutableList<Integer> actual = assignment.getBins()

        // Assertions
        GroovyTestCase.assertEquals(10, actual.size())
        GroovyTestCase.assertEquals(expectedBinList, actual)
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Size '26' is not divisible by 20")
    void testShouldRaiseArgumentErrorWhenGivenSizeNotDivisibleBy20() {
        new ProgrammingAssignment(26);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Size must be >= 20")
    void testShouldRaiseErrorWhenSizeLessThan20(){
        new ProgrammingAssignment(19);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Size '25' must be an even number")
    void testShouldRaiseErrorWhenGivenOddNumber(){
        new ProgrammingAssignment(25);
    }

    @Test
    void testShouldDisplayLabels(){
        List<String> expectedLabel = ["1 to 10", "11 to 20", "21 to 30", "31 to 40", "41 to 50", "51 to 60", "61 to 70", "71 to 80", "81 to 90", "91 to 100"]
        GroovyTestCase.assertEquals(expectedLabel, new ProgrammingAssignmentDecorator(200).Labels())
    }
}