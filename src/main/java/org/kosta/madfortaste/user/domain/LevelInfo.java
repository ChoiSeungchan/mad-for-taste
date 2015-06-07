package org.kosta.madfortaste.user.domain;

public class LevelInfo {

	private int level;
	private int currentLevelExp;
	private int requiredExp;
	private int nextLevelExp;
	private int expDemandBlock;
	private double expPercentage;

	public LevelInfo() {
		super();
	}

	public LevelInfo(int level, int currentLevelExp, int requiredExp,
			int nextLevelExp, int expDemandBlock, double expPercentage) {
		super();
		this.level = level;
		this.currentLevelExp = currentLevelExp;
		this.requiredExp = requiredExp;
		this.nextLevelExp = nextLevelExp;
		this.expDemandBlock = expDemandBlock;
		this.expPercentage = expPercentage;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCurrentLevelExp() {
		return currentLevelExp;
	}

	public void setCurrentLevelExp(int currentLevelExp) {
		this.currentLevelExp = currentLevelExp;
	}

	public int getRequiredExp() {
		return requiredExp;
	}

	public void setRequiredExp(int requiredExp) {
		this.requiredExp = requiredExp;
	}

	public int getNextLevelExp() {
		return nextLevelExp;
	}

	public void setNextLevelExp(int nextLevelExp) {
		this.nextLevelExp = nextLevelExp;
	}

	public int getExpDemandBlock() {
		return expDemandBlock;
	}

	public void setExpDemandBlock(int expDemandBlock) {
		this.expDemandBlock = expDemandBlock;
	}

	public double getExpPercentage() {
		return expPercentage;
	}

	public void setExpPercentage(double expPercentage) {
		this.expPercentage = expPercentage;
	}

	@Override
	public String toString() {
		return "LevelInfo [level=" + level + ", currentLevelExp="
				+ currentLevelExp + ", requiredExp=" + requiredExp
				+ ", nextLevelExp=" + nextLevelExp + ", expDemandBlock="
				+ expDemandBlock + ", expPercentage=" + expPercentage + "]";
	}

}
