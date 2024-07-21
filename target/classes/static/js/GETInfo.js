$(document).ready(function () {

    $.ajax({
        type: 'GET',
        url: `/calculator/${data}/info`,  // Используйте значение data из FreeMarker
        dataType: 'json',
        success: function (response) {
            if (response && response.info) {
                $('#info').html(`<p>${response.info}</p>`);
            } else {
                $('#info').html('<p>Данные не найдены</p>');
            }
        },
        error: function (xhr, status, error) {
            console.error('Ошибка:', error);
            $('#info').html(`<p>Ошибка: ${xhr.responseText}</p>`);
        }
    });

});
