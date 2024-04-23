package com.gfj.yellodate.service;

import com.gfj.yellodate.pojo.Article;
import com.gfj.yellodate.pojo.PageBean;

public interface ArticleService {
    //添加文章
    void add(Article article);
    //分页查询文章
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
