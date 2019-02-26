
$(window).resize(function() {
    let viewportWidth = $(window).width();
    if (viewportWidth < 575) {
        $(".btn").removeClass("btn-lg").addClass("btn-sm");
    }
});
