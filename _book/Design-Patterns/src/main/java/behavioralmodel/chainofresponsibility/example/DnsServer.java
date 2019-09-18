package behavioralmodel.chainofresponsibility.example;

import java.util.Random;

/**
 * 描述:
 * 抽象域名服务器
 *
 * @author lars
 * @date 2019/7/12 18:18
 */
public abstract class DnsServer {
    /**
     * 上级dns服务器
     */
    private DnsServer upDnsServer;

    /**
     * 解析域名
     *
     * @param domain 域名
     * @return
     */
    public abstract Address resolve(String domain);

    public DnsServer getUpDnsServer() {
        return upDnsServer;
    }

    public void setUpDnsServer(DnsServer upDnsServer) {
        this.upDnsServer = upDnsServer;
    }

    /**
     * 获取ip
     *
     * @return
     */
    protected String getIpAddress() {

        Random rand = new Random();

        return rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255);

    }
}
