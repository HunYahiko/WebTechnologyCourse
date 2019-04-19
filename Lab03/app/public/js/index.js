
const $main = $('#main');

$('#create--page').click(function () {
    $main.load('/create-page');
});

$('#read--page').click(function () {
    $main.load('/review');
});



