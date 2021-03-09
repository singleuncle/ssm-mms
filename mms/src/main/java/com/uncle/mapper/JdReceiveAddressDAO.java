package com.uncle.mapper;

import com.uncle.bean.JdReceiveAddress;

public interface JdReceiveAddressDAO {
    JdReceiveAddress  findDefaultAddressByUserId(int user_id);
}
