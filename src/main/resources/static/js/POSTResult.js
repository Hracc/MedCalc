$(document).ready(function() {
    let debounceTimer;

    // Функция для расчета значений
    function calculate() {
        let allInputsValid = true;
        const params = {};

        // Сбор параметров из формы
        info.forEach(param => {
            let key = param.key;
            let type = param.type;
            let value;

            switch (type) {
                case "number":
                    value = parseFloat($(`#${key}`).val());
                    if (isNaN(value) || value === "") {
                        if (notRequireNumbs.hasOwnProperty(key)) {
                            value = notRequireNumbs[key];  // Используем значение по умолчанию, если оно есть
                        } else {
                            allInputsValid = false;  // Поле обязательно, но значение отсутствует или некорректно
                            return;  // Прекращаем выполнение для текущего параметра
                        }
                    }
                    break;
                case "checkbox":
                    value = $(`#${key}`).is(':checked');
                    break;
                case "select":
                    value = $(`#${key}`).val();
                    break;
                default:
                    allInputsValid = false;  // Неизвестный тип поля
                    return;  // Прекращаем выполнение для текущего параметра
            }

            params[key] = value;
        });

        if (allInputsValid) {
            console.log('Params before POST:', params);
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

    // Установка задержки на отправку запроса после изменения или ввода значения
    info.forEach(param => {
        const keyElement = $(`#${param.key}`);
        keyElement.on('input change', function() {
            clearTimeout(debounceTimer);
            debounceTimer = setTimeout(calculate, 250);
        });
    });
});
