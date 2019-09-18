package behavioralmodel.statemode.example;

/**
 * 描述:
 * 环境类
 *
 * @author lars
 * @date 2019/7/16 14:35
 */
public class PersonContext {
    private PersonMood personMood;

    public PersonContext() {
        this.personMood = new Happy();
    }

    public PersonMood getPersonMood() {
        return personMood;
    }

    public void setPersonMood(PersonMood personMood) {
        this.personMood = personMood;
    }

    public void pickMoney(){
        System.out.println("中彩票了");
        setPersonMood(new Happy());
        personMood.mood();
    }

    public void lostMoney(){
        System.out.println("丢了100块");
        setPersonMood(new Sad());
        personMood.mood();
    }

    public void eatThings(){
        System.out.println("去吃海底捞");
        setPersonMood(new Excited());
        personMood.mood();
    }
}
