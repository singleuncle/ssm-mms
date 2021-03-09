package com.uncle.service;

import com.uncle.bean.JdCategory;
import com.uncle.mapper.JdCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 分类的业务类
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
@Service("categoryService")
public class JdCategoryService {

    @Autowired
    private JdCategoryDAO categoryDao;

    /*
     * @Description: 根据父分类id 获取子分类列表
     * @Param: [parent_id]
     * @return: java.util.List<com.uncle.bean.JdCategory>
     * @Author: 步尔斯特
     * @Date: 2021/3/6
     */
    public List<JdCategory> subCategoryList(int parent_id) {
        return categoryDao.findSubCategoriesByParentId(parent_id);
    }
}
