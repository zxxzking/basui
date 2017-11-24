package com.lv.basui.utils;

import java.io.Serializable;

public class Paging implements Serializable{


	private static final long serialVersionUID = 4978502500376939257L;
	
	/** 每页的记录数 0:不分页 */
	private int pageSize = 10;

	/**
	 * 当前页
	 */
	private int page = 1;

	/**
	 * 总记录数
	 */
	private int total = 0;

	/**
	 * 排序的列
	 */
	private String sort;
	/**
	 * 排序的方式
	 */
	private String order;

	private int totalPage;

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the {@link #pageSize}
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the {@link #pageSize} to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the {@link #page}
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the {@link #page} to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the {@link #total}
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the {@link #total} to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		int total = getTotal();
		if (total == 0) {
			return 0;
		}
		if (total <= pageSize || 0 == pageSize) {
			return this.totalPage = 1;
		}
		if (total % pageSize == 0) {
			return this.totalPage = total / pageSize;
		} else {
			return this.totalPage = (total / pageSize) + 1;
		}
	}

	public int getFirstResult() {
		return ((page < 1 ? 1 : page) - 1) * pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
