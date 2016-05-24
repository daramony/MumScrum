
<div class="container">
    <div id="burnDown">

    </div>
</div>
<!-- /.container -->




<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>


<script>
    $(function () {

        var xData = [];
        var devData = [];
        var testData = [];

        $.ajax({
            'url': "/mumScrum/generateBDChart/${sprintId}",
            'dataType': 'json'
        }).done(function (response) {
            console.log(response);
            $.each(response, function (key, value) {

                if(key=='dev') {
                    $.each(value, function (key, value) {
                        devData.push(value);
                        xData.push(key);
                    });
                }else{
                    $.each(value, function (key, value) {
                        testData.push(value);
                        xData.push(key);
                    });
                }

            });


            $('#burnDown').highcharts({
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Development Burn Down Chart'
                },
                subtitle: {
                    text: ''
                },
                xAxis: {
                    categories: xData,
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Development Hours'
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} Hours</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series: [
                    {
                        name: 'Development',
                        data: devData

                    },
                    {
                        name: "Test",
                        data: testData
                    }
                ]
            });
        });


    });
</script>

