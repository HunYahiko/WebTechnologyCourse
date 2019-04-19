
$('#create--form').submit(function(e) {
    e.preventDefault();

    const form = $(this);
    let data = form.serializeArray();
    const formData = JSON.stringify(getFormData(data));

    $.ajax({
        url: "http://localhost:3000/review",
        type: "POST",
        data: formData,
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            $('.form-submit--result').show();
        }
    });
});

function getFormData(data) {
    let unindexed_array = data;
    let indexed_array = {};

    $.map(unindexed_array, function(value, key){
        indexed_array[value['name']] = value['value'];
    });

    return indexed_array;
}

