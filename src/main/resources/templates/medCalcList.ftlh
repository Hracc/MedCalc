<!DOCTYPE html>
<html>
    <head>
        <title>Калькуляторы</title>
    </head>
    <body>
        <h1>bruh</h1>
        <#list calcList?keys as key>
            <div>
                <p>${key}: ${calcList[key].getInfo()}</p>
            </div>
        </#list>  
    </body>
</html>