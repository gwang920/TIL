(function ($) {
	"use strict";

	var ps = new kakao.maps.services.Places();

	// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
	var infowindow;
	var markers = [];

	$('#btn_map_search').click(searchPlaces);

	// 키워드 검색을 요청하는 함수입니다
	function searchPlaces() {
		var keyword = roullet_result.text;
		var map_address = $('#map_address').val();

		if (!map_address.replace(/^\s+|\s+$/g, '') && keyword != null && keyword != '') {
			alert('키워드를 입력해주세요!');
			return false;
		}

		// var geocoder = new kakao.maps.services.Geocoder();
		// geocoder.coord2Address(userPosition[1], userPosition[0], geoCoderCallback);
		// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
		ps.keywordSearch(map_address + keyword, placesSearchCB);
	}

	// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
	function placesSearchCB(data, status) {
		if (status === kakao.maps.services.Status.OK) {

			// 정상적으로 검색이 완료됐으면
			// 검색 목록과 마커를 표출합니다
			displayPlaces(data);
		} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

			alert('검색 결과가 존재하지 않습니다.');
			return;

		} else if (status === kakao.maps.services.Status.ERROR) {
			alert('검색 결과 중 오류가 발생했습니다.');
			return;
		}
	}

	function addUserPosition() {
		// 지도에 표시할 원을 생성합니다
		var circle = new kakao.maps.Circle({
			center: new kakao.maps.LatLng(userPosition[0], userPosition[1]),  // 원의 중심좌표 입니다 
			radius: 20, // 미터 단위의 원의 반지름입니다 
			strokeWeight: 5, // 선의 두께입니다 
			strokeColor: '#F10000', // 선의 색깔입니다
			strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
			strokeStyle: 'solid', // 선의 스타일 입니다
			fillColor: '#CFE7FF', // 채우기 색깔입니다
			fillOpacity: 0.7  // 채우기 불투명도 입니다   
		});

		// 지도에 원을 표시합니다 
		circle.setMap(map);
	}

	// 검색 결과 목록과 마커를 표출하는 함수입니다
	function displayPlaces(places) {
		var listEl = document.getElementById('placesList'),
			menuEl = document.getElementById('menu_wrap'),
			fragment = document.createDocumentFragment(),
			bounds = new kakao.maps.LatLngBounds();

		// 검색 결과 목록에 추가된 항목들을 제거합니다
		removeAllChildNods(listEl);

		// 지도에 표시되고 있는 마커를 제거합니다
		removeMarker();

		for (var i = 0; i < places.length; i++) {

			// 마커를 생성하고 지도에 표시합니다
			var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
				marker = addMarker(placePosition, i),
				itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

			// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
			// LatLngBounds 객체에 좌표를 추가합니다
			bounds.extend(placePosition);

			// 마커와 검색결과 항목에 mouseover 했을때
			// 해당 장소에 인포윈도우에 장소명을 표시합니다
			// mouseout 했을 때는 인포윈도우를 닫습니다

			(function (place, placePosition) {
				itemEl.onclick = function () {
					if (infowindow != null) {
						infowindow.setMap(null);
					}
					
					displayInfowindow(place, placePosition);
					map.setCenter(placePosition);
				};
			})(places[i], placePosition);

			fragment.appendChild(itemEl);
		}

		// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
		listEl.appendChild(fragment);
		menuEl.scrollTop = 0;

		// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
		map.setBounds(bounds);
		addUserPosition();
	}

	// 검색결과 항목을 Element로 반환하는 함수입니다
	function getListItem(index, places) {

		var el = document.createElement('li'),
			itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
				'<div class="info">' +
				'   <h5>' + places.place_name + '</h5>';

		if (places.road_address_name) {
			itemStr += '    <span>' + places.road_address_name + '</span>' +
				'   <span class="jibun gray">' + places.address_name + '</span>';
		} else {
			itemStr += '    <span>' + places.address_name + '</span>';
		}

		itemStr += '  <span class="tel">' + places.phone + '</span>' +
			'</div>';

		el.innerHTML = itemStr;
		el.className = 'item';

		return el;
	}

	// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
	function addMarker(position, idx) {
		var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
			imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
			imgOptions = {
				spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
				spriteOrigin: new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
				offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
			},
			markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
			marker = new kakao.maps.Marker({
				position: position, // 마커의 위치
				image: markerImage
			});

		marker.setMap(map); // 지도 위에 마커를 표출합니다
		markers.push(marker);  // 배열에 생성된 마커를 추가합니다

		return marker;
	}

	// 지도 위에 표시되고 있는 마커를 모두 제거합니다
	function removeMarker() {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
		}
		markers = [];
	}

	// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
	// 인포윈도우에 장소명을 표시합니다
	function displayInfowindow(place, placePosition) {
		var itemStr = '<div class="customoverlay">'
    	+ '  <a href="' + place.place_url + '" target="_blank">'
    	+ '    <span class="title">' + place.place_name + '</span>'
    	+ '  </a>'
    	+ '</div>';

		infowindow = new kakao.maps.CustomOverlay({
			map : map,
			position : placePosition,
			content : itemStr
		});
	}

	// 검색결과 목록의 자식 Element를 제거하는 함수입니다
	function removeAllChildNods(el) {
		while (el.hasChildNodes()) {
			el.removeChild(el.lastChild);
		}
	}
})(jQuery);