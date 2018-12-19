package learning.java.spring.springboot.springbootelastcsearch.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import learning.java.spring.springboot.springbootelastcsearch.domin.Article;

/**
 * 连接ES搜索缓存
 * @author DY
 *
 */
@Component 
//@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

	
}
