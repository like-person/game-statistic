Тестовое задание

С помощью Java 8/MongoDB/Maven (сетевой фреймворк свой, по выбору, в идеале что-либо, использующее Netty) создать сервис с REST Api для хранения статистики приложений (некий аналог Flurry)


Добавление события

$ curl -i -X POST -H "Content-Type:application/json" -d '{  "secretKey" : "ofw0k5YIA7",  "eventName" : "marketOpen" }' http://localhost:8080/events

При добавлении фиксируется время принятия и IP отправителя


Поиск события по secret key

$ curl http://localhost:8080/events/search/findBySecretKey?key=ofw0k5YIA7

{
  "_embedded": {
    "events": [
      {
        "secretKey": "ofw0k5YIA7",
        "eventName": "marketOpen",
        "eventIp": "192.168.0.101",
        "eventTime": "2015-10-04T12:32:02.949",
        "_links": {
          "self": {
            "href": "http://localhost:8080/events/5610c7e2bcc1f3f332b6e56b"
          }
        }
      }
    ]
  }
}


Поиск события по secret key и по имени события

$ curl http://localhost:8080/events/search/findBySecretKeyAndEventName?key=ofw0k5YIA7&name=marketOpen

{
  "_embedded": {
    "events": [
      {
        "secretKey": "ofw0k5YIA7",
        "eventName": "marketOpen",
        "eventIp": "192.168.0.101",
        "eventTime": "2015-10-04T12:32:02.949",
        "_links": {
          "self": {
            "href": "http://localhost:8080/events/5610c7e2bcc1f3f332b6e56b"
          }
        }
      }
    ]
  }
}
