
$('.update-btn').click(function() {
    // console.log("Update button number: " + $(this).attr('id'));
    const formId = $(this).attr('id');
    const form = $("#form" + formId);
    let data = form.serializeArray();
    const formData = JSON.stringify(getFormData(data));

    $.ajax({
        url: "http://localhost:3000/review/" + formId,
        type: "PUT",
        data: formData,
        dataType: "json",
        contentType: "application/json",
        success: function () {
            $('#main').load('/review');
        }
    });
});

$('.delete-btn').click(function() {
    // console.log("Delete button number: " + $(this).attr('id'));
    const formId = $(this).attr('id');

    $.ajax({
        url: "http://localhost:3000/review/" + formId,
        type: "DELETE",
        dataType: "json",
        success: function () {
            $('#main').load('/review');
        }
    });
});

