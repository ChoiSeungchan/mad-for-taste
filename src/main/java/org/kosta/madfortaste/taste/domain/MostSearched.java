package org.kosta.madfortaste.taste.domain;

public class MostSearched {
	private String name;
	private int rank;

	public MostSearched() {
		super();
	}

	public MostSearched(String name, int rank) {
		super();
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "MostSearched [name=" + name + ", rank=" + rank + "]";
	}

}
