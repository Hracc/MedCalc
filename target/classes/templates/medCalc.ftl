<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${medCalc.name}</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <!-- Структура страницы -->
    <a href="/">Вернуться назад</a>
    <h1>Калькулятор: ${medCalc.name}</h1>
    <form id="medCalcForm">
        <#list medCalc.infoParams as param>
            <label for="${param.key}">${param.descr}:</label><br>
            <#if param.type != 'select'>
                <input type="${param.type}" id="${param.key}" name="${param.key}"<#list medCalc.numberParams as numb><#if numb.key == param.key> step=${numb.step?c} max=${numb.max?c} min=${numb.min?c}</#if></#list>>
            <#else>
                <select id="${param.key}" name="${param.key}">
                <#list medCalc.listParam as select>
                    <option value="${select}">${select}</option>
                </#list>
                </select>
            </#if>
            <br><br>
        </#list>
    </form>
    <div id="result"></div>
    <div id="info"></div>
    <div id="descr"></div>

    <!-- Подключение внешнего скрипта -->
    <script>
        const info = [
            <#list medCalc.infoParams as param>
                {key: "${param.key}", type: "${param.type}"}<#if param_has_next>,</#if>
            </#list>
        ];
        const results = [
            <#list medCalc.infoResult as res>
                {key: "${res.key}", descr: "${res.descr}"}<#if res_has_next>,</#if>
            </#list>
        ];
        const data = "${data}";
        const notRequireNumbs = {
            <#list medCalc.notRequireNumbs?keys as key>
                "${key}": ${medCalc.notRequireNumbs[key]?c}<#if key_has_next>,</#if>
            </#list>
        };
    </script>
    <script src="/js/POSTResult.js"></script>
    <script src="/js/GETInfo.js"></script>
</body>
</html>
