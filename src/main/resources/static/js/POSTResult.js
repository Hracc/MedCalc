$(document).ready(function() {
    let debounceTimer;

    // Функция для отправки результата расчета значений
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
                            value = notRequireNumbs[key];
                        } else {
                            allInputsValid = false;
                            return;
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
                    allInputsValid = false;
                    return;
            }

            params[key] = value;
        });

        if (allInputsValid) {
            $.ajax({
                type: 'POST',
                url: `/calculator/${data}/result`,
                contentType: 'application/json',
                data: JSON.stringify(params),
                success: function(response) {
                    let resultHtml = '<strong>Результаты:</strong>'; 
                    // Вывод результата
                    results.forEach(res => {
                        resultHtml += `<div class="result-item"><span class="label">${res.descr}:</span> ${response[res.key]}</div>`;
                    });
                    $('#result').html(resultHtml);
                },
                error: function(xhr, status, error) {
                    $('#result').html(`<p>Ошибка: ${xhr.responseText}</p>`);
                }
            });
        } else {
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
