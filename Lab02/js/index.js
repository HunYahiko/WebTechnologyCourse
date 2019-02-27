
$(window).resize(function() {
    let viewportWidth = $(window).width();
    if (viewportWidth < 575) {
        $(".btn").removeClass("btn-lg").addClass("btn-sm");
    } else {
        $(".btn").removeClass("btn-sm").addClass("btn-lg");
    }
});

$(document).ready(function() {
    $('.carousel').carousel({
        interval: 5000
    });
});

