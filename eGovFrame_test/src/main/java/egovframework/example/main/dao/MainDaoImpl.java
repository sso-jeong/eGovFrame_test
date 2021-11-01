package egovframework.example.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.main.model.Criteria;
import egovframework.example.main.model.MainVO;
import egovframework.example.main.model.PagingTestVO;

@Repository
public class MainDaoImpl implements MainDao {

	@Autowired
	private SqlSession sqlSession;

	// 게시판 목록보기 + 검색 + 페이징
	@Override
	public  List<Map<String,Object>> selectList(PagingTestVO searchVO) throws Exception {
		return sqlSession.selectList("selectList", searchVO);
		// return selectList("selectList", searchVO);
	}

	// 게시글 총 갯수 조회
	@Override
	public int selectCnt() {
		return (Integer) sqlSession.selectOne("getTotal");
		//return (Integer) selectOne("selectCnt", searchVO);
	}

	// 게시글 목록
	@Override
	public List<MainVO> selectList2(MainVO MainVO) throws Exception {
		return sqlSession.selectList("selectList2", MainVO);
	}

	// 게시글 상세
	@Override
	public MainVO selectDetail(int BID) throws Exception {
		System.out.println("DaoImpl bid >> " + BID);
		return sqlSession.selectOne("selectDetail", BID);
	}

	// 게시글 등록
	@Override
	public void createBoard(MainVO MainVO) throws Exception {

		System.out.println("dao MainVO >>>>>>>> " + MainVO);
		sqlSession.insert("createBoard", MainVO);
	}

	// 게시글 수정
	@Override
	public void updateBoard(MainVO MainVO) throws Exception {
		sqlSession.update("updateBoard", MainVO);
	}

	// 게시글 삭제
	@Override
	public void deleteBoard(int BID) throws Exception {
		sqlSession.delete("deleteBoard", BID);
	}

	@Override
	public List<MainVO> getListPaging(Criteria cri) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.selectList("getListPaging", cri);
	}

	
	
}
