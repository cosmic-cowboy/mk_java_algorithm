package com.slgerkamp.mkjavaalgorithm.stringSearching;


class StringSearchingFixture{
	String searchTarget;
	String pattern;
	int expecedIndex;
	
	public StringSearchingFixture(String searchTarget, String pattern, int expecedIndex) {
		super();
		this.searchTarget = searchTarget;
		this.pattern = pattern;
		this.expecedIndex = expecedIndex;
	}
	
	@Override
	public String toString() {
		return String.format("when searchTarget =%s, pattern=%s, expecedIndex=%s", searchTarget, pattern, expecedIndex);
	}
}