package Chapter8.RecursionAndDynamicProgramming;

import java.util.Comparator;

/**
 * Created by hnastevska on 7/6/2017.
 */
public class BoxComparator implements Comparator<Box> {

    @Override
    public int compare(Box x, Box y) {
        return y.height - x.height;
    }


}
