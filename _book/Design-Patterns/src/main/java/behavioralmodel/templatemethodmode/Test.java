package behavioralmodel.templatemethodmode;

/**
 * 描述:
 比如春运回家会经历：买票、到达车站、检票、上车、到达目的地

 其中整体的流程相同，但是每个人春运回家的交通工具是不同的

 其中
 抽象类：春运回家，模板方法（买票、到达车站、检票、上车、到达目的地），抽象方法（买票、到达车站、上车）具体方法（检票、到达目的地）
 坐火车回家：具体类
 坐高铁回家：具体类
 *
 * @author lars
 * @date 2019/7/10 10:54
 */
public class Test {

    public static void main(String[] args) {

        SpringBackHome backHome1 = new Train();
        backHome1.templateMethod();


        SpringBackHome backHome2 = new HighSpeedRail();
        backHome2.templateMethod();


    }
}
