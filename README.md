
# Параметры для запуска тестов

## Ориентация экрана
* Запуск тестов с альбомной ориентацией экрана: mvn clean test -Dorientation=landscape
* Запуск тестов с книжной ориентацией экрана: mvn clean test -Dorientation=portrait

## Интернет соединение через Wi-Fi
* Запуск тестов с включенным Wi-Fi: mvn clean test -Dwifi=enabled
* Запуск тестов с выключенным Wi-Fi: mvn clean test -Dwifi=disabled
