var jsonData_global;

$(function()
{
    $.getJSON("/stream/stock_set", function(jsonData)
    {
        jsonData_global = jsonData.sort(function(a, b)
        {
            return a.id - b.id;
        });

        $.each(jsonData_global, function(key, item)
        {
            $('#stocks').append('<a href="/demo/id/' + item.id + '">' + item.id + '_' + item.name + '</a><br>');
        });
    });
});
