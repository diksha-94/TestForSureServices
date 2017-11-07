package edu.tests.TestForSure.entity;

import java.math.BigDecimal;

public class TopPerformers {
	private String name;
	private BigDecimal marks_scored;
	private int rank;
	private BigDecimal time_taken;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMarks_scored() {
		return marks_scored;
	}
	public void setMarks_scored(BigDecimal marks_scored) {
		this.marks_scored = marks_scored;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public BigDecimal getTime_taken() {
		return time_taken;
	}
	public void setTime_taken(BigDecimal time_taken) {
		this.time_taken = time_taken;
	}
	@Override
	public String toString() {
		return "TopPerformers [name=" + name + ", marks_scored=" + marks_scored + ", rank=" + rank + ", time_taken="
				+ time_taken + "]";
	}
	public TopPerformers(String name, BigDecimal marks_scored, int rank, BigDecimal time_taken) {
		super();
		this.name = name;
		this.marks_scored = marks_scored;
		this.rank = rank;
		this.time_taken = time_taken;
	}
	public TopPerformers() {
		super();
	}
	
	
}
