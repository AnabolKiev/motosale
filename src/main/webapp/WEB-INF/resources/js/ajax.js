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

function submitEngineTypes(source) {
    var data = [];
    $('#engineType').find("tr:has(:input)").each(function() {
        data.push({ id: $(this).find("input[name=id]").val(),
                  name: $(this).find("input[name=name]").val(),
             shortName: $(this).find("input[name=shortName]").val(),
           engineOrder: $(this).find("input[name=engineOrder]").val(),
             groupName: $(this).find("input[name=groupName]").val(),
            groupOrder: $(this).find("input[name=groupOrder]").val() });
    });
    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: '/ajax/engineType/',
        data : JSON.stringify(data),
        dataType : "JSON"
    });
    return false;
};

function submitModelAttr() {
    event.preventDefault();
    var data = {};
    $('#modelAttrForm').find(':input').not(':button, :submit, :reset').each(function() {
        data[this.name] = $(this).val();
    });
    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: '/ajax/modelAttr/',
        data : JSON.stringify(data),
        dataType : "JSON"
    });
}

function deleteModel(id) {
    event.preventDefault();
    $.ajax({
        type: "GET",
        url: "/ajax/deleteModel/",
        data: {modelId: id},
        success: $('#modelsTable tr').each(function(){
            if($(this).find('td').eq(0).text() == id){
                $(this).remove();
            }
        })
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
                    '<a href=' + link + ' onclick=showModelAttr(' + value.id + ')>'+ value.year + '</a></td><td>' +
                    '<a href=' + link + ' onclick=deleteModel(' + value.id + ')>' + 'X' + '</a></td></tr>');
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
            $('#modelAttrForm').find(':input').not(':button,:submit,:reset,:hidden').val('').removeAttr('checked').removeAttr('selected');
            $.each(data, function( key, value ) {
                $('#modelAttrForm [name=' + key + ']').val(value);
                if (this.constructor.name == 'Object')
                    $('#' + key + 'Select').val(this.id);
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