$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: `/calculator/${data}/info`,
        dataType: 'json',
        success: function (response) {
            if (response && response.info) {
                const existingContent = $('#info').html();
                const newContent = response.info.split('\n').map(line => `<p>${line}</p>`).join('');
                $('#info').html(existingContent + newContent);
            } else {
                $('#info').html('<div>Данные не найдены</div>');
            }
        },
        error: function (xhr, status, error) {
            console.error('Ошибка:', error);
            $('#info').html(`<div>Ошибка: ${xhr.responseText}</div>`);
        }
    });
});
