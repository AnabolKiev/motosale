function submitCheckboxes() {
    $.ajax({
        type: "POST",
        url: "/ajax/manufacturer/",
        data: $("input:checked").serialize(),
        success: function(data){
                    $('#ajaxResponse').html(data)
                }
    });
    return false;
};