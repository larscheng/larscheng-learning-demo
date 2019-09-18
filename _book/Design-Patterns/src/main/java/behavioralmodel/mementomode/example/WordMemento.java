package behavioralmodel.mementomode.example;

/**
 * 描述:
 * 备忘录
 *
 * @author lars
 * @date 2019/7/19 14:03
 */
public class WordMemento {
    private String note;

    public WordMemento(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
