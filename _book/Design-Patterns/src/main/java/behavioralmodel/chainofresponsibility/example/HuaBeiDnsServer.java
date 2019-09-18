package behavioralmodel.chainofresponsibility.example;

/**
 * 描述:华北地区dns服务器
 *
 * @author lars
 * @date 2019/7/12 18:29
 */
public class HuaBeiDnsServer extends DnsServer {
    @Override
    public Address resolve(String domain) {

        if (domain.endsWith(".com")){
            Address address = new Address();
            address.setDomain(domain);
            address.setIp(super.getIpAddress());
            address.setOwner("华北地区dns服务器");
            return address;
        }else {
            //交给上级域名服务器解析
            return  super.getUpDnsServer().resolve(domain);
        }
    }
}
