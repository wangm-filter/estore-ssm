package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.ShopAddress;

public interface ShopAddressMapper {
	List<ShopAddress> selectAddressByCustId(int custid);
	ShopAddress selectAddressById(int id);
}
