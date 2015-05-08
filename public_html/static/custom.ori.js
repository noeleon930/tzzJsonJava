var chart_value;
if(chart_average == true)
{
    chart_value = ['point_average'];
}
else
{
    chart_value = ['point_open', 'point_high', 'point_low', 'point_close'];
}

$.getJSON("/stream/id/" + chart_id, function(jsonData)
{
    var chart = c3.generate(
    {
        bindto: '#chart',
        data:
        {
            json: jsonData,
            keys:
            {
                x: 'stock_dateStr',
                value: chart_value,
            },
            xFormat: '%Y%m%d',
            type: 'line'
        },
        point:
        {
            show: false
        },
        size:
        {
            height: 600
        },
        // zoom:
        // {
        //     enabled: true
        // },
        subchart:
        {
            show: true
        },
        axis:
        {
            x:
            {
                type: 'timeseries',
                tick:
                {
                    fit: true,
                    count: 50,
                    culling:
                    {
                        max: 50
                    },
                    rotate: 80,
                    format: '%Y%m%d'
                }
            }
        }
    });

    chart_global = chart;

    $('#bar').html("&nbsp&nbsp&nbsp" + jsonData[0].stock_name);
});
