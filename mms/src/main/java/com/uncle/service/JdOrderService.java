package com.uncle.service;

import com.uncle.bean.JdItem;
import com.uncle.bean.JdOrder;
import com.uncle.mapper.JdItemDAO;
import com.uncle.mapper.JdOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description: 订单业务类
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
@Service("orderService")
public class JdOrderService {
    @Autowired
    private JdOrderDAO orderDao;
    @Autowired
    private JdItemDAO itemDao;

    /**
     * 提供一个服务  根据当前用户 以及 订单状态 获取订单列表
     */
    public List<JdOrder> orderList(int user_id, String status) {

        return orderDao.getOrderList(user_id, status);
    }

    /**
     * 根据订单id 更新订单状态
     */
    public boolean updateOrderStatus(String status, int order_id) {

        return orderDao.updateOrderStatus(status, order_id) == 1 ? true : false;
    }

    /**
     * 插入订单 和 订单详情的服务
     */
    @Transactional
    public void addOrderAndItems(JdOrder order) {

        int osf = orderDao.insertJdOrder(order);
        List<JdItem> items = order.getItems();


        int isf = 0;
        for (int i = 0; i < items.size(); i++) {
            // 给每个条目设置 订单生成的id
            items.get(i).setOrder_id(order.getOrder_id());
            isf = itemDao.insertJdItem(items.get(i));
            if (isf == 0) {
                break;
            }
        }
        //isf = 0;
        if (osf == 0 || isf == 0) {
            throw new RuntimeException("订单插入失败");
        }
    }

}
