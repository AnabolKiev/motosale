function submitCheckboxes() {
    var myCheckboxes = new Array();
    $("input:checked").each(function() {
        myCheckboxes.push($(this).val());
    });
    $.ajax({
        type: "POST",
        url: "/ajax/manufacturer/",
        data: { checkedManufacturers:myCheckboxes },
        success: function(data){
                    $('#ajaxResponse').html(data)
                }
    });
    return false;
};