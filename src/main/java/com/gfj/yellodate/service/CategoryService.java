package com.gfj.yellodate.service;

import com.gfj.yellodate.pojo.Category;

import java.util.List;

public interface CategoryService {
    //新增文章分类
    void add(Category category);
    //查询文章分类
    List<Category> list();
    //根据Id查询分类信息
    Category findById(Integer id);
    //更新分类信息
    void update(Category category);
}
