package Chapter8.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 */
public class RobotInAGrid {

    /* To find a path from the origin, we just work backwards like this.
    * Starting from the last cell, we try to find a path to each of its adjacent cells.
    * The recursive code below implements this algorithm
    *
    *   This solution is O(2^r+c), since each path has r+c steps and there are two choices
    *   we can make at each step.*/

    static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    static boolean getPath(boolean[][] maze, int row, int column, ArrayList<Point> path) {
        //If out of bounds or not available, return.
        if (column < 0 || row < 0 || !maze[row][column]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (column == 0);

        //If there's a path from the start to here, add my location.
        if (isAtOrigin || getPath(maze, row, column - 1, path) || getPath(maze, row - 1, column, path)) {
            Point p = new Point(row, column);
            path.add(p);
            return true;
        }
        return false;
    }

    /*WE SHOULD LOOK FOR A FASTER WAY - Often, we can optimize exponential algorithms by finding duplicate work.
    * This simple change will make our code run substantially faster. This algorithm will now take O(row*column) time
    * because we hit each cell just once
    * */
    ArrayList<Point> getPath1(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        /* If out of bounds or not available,return.*/
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        //If we've already visited this cell, return.
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);

        /*If there's a path from start to my current location, add my location*/
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p); // Cache result
        return false;
    }

}
