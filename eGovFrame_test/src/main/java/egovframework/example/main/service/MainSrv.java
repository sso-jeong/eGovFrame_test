package egovframework.example.main.service;

import java.util.List;
import java.util.Map;

import egovframework.example.main.model.Criteria;
import egovframework.example.main.model.MainVO;
import egovframework.example.main.model.PagingTestVO;

public interface MainSrv {

	// 게시판 목록보기 + 검색 + 페이징
	public  List<Map<String,Object>> selectList(PagingTestVO searchVO) throws Exception;

	// 게시글 총 갯수 조회
	int selectCnt() throws Exception;

	// 게시판 목록
	public List<MainVO> selectList2(MainVO MainVO) throws Exception;

	// 게시판 상세
	public MainVO selectDetail(int BID) throws Exception;

	// 게시글 등록
	public void createBoard(MainVO MainVO) throws Exception;

	// 게시글 수정
	public void updateBoard(MainVO MainVO) throws Exception;

	// 게시글 삭제
	public void deleteBoard(int BID) throws Exception;

    // 게시글 페이징
    List<MainVO> getListPaging(Criteria cri) throws Exception;

}
