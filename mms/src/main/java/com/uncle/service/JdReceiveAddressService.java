package com.uncle.service;

import com.uncle.bean.JdReceiveAddress;
import com.uncle.mapper.JdReceiveAddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description: 收获地址业务类
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
@Service("addressService")
public class JdReceiveAddressService {
    @Autowired
    private JdReceiveAddressDAO addressDao;

    public JdReceiveAddress defaultAddressByUserId(int user_id) {

        return addressDao.findDefaultAddressByUserId(user_id);
    }
}
