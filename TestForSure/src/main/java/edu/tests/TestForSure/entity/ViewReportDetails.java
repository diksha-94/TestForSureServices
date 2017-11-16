package edu.tests.TestForSure.entity;

import java.math.BigDecimal;

public class ViewReportDetails {
	private String username;
	private String testTitle;
	private int rank;
	private int totalCandidates;
	private BigDecimal totalMarks;
	private BigDecimal marksScored;
	private int totalQuestions;
	private int questionsAttempted;
	private int correctQues;
	private int incorrectQues;
	private BigDecimal timeTaken;
	private BigDecimal toppersScore;
	private BigDecimal toppersTime;
	private BigDecimal avgScore;
	private BigDecimal avgTime;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTotalCandidates() {
		return totalCandidates;
	}
	public void setTotalCandidates(int totalCandidates) {
		this.totalCandidates = totalCandidates;
	}
	public BigDecimal getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(BigDecimal totalMarks) {
		this.totalMarks = totalMarks;
	}
	public BigDecimal getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public int getQuestionsAttempted() {
		return questionsAttempted;
	}
	public void setQuestionsAttempted(int questionsAttempted) {
		this.questionsAttempted = questionsAttempted;
	}
	public int getCorrectQues() {
		return correctQues;
	}
	public void setCorrectQues(int correctQues) {
		this.correctQues = correctQues;
	}
	public int getIncorrectQues() {
		return incorrectQues;
	}
	public void setIncorrectQues(int incorrectQues) {
		this.incorrectQues = incorrectQues;
	}
	public BigDecimal getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(BigDecimal timeTaken) {
		this.timeTaken = timeTaken;
	}
	public BigDecimal getToppersScore() {
		return toppersScore;
	}
	public void setToppersScore(BigDecimal toppersScore) {
		this.toppersScore = toppersScore;
	}
	public BigDecimal getToppersTime() {
		return toppersTime;
	}
	public void setToppersTime(BigDecimal toppersTime) {
		this.toppersTime = toppersTime;
	}
	public BigDecimal getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(BigDecimal avgScore) {
		this.avgScore = avgScore;
	}
	public BigDecimal getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(BigDecimal avgTime) {
		this.avgTime = avgTime;
	}
	@Override
	public String toString() {
		return "ViewReportDetails [username=" + username + ", rank=" + rank + ", totalCandidates=" + totalCandidates
				+ ", totalMarks=" + totalMarks + ", marksScored=" + marksScored + ", totalQuestions=" + totalQuestions
				+ ", questionsAttempted=" + questionsAttempted + ", correctQues=" + correctQues + ", incorrectQues="
				+ incorrectQues + ", timeTaken=" + timeTaken + ", toppersScore=" + toppersScore + ", toppersTime="
				+ toppersTime + ", avgScore=" + avgScore + ", avgTime=" + avgTime + ", testTitle=" + testTitle + "]";
	}
	public ViewReportDetails(String username, String testTitle, int rank, int totalCandidates, BigDecimal totalMarks,
			BigDecimal marksScored, int totalQuestions, int questionsAttempted, int correctQues, int incorrectQues,
			BigDecimal timeTaken, BigDecimal toppersScore, BigDecimal toppersTime, BigDecimal avgScore,
			BigDecimal avgTime) {
		super();
		this.username = username;
		this.rank = rank;
		this.totalCandidates = totalCandidates;
		this.totalMarks = totalMarks;
		this.marksScored = marksScored;
		this.totalQuestions = totalQuestions;
		this.questionsAttempted = questionsAttempted;
		this.correctQues = correctQues;
		this.incorrectQues = incorrectQues;
		this.timeTaken = timeTaken;
		this.toppersScore = toppersScore;
		this.toppersTime = toppersTime;
		this.avgScore = avgScore;
		this.avgTime = avgTime;
		this.testTitle = testTitle;
	}
	public ViewReportDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
}
