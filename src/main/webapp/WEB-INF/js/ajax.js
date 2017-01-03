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

function submitModelAttr() {
    event.preventDefault();
    var data = {};
    $('#modelAttrForm').find(':input:not(:button)').each(function() {
        data[this.name] = $(this).val();
    });
    $('#test').text(JSON.stringify(data));
    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: '/ajax/modelAttr/',
        data : JSON.stringify(data),
        dataType : "JSON"
    });
}

function showModels(id) {
    event.preventDefault();
    $.ajax({
        type: "GET",
        url: "/ajax/model/",
        data: {manufacturerId: id},
        success: function (data) {
            $("#modelsTable tbody").empty();
            $.each(data, function( index, value ) {
                var link = '/admin/' + id + '/' + value.id;
                var row = $('<tr><td>' + value.id + '</td><td>' + value.name + '</td><td>' +
                    '<a href=' + link + ' onclick=showModelAttr(' + value.id + ')>'+ value.year + '</a></td></tr>');
                $("#modelsTable tbody").append(row);
            });
        }
    });
}

function showModelAttr(id) {
    event.preventDefault();
    $.ajax({
        type: "GET",
        url: "/ajax/modelAttr/",
        data: {modelId: id},
        success: function (data) {
            $('#modelAttrForm input').val('').removeAttr('checked').removeAttr('selected');
            $.each(data, function( key, value ) {
                $('#modelAttrForm [name=' + key + ']').val(value);
                if (this.constructor.name == 'Object') {
                    $('#' + key + 'Select').val(this.id);
                    console.log('#' + key + 'Select  id=' + this.id);
                }
            });
        }
    });
}

$(document).ready( function() {
    $('#manufacturerTable2 a').click(function() {
        showModels($(this).attr('value'));
    });

    $('#saveModelAttr').click(function() {
        if ($('#modelAttrForm')[0].checkValidity()) submitModelAttr();
    });
});