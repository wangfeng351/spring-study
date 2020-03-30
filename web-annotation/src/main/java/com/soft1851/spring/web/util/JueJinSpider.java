package com.soft1851.spring.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JavaType;
import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.GithubSponsors;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/27
 * @Version 1.0
 */
public class JueJinSpider {
    private Integer SUCCESS = 200;

    //通过解析页面，爬取github上Sponsors页面
    public static List<GithubSponsors> getSponsors() {
        List<GithubSponsors> list = new ArrayList<>();
        //链接到目标地址
        String url = "https://github.com/sponsors/community";
//        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7e02d1f265da795c71f859&device_id=1585316561629&token=eyJhY2Nlc3NfdG9rZW4iOiJVMWVIdVd4TUtUNW1VVHpoIiwicmVmcmVzaF90b2tlbiI6InRQUmxvSjVEd2lJS2swSksiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        // 创建Context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response.getStatusLine());

        //如果请求成功，则获取网页源码
        if (response.getStatusLine().getStatusCode() == 200) {
            //获取响应对象实体，并转成utf-8
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
                System.out.println(res);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Document document = Jsoup.parse(res, "utf-8");
            Elements divs = document.getElementsByClass("Box-row d-flex");
            System.out.println("div长度：" + divs.size());
            for(Element div : divs){
//                System.out.println(div.child(0).child(0).child(0).attr("src"));
                String avatar = div.child(0).child(0).child(0).attr("src");
                Element element = div.child(1).child(0);
//                System.out.println(element.child(0).text());
                String name = element.child(0).text();
                String description = element.child(1).text();
                GithubSponsors sponsors = GithubSponsors.builder()
                        .avatar(avatar)
                        .authorName(name)
                        .description(description)
                        .build();
                list.add(sponsors);
            }
        }
            return list;
        }

    public static List<Topic> getTopic() {
        List<Topic> topicList = new ArrayList<>();
        //链接到目标地址
        String url = "https://github.com/sponsors/community";
//        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7e02d1f265da795c71f859&device_id=1585316561629&token=eyJhY2Nlc3NfdG9rZW4iOiJVMWVIdVd4TUtUNW1VVHpoIiwicmVmcmVzaF90b2tlbiI6InRQUmxvSjVEd2lJS2swSksiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        // 创建Context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response.getStatusLine());

        //如果请求成功，则获取网页源码
        if (response.getStatusLine().getStatusCode() == 200) {
            //获取响应对象实体，并转成utf-8
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
            list.forEach(e ->{
                JSONObject json = JSONObject.parseObject(e.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId")
                        )
                        .topicName(json.getString("title"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followsCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topicList.add(topic);
            });
        }
        return topicList;
    }

    //获取知乎图书页信息
    public static List<Book> getBook(){
        List<Book> bookList = new ArrayList<>();
        String url = "https://www.zhihu.com/api/v3/books/categories/284?version=v2&limit=15&sort_by=read_count_7days&offset=5";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String content = null;
            try {
                content = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONObject.parseObject(content);
            System.out.println(jsonObject);
            JSONArray ja = jsonObject.getJSONArray("data");
            System.out.println(ja.get(0));
            ja.forEach(o ->{
                JSONObject object = JSON.parseObject(o.toString());
                JSONArray arr = object.getJSONArray("authors");
                JSONObject author = JSON.parseObject(arr.get(0).toString());
                JSONObject promotion = object.getJSONObject("promotion");
                String price = promotion.getString("price").substring(0,2) + "." +
                        promotion.getString("price").substring(2);
                Book book = Book.builder()
                        .id(object.getInteger("id"))
                        .price(Double.parseDouble(price))
                        .author(author.getString("name"))
                        .name(object.getString("title"))
                        .avatar(object.getString("cover"))
                        .url(object.getString("url"))
                        .build();
                bookList.add(book);
            });
        }
        return bookList;
    }

    public static void main(String[] args) {
//        List<GithubSponsors> topics = getSponsors();
        List<Book> list = getBook();
//        list.forEach(o ->{
//            System.out.println(o.toString());
//        });
    }
}
