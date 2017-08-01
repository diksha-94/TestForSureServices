package edu.tests.TestForSure.entity;

public class TestId{
	private int test_id;

	public TestId(int test_id) {
		super();
		this.test_id = test_id;
	}
	
	public TestId() {
		super();
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	@Override
	public String toString() {
		return "TestDetails [test_id=" + test_id + "]";
	}
}
