package Chapter7.ObjectOrientedDesign.call_center;

/**
 * Created by hnastevska on 6/28/2017.
 */
public class Call {
    /* Minimal rank of employee who can handle this call */
    private Rank rank;

    /*Person who is calling. */
    private Caller caller;

    /*Employee who is handling call */
    private Employee handler;

    public  Call (Caller c){
        rank = Rank.RESPONDER;
        caller = c;
    }

    /* Set employee who is handling call */
    public void setHandler(Employee e){
        handler = e;
    }
    public void  reply(String message){
        return;
    }
    public Rank getRank() {
        return rank;
    }
    public void setRank(Rank r){
        rank = r;
    }
    public Rank incrementRank(){
        return null;
    }
    public  void disconnect(){

    }


}
