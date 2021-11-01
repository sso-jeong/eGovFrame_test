package egovframework.example.main.model;

public class PagingTestVO {

	// 헌재 페이지 번호
	private int page;

	// 한 페이지당 보여줄 게시글 갯수
	private int recordCountPerPage;

	// 페이지 갯수
	private int pageUnit = 10;

	// 특정 페이지의 게시글 시작 번호
	public int firstIndex() {
		return (this.page - 1) * recordCountPerPage;
	}


	public void Criteria() {
		this.page = 1;
		this.recordCountPerPage = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		int cnt = this.recordCountPerPage;
		if (pageUnit != cnt) {
			this.recordCountPerPage = cnt;
		} else {
			this.recordCountPerPage = pageUnit;
		}
	}

	

}
