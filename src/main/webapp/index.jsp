<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <!-- 引入 echarts.js -->
    <script src="js/echarts.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;margin-left:50px"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
       // var option =

        // 使用刚指定的配置项和数据显示图表。
        //myChart.setOption(option);

        $.get('rest/echartsMeasureService/map', function(result){
            myChart.setOption($.parseJSON(result));
        });

    </script>
</body>
</html>