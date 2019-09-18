package behavioralmodel.mementomode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/19 14:21
 */
public class Client {

    public static void main(String[] args) {
        Word2016 word2016 = new Word2016();

        WordUser wordUser = new WordUser();

        //写文档
        wordUser.setNote("你好！");
        //创建备忘录
        WordMemento wordMemento = wordUser.createMemento();
        //管理备忘录
        word2016.add(wordMemento);
        //写文档
        wordUser.setNote("你好！我叫李四。");
        //创建备忘录
        wordMemento = wordUser.createMemento();
        //管理备忘录
        word2016.add(wordMemento);
        //写文档
        wordUser.setNote("你好！我叫李四。你叫啥？");
        //创建备忘录
        wordMemento = wordUser.createMemento();
        //管理备忘录
        word2016.add(wordMemento);

        //恢复
        wordUser.restoreMemento(word2016.get());
        //恢复后的word内容
        System.out.println(wordUser.getNote());

        //恢复+1
        wordUser.restoreMemento(word2016.get());
        //恢复+1后的word内容
        System.out.println(wordUser.getNote());

        //写文档
        wordUser.setNote("你好！我叫张三");
        //创建备忘录
        wordMemento = wordUser.createMemento();
        //管理备忘录
        word2016.add(wordMemento);

        //恢复
        wordUser.restoreMemento(word2016.get());
        //恢复后的word内容
        System.out.println(wordUser.getNote());

    }
}
