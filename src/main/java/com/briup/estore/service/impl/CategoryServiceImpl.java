package com.briup.estore.service.impl;

import com.briup.estore.bean.Category;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Cacheable(value = "findFirstwithSecondCategory",key = "'findFirstwithSecondCategory'")
	@Override
	public List<Category> findFirstwithSecondCategory() {
		List<Category> catelist = categoryMapper.selectFirstCategory();
		
		return catelist;
	}

}
