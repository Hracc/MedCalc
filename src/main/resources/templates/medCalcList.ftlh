<!DOCTYPE html>
<html>
    <head>
        <title>Медицинские калькуляторы</title>
    </head>
    <body>
        <h1>bruh</h1>
        <#list calcList?keys as key>
            <div>
                <a href="/${calcList[key].getId()}">${calcList[key].getName()}</a>
                <p>${calcList[key].getInfo()}</p>

            </div>
        </#list>  
    </body>
</html>