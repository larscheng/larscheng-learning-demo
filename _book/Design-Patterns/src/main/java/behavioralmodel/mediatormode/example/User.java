package behavioralmodel.mediatormode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/17 11:04
 */
public abstract class User {
    String name;

    ChatTool tool;

    public User(String name) {
        this.name = name;
    }

    public void setTool(ChatTool tool) {
        this.tool = tool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChatTool getTool() {
        return tool;
    }

    public abstract void send(String name,String msg);
    public abstract void receive(User from,String msg);

}
