package egovframework.example.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.main.dao.MainDao;
import egovframework.example.main.model.Criteria;
import egovframework.example.main.model.MainVO;
import egovframework.example.main.model.PagingTestVO;

@Service("mainSrvImpl")
public class MainSrvImpl implements MainSrv {

	@Autowired
	private MainDao mainDao;
	
	// 게시판 목록보기 + 검색 + 페이징
	@Override
	public  List<Map<String,Object>>  selectList(PagingTestVO searchVO) throws Exception {
		return mainDao.selectList(searchVO);
	}

	@Override
	public int selectCnt() throws Exception {
		return mainDao.selectCnt();
	}
	
	//게시글 목록
	@Override
	public List<MainVO> selectList2(MainVO MainVO) throws Exception {
		return mainDao.selectList2(MainVO);
	}

	//게시글 상세
	@Override
	public MainVO selectDetail(int BID) throws Exception {
		System.out.println("mainSrvImpl bid >> " + BID);
		return mainDao.selectDetail(BID);
	}

	//게시글 등록
	@Override
	public void createBoard(MainVO MainVO) throws Exception {

		System.out.println("mainSrvImpl MainVO >> " + MainVO);
		mainDao.createBoard(MainVO);		
	}

	//게시글 수정
	@Override
	public void updateBoard(MainVO MainVO) throws Exception {
		mainDao.updateBoard(MainVO);		
	}

	//게시글 삭제
	@Override
	public void deleteBoard(int BID) throws Exception {
		mainDao.deleteBoard(BID);		
	}

	@Override
	public List<MainVO> getListPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return mainDao.getListPaging(cri);
	}



	

}
