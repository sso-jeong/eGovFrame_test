package egovframework.example.main.mapper;

import java.util.List;

import egovframework.example.main.model.MainVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

public interface MainMapper {

	//게시판 목록
	public List<MainVO> selectList(MainVO MainVO) throws Exception;

	//게시판 상세
	public MainVO selectDetail(int BID) throws Exception;
    
    //게시글 등록
	public void createBoard(MainVO MainVO) throws Exception;
    
    //게시글 수정
	public void updateBoard(MainVO MainVO) throws Exception;
 
    //게시글 삭제
	public void deleteBoard(int BID) throws Exception;
}
