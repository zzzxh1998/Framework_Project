package com.qiguliuxing.dts.admin.dao;

import java.io.Serializable;
import java.util.List;

import com.qiguliuxing.dts.db.bean.CategorySellAmts;

public class CategorySellVo implements Serializable{
	
	private static final long serialVersionUID = 96458407347975166L;

    private String[] categoryNames;//一级大类目录名称
	
	private List<CategorySellAmts> categorySellData;//大类销售金额集合

	public String[] getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(String[] categoryNames) {
		this.categoryNames = categoryNames;
	}

	public List<CategorySellAmts> getCategorySellData() {
		return categorySellData;
	}

	public void setCategorySellData(List<CategorySellAmts> categorySellData) {
		this.categorySellData = categorySellData;
	}

	
}
