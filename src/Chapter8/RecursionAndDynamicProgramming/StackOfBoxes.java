package Chapter8.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Stack of Boxes: You have a stack of n boxes, with widths Wi' heights hi' and depths d1• The boxes
 * cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
 * larger than the box above it in width, height. and depth. Implement a method to compute the
 * height of the tallest possible stack. The height of a stack is the sum of the heights of each box.
 */
public class StackOfBoxes {
    int createStack(ArrayList<Box> boxes) {
        //Sort in descending order by height.
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
    }

    //Better Solution


    int createStack1(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack1(boxes, i, stackMap);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int createStack1(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack1(boxes, i, stackMap);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        stackMap[bottomIndex] = maxHeight;
        return maxHeight;
    }

    /*
        Solution Using Memoization
     */
    int createStack2(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] stackMap = new int[boxes.size()];
        return createStack2(boxes, null, 0, stackMap);
    }

    private int createStack2(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap) {
        if (offset >= boxes.size()) return 0; //Base case

        // height with this bottom
        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (stackMap[offset] == 0) {
                stackMap[offset] = createStack2(boxes, newBottom, offset + 1, stackMap);
                stackMap[offset] += newBottom.height;
            }
            heightWithBottom = stackMap[offset];
        }
        //without this bottom
        int heightWithoutBottom = createStack2(boxes, bottom, offset + 1, stackMap);

        //Return better of two options
        return Math.max(heightWithBottom, heightWithoutBottom);
    }

}
