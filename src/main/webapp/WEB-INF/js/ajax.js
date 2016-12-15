function submitCheckboxes() {
    $.ajax({
        type: "POST",
        url: "/ajax/manufacturer/",
        data: $("input:checked").serialize()
    });
    return false;
};

function submitDictionary(source) {
    var formId = $(source).closest('form').attr('id');
    var data = {};
    $('#' + formId).find(':input:not(:button)').each(function() {
        data[this.name] = $(this).val();
    });
    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: '/ajax/' + formId + '/',
        data : JSON.stringify(data),
        dataType : "JSON"
    });
    return false;
};