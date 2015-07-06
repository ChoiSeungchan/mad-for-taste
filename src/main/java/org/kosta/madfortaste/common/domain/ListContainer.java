package org.kosta.madfortaste.common.domain;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;

public class ListContainer {
	
	private List<?> list;
	private Page page;
	
	public ListContainer(List<?> list, Page page) {
		super();
		this.list = list;
		this.page = page;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "ObjectList [list=" + list + ", page=" + page + "]";
	}
}
