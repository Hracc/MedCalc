$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: `/calculator/${data}/info`,  // Использование значения data из FreeMarker
        dataType: 'json',
        success: function (response) {
            // Проверяем, есть ли новые данные для добавления
            if (response && response.info) {
                // Если нужно добавить информацию, сначала сохраним старую
                const existingContent = $('#info').html();
                
                // Обновляем или добавляем новые данные
                const newContent = `<div>${response.info}</div>`;
                
                // Объединяем старое и новое содержание
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
