package test.ES;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

//https://blog.csdn.net/qwq1518346864/article/details/117716279
public class EsDemo {

    //定义RestHighLevelClient对象
    RestHighLevelClient client = EsClient.getClient();

    //定义索引名称
    String index = "sms_log_index";

    @Test
    public void searchTerm() throws IOException {
        //1. 创建Request对象
        SearchRequest request = new SearchRequest(index);

        //2. 指定查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("province", "北京"));
        request.source(builder);

        //3. 执行查询
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        //4. 获取到_source中的数据，并展示
        for (SearchHit hit : response.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void searchTerms() throws IOException{
        //1. 创建request
        SearchRequest request = new SearchRequest(index);

        //2. 封装查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termsQuery("province", "北京", "上海"));
        request.source(builder);

        //3. 执行查询
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        //4. 输出_source
        for (SearchHit hit : response.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println(sourceAsMap);
        }
    }

}
