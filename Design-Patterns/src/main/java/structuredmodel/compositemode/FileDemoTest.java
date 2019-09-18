package structuredmodel.compositemode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
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
