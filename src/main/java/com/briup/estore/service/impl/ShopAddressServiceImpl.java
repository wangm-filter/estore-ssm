package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.ShopAddressMapper;
import com.briup.estore.service.IShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ShopAddressServiceImpl implements IShopAddressService{
	@Autowired
	private ShopAddressMapper shopAddressMapper;
	
	@Cacheable(value="selectAddressesByCustId",key = "'arrdessWithCustid'")
	@Override
	public List<ShopAddress> selectAddressesByCustId(int id) {
		List<ShopAddress> addresslist = shopAddressMapper.selectAddressByCustId(id);
		
		return addresslist;
	}
	
	@Cacheable(value="selectAddressById",key = "'address'")
	@Override
	public ShopAddress selectAddressById(int id) {
		ShopAddress address = shopAddressMapper.selectAddressById(id);
		return address;
	}

}
