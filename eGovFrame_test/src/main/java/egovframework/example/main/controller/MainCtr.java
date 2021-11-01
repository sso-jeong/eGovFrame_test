package egovframework.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.main.model.Criteria;
import egovframework.example.main.model.MainVO;
import egovframework.example.main.model.PageMakerDTO;
import egovframework.example.main.service.MainSrv;

@Controller
public class MainCtr {
	
	@Autowired
	private MainSrv mainSrv;

	// 게시판 목록 페이지
	/*
	 * @RequestMapping(value = "/main.do", method = RequestMethod.GET) public
	 * ModelAndView mainPage(MainVO MainVO) throws Exception {
	 * 
	 * ModelAndView mav = new ModelAndView();
	 * 
	 * List<MainVO> list = mainSrv.selectList2(MainVO); mav.addObject("list", list);
	 * mav.setViewName("main");
	 * 
	 * return mav; }
	 */

	// 글 목록 조회 , pageing

	/*
	 * @RequestMapping(value = "/main.do", method = RequestMethod.GET) public
	 * ModelAndView selectList(@ModelAttribute("searchVO") PagingTestVO searchVO)
	 * throws Exception {
	 * 
	 * ModelAndView mav = new ModelAndView();
	 * 
	 * PagingMaker pageMaker = new PagingMaker(); pageMaker.setCri(searchVO);
	 * pageMaker.setTotalCount(100);
	 * 
	 * List<Map<String, Object>> list = mainSrv.selectList(searchVO);
	 * mav.addObject("list", list); mav.addObject("pageMaker", pageMaker);
	 * mav.setViewName("main");
	 * 
	 * return mav; }
	 */
	
	// 글 상세페이지
	@RequestMapping(value = "/detail.do")
	public ModelAndView detailPage(int BID) throws Exception {

		ModelAndView mav = new ModelAndView();
		System.out.println("ctr >>>>> " + BID);
		MainVO detail = mainSrv.selectDetail(BID);
		mav.addObject("detail", detail);
		mav.setViewName("detail");

		System.out.println("ctr detail >>>>>>> " + mav);

		return mav;
	}

	// 글 작성 화면
	@GetMapping("/write.do")
	public String write() throws Exception {
		
		return "write";
	}

	// 글 작성 처리
	@PostMapping("/write.do")
	public String create(MainVO MainVO) throws Exception {

		mainSrv.createBoard(MainVO);
		return "redirect:/main.do";
	}

	// 글 수정
	@PostMapping("/detail.do")
	public String updateBoard(MainVO MainVO) throws Exception {

		mainSrv.updateBoard(MainVO);
		return "redirect:/main.do";
	}

	// 글 삭제
	@PostMapping("/delete.do")
	public String deleteBoard(int BID) throws Exception {

		mainSrv.deleteBoard(BID);
		return "redirect:/main.do";
	}
	
	// 글 목록 조회
	@GetMapping("/main.do")
	public void getListPaging(Model model, Criteria cri) throws Exception {
		model.addAttribute("list", mainSrv.getListPaging(cri));
		
		int total = mainSrv.selectCnt();
		
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		
		model.addAttribute("pageMaker", pageMake);
	}

}
