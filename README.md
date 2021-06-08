# Тестовое для МКБ
## Задание:

>Написать Андроид мобильное приложение по отображению списка Курсов Валют.

>API:
>http request: POST
>url: https://alpha.as50464.net:29870/moby-pre-44/core?r=BEYkZbmV&d=563B4852-6D4B-49D6-A86E-B273DD520FD2&t=ExchangeRates&v=44
>json body: {\"uid\":\"563B4852-6D4B-49D6-A86E-B273DD520FD2\",\"type\":\"ExchangeRates\",\"rid\":\"BEYkZbmV\"}

>Request headers:
>User-Agent=Test GeekBrains iOS 3.0.0.182 (iPhone 11; iOS 14.4.1; Scale/2.00; Private);Content-Type=application/json;Accept=application/json

>Получить список валют и отображать их.
>Стиль экранов отображения произвольный, единственное условие - отображение всей информации из ответа.

## Использовал:
* api lvl 23
* kotlin
* retrofit
* okhttp
* hilt
* courutines
* mvvm
* view binding

## Замечания:
Не совсем понял смысл некоторых полей, поэтому просто отобразил их в детализации
Если вылезает снакбар с ошибкой, значит случился таймаут при соединении с сервером, не совсем понятно, что с этим делать.
Можно таймаут побольше поставить, но он и так дефолтный нормальный. Нажмите перезагрузить в снакбаре.
