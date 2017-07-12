package Chapter10.SearchingAndSorting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Missing Int: Given an input file with four billion non-negative integers, provide an algorithm to
 * generate an integer that is not contained in the file. Assume you have 1 GB of memory available for
 * this task.
 * FOLLOW UP
 * What if you have only 10MB of memory? Assume that all the values are distinct and we now have
 * no more than one billion non-negative integers.
 */
public class MissingInt {
    long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
    byte[] bitfield = new byte[(int) (numberOfInts / 8)];
    String filename = "name";

    void findOpenNumber() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            /*
                Finds the corresponding number in the bitfield by using the OR operator to
                set the nth bit of a byte (e.g., 10 would correspond to the 2nd bit of
                index 2 in the byte array
             */
            bitfield[n / 8] |= 1 << (n % 8);
        }
        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                /*
                    Retrieves the individual bits of each byte. When 0 bit is found, print
                    the corresponding value.
                 */
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                    return;
                }
            }
        }
    }

    // SECOND SOLUTION

    int findOpenNumber(String filename) throws FileNotFoundException {
        int rangeSize = (1 << 20); // 2^20 bits (2^17 bytes)

        //Get count of number of values within each block.
        int[] blocks = getCountPerBlock(filename, rangeSize);

        //Find a block with a missing value
        int blockIndex = findBlockWithMissing(blocks, rangeSize);
        if (blockIndex < 0) return -1;

        //Create bit vector for items within this range
        byte[] bitVector = getBitVectorForRange(filename, blockIndex, rangeSize);

        //Find a zero in the bit vector
        int offset = findZero(bitVector);
        if (offset < 0) return -1;

        //Compute missing value
        return blockIndex * rangeSize + offset;

    }

    //Find a zero within the bit vector and return the index
    private int findZero(byte[] bitVector) {
        for (int i = 0; i < bitVector.length; i++) {
            if (bitVector[i] != ~0) { //if not all 1s
                int bitIndex = findZero(bitVector[i]);
                return i * Byte.SIZE + bitIndex;
            }
        }
        return 0;
    }

    //Find index that is 0 within byte
    private int findZero(byte b) {
        for (int i = 0; i < Byte.SIZE; i++) {
            int mask = 1 << i;
            if ((b & mask) == 0) {
                return i;
            }
        }
        return -1;
    }

    // Create a bit vector for the values within a specific range
    private byte[] getBitVectorForRange(String filename, int blockIndex, int rangeSize) throws FileNotFoundException {
        int startRange = blockIndex * rangeSize;
        int endRange = startRange + rangeSize;
        byte[] bitVector = new byte[rangeSize / Byte.SIZE];
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            // if the number is inside the block that's missing numbers, we record it
            if (startRange <= value && value < endRange) {
                int offset = value - startRange;
                int mask = (1 << (offset % Byte.SIZE));
                bitVector[offset / Byte.SIZE] |= mask;
            }
        }
        in.close();
        return bitVector;
    }

    //Find a block whose count is low
    private int findBlockWithMissing(int[] blocks, int rangeSize) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] < rangeSize) {
                return i;
            }
        }
        return -1;
    }

    // Get counts of items within each range
    private int[] getCountPerBlock(String filename, int rangeSize) throws FileNotFoundException {
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] blocks = new int[arraySize];
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            blocks[value / rangeSize]++;
        }
        in.close();
        return blocks;
    }
}
