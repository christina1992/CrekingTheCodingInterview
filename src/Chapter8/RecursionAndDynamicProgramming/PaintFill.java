package Chapter8.RecursionAndDynamicProgramming;

/**
 * Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 * The Solution represent DFC search in a graph, we could do this with BFS also
 */
public class PaintFill {
    boolean PaintFill(Color[][] screen, int r, int c, Color ncolor) {
        if (screen[r][c] == ncolor) return false;
        return PaintFill(screen, r, c, screen[r][c], ncolor);
    }

    private boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }

        if (screen[r][c] == ocolor) {
            screen[r][c] = ncolor;
            PaintFill(screen, r - 1, c, ocolor, ncolor);// up
            PaintFill(screen, r + 1, c, ocolor, ncolor);//down
            PaintFill(screen, r, c - 1, ocolor, ncolor);//left
            PaintFill(screen, r, c + 1, ocolor, ncolor);//right
        }
        return true;
    }

    /*Pixel by pixel we expand outwards by calling paintFill on the surrounding pixel.
    * When we hit a pixel that is not green,we stop.
    * We can implement this algorithm recursively.*/
    enum Color {
        Black, White, Red, Yellow, Green
    }
}
