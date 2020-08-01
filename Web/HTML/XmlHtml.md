# XML & HTML 연동

### xml.html

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<style></style>
<script>
function makeChart(data){
	
	Highcharts.chart('container', {
    chart: {
        type: 'line'
    },
    title: {
        text: 'Seoul Monthly Average Temperature'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    },
    yAxis: {
        title: {
            text: 'Temperature (°C)'
        }
    },
    plotOptions: {
        line: {
            dataLabels: {
                enabled: true
            },
            enableMouseTracking: false
        }
	},
	
	//(json) , 배열 안에 object 안에 name(attribute)과 data(배열) 
				// series: [{
				//     name: 'Seoul',
				//     data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
				// }, {
				//     name: 'Busan',
				//     data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
				// }, {
				//     name: 'Daegu',
				//     data: [12, 5.2, 6.7, 43.5, 33.9, 36.2, 31.0, 22.6, 41.2, 23.3, 33, 32]
				// }
				// ]
    series:data
	});
}; // end makeChart

function Temp(n,d1){
	this.name = n;
	this.data = d1;
};

function parsing(data){

	var ts = $(data).find('temp');
	var datas = [];
	ts.each(function(index,item){
		var name = $(this).find('name').text();
	
		var d = $(this).find('data');
		var ds = [];
		d.each(function(index,item){
			ds.push(Number($(item).text()));
		});
		var obj = new Temp(name,ds);
		datas.push(obj);
	});
	makeChart(datas);

	// 	var name = $(this).find('name').text();  // name의 data 가져오기 
		// 	var data1 = $(this).find('data1').text();
		// 	var data2 = $(this).find('data2').text();
		// 	var data3 = $(this).find('data3').text();
		// 	for(var i=0;i<d.length;i++){

		// 	}

		// 	var obj= 
		// 	new Temp(name,Number(data1),Number(data2),Number(data3));
		// 	datas.push(obj);    //object를 배열에 넣는 방법 
};

function getData(){
	$.ajax({
		url:'temp.xml',
		success:function(data){ //json data가 내려온다 
			parsing(data);
			//makeChart(eval(data));
		}
	});
};


// loading 
$(document).ready(function(){
	getData();
	//setInterval(getData,5000); 5초에 한번씩 소환
});
</script>
</head>
<body>
<h1>My Charts</h1>
<div id="container" 
style="min-width: 310px; height: 400px; margin: 0 auto"></div>

</body>
</html>



```

### temp.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<temps>
<temp>
	<name>Seoul</name>
	<data>10</data>
	<data>20</data>
	<data>30</data>
	<data>40</data>
	<data>50</data>
	<data>60</data>
	<data>70</data>
	<data>80</data>
	<data>90</data>
	<data>100</data>
	<data>100</data>
	<data>100</data>
</temp>
<temp>
	<name>Busan</name>
	<data>50</data>
	<data>30</data>
	<data>60</data>
	<data>70</data>
	<data>80</data>
	<data>20</data>
	<data>30</data>
	<data>40</data>
	<data>50</data>
	<data>10</data>
	<data>10</data>
	<data>10</data>
</temp>
</temps>
```



* 차트 www.highcharts.com