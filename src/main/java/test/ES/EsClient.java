package test.ES;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * 创建测试类，连接ES
 */
//https://blog.csdn.net/qwq1518346864/article/details/117716279
public class EsClient {
    public static RestHighLevelClient getClient() {

        // 创建HttpHost对象
        HttpHost httpHost = new HttpHost("192.168.33.169", 9200);

        // 创建RestClientBuilder
        RestClientBuilder clientBuilder = RestClient.builder(httpHost);

        // 创建RestHighLevelClient
        RestHighLevelClient client = new RestHighLevelClient(clientBuilder);

        // 返回
        return client;
    }
}
