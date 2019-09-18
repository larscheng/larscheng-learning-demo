package behavioralmodel.chainofresponsibility.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/12 18:35
 */
public class Client {
    public static void main(String[] args) {
        DnsServer small = new HangzhouDnsServer();

        DnsServer big = new ZheJiangDnsServer();

        DnsServer bigBig = new HuaBeiDnsServer();

        small.setUpDnsServer(big);
        big.setUpDnsServer(bigBig);

        System.out.println(small.resolve("www.sadas.com").toString());
        System.out.println(small.resolve("www.sadas.cn").toString());
        System.out.println(small.resolve("www.sadas.net").toString());
    }
}
