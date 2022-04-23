package test.rpc;

/**
 * @ClassName RpcProvider
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 18:28
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
