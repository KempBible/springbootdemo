package test.Java8新特性;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.jianshu.com/p/dd5121c8fa89
 */
public class Java8stream中利用groupingBy进行多字段分组 {

    @Test
    public void test1(){
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }

    @Test
    public void test2(){
        Item item1 = new Item();
        item1.setCountry("meiguo");
        item1.setProductType("American");

        Item item2 = new Item();
        item2.setCountry("riben");
        item2.setProductType("JapanMade");

        List<Item> recordItems = new ArrayList<>();
        recordItems.add(item1);
        recordItems.add(item2);

        Map<String, List<Item>> countMap = recordItems.stream().collect(Collectors.groupingBy(o -> o.getProductType()));
        List<Record> records = new ArrayList<Record>();
        countMap.keySet().forEach(productType -> {
            Map<String, Long> countMap1 = countMap.get(productType).stream().collect(Collectors.groupingBy(o -> o.getCounttry(), Collectors.counting()));
            countMap1.keySet().stream().forEach(country -> {
                Record record = new Record();
                record.set("device_type", productType);
                record.set("location", country);
                record.set("count", countMap1.get(country).intValue());
                records.add(record);
            });
        });
        System.out.println(records);
    }

    @Test
    public void test3(){
        Item item1 = new Item();
        item1.setCountry("meiguo_America");
        item1.setProductType("American");

        Item item2 = new Item();
        item2.setCountry("riben_Japan");
        item2.setProductType("JapanMade");

        List<Item> recordItems = new ArrayList<>();
        recordItems.add(item1);
        recordItems.add(item2);

        // 分组统计
        Map<String, Long> countMap = recordItems.stream().collect(Collectors.groupingBy(o -> o.getCounttry(), Collectors.counting()));
        List<Record> countRecords = countMap.keySet().stream().map(key -> {
            String[] temp = key.split("_");
            String productType = temp[0];
            String country = temp[1];

            Record record = new Record();
            record.set("device_type", productType);
            record.set("location", country);
            record.set("count", countMap.get(key).intValue());
            return record;
        }).collect(Collectors.toList());
        System.out.println(countRecords);
    }

}

class Item{

    private String country;
    private String productType;

    public String getCounttry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}

class Record{
    Map<String, Object> map = new HashMap<>();

    public void set(String key, Object value){
        map.put(key, value);
    }
}