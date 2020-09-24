package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.ShopAddress;

public interface IShopAddressService {
	List<ShopAddress> selectAddressesByCustId(int custid);
	ShopAddress selectAddressById(int id);
}
