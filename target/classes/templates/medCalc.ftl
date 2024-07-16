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
        <#list info as param>
            <label for=${param.key}>${param.name}</label>
            <input type=${param.type} id=${param.key} name=${param.key}><br><br>
        </#list>
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
                    $('#result').html('<p>Введите все нужные значения.</p>');
                }
            }

            $('#V, #t, #hm').on('input change', function(){
                clearTimeout(debounceTimer);
                debounceTimer = setTimeout(calculate, 300);
            });
        });
    </script>
</body>
</html>
