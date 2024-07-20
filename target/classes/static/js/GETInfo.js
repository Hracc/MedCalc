$(document).ready(function() {

    // Функция для расчета значений
    function info() {
            $.ajax({
                type: 'GET',
                url: `/calculator/${data}/info`,
                dataType: 'json',
                success: function(response) {
                    $('#info').html(`<p>${response}</p>`);
                },
                error: function(xhr, status, error) {
                }
            });
    }
});
