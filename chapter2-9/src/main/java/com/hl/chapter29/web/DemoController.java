package com.hl.chapter29.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 测试接口
 */
@Controller
public class DemoController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * String类型
     */
    @PostMapping(value = "/string")
    @ResponseBody
    public String stringTest(HttpServletRequest request, @RequestBody String req) {

        // 插入一个key值
        redisTemplate.opsForValue().set("a", 1000);
        // 判断是否有key对应的值，有返回true，没有返回false
        boolean isExist = redisTemplate.hasKey("a");
        System.out.println(isExist);
        // 取出key对应的值
        redisTemplate.opsForValue().get("a");
        // 删除某个key
        redisTemplate.delete("a");
        // 批量删除key
        List keys = new ArrayList<String>();
        keys.add("a");
        keys.add("b");
        redisTemplate.delete(keys);
        // 将当前传入的key值序列化为btye[]类型
        redisTemplate.opsForValue().set("b", 2000);
        System.out.println(redisTemplate.dump("b"));
        // 设置过期时间
        redisTemplate.expire("b", 10000, TimeUnit.MILLISECONDS);
//        System.out.println(redisTemplate.expireAt("b", new Date()));

        // 查找匹配的key值，返回set集合
        redisTemplate.opsForValue().set("a", 1100);
        redisTemplate.opsForValue().set("c", 3000);
        System.out.println(redisTemplate.keys("*"));

        // 修改key名称
        redisTemplate.rename("a", "aa");

        // 返回传入key存储的数据类型
        System.out.println(redisTemplate.type("aa"));

        // 随机取出一个key
        System.out.println(redisTemplate.randomKey());

        // 返回当前key剩余过期时间
        System.out.println(redisTemplate.getExpire("aa"));
        System.out.println(redisTemplate.getExpire("aa", TimeUnit.SECONDS));

        // 将key持久化
        redisTemplate.persist("c");

        // 将当前key迁移到指定数据库中
        redisTemplate.move("c", 1);

        // 返回部分字符
        System.out.println(redisTemplate.opsForValue().get("a", 0, 2));

        // 批量获取值
        List keys2 = new ArrayList();
        keys2.add("a");
        keys2.add("b");
        keys2.add("c");
        System.out.println(redisTemplate.opsForValue().multiGet(keys2));

        // 新增字符串
        redisTemplate.opsForValue().append("a", "1000");

        // 如果对应的map集合名称不存在，则添加否则不做修改
        Map valueMap = new HashMap();
        valueMap.put("valueMap1", "map1");
        valueMap.put("valueMap2", "map2");
        valueMap.put("valueMap3", "map3");
        redisTemplate.opsForValue().multiSetIfAbsent(valueMap);

        // 设置map集合到redis
        Map valueMap2 = new HashMap();
        valueMap2.put("valueMap1", "map1");
        valueMap2.put("valueMap2", "map2");
        valueMap2.put("valueMap3", "map3");
        redisTemplate.opsForValue().multiSet(valueMap2);

        // 获取字符串的长度
        redisTemplate.opsForValue().size("a");

        // 重新设置key对应的值，如果存在返回false，否则返回true
        redisTemplate.opsForValue().setIfAbsent("a", 33);

        // 将值 value 关联到 key,并将 key 的过期时间设为 timeout
        redisTemplate.opsForValue().set("a", 2000, 10, TimeUnit.HOURS);

        // 将二进制第offset位值变为value
//        redisTemplate.opsForValue().setBit(key, offset, value);

        // 对key所储存的字符串值，获取指定偏移量上的位(bit)
//        redisTemplate.opsForValue().getBit(key, offset);


        return JSONObject.parseObject(req).toJSONString();
    }

    /**
     * hash类型
     */
    @RequestMapping(value = "/hash")
    @ResponseBody
    public String hashTest(HttpServletRequest request) {

        // 新增hashMap值
        redisTemplate.opsForHash().put("hash", "a", "第一个");

        // 获取指定map键是否有值，有就返回，没有返回null
        System.out.println(redisTemplate.opsForHash().get("hash", "a"));

        // 获取指定key中所有键值对
        redisTemplate.opsForHash().put("hash", "b", "第二个");
        redisTemplate.opsForHash().put("hash", "c", "第三个");
        System.out.println(redisTemplate.opsForHash().entries("hash"));

        // 以Map集合的方式添加键值对
        Map map = new HashMap<String, String>();
        map.put("d", "第四个");
        map.put("e", "第五个");
        redisTemplate.opsForHash().putAll("hash", map);
        System.out.println(redisTemplate.opsForHash().entries("hash"));

        // 仅当hashKey不存在时才设置
        redisTemplate.opsForHash().putIfAbsent("hash", "a", "不是第一个了");
        redisTemplate.opsForHash().putIfAbsent("hash", "f", "第六个");
        System.out.println(redisTemplate.opsForHash().entries("hash"));

        // 删除一个或多个hash表字段
        redisTemplate.opsForHash().delete("hash", "e", "f");
        System.out.println(redisTemplate.opsForHash().entries("hash"));

        // 查看hash表中指定字段是否存在
        System.out.println(redisTemplate.opsForHash().hasKey("hash", "f"));

        // 给hash表中指定字段的整数值加上增量increment
        redisTemplate.opsForHash().put("hash", "e", 10);
        redisTemplate.opsForHash().increment("hash", "e", 10);
        System.out.println(redisTemplate.opsForHash().get("hash", "e"));

        // 给hash表中指定字段的浮点值加上increment
//        redisTemplate.opsForHash().put("hash", "f", 15.5);
//        redisTemplate.opsForHash().increment("hash", "f", 21.1);
//        System.out.println(redisTemplate.opsForHash().get("hash", "f"));

        // 获取hash表中所有字段
        System.out.println(redisTemplate.opsForHash().keys("hash"));

        // 获取hash表中字段数量
        System.out.println(redisTemplate.opsForHash().size("hash"));

        // 获取hash表中存在的所有值
        System.out.println(redisTemplate.opsForHash().values("hash"));

        // 匹配获取键值对
        try {
            Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan("hash", ScanOptions.NONE);
            while (cursor.hasNext()) {
                Map.Entry<Object, Object> entry = cursor.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + ": " + value);
            }
            cursor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * list类型
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public String listTest(HttpServletRequest request) {

        // 向列表中头部添加元素
        redisTemplate.opsForList().leftPush("list", "第一个list元素");
        // 通过index获取列表中的元素
        System.out.println(redisTemplate.opsForList().index("list", 0));

        // 把多个值存入列表头部
        redisTemplate.opsForList().leftPushAll("list", "第二个list元素", "第三个list元素", "第四个list元素");

        // 获取列表指定范围内元素，start起始位置，end结束位置，-1返回所有
        System.out.println(redisTemplate.opsForList().range("list", 0, 3));

        // list存在的时候再加入
        redisTemplate.opsForList().leftPushIfPresent("list", "第六个list元素");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

        // 在pivot值存在时在pivot前面添加
        redisTemplate.opsForList().leftPush("list", "第六个list元素", "第五个半list元素");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

        // 按照先进先出的原则添加多个值
        redisTemplate.opsForList().rightPush("list", "第七个list元素");
        redisTemplate.opsForList().rightPushAll("list", "第八个list元素", "第九个list元素");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

        // 在pivot右边添加值
        redisTemplate.opsForList().rightPush("list", "第七个list元素", "第七个半list元素");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

        // 设置指定索引处元素的值
        redisTemplate.opsForList().set("list", 5, "修改后的list元素");

        // 移除并获取列表中第一个元素
        System.out.println(redisTemplate.opsForList().leftPop("list"));
        System.out.println(redisTemplate.opsForList().leftPop("list", 10, TimeUnit.SECONDS));

        // 移除并获取列表中最后一个元素
        System.out.println(redisTemplate.opsForList().rightPop("list"));
        System.out.println(redisTemplate.opsForList().rightPop("list", 8, TimeUnit.SECONDS));

        // 从一个列表右边弹出一个元素并将该元素插入另一个列表的左边
        redisTemplate.opsForList().rightPopAndLeftPush("list", "list2");
        redisTemplate.opsForList().rightPopAndLeftPush("list", "list2", 10, TimeUnit.SECONDS);

        // 删除列表中值等于指定value的元素，index=0删除所有，index>0删除头部开始第一个，index<0删除尾部开始第一个
        redisTemplate.opsForList().remove("list", 0, "第三个list元素");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

        // 列表进行裁剪
        redisTemplate.opsForList().trim("list", 1, 4);
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

        // 获取当前列表长度
        System.out.println(redisTemplate.opsForList().size("list"));

        return null;
    }

    /**
     * set类型
     */
    @GetMapping(value = "/set")
    @ResponseBody
    public String setTest(HttpServletRequest request) {
        // 添加元素
        redisTemplate.opsForSet().add("set", "第一个set元素");
        redisTemplate.opsForSet().add("set", "第二个set元素");
        redisTemplate.opsForSet().add("set", "第三个set元素");
        redisTemplate.opsForSet().add("set", "第四个set元素");
        redisTemplate.opsForSet().add("set", "第五个set元素");

        // 获取集合中所有元素
        System.out.println(redisTemplate.opsForSet().members("set"));

        // 移除元素
        redisTemplate.opsForSet().remove("set", "第一个set元素", "第三个set元素");
        System.out.println(redisTemplate.opsForSet().members("set"));

        // 删除并返回一个随机元素
        System.out.println(redisTemplate.opsForSet().pop("set"));


        // 获取集合大小
        System.out.println(redisTemplate.opsForSet().size("set"));

        // 判断集合是否包含value
        System.out.println(redisTemplate.opsForSet().isMember("set", "第四个set元素"));

        redisTemplate.opsForSet().add("otherSet", "第一个set元素");
        redisTemplate.opsForSet().add("otherSet", "第二个set元素");
        redisTemplate.opsForSet().add("otherSet", "第三个set元素");
        redisTemplate.opsForSet().add("otherSet", "第四个set元素");
        // 获取两个集合的交集
        System.out.println(redisTemplate.opsForSet().intersect("set", "otherSet"));

        // 获取多个集合的交集
        redisTemplate.opsForSet().add("thirdSet", "第二个set元素");
        Set otherKeys = new HashSet();
        otherKeys.add("otherSet");
        otherKeys.add("thirdSet");
        System.out.println(redisTemplate.opsForSet().intersect("set", otherKeys));

        // set集合与otherSet集合的交集存储到targetSet集合中
        redisTemplate.opsForSet().intersectAndStore("set", "otherSet", "targetSet");
        System.out.println(redisTemplate.opsForSet().members("targetSet"));

        // set集合与多个集合的交集存储到targetSet集合中
        redisTemplate.opsForSet().intersectAndStore("set", otherKeys, "targetSet");
        System.out.println(redisTemplate.opsForSet().members("targetSet"));

        // 获取两个或者多个集合的并集
        System.out.println(redisTemplate.opsForSet().union("set", "otherSet"));
        System.out.println(redisTemplate.opsForSet().union("set", otherKeys));

        // set集合与多个集合的并集存储到targetSet集合中
        redisTemplate.opsForSet().unionAndStore("set", otherKeys, "targetSet2");
        System.out.println(redisTemplate.opsForSet().members("targetSets"));

        // 获取两个或者多个集合的差集
        System.out.println(redisTemplate.opsForSet().difference("set", otherKeys));

        // 差集存储到targetSet中
        redisTemplate.opsForSet().unionAndStore("set", otherKeys, "targetSet3");
        System.out.println(redisTemplate.opsForSet().members("targetSet3"));

        // 随机获取集合中的一个元素
        System.out.println(redisTemplate.opsForSet().randomMember("set"));

        // 随机获取集合中若干个元素
        System.out.println(redisTemplate.opsForSet().randomMembers("set", 5));

        // 遍历set，类似于iterator
        try {
            Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForSet().scan("set", ScanOptions.NONE);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
            cursor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * zset类型
     */
    @GetMapping(value = "/zset")
    @ResponseBody
    public String zsetTest(HttpServletRequest request) {
        // 添加元素，有序集合按照score的值从小到大排序
        redisTemplate.opsForZSet().add("zset", "第一个zset", 100);
        redisTemplate.opsForZSet().add("zset", "第二个zset", 110);
        redisTemplate.opsForZSet().add("zset", "第三个zset", 120);
        redisTemplate.opsForZSet().add("zset", "第四个zset", 130);
        redisTemplate.opsForZSet().add("zset", "第五个zset", 140);

        // 获取元素在集合中的排名，按照score值从小到大排序
        System.out.println("从小到大：" + redisTemplate.opsForZSet().rank("zset", "第二个zset"));

        // 获取元素在集合中的排名，按照score值从大到小排序
        System.out.println("从大到小：" + redisTemplate.opsForZSet().reverseRank("zset", "第二个zset"));

        System.out.println("--------------------------------------");

        // 获取集合中给定区间的元素，start开始位置，end结束位置，-1查询所有(从小到大)
        // 返回值为:Set<ZSetOperations.TypedTuple<V>>
        Iterator iterator = redisTemplate.opsForZSet().rangeWithScores("zset", 0, -1).iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple typedTuple = (ZSetOperations.TypedTuple) iterator.next();
            System.out.println("从小到大：" + typedTuple.getValue() + ", " + typedTuple.getScore());
        }

        System.out.println("--------------------------------------");

        // 获取集合中给定区间的元素，start开始位置，end结束位置，-1查询所有（从大到小）
        Iterator iterator3 = redisTemplate.opsForZSet().reverseRangeWithScores("zset", 0, -1).iterator();
        while (iterator3.hasNext()) {
            ZSetOperations.TypedTuple typedTuple3 = (ZSetOperations.TypedTuple) iterator3.next();
            System.out.println("从大到小：" + typedTuple3.getValue() + ", " + typedTuple3.getScore());
        }

        System.out.println("--------------------------------------");

        // 按照score值查询集合中的元素，结果从小到大排序
        System.out.println("从小到大：" + redisTemplate.opsForZSet().rangeByScore("zset", 100, 200));
        Iterator iterator4 = redisTemplate.opsForZSet().rangeByScoreWithScores("zset", 100, 200).iterator();
        while (iterator4.hasNext()) {
            ZSetOperations.TypedTuple typedTuple4 = (ZSetOperations.TypedTuple) iterator4.next();
            System.out.println("从小到大：" + typedTuple4.getValue() + ", " + typedTuple4.getScore());
        }

        System.out.println("--------------------------------------");


        // 按照score值查询集合中的元素，结果从大到小排序
        System.out.println("从大到小：" + redisTemplate.opsForZSet().reverseRangeByScore("zset", 100, 200));
        Iterator iterator5 = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("zset", 100, 200).iterator();
        while (iterator5.hasNext()) {
            ZSetOperations.TypedTuple typedTuple5 = (ZSetOperations.TypedTuple) iterator5.next();
            System.out.println("从大到小：" + typedTuple5.getValue() + ", " + typedTuple5.getScore());
        }

        System.out.println("--------------------------------------");

        // 从大到小排序获取集合中score在给定最大最小范围内的元素
        System.out.println("从大到小：" + redisTemplate.opsForZSet().reverseRangeByScore("zset", 100, 1000, 0, -1));

        System.out.println("--------------------------------------");

        // 根据score获取集合元素数量
        System.out.println(redisTemplate.opsForZSet().count("zset", 100, 150));

        System.out.println("--------------------------------------");

        // 获取集合大小
        System.out.println(redisTemplate.opsForZSet().size("zset"));
        System.out.println(redisTemplate.opsForZSet().zCard("zset"));

        System.out.println("--------------------------------------");

        // 获取集合中key value 对应的score
        System.out.println(redisTemplate.opsForZSet().score("zset", "第三个zset"));

        System.out.println("--------------------------------------");

        // 移除指定索引位置的元素
        redisTemplate.opsForZSet().removeRange("zset", 0, 1);
        System.out.println(redisTemplate.opsForZSet().range("zset", 0, -1));

        System.out.println("--------------------------------------");

        // 获取key 和otherKey的交集并存储在targetKey
        redisTemplate.opsForZSet().add("otherZset", "第二个zset", 200);
        redisTemplate.opsForZSet().add("otherZset", "第三个zset", 200);
        redisTemplate.opsForZSet().intersectAndStore("zset", "otherZset", "targetZset");
        System.out.println(redisTemplate.opsForZSet().range("targetZset", 0, -1));

        System.out.println("--------------------------------------");

        // 获取key和otherKey的并集并且存储在targetKey中
        redisTemplate.opsForZSet().unionAndStore("zset", "otherZset", "fourthZset");
        System.out.println(redisTemplate.opsForZSet().range("fourthZset", 0, -1));

        System.out.println("--------------------------------------");

        // 遍历集合
        try {
            Cursor<ZSetOperations.TypedTuple> cursor = redisTemplate.opsForZSet().scan("zset", ScanOptions.NONE);
            while (cursor.hasNext()) {
                ZSetOperations.TypedTuple typedTuple = cursor.next();
                System.out.println(typedTuple.getValue() + ", " + typedTuple.getScore());
            }
            cursor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
