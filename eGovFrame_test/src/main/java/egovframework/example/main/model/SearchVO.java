package egovframework.example.main.model;

import java.util.Arrays;

public class SearchVO {

	/** 검색조건 */
	private String searchType = "";

	/** 검색 타입 배열 */
	private String[] searchTypeArr;

	/** 검색Keyword */
	private String searchKeyword = "";

	/** 검색사용여부 */
	private String searchUseYn = "";

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
		this.searchTypeArr = searchType.split("");
	}

	public String[] getSearchTypeArr() {
		return searchTypeArr;
	}

	public void setSearchTypeArr(String[] searchTypeArr) {
		this.searchTypeArr = searchTypeArr;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	@Override
	public String toString() {
		return "SearchVO [searchType=" + searchType + ", searchTypeArr=" + Arrays.toString(searchTypeArr) + ", searchKeyword=" + searchKeyword + ", searchUseYn=" + searchUseYn + "]";
	}

	
	
}
