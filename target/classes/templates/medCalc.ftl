<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${medCalc.name}</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/css/style.css?v=1.0"> <!-- Подключение CSS -->
</head>
<body>
    <div class="header">
        <a href="/">Медицинские калькуляторы</a>
    </div>
    <div class="container">
        <h1>${medCalc.name}</h1>
        <form id="medCalcForm">
            <#list medCalc.infoParams as param>
                <label for="${param.key}">${param.descr}:</label><br>
                <#if param.type == 'checkbox'>
                    <label class="switch">
                        <input type="checkbox" id="${param.key}" name="${param.key}">
                        <span class="slider"></span>
                    </label>
                <#elseif param.type == 'select'>
                        <select id="${param.key}" name="${param.key}">
                            <#list medCalc.listParam as select>
                                <#if param.key == select.key>
                                    <option value="${select.name}">${select.name}</option>
                                </#if>
                            </#list>
                        </select>
                <#else>
                    <input type="${param.type}" id="${param.key}" name="${param.key}"<#list medCalc.numberParams as numb><#if numb.key == param.key> step=${numb.step?c} max=${numb.max?c} min=${numb.min?c}</#if></#list>>
                </#if>
                <br><br>
            </#list>
            <!-- Кнопка сброса -->
            <button type="reset" class="btn-reset">Сброс</button>
        </form>
        <div id="result">
            <strong>Результаты:</strong>
        </div>
    <div id="info">
        <strong>О чем калькулятор?</strong>
        <div class="description">
            Ниже описаны основый для расчета нужных значений.
        </div>
        <div class="detailed-info">
            <!-- Более детальная информация, переданная ниже -->
        </div>
    </div>
    </div>
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
    <script src="/js/POSTResult.js?v=1.0"></script>
    <script src="/js/GETInfo.js?v=1.0"></script>
</body>
</html>
