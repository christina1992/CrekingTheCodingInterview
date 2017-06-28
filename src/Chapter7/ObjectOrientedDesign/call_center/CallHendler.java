package Chapter7.ObjectOrientedDesign.call_center;

import java.util.List;

/**
 * Created by hnastevska on 6/28/2017.
 */
public class CallHendler {
    /* 3 levels of employees: respondents, managers, directors */
    private final int LEVELS = 3;

    /* Initializing 10 respondents, 4 managers, and 2 directors. */
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    /* List of employees, by level.
    * employeeLevels[0] = respondents
    * employeeLevels[1] = managers
    * employeeLevels[2] = directors
    * */
    List<List<Employee>> employeeLevels;

    /* queues for each call's rank*/
    List<List<Call>> callQueues;

    public CallHendler(List<List<Employee>> employeeLevels, List<List<Call>> callQueues) {
        this.employeeLevels = employeeLevels;
        this.callQueues = callQueues;
    }

    /*Gets the first available employee who will handle this call.*/
    public Employee getHandlerForCall(Call call) {
        return null;
    }

    /*Routes the call to an available employee, or saves in a queue if no employee
     * is available */
    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    /*Routes the call to an available employee, or saves in a queue if no employee
     * is available */
    public void dispatchCall(Call call) {
        /*Try to route the call to an employee with minimal rank.*/
        Employee emp = getHandlerForCall(call);
        if (emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            /*Place the call into corresponding call queue according to its rank. */
            call.reply("Please wait for free employee to reply");
            //callQueues.get(call.getRank().getValue().add(call));
        }
    }

    /*An employee got free. Look for a waiting call that employee can serve. Return
     * true if we assigned a call, false otherwise. */
    public boolean assignCall(Employee emp) {
        return true;
    }
}
