[*]                    [*]                   [*]                    [*]                   [*]                    [*]
'####::::::::::::'########:::'####:::'######:::'##:::'##::'##:::'##::::'########::'########:::::'###:::::'##::::'##:
. ##::::::::::::::##.... ##::. ##:::'##... ##:::##::'##:::. ##:'##:::::... ##..::::##.....:::::'## ##:::::###::'###:
: ##::::::::::::::##:::: ##::: ##::::##:::..::::##:'##:::::. ####::::::::: ##::::::##:::::::::'##:. ##::::####'####:
: ##:::'#######:::########:::: ##:::. ######::::#####:::::::. ##:::::::::: ##::::::######::::'##:::. ##:::## ### ##:
: ##:::........:::##.. ##::::: ##::::..... ##:::##. ##::::::: ##:::::::::: ##::::::##...::::::#########:::##. #: ##:
: ##::::::::::::::##::. ##:::: ##:::'##::: ##:::##:. ##:::::: ##:::::::::: ##::::::##:::::::::##.... ##:::##:.:: ##:
'####:::::::::::::##:::. ##::'####::. ######::::##::. ##::::: ##:::::::::: ##::::::########:::##:::: ##:::##:::: ##:
....:::::::::::::..:::::..:::....::::......::::..::::..::::::..:::::::::::..::::::........:::..:::::..:::..:::::..::

1) Сапожников Сергей Алексеевич (Developer) - @ser_ser_ser / SAleSapozhnikov@sberbank.ru
2) Гагаев Александр Алексеевич (QA Java) - @gagaevich / aagagaev@sberbank.ru
3) Сираш Станислав Сергеевич (System Analyst) - @Stan_89 / sssirash@sberbank.ru
4) Костицына Кристина Ивановна (Developer) - @Kr_K_I / kikostitsyna@sberbank.ru


### For quick start just go here: [https//t.me/i-risky-bot]()


###### Инструкция к использованию i-risky-app ######

# здесь и далее разработанное нами решение будет называться [i-risky-system]
# i-risky-system включает в себя несколько программных элементов работающих в единой логической системе
# i-risky-system разработана вне контура банка, поэтому, демонстрационные программные элементы доступны только в публичной сети интернет


### i-risky-system включает в себя следующие программные элементы:

1) [Java Spring Service]
   [функциональность элемента]
     - эмуляция работы сервиса ППРБ в части предоставления кредитной истории клиента в формате JSON
     - эмуляция проверки валидности персональных данных в кредитной истории полученной в формате JSON от ППРБ
     - предоставление по HTTP в GigaAgentBuilder calculated variables, сохранение результатов работы агентов в БД, 
     - раскатка структуры и наполнение H2 Database + CRUD 
   [особенности реализации]
     - запускается на localhost в IDE или как Docker container
     - для взаимодействиями с ресурсами в сети использует url-port forwarding by https://tuna.am/
     - проверить что docker контейнер с сервисом запущен и i-risky-system готова к тестированию - HTTP GET [https://irisky-giga.nl.tuna.am/health-check]

2) [GigaAgentBuilder]
   [функциональность элемента]
      - интеграция с Telegram и настройку UI в боте
      - оркестрация шагов пользователя в процессе прохождения клиентского пути (HTTP GET/POST -> Java Spring Service, логирование этапов прохождения пути, вызов работы AI агентов)
   [особенности реализации]
      - пишет информацию о каждом пройденном шаге процесса в чат пользователю в формате ###LOGGER:*текущий шаг процесса*###" [ТОЛЬКО В РАМКАХ ДЕМО]
      - включает в себя 3 агента:
        1. credit-history-analyzer-agent - получает на вход JSON с кредитной историей клиента без персональных данных 
           на основании этого JSON генерирует описание кредитной истории клиента используя RAG + prompt
        2. credit-hist-analyze-validator-agent - получает на вход отчет, который сгенерировал credit-history-analyzer-agent, проверяет, что шаблон составлен корректно используя 
           RAG + prompt, если отчет составлен корректно, то этот агент отправляет отчет пользователю, если отчет составлен некорректно, то отправляет отчет на доработку обратно 
           в credit-history-analyzer-agent
        3. credit-hist-consultant - после получения клиентом проанализированной кредитной истории отвечает на вопросы клиента касательно данной кредитной истории и по запросу 
           пользователя дает советы по улучшению кредитной истории + так же предлагает услуги банка

3) [GenAI Gigachat Max]
   [функциональность элемента]
      - отвечает за результат работы всех AI агентов, а так же за выполнение всех прописанных инструкций для конфигурационных элементов в GigaAgentBuilder
   [особенности реализации]
      - непосредственно вызываемая Gigachat AI модель

