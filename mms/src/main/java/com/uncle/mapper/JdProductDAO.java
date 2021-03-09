package com.uncle.mapper;

import com.uncle.bean.JdProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
* @Description: 产品接口
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
public interface JdProductDAO {

    /*
     * @Description: 根据页面信息查询产品列表
     * @Param: [category_id, order_std, order_type, start_pos, page_size]
     * @return: java.util.List<com.uncle.bean.JdProduct>
     * @Author: 步尔斯特
     * @Date: 2021/3/6
     */
    List<JdProduct> getProductListByPageInfo(@Param("category_id") int category_id,
                                             @Param("order_std") String order_std,
                                             @Param("order_type") String order_type,
                                             @Param("start_pos") int start_pos,
                                             @Param("page_size") int page_size);

    int getProductCountByCategoryId(@Param("category_id") int category_id);

    JdProduct getProductById(@Param("product_id") int product_id);
}
