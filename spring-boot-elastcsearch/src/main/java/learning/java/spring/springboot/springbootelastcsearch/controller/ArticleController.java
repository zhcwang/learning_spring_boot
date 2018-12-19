package learning.java.spring.springboot.springbootelastcsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.springbootelastcsearch.domin.Article;
import learning.java.spring.springboot.springbootelastcsearch.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
@RestController
@RequestMapping("/api")
public class ArticleController {
	@Autowired
	ArticleRepository manager;
	
	@GetMapping("save")
	public String save(long id,String title) {
		Article article = new Article();
		article.setId(id);
		article.setPv(123);
		article.setContent("springboot整合elasticsearch，这个是新版本 2018年录制");
		article.setTitle(title);
		article.setSummary("搜索框架整合");
		
		manager.save(article);
		return "保存成功";
	}
	@GetMapping("search")
	public Object search(String title) {
		//QueryBuilder queryBuilder = QueryBuilders.matchAllQuery(); //搜索全部文档
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
		Iterable<Article> list =  manager.search(queryBuilder);
		
		return list;
	}
}
