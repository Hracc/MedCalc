$(document).ready(function() {
    let debounceTimer;

    // Функция для расчета значений
    function calculate() {
        let allInputsValid = true;
        const params = {};

        // Сбор параметров из form
        info.forEach(param => {
            let key = param.key;
            let type = param.type;
            let value;

            if (type === "number") {
                value = parseFloat($(`#${key}`).val());
            } else {
                value = $(`#${key}`).is(':checked');
            }

            if (isNaN(value) || value === "") {
                value = 1;
            }
            params[key] = value;

            // Проверка обязательных полей
            if ((isNaN(value) || value === "")) {
                //allInputsValid = false;
            }
        });

        if (allInputsValid) {
            // Отправка POST-запроса
            $.ajax({
                type: 'POST',
                url: `/calculator/${data}/result`,
                contentType: 'application/json',
                data: JSON.stringify(params),
                success: function(response) {
                    let resultHtml = '';
                    // Вывод результата
                    results.forEach(res => {
                        resultHtml += `<p>${res.descr}: ${response[res.key]}</p>`;
                    });
                    $('#result').html(resultHtml);
                },
                error: function(xhr, status, error) {
                    $('#result').html(`<p>Ошибка: ${xhr.responseText}</p>`);
                }
            });
        } else {
            // Если не все нужные значения введены
            $('#result').html('<p>Введите значения.</p>');
        }
    }

    // Установка задержки на отправки запроса после изменения или ввода значения
    info.forEach(param => {
        const keyElement = $(`#${param.key}`);
        keyElement.on('input change', function() {
            clearTimeout(debounceTimer);
            debounceTimer = setTimeout(calculate, 250);
        });
    });
});
