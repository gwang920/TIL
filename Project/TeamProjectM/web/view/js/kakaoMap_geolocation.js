(function ($) {
	"use strict";

	getLocation();

	function geoSuccess(position) {
		console.log(position.coords.latitude);
		console.log(position.coords.longitude);

		userPosition[0] = position.coords.latitude;
		userPosition[1] = position.coords.longitude;
	};

	function geoError(error) {
		console.log('Error occurred. Error code: ' + error.code);
		// error.code can be:
		//   0: unknown error
		//   1: permission denied
		//   2: position unavailable (error response from location provider)
		//   3: timed out
	};

	function getLocation() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(geoSuccess, geoError);
		}

		else {
			console.log('Geolocation is not supported for this Browser/OS.');
		}
	};
})(jQuery);