package Chapter7.ObjectOrientedDesign.call_center;

/**
 * Created by hnastevska on 6/28/2017.
 */
public abstract class Employee {
    private Call currentCall = null;
    private Rank rank;

    public Employee(Call currentCall) {
        this.currentCall = currentCall;
    }

    /*Start the conversation */
    public void receiveCall(Call call) {

    }

    /*the issue is resolved, finish the call */
    public void callCompleted() {

    }

    /* the issue has not been resolved. Escalate the call, and assign a new call to
     * the employee */
    public void escalateAndReassign() {

    }

    /* Assign a new call to an employee, if the employee is free */
    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}
