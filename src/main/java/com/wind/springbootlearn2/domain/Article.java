package com.wind.springbootlearn2.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 学习elastic使用的实体类（文章对象）
 *
 * document对应是一条记录，里面的indexName表示存到blog数据库
 * ，type表示存到数据库中article这个表
 * */
@Data
@Document(indexName = "blog",type = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String summary;
    private String content;
    private int pv;

}


