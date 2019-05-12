# GoodLineTest
Тестовое задание от GoodLine

# Тесты и игра
[Документ со скриншотами](https://docs.google.com/document/d/1H5QsX-UveTyg7zohvS-tbVta-DE-nCInqh823f9OkL0/edit?usp=sharing "Документ") 

# Задание 2
компиляция  
javac LenOfFirstLine.java  
запуск  
java LenOfFirstLine {filename}

# Необходимые тесты (Задача 3)
[Тесты](https://vk.com/away.php?utf=1&to=https%3A%2F%2Fdocs.google.com%2Fdocument%2Fd%2F1EOaN3E9vd44aCZcZR1lG88JpQNR-OJv4iAWKD7Q8TJo%2Fedit%3Fusp%3Dsharing "Тесты")

# Задача 4
Проект с тестами в папке testapp.  
Для запуска тестов необходимо в папке запустить комманды:    
mvn test  
Для реализации тестов были использованы Java, Maven, JUnit, Rest Assured.

# Задача 5
Проект с тестами в папке autoapp.  
Для запуска тестов необходимо в папке запустить комманды:   
mvn test  
Для реализации тестов были использованы Java, Maven, JUnit, Selenium WebDriver.

# Задача 6
Проект с кроссбразерным тестированием в папке crossBrowserTest  
Для запуска тестов необходимо предварительно установить selenoid  
Запустить selenoid с параметрами selenoid start  
После завершения запустить тесты, для этого в папке с проектом:  
mvn test  

# Jenkins PipeLine
JenkinsFile находится в корневой папке  
Заменить linuxMavenPath или winMavenPath на ваш путь maven 
Например /mnt/c/apache-maven-3.6.1/bin/mvn