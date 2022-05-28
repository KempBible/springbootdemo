package test.ES.ElasticSearch的term多条件与terms多值查询;

import java.util.Iterator;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//https://fiend.blog.csdn.net/article/details/121474827?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-121474827-blog-83715134.pc_relevant_aa&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-121474827-blog-83715134.pc_relevant_aa&utm_relevant_index=1
public class TestClient {
    private static final Logger logger = LoggerFactory.getLogger(EsQueryUtil.class);

    public static void main(String[] args) {
        EsQueryUtil esQuery = new EsQueryUtil();

        Long allowanceId = 11L;
        Long skuId = 12L;
        int from = 0;
        int size = 20;
        String sortName = "limit_time";

        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.filter(QueryBuilders.termQuery("allowance_id", allowanceId));
        builder.filter(QueryBuilders.termQuery("sku_id", skuId));
        SearchResponse searchResponse = esQuery.queryByPage(builder, from, size, sortName, SortOrder.DESC);
        if(searchResponse != null) {
            logger.info("totalHits:{}",searchResponse.getHits().getTotalHits());
            Iterator<SearchHit> iterator = searchResponse.getHits().iterator();
            while (iterator.hasNext()){
                SearchHit hit = iterator.next();
                logger.info("sourceAsString:{}",hit.getSourceAsString());
            }

            esQuery.close();
        }
    }
}