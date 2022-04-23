package com.example.springbootdemo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mydb")
@Api(value = "用户接口", tags = "用户相关接口")
public class DBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ApiOperation(value = "测试swagger2配置", notes = "无需关注本接口")
    public List<Map<String, Object>> getDbType() {
        String sql = "select * from message";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ":" + value);
                }
            }
        }
        return list;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Map<String, Object> getUser(@PathVariable String id) {
        Map<String, Object> map = null;
        List<Map<String, Object>> list = getDbType();

        for (Map<String, Object> dbmap : list) {
            Set<String> set = dbmap.keySet();
            for (String key : set) {
                if (key.equals("id")) {
                    if (dbmap.get(key).equals(id)) {
                        map = dbmap;
                    }
                }
            }
        }

        if (map == null) {
            map = list.get(0);
        }
        return map;
    }

}