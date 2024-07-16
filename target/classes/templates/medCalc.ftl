<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Расчет скорости внутривенного капельного введения препарата</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <a href="/">Вернуться назад</a>
    <h1>Калькулятор: Расчет скорости внутривенного капельного введения препарата</h1>
    <form id="medCalcForm">
        <label for="V">Объем раствора (мл):</label>
        <input type="number" step="0.1" id="V" name="V" required><br><br>

        <label for="t">Время (мин):</label>
        <input type="number" step="0.1" id="t" name="t" required><br><br>

        <label for="hm">Использовать часы (выбор):</label>
        <input type="checkbox" id="hm" name="hm"><br><br>
    </form>

    <div id="result"></div>

    <script>
        $(document).ready(function() {
            let debounceTimer;

            function calculate() {
                const V = parseFloat($('#V').val());
                const t = parseFloat($('#t').val());
                const hm = $('#hm').is(':checked');
                if (!isNaN(V) && !isNaN(t)) {
                    const params = {
                        V: V,
                        t: t,
                        hm: hm
                    };

                    $.ajax({
                        type: 'POST',
                        url: '/calculator/${data?js_string}/result',
                        contentType: 'application/json',
                        data: JSON.stringify(params),
                        success: function(response) {
                            $('#result').html('<p>Результат в минутах: ' + response.resultMinute + '</p>'
                                + '<p>Результат в часах: ' + response.resultHour + '</p>');
                        },
                        error: function(xhr, status, error) {
                            $('#result').html('<p>Ошибка: ' + error + '</p>');
                        }
                    });
                } else {
                    $('#result').html('<p>Пожалуйста, введите корректные значения.</p>');
                }
            }

            function debounceCalculate() {
                clearTimeout(debounceTimer);
                debounceTimer = setTimeout(calculate, 300);
            }

            // Обработчики событий для всех полей ввода
            $('#V, #t, #hm').on('input change', debounceCalculate);
        });
    </script>
</body>
</html>
