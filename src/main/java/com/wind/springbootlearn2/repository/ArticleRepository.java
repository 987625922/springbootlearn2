package com.wind.springbootlearn2.repository;

import com.wind.springbootlearn2.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * elasticsearch使用
 *
 * @Repository 标识一个数据仓库，里面的实现就是@Component
 */
@Repository
//@Document(indexName = "blog", type = "article", shards = 1, replicas = 0)
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

}
