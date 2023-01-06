$(document).ready(function(){
	const json = './json/data.json';
	$.getJSON(json, function(data){
		//방법1
		let member_data="";
		$.each(data, function(key, value){
			member_data += "<tr>";
            member_data += "<td>"+ value.id +"</td>";
            member_data += "<td>"+ value.name +"</td>";
            member_data += "<td>"+ value.age +"</td>";
            member_data += "<td>"+ value.address +"</td>";
            member_data += "<td>"+ value.gender +"</td>";
            member_data += "<td>"+ value.job +"</td>";
            member_data += "<td>"+ value.hobby +"</td>";
			member_data += "</tr>";
		});
		$('#member_table').append(member_data);
		
		//방법2
		/*
		$.each(data, function(key, value){
			
			
			console.log(value.id);
			console.log(value.name);
			console.log(value.age);
			console.log(value.address);
			console.log(value.gender);
			console.log(value.job);
			console.log(value.hobby);
			
			//테이블에 추가
			$('table').attr('border', '10')
			$('tbody').append(
				"<tr>"	+		
					"<td>"+value.id+"</td>"	+ 	
					"<td>"+value.name+"</td>"	+ 	
					"<td>"+value.age+"</td>"	+ 	
					"<td>"+value.address+"</td>"	+ 	
					"<td>"+value.gender+"</td>"	+ 	
					"<td>"+value.job+"</td>"	+ 	
					"<td>"+value.hobby+"</td>"	+ 	
				"</tr>"		
			);
			
		});
		*/
	});
});