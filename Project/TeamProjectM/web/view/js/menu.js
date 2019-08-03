function makeRowPre(food_id, food_name, index) {
	var rowSentence = "<tr id=" + index + "><td>" + food_name + "</td></tr>";
	$('#menu_add_table > tbody').append(rowSentence);
	var tagOrder = "#" + index;
	$(document).on("click", tagOrder, function (event) {
		
		var tr = $(this);
		if (user_id != null) {
			$.ajax({
				url: "AddPre.mc",
				type: "POST",
				data: {
					"id": user_id, "name": food_id
				},
				success: function (data) {
					if (data == "success") {
						$('#menu_add_table > tbody > ' + tagOrder).remove();
					}
					else alertify.alert("로그인이 필요합니다");
				},
				error: function () {

					alertify.alert("로그인이 필요합니다");
				}
			});
		}
		else {
			
			$('#menu_add_table > tbody > ' + tagOrder).remove();
			FoodList.push({ 'fillStyle': '#EAEAEA', 'text': food_name });
			numSegments++;
		}
	});
}


function makeRowIgnore(food_id, food_name, index) {
	var rowSentence = "<tr id=" + index + "><td>" +  food_name + "</td></tr>";
	$('#menu_add_table > tbody').append(rowSentence);
	var tagOrder = "#" + index;
	$(document).on("click", tagOrder, function (event) {
		var tr = $(this);
		if (user_id != null) {
			$.ajax({
				url: "AddPre.mc",
				type: "POST",
				data: {
					"id": user_id, "name": food_id
				},
				success: function (data) {
					if (data == "success") {
						alert("successfully delete food in Ignore");
						$('#menu_add_table > tbody > ' + tagOrder).append();
					}
					else alertify.alert("로그인이 필요합니다");
				},
				error: function () {

					alertify.alert("로그인이 필요합니다");
				}
			});
		}
		else {
			$('#menu_add_table > tbody > ' + tagOrder).remove();
		}
	});
}

//startSpin();
var foodMenulist;
$('.p_add').click(function () {
	alertify.alert("메뉴를 클릭해주세요");
	$('#menu_add_table > tbody').empty();

	$.ajax({
		url: "menu_add_table_add_list.mc",
		type: "POST",
		data: {
			"id": user_id
		},
		success: function (data) {
			var index = 0;
			foodMenulist = JSON.parse(data);
			// $.extend(true,{},JSON.parse(data));
			$.each(foodMenulist, function () {
				makeRowPre(this.id, this.name, index);
				index = index + 1;
			})
			$('#menu_select_default_img').remove();
			$('.portfolio-item .thumb-inner').css('visibility', 'visible');
		},
		error: function () {
			alert("fail load list data");
		}

	});
});
$('.p_delete').click(function () {
	//numSegments++;
	
	var foodlist;

	$('#menu_add_table > tbody').empty();
	$.ajax({
		url: "add_pre_roullet.mc",
		type: "POST",
		data: {
			"id": user_id
		},
		success: function (data) {
			var index = 0;
			foodlist = JSON.parse(data);
		
			$.each(foodlist, function () {
				makeRowIgnore(this.id, this.name, index);
				index = index + 1;
			})

			$('#menu_select_default_img').remove();
			$('.portfolio-item .thumb-inner').css('visibility', 'visible');
		}
	});

});