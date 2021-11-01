<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style type="text/css">
a {
	text-decoration: auto;
}
  .pageInfo{
      list-style : none;
      display: inline-block;
    margin: 50px 0 0 100px;      
  }
  .pageInfo li{
      float: left;
    font-size: 20px;
    margin-left: 18px;
    padding: 7px;
    font-weight: 500;
  }
 a:link {color:black; text-decoration: none;}
 a:visited {color:black; text-decoration: none;}
 a:hover {color:black; text-decoration: underline;}
 
</style>
</head>
<body>
	<br />
	<h1 class="text-center">Board List</h1>
	<br />
	<br />

	<div class="container">
		<table class="table table-hover table-striped text-center"
			style="border: 1px solid;">
			<colgroup>
				<col width="10%" />
				<col width="40" />
				<col width="10%" />
				<col width="10%" />
				<col width="15%" />
				<col width="15%" />
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일자</th>
					<th>수정일자</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list }" var="result" varStatus="status">
					<tr>
						<td>${result.BID}</td>
						<td><a href="detail.do?BID=${result.BID}">${result.TITLE}</a></td>
						<td>${result.CREATEDNM}</td>
						<td>${result.HITCNT}</td>
						<td>${result.FRSTREGISTPNTTM}</td>
						<td>${result.LASTUPDTPNTTM}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<hr />
		<div>
			<ul class="pagination justify-content-center">
			
			<!-- 	 <li><a href="#" style="margin-right: 5px;" class="text-secondary">◀</a></li>
	               
	            <li><a href="#" style="margin-right: 5px;"
	               class="text-secondary">1</a></li>
	            <li><a href="#" style="margin-right: 5px;"
	               class="text-secondary">2</a></li>
	            <li><a href="#" style="margin-right: 5px;"
	               class="text-secondary">3</a></li>
	            <li><a href="#" style="margin-right: 5px;"
	               class="text-secondary">4</a></li> 
	            <li><a href="#" style="margin-right: 5px;"
	               class="text-secondary">5</a></li>
		
	            <li><a href="#" style="margin-right: 5px;"
	               class="text-secondary">▶</a></li> -->

				<!-- 페이지 번호 출력 -->
				<div class="pageInfo_wrap" >
			        <div class="pageInfo_area">
				        <!-- 각 번호 페이지 버튼 -->
				        <ui id="pageInfo" class="pageInfo">
				        <!-- 이전페이지 버튼 -->
			                <c:if test="${pageMaker.prev}">
			                    <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
			                </c:if>
			                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			                   <li class="pageInfo_btn"><a href="${num}">${num}</a></li>
			                </c:forEach>
			                  <!-- 다음페이지 버튼 -->
			                <c:if test="${pageMaker.next}">
			                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
			                </c:if>    
				 		</ui>
			        </div>
			    </div>
    
				<form id="moveForm" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
	        		<input type="hidden" name="amount" value="${pageMaker.cri.amount }"> 
				</form>
        
			  <%--   <c:if test="${pageMaker.prev}">
					<li><a href='<c:url value="main.do?page=${pageMaker.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a></li>
				</c:if>
				
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
					<li><a href='<c:url value="main.do?page=${num }"/>'><i	class="fa">${num }</i></a></li>
				</c:forEach>
				
				<c:if test="${pageMaker.next && pageMaker.endPage >0 }"> 
						<li> <a href='<c:url value="main.do?page=${pageMaker.endPage+1 }"/>'><i class="fa fa-chevron-right"></i></a></li>
				</c:if>  --%>

				<!-- 페이지 번호 출력 -->

			</ul>
		</div>
		<button type="button" id="btnWrite" class="btn btn-outline-info">글쓰기</button>

		<!-- search start -->
	<!-- 	<div class="form-group row">

			<div class="w100" style="padding-right: 10px">
				<select class="form-control form-control-sm" name="searchCondition"
					id="searchCondition">
					<option value="BID">번호</option>
					<option value="TITLE">제목</option>
					<option value="TITLE">제목</option>
				</select>
			</div>

			<div class="w300" style="padding-right: 10px">
				<input type="text" class="form-control form-control-sm"
					name="searchKeyword" id="searchKeyword">
			</div>

			<div>
				<button class="btn btn-sm btn-primary" name="btnSearch"
					id="btnSearch">검색</button>
			</div>

		</div> -->
		<!-- search end -->


	</div>

	<br>
	<script>
		$(document).ready(function() {
			$("#btnWrite").click(function() {
				location.href = "write.do";
			})
		})		


		// 검색
		$(document).on('click', '#btnSearch', function(e) {
			e.preventDefault();
			var url = "/main.do";
			url += "?searchCondition=" + $('#searchCondition').val();
			url += "&searchKeyword=" + $('#searchKeyword').val();
			location.href = url;
			console.log(url);

		});
		
		let moveForm = $("#moveForm");
		
		$(".move").on("click", function(e){
			e.preventDefault();
			
			moveForm.append("<input type='hidden' name='BID' value='"+ $(this).attr("href")+ "'>");
	        moveForm.attr("action", "/eGovFrame_test/main.do");
	        moveForm.submit();
		});
		
		$(".pageInfo a").on("click", function(e){
			e.preventDefault();
			moveForm.find("input[name='pageNum']").val($(this).attr("href"));
	        moveForm.attr("action", "/eGovFrame_test/main.do");
	        moveForm.submit();
		        
		});
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
		integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
		crossorigin="anonymous"></script>
</body>
</html>