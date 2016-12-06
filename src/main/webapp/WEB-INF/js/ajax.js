$(document).ready(function(){
    $('#manufacturerTable:checkbox').click(function() {
        $.ajax( {
            type: 'POST',
            url: '/ajax/manufacturer/',
            data: { checkedManufacturers : $('input:checkbox:checked').val()},
            success: function(data) {
                $('#ajaxResponse').html(data);
            }
        });
    })
});
