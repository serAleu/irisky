--liquibase formatted sql

--changeset ser_aleu_kris:1cb81952-e3fd-4a5b-8d72-e9d1ed79bffe runOnChange:true failOnError:true
--comment: Плохая КИ
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (5l, 56666L, 'k111029295386855', true, 'Лазурная Виктория Ивановна',
        '{
  "taskID": "1463eb71-b1b6-1bdc-1ed9-620ad0ef5d11",
  "responseDate": "28.12.2024",
   "rating": {
    "score": 570,
    "levels": [
      570,
      793,
      874,
      999
    ]
  },
  "factors": [
    {
      "factorInfluence": "-90"
    }
  ],
  "report": {
    "loansObligationsOpen": [
      {
        "caption": "ПАО СОВКОМБАНК",
        "arrearsSum": "1 000 000,00 ₽",
        "paymentAmount": "-",
        "duration": "31.12.2027",
        "outStandingBalance": "2 000 000,00 ₽",
        "arrearsBalance": "1 000 000,00 ₽",
        "openDate": "01.01.2020",
        "value": "3 000 000,00 ₽"
      },
      {
        "caption": "ПАО ВТБ",
        "arrearsSum": "500 000,00 ₽",
        "paymentAmount": "-",
        "duration": "31.12.2026",
        "outStandingBalance": "1 500 000,00 ₽",
        "arrearsBalance": "500 000,00 ₽",
        "openDate": "01.06.2021",
        "value": "2 000 000,00 ₽"
      }
    ],
    "loansObligationsClosed": [
      {
        "caption": "ПАО ГАЗПРОМБАНК",
        "paymentAmount": "-",
        "duration": "31.12.2022",
        "outStandingBalance": "-",
        "arrearsBalance": "200 000,00 ₽",
        "openDate": "01.01.2019",
        "closeDate": "31.12.2022",
        "value": "500 000,00 ₽"
      }
    ],
    "collateralContractsOpen": [
      {
        "caption": "Квартира в центре города",
        "type": "Недвижимость",
        "openDate": "01.01.2020",
        "closeDate": "-",
        "value": "5 000 000,00 ₽"
      },
      {
        "caption": "Дом в пригороде",
        "type": "Недвижимость",
        "openDate": "01.06.2021",
        "closeDate": "-",
        "value": "3 000 000,00 ₽"
      },
      {
        "caption": "Автомобиль Mercedes-Benz",
        "type": "Движимое имущество",
        "openDate": "01.01.2020",
        "closeDate": "-",
        "value": "1 500 000,00 ₽"
      },
      {
        "caption": "Яхта",
        "type": "Движимое имущество",
        "openDate": "01.06.2021",
        "closeDate": "-",
        "value": "2 000 000,00 ₽"
      }
    ],
    "collateralContractsClosed": [],
    "statements": [
      {
        "title": "ПАО СОВКОМБАНК",
        "date": "01.01.2025",
        "status": "Отказано",
        "source": "ПАО СОВКОМБАНК",
        "value": "500 000,00 ₽",
        "commitment": "-"
      },
      {
        "title": "ПАО ВТБ",
        "date": "01.06.2024",
        "status": "Отказано",
        "source": "ПАО ВТБ",
        "value": "1 000 000,00 ₽",
        "commitment": "-"
      },
      {
        "title": "ПАО СБЕРБАНК",
        "date": "01.03.2024",
        "status": "Отказано",
        "source": "ПАО СБЕРБАНК",
        "value": "2 000 000,00 ₽",
        "commitment": "-"
      }
    ]
  }
}
')
