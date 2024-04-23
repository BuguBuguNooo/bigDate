package com.gfj.yellodate.service.impl;

import com.gfj.yellodate.mapper.ArticleMapper;
import com.gfj.yellodate.pojo.Article;
import com.gfj.yellodate.pojo.PageBean;
import com.gfj.yellodate.service.ArticleService;
import com.gfj.yellodate.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        article.setCreateUser(userid);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //创建PageBean对象
        PageBean<Article> pb = new PageBean<>();
        //开启分页查询(调用PageHelper.startPage方法)
        PageHelper.startPage(pageNum, pageSize);
        //调用mapper查询数据
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        List<Article> ls = articleMapper.list(categoryId, state, userid);
        //将查询结果封装到PageBean对象中
        Page<Article> p = (Page<Article>) ls;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
