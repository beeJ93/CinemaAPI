$(document).ready(function(){
	$.ajax({
		//ajax옵션 설정
		url:"http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=f5eef3421c602c6cb7ea224104795888",
		type:"GET",
		data:{},
		
		//요청이 성공시 할 일 처리
		success:function(response){
			console.log(response)
			console.log(typeof response)
			//항일 처리
			
			//페이지단에 붙이기
		}
	})
});