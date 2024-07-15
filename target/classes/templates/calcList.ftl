<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get Calc List</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Calculation List</h1>
    <ul id="calcList"></ul>

    <script>
        $(document).ready(function() {
            $.ajax({
                url: 'calculator/list',
                type: 'GET',
                dataType: 'json',
                success: function(response) {
                    $('#calcList').empty(); // Очистить существующий список
                    $.each(response, function(key, value) {
                        $('#calcList').append('<li>' + key + ': ' + value + '</li>');
                    });
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching calculation list:', status, error);
                }
            });
        });
    </script>
</body>
</html>
