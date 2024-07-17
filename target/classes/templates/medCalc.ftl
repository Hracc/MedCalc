<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${calc.name}</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <a href="/">Вернуться назад</a>
    <h1>Калькулятор: ${calc.name}</h1>
    <form id="medCalcForm">
        <#list info as param>
            <label for="${param.key}">${param.name}</label>
            <input type="${param.type}" id="${param.key}" name="${param.key}"><br><br>
        </#list>
    </form>

    <div id="result"></div>

    <script>
        $(document).ready(function() {
            let debounceTimer;

            function calculate() {
                let allInputsValid = true;
                const params = {};

                <#list info as param>
                    <#if param.type == "number">
                        const ${param.key} = parseFloat($('#${param.key?js_string}').val());
                    <#else>
                        const ${param.key} = $('#${param.key?js_string}').is(':checked');
                    </#if>
                    params["${param.key?js_string}"] = ${param.key};

                    if (${param.required?c} && isNaN(${param.key})) {
                        allInputsValid = false;
                    }
                </#list>

                if (allInputsValid) {
                    $.ajax({
                        type: 'POST',
                        url: '/calculator/${data?js_string}/result',
                        contentType: 'application/json',
                        data: JSON.stringify(params),
                        success: function(response) {
                            console.log(response);
                            let resultHtml = '';
                            <#list results as res>
                                resultHtml += '<p>${res.descr}: ' + response['${res.key}'] + '</p>';
                            </#list>
                            $('#result').html(resultHtml);
                        },
                        error: function(xhr, status, error) {
                            $('#result').html('<p>Ошибка: ' + error + '</p>');
                        }
                    });
                } else {
                    $('#result').html('<p>Введите все нужные значения.</p>');
                }
            }

            <#list info as param>
                $('#${param.key}').on('input change', function() {
                    clearTimeout(debounceTimer);
                    debounceTimer = setTimeout(calculate, 300);
                });
            </#list>
        });
    </script>
</body>
</html>
