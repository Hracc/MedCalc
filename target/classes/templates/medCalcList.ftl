<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Get Calc List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <h1>Медицинские калькуляторы</h1>
    <div id="calcList">
        <#list medCalcList?keys as key>
            <a href='/calculator/${key}'>
                ${medCalcList[key]}
            </a><br><br>
        </#list>
    </div>
</body>

</html>