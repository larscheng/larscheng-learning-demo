package behavioralmodel.visitormode.demo;

/**
 * @auther: zhengql
 * @date: 2019/7/18 11:51
 * @description:
 */
public interface Element {
    void accept(Visitor visitor);
}
