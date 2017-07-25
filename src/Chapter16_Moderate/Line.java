package Chapter16_Moderate;

/**
 * Created by hnastevska on 7/17/2017.
 */
public class Line {
    public double slope, yintercept;

    public Line(Point start, Point end) {
        double deltaY = end.y - start.y;
        double deltaX = end.x - start.x;
        slope = deltaY / deltaX; // will be infinity (not exception) when deltaX = 0;
        yintercept = end.y - slope * end.x;
    }
}
