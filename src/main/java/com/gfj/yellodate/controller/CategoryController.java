package com.gfj.yellodate.controller;

import com.gfj.yellodate.pojo.Category;
import com.gfj.yellodate.pojo.Result;
import com.gfj.yellodate.service.CategoryService;
import com.gfj.yellodate.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }
    @GetMapping
    public  Result<List<Category>> list() {
        List<Category> res = categoryService.list();
        return Result.success(res);
    }

    @GetMapping("/detail")
    public Result<Category> getDetail(Integer id) {
        Category c = categoryService.findById(id);
        if(c == null) {
            return Result.error("分类不存在");
        }
        return Result.success(c);
    }
    @PutMapping
    public Result updateCategory(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

}
