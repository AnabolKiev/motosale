function submitCheckboxes() {
    $.ajax({
        type: "POST",
        url: "/ajax/manufacturer/",
        data: $("input:checked").serialize()
    });
    return false;
};

function submitCategories() {
    $.ajax({
        type: "POST",
        url: "/ajax/category/",
        data: $("#categoriesForm").serialize()
    });
    return false;
};

function submitEngineTypes() {
    //var data = $("#engineTypeForm").serialize();
    var data = {}
    data["1"] = "honda";
    data["2"] = "triumph";
    //search["email"] = $("#email").val();
    var data2 = {key: "1", value : "test"};

    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: "/ajax/engineType/",
        data : JSON.stringify(data2),
        dataType : 'json'
    });
    $("#test").text(JSON.stringify(data2));
    return false;
};