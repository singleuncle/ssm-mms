package com.uncle.controller;

import com.uncle.bean.JdCategory;
import com.uncle.bean.JdProduct;
import com.uncle.service.JdCategoryService;
import com.uncle.service.JdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @Description: 跳转到图书列表页面
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
@Controller
public class JdBookListController {

    @Autowired
    private JdCategoryService categoryService;
    @Autowired
    private JdProductService productService;

    /*
     * @Description: 通过页面携带的请求参数，跳转到图书列表页面
     * @Param: [parent_id, request]
     * @return: java.lang.String
     * @Author: 步尔斯特
     * @Date: 2021/3/6
     */
    @RequestMapping("/bookList")
    public String toBookList(int parent_id, HttpServletRequest request) {
        // 根据父分类id  获取子分类列表
        List<JdCategory> categories = categoryService.subCategoryList(parent_id);
        request.setAttribute("categories", categories);
        // 获取第一个分类对应的id
        int first_category_id = categories.isEmpty() ? -1 : categories.get(0).getCategory_id();
        request.setAttribute("first_category_id", first_category_id);
        // 默认是 销量排序 降序
        String order_std = "print_number";
        String order_type = "desc";
        // 默认从 0  开始  一页显示 4条
        int start_pos = 0;
        int page_size = 4;

        List<JdProduct> products = productService.
                productListByPageInfo(  first_category_id,
                                        order_std,
                                        order_type,
                                        start_pos,
                                        page_size);
        request.setAttribute("products", products);

        // 跳转到 书的列表页面时  计算出总页数
        int sumCount = productService.productCountByCategoryId(first_category_id);
        int sumPages = (sumCount + page_size - 1) / page_size;
        request.setAttribute("sumPages", sumPages);
        return "book_list";
    }

    /*
    * @Description: 查询当前页面的产品列表
    * @Author: 步尔斯特
    * @Date: 2021/3/6
    */
    @RequestMapping("/bookListAJAX")
    @ResponseBody
    public List<JdProduct> bookListAJAX(int first_category_id,
                                        String order_std,
                                        String order_type,
                                        int start_pos,
                                        int page_size) {
        List<JdProduct> products = productService.
                productListByPageInfo(  first_category_id,
                                        order_std,
                                        order_type,
                                        start_pos, page_size);
        return products;
    }
}
