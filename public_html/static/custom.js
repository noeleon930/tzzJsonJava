var chart_global;
var chart_status = "area";

$.getJSON("/stream/id/1218", function(jsonData)
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
                value: ['point_open', 'point_high', 'point_low', 'point_close'],
            },
            xFormat: '%Y%m%d',
            type: 'line'
        },
        point:
        {
            show: false
        },
        zoom:
        {
            enabled: true
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
});
