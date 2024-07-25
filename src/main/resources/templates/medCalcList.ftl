<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список калькуляторов</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="header">
        <a href="/">Медицинские калькуляторы</a>
    </div>
    <div class="container">
        <h1>Список:</h1>
        <div id="calcList">
            <#list medCalcList?keys as key>
                <div class="calc-list-item">
                    <a href='/calculator/${key}'>${medCalcList[key]}</a>
                </div>
            </#list>
        </div>
    </div>
</body>
</html>
