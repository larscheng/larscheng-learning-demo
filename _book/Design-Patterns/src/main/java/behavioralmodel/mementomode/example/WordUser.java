package behavioralmodel.mementomode.example;

/**
 * 描述:
 * 发起人
 *
 * @author lars
 * @date 2019/7/19 14:02
 */
public class WordUser {
    private String note;


    public WordMemento createMemento(){
        return new WordMemento(note);
    }
    public void restoreMemento(WordMemento wordMemento){
        setNote(wordMemento.getNote());
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
