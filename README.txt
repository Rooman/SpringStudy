#SpringStudy

Рекомендуемые материалы:
http://www.amazon.com/Spring-Action-Craig-Walls/dp/161729120X
http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/
https://www.youtube.com/watch?v=BmBr5diz8WA (Евгений Борисов — Spring-потрошитель, часть 1)
https://www.youtube.com/watch?v=cou_qomYLNU (Евгений Борисов — Spring-потрошитель, часть 2)
https://www.youtube.com/watch?v=VeCJ0o9RS20 (Spring configuration metadata -- что и как должно быть)
https://www.youtube.com/watch?v=-_aWK8T_YMI (Spring Framework on Java 8)


1) Рассчитана на ознакомление с классом BeanPostProcessor и, непосредственно, методом postProcessBeforeInitialization.
Практика:
    1) Создать аннотацию, которая будет отвечать за инжект случайного числа
    2) Создать класс бин пост процессора, который будет отвечать за логику инжетка в поля проаннотированые нашей аннотацией
    Усложнения:
        Аннотация становится мультитипной и теперь может инжектить случайный Double или String (указываем количество символов)

2) Рассчитана на ознакомление с классом BeanFactoryPostProcessor
Практика:
    Реализовать класс PropertyPlaceholder, который должен для всех бинов типа  Printer заменять значение поля message,
    используя класс PropertyRepository
Усложнения:
    1) Используем внешний проперти файл вместо PropertyRepository
    
3) Рассчитана на ознакомление с классом BeanPostProcessor и, непосредственно, методом postProcessAfterInitialization.
Практика:
Самостоятельно реализовать механизм логгирования через прокси, используя пример.
    Усложнение:
    1) Добавьте еще одну обертку, которая будет выводить "Начало транзации" и "Конец транзакции" для методов, которые
    аннотированы вашей кастомной аннотацией @Transactional. Проверьте, оборачиваются ли ваши объекты сразу в 2 реализации прокси
