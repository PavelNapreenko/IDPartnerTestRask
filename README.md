# IDPartnerTestTask
Создан бекэнд для веб приложения, показывающего курс USD, JPY, RUB по отношению к EUR.
Курсы берутся с сайта евробанка. Каждые 30 минут в базу добавляются данные по этим курсам.
Из фронта добален только вывод всех курсов в базе.
Возможен поиск по названию валюты и по дате.

*Требования к окружению и компонентам:*

**Название**               |     **Ограничение**
---------------------------- | ----------------------
Версия JDK                   |     11
Система контроля версий      |     GIT
Версия Spring Boot           |     2.5.4
База данных                  |     MySQL 8
Сборщик проекта              |     Maven

**Запуск приложения**
______________________________________________________

Подготовить окружение:
$ cp .env_example .env

Задать необходимые значения переменным:
PORT,
JDBC_DATABASE_

Запустить приложение с нужными переменными окружения:

$ set -a; . ./.env; java -jar target/test_task-0.0.1.jar; set +a

Или в IntelliJ IDEA: Edit Configuration / EnvFile / Enable EnvFile / + .env.

<img alt="GitHub watchers" src="https://img.shields.io/github/watchers/PavelNapreenko/blog-engine?color=green&style=plastic">
<img alt="GitHub language count" src="https://img.shields.io/github/languages/count/PavelNapreenko/blog-engine?style=plastic">
<img alt="GitHub top language" src="https://img.shields.io/github/languages/top/PavelNapreenko/blog-engine?color=yellow&style=plastic">
<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/PavelNapreenko/blog-engine?color=brown&style=plastic">
<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/m/PavelNapreenko/blog-engine?color=pink&style=plastic">
