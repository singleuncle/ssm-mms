package com.uncle.mapper;

import com.uncle.bean.JdCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
* @Description: 分类的接口
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
public interface JdCategoryDAO {
    /*
     * @Description: 根据父ID查询分类的列表
     * @Param: [parent_id]
     * @return: java.util.List<com.uncle.bean.JdCategory>
     * @Author: 步尔斯特
     * @Date: 2021/3/6
     */
    List<JdCategory> findSubCategoriesByParentId(@Param("parent_id") int parent_id);
}
