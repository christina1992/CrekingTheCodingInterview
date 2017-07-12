package Chapter9.SystemDesignAndScalability;

import java.util.ArrayList;

/**
 * Created by hnastevska on 7/10/2017.
 */
public class Person {
    int id;
    ArrayList<Integer> friends;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }
}
