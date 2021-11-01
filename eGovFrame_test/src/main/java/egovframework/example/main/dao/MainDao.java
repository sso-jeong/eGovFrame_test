package egovframework.example.main.dao;

import java.util.List;
import java.util.Map;

import egovframework.example.main.model.Criteria;
import egovframework.example.main.model.MainVO;
import egovframework.example.main.model.PagingTestVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface MainDao {
	
	// 게시글 조회
	 List<Map<String,Object>> selectList(PagingTestVO searchVO) throws Exception;

	// 게시글 총 갯수 조회
	int selectCnt() throws Exception;

	//게시판 목록 test
	List<MainVO> selectList2(MainVO MainVO) throws Exception;

	//게시판 상세
    MainVO selectDetail(int BID)throws Exception;
    
    //게시글 등록
    void createBoard(MainVO MainVO) throws Exception;
    
    //게시글 수정
    void updateBoard(MainVO MainVO) throws Exception;
 
    //게시글 삭제
    void deleteBoard(int BID) throws Exception;
    
    // 게시글 페이징
    List<MainVO> getListPaging(Criteria cri) throws Exception;
}
