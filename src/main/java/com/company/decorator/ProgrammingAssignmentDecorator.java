package com.company.decorator;

import com.company.model.ProgrammingAssignment;
import com.company.utils.IRandomizedGenerator;
import com.company.utils.RandomizedGenerator;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: desoleary
 * Date: 2013-05-08
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProgrammingAssignmentDecorator extends ProgrammingAssignment {

    public ProgrammingAssignmentDecorator(){
        // Delegate to base class
        super();
    }

    public ProgrammingAssignmentDecorator(int size){
        // Delegate to base class
        super(size);
    }

    /** public instance methods **/

    /**
     * Returns a list of labels used to label graph
     * @return [ImmutableList<String>]
     */
    public ImmutableList<String> Labels(){
        List<String> result = new ArrayList<String>(getBins().size());

        for(int index = 1; index <= getBins().size(); index++){
            int upperRange = getBinSize()*index;
            int lowerRange = upperRange - getBinSize() + 1;
            result.add(String.format("%s to %s", lowerRange, upperRange));
        }
        return ImmutableList.copyOf(result);
    }

    public String randomizeListStr()
    {
        return join(getRandomisedList());
    }

    public String FirstHalfStr()
    {
        return join(getFirstHalf());
    }

    // Static methods
    // TODO: Move to String extension method and convert to generic method once needed in more than one place
    public static String join(List<Integer> items)
    {
        return Joiner.on(",").join(items);
    }
}