4) [H2 Database] 
   [функциональность элемента]
      - хранение Mocks для эмуляции работы сервиса ППРБ - кредитные истории в формате JSON, персоналка, agreements
      - сохранение в БД этапов до/после вызова агентов
      - сохранение результатов работы агентов в отношении OneToMany / клиент к процессу анализа кредитной истории
   [особенности реализации]
      - аналог используемой в банке Pangolin (PostgreSQL)
      - переключение на использование PostgreSQL осуществляется сменой необходимого драйвера в настройках Java Spring Service
      - локальная база данных H2 раскатывается при поднятии Java Spring AI Service на localhost
      - что бы обратиться к БД поднятой в рамках демонстрации i-risky-system вам необходимо выполнить следующие действия:
        1. перейти по этой ссылке [https://irisky-giga.nl.tuna.am/h2-irisky/]
        2. в открывшемся интерфейсе нажать на [Connect]
        3. далее откроется Веб интерфейс H2 Database где вы можете выполнять SQL запросы и смотреть объекты БД аналогично как это организовано 
        в используемых в банке клиентах (dbeaver,pgAdmin и тп)
   
5) [RAG (Retrieval Augmented Generation)]
   [функциональность элемента]
      - обеспечение дополнительно необходимого контекста для работы агентов credit-hist-analyze-validator-agent и credit-hist-analyze-validator-agent
   [особенности реализации]
      - в данном .pdf файле описаны предназначение, смысл, возможные и пограничные значения необходимых JSON полей для составления описания кредитной истории и валидации составленного 
      описания кредитной истории клиента агентами.

6) [TelegramBot]
   [функциональность элемента]
      - адрес по которому можно использовать демонстрационный функционал бота: [https//t.me/i-risky-bot]()
      - основная задача бота - эмуляция работы СБОЛа
      - работает в качестве UI для взаимодействия пользователя с i-risky-system
   [особенности реализации]
      - бот создан, настроен и оформлен через стандартный функционал предоставляемый Telegram, а именно - @BotFather
      - слушает входящие сообщения, фиксирует нажатия кнопка и отвечает за генерацию ответа в чате бота программный элемент - GigaAgentBuilder

   
### Как использовать наше решение:

1) Зайти в Telegram
2) Найти чат бота: @i_risky_bot
3) Нажать на кнопку [Старт] или ввести команду [/start]
4) Бот предоставляет button list, где каждая кнопка - это ФИО клиента получение кредитной истории которого мы можем сэмулировать в рамках данного запуска. 
Каждый клиент имеет свое значение скорбалла и свои уникальные особенности в кредитной истории. Список возможных клиентов с кратким описанием их кредитной истории приложен в
конце данной инструкции.
5) Выбрать клиента из предоставленного списка и нажать на кнопку с его ФИО. После этого в чат выведется следующее сообщение 
[Вы приобрели отчет кредитной истории от ОКБ. Хотите проанализировать его с помощью нашего ИИ-помощника?], а ниже появится кнопка [Получить анализ отчета от ИИ-помощника]

   [
   Note: если в этот момент (до нажатия кнопки "Получить анализ отчета от ИИ-помощника") зайти посмотреть в логи сервиса или выполнить запрос в БД, мы увидим, что 
   произошла эмуляция проверки кредитной истории на предмет подтягивания некорректных данных в КИ клиента см. i_risky.credit_hist_processing_agent.pi_is_valid is true
   ]

6) Необходимо нажать на эту кнопку, далее в чат начнут поступать сообщения в формате [###LOGGER:*текущий шаг процесса*###] - это системный лог, который 
выводится пользователю только в рамках демо чтобы наблюдатель понимал какой шаг процесса сейчас выполняется
7) Далее в чат поступит проанализированная и провалидированная кредитная история в формате текстового описания, и появится кнопка [I-RISKY-SYSTEM stop process].
8) До момента пока пользователь не нажмет на эту кнопку, бот будет ожидать вопросов пользователя. Как только кнопка будет нажата, процесс завершит свою работу
и перейдет на Шаг 3 данного руководства. 
9) С этого момента можно задавать вопросы боту в чате касательно полученной кредитной истории, просить бота дать советы по улучшению и т.к. после того, как бот 
ответит на все ваши вопросы, вам необходимо нажать на кнопку [I-RISKY-SYSTEM stop process].


### Как запустить i-risky-app на своей локальной машине

   [
   Note: начиная с 03.02.2025-00:00 по 05.02.2025-18:00 сервис i-risky-app будет запущен для обеспечения работоспособности i-risky-system. 
   Это значит, что URLs по которым к i-risky-app обращается GigaAgentBuilder + GenAI Gigachat и H2Database будут уже заняты демонстрационным
   контейнером. Если вы хотите поднять i-risky-app service локально, просьба написать в тг одному из участников команды (контакты даны выше)
   ]

# Если у вас есть установленный docker:

выполнить: docker pull seraleu/i-risky-app:latest
выполнить: docker run -p -d 127.0.0.1:3838:3838 seraleu/i-risky-app --rm

# Если у вас на рабочей машине установлена любая IDE и/или установлены GIT и Maven:

1) git clone https://github.com/serAleu/irisky.git
2) mvn clean install
3) java -jar i-risky-app.jar

Запущенный на локальной машине сервис работает, но не предоставляет возможности взаимодействовать с публичными ресурсами в сети.

ссылка на h2: https://irisky-giga.nl.tuna.am/h2-irisky/


### Список тестовых клиентов
Новиков Михаил Андреевич
Никитина Дарья Антоновна
Лукаш Андрей Владимирович
Иванько Михаил Витальевич
Лазурная Виктория Ивановна
Грабко Антонина Владимировна
Почеп Анастасия Олеговна
Снежный Константин Артемович
Киркоров Антон Магамедович