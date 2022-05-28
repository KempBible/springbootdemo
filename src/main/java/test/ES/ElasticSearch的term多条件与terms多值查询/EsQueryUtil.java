package test.ES.ElasticSearch的term多条件与terms多值查询;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//https://fiend.blog.csdn.net/article/details/121474827?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-121474827-blog-83715134.pc_relevant_aa&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-121474827-blog-83715134.pc_relevant_aa&utm_relevant_index=1
public class EsQueryUtil  {
    private final Logger logger = LoggerFactory.getLogger(EsQueryUtil.class);

    private static RestHighLevelClient restHighLevelClient;

//    private static final String HOST = "icptest.jd.local";
//    private static final String USERNAME = "elastic";
//    private static final String PASSWORD = "kanguangtao1@jd.com";

    public EsQueryUtil() {
        restHighLevelClient = buildClient();
    }
    /**
     * 初始化客户端
     * @return
     */
    protected RestHighLevelClient buildClient() {
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(USERNAME, PASSWORD));
//
//        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost(HOST))
//                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//                    @Override
//                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
//                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//                    }
//                });
//
//        Header[] defaultHeaders = new Header[]{new BasicHeader("Host", HOST)};
//        restClientBuilder.setDefaultHeaders(defaultHeaders);
//        return new RestHighLevelClient(restClientBuilder);

        // 创建HttpHost对象
        HttpHost httpHost = new HttpHost("192.168.33.169", 9200);

        // 创建RestClientBuilder
        RestClientBuilder clientBuilder = RestClient.builder(httpHost);

        // 创建RestHighLevelClient
        RestHighLevelClient client = new RestHighLevelClient(clientBuilder);

        // 返回
        return client;
    }

    /**
     * 释放连接
     */
    public void close() {
        try {
            if (restHighLevelClient != null) {
                restHighLevelClient.close();
            }
        } catch (Exception e) {
            logger.error("Error closing ElasticSearch client: ", e);
        }
    }
    /**
     * 分页条件查询
     * @param builders
     * @param from
     * @param size
     * @param sortName
     * @param order
     * @return
     */
    public SearchResponse queryByPage(QueryBuilder builders, int from, int size,String sortName, SortOrder order) {
        SearchRequest searchRequest = new SearchRequest("icpool_sku_index_pre");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(builders);
        if (from > 0) {
            searchSourceBuilder.from(from);
        }
        searchSourceBuilder.sort(sortName, order);
        if (size > 0) {
            searchSourceBuilder.size(size);
        }
        searchRequest.source(searchSourceBuilder);
        logger.info("searchRequest==>> {}", searchRequest.toString());
        SearchResponse response = null;
        try {
            response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            logger.error("occur an exception:{}",e.getMessage(),e);
        }
        return response;
    }
}
