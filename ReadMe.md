## Предисловия
Проект выполнил Баженов Е.И., студент ПГУТИ. 4 курс.

Дискорд - **hragun**.

## О чем проект?
Проект был сделан по тестовому заданию **Java** "Медицинские калькуляторы" 
(описание задания находится в папке doc).

В данном проекте были реализованы три калькулятора из данного сайта - [medicalc.com](https://medicalc.pro/):
* [Расчет дефицита калия](https://medicalc.pro/rashchetkalija),
* [Шкала комы Мэйо](https://medicalc.pro/mayo),
* [Расчет гидробаланса](https://medicalc.pro/gidrobalans).

В проекте используются:
* **Spring Boot ,Spring Web, SWAGGER** (для проверки ссылок по заданию);
* **Freemarker, CSS, JS, JQuery**.

## Запуск проекта
Если запускать через **IDEA** топ запустите класс **MedCalcApplication** (**src.main.java.MedCalcApplication**).

Если же через **.jar** файл то в папке target есть **med_calc-0.0.1-SNAPSHOT.jar**

Команда для запуска: 
```powershell
java -jar .\med_calc-0.0.1-SNAPSHOT.jar**)
```

**Требуется Java 17+.**

После запуска проекта перейдите на сайт: http://localhost:8080/

Ссылка для SWAGGER:  http://localhost:8080/swagger-ui/index.html
