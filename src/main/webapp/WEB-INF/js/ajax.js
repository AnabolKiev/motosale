function submitCheckboxes() {
    $.ajax({
        type: "POST",
        url: "/ajax/manufacturer/",
        data: $("input:checked").serialize()
    });
    return false;
};

function submitCategories() {
    var attr = new Array();
    var object = {};
    var key = $("input:hidden").val();
    var value = $("input:hidden").val();
    object[key] = value;
    attr.push(object);

    $.ajax({
        type: "POST",
        url: "/ajax/category/",
        data: attr
    });
    return false;
};