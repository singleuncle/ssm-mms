package com.uncle.service;

import com.uncle.bean.JdProduct;
import com.uncle.mapper.JdProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 产品业务类
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
@Service("productService")
public class JdProductService {
    @Autowired
    private JdProductDAO productDao;

    /*
     * @Description: 根据页面上的信息 获取产品列表
     * @Param: [category_id, order_std, order_type, start_pos, page_size]
     * @return: java.util.List<com.uncle.bean.JdProduct>
     * @Author: 步尔斯特
     * @Date: 2021/3/6
     */
    public List<JdProduct> productListByPageInfo(int category_id,
                                                 String order_std,
                                                 String order_type,
                                                 int start_pos,
                                                 int page_size) {
        return productDao.getProductListByPageInfo(category_id, order_std,
                order_type, start_pos, page_size);
    }

    public int productCountByCategoryId(int category_id) {

        return productDao.getProductCountByCategoryId(category_id);
    }

    public JdProduct productById(int product_id) {

        return productDao.getProductById(product_id);
    }
}
