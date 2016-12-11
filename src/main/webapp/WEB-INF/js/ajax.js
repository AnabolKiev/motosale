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