package com.gfj.yellodate.mapper;

import com.gfj.yellodate.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time)" +
            " values(#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);
    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer userId);
    @Select("select * from category where id = #{id} and create_user = #{userid}")
    Category findById(Integer id, Integer userid);
    @Update("update category set category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = #{updateTime} where id = #{id} and create_user = #{createUser}")
    void update(Category category);
}
