### 组合模式

又叫做“部分-整体模式”，它是一种将对象组合成树状层次结构的模式，用来表示“部分-整体”的关系，使用户对单个对象和组合对象具有一致的访问性

eg：一个公司的的组织建构就是典型的组合模式，对外是一个对象公司，内部其实是由多个子公司对象组合而成

再比如 操作系统中的文件夹与文件的关系也可以用组合模式


### 优缺点

优点

- 可以实客户端代码一致性的处理单个对象和组合对象，无需关心他是什么对象
- 组合体内加入新对象相对容易，并且客户端不会受到影响

缺点：

- 设计复杂度增加


### 角色和实现

- 抽象构件角色：为树叶、树枝构件角色生命公共接口，并实现其默认行为。

- 树叶构件角色：是组合中的叶子节点，他没有子节点，用于实现抽象构件角色中的声明的公共接口

- 树枝构件角色：是组合中的分支节点对象，他有子节点，它实现抽象构建角色中声明的接口，其作用是存储和管理子部件，通常包含add、remove、getchild方法

- 客户角色：通过抽象构建角色访问控制对象

组合模式分为`透明式`组合模式和`安全式`组合模式

透明式：抽象构件角色声明了所有子类中的全部方法，客户端无需区别树叶对象和树枝对象，对客户端来说是透明的，导致树叶对象本来是没有add、remove这些方法的却要去实现他们呢，存在安全性问题

![](http://c.biancheng.net/uploads/allimg/181115/3-1Q1151G62L17.gif)

安全式：将管理子构件的方法移到树枝构件中，抽象构件和树叶构件没有对子对象的管理方法，如此避免了透明式的安全性问题，但由于叶子和分支有不同的接口，客户端在调用时要指代树叶对象和树枝对象的存在，所以失去了透明性

![](http://c.biancheng.net/uploads/allimg/181115/3-1Q1151GF5221.gif)

```java


/**
 * 描述:
 *
 * 访问树形集合
 *              c0
 *      leaf1       c1
 *            leaf2   leaf3
 * 透明式组合模式
 *
 * @author lars
 * @date 2019/7/8 14:32
 */
public class CompositeModeTest1 {

    /***
     * 抽象构件角色
     */
    interface Compoent {
        public void add(Compoent compoent);

        public void remove(Compoent compoent);

        public Compoent getChild(int i);

        public void operation();
    }

    /**
     * 树叶构件角色
     */
    static class Leaf implements Compoent {


        private String name;

        public Leaf(String name) {
            this.name = name;
        }

        @Override
        public void add(Compoent compoent) {

        }

        @Override
        public void remove(Compoent compoent) {

        }

        @Override
        public Compoent getChild(int i) {
            return null;
        }

        @Override
        public void operation() {
            System.out.println("树叶 " + name + " 被访问");
        }
    }


    /**
     * 树枝构件角色
     */
    static class Composite implements Compoent{

        private List<Compoent> compoents = new ArrayList<Compoent>();

        @Override
        public void add(Compoent compoent) {
            compoents.add(compoent);
        }

        @Override
        public void remove(Compoent compoent) {
            compoents.remove(compoent);
        }

        @Override
        public Compoent getChild(int i) {
            return compoents.get(i);
        }

        @Override
        public void operation() {
            compoents.forEach(Compoent::operation);
        }
    }

    /**
     * 客户端角色
     */
    static class Client{
        public Client() {

            Compoent c0 = new Composite();
            Compoent c1 = new Composite();
            Compoent leaf1 = new Leaf("1");
            Compoent leaf2 = new Leaf("2");
            Compoent leaf3 = new Leaf("3");
            c0.add(leaf1);
            c0.add(c1);
            c1.add(leaf2);
            c1.add(leaf3);

            c0.operation();

            c1.operation();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}

```


### 模拟场景

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190708162505.png)

经典模拟场景，文件文件夹

```java
package structuredmodel.compositemode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:文件文件夹---组合模式
 *
 * @author lars
 * @date 2019/7/8 15:40
 */
public class FileDemoTest {

    /**
     * 抽象构件角色：文件
     */
    interface File{
        public void display();
    }

    /**
     * 树叶构件角色：文本文件
     */
    static class textFile implements File{

        private String name;

        public textFile(String name) {
            this.name = name;
        }

        @Override
        public void display() {
            System.out.println("txt文件："+name);
        }
    }

    /***
     * 树叶构件角色：图片文件
     */
    static class imgFile implements File{

        private String name;

        public imgFile(String name) {
            this.name = name;
        }

        @Override
        public void display() {
            System.out.println("图片文件："+name);
        }
    }

    /**
     * 树枝构件角色：文件夹
     */
    static class Folder implements File{

        private String name;
        private List<File> files = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void add(File file) {
            files.add(file);
        }

        public void del(File file) {
            files.remove(file);
        }

        @Override
        public void display() {
            System.out.println("当前文件夹目录: "+name);
            files.forEach(File::display);
        }
    }

    static class Client{

        public Client() {
            Folder folder1 = new Folder("/root");
            Folder folder2 = new Folder("/root/home");

            textFile textFile1 = new textFile("demo.txt");
            textFile textFile2 = new textFile("example.txt");
            imgFile imgFile1 = new imgFile("demo.jpg");
            imgFile imgFile2 = new imgFile("example.jpg");

            folder1.add(textFile1);
            folder1.add(folder2);
            
            folder2.add(textFile2);
            folder2.add(imgFile1);
            folder2.add(imgFile2);

            folder1.display();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}

```
