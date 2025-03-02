--liquibase formatted sql

--changeset ser_aleu_kris:1cb80412-e3fd-4a4b-8d72-e9d1ed79bffe runOnChange:true failOnError:true
--comment: Хорошая КИ
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (3l, 3456L, 'k111029643389411', true, 'Лукаш Андрей Владимирович',
        '{
  "taskID": "2363eb71-b3b6-4bdc-8ed9-690ad0ef5d07",
  "responseDate": "19.09.2024",
  "rating": {
    "score": 899,
    "levels": [
      570,
      793,
      874,
      999
    ]
  },
  "factors": [
    {
      "factorInfluence": "60"
    },
    {
      "factorInfluence": "40"
    }
  ],
  "report": {
    "loansObligationsOpen": [
      {
        "caption": "Сбербанк",
        "arrearsSum": "0,00 ₽",
        "paymentAmount": "15 000,00 ₽",
        "duration": "01.01.2028",
        "outStandingBalance": "400 000,00 ₽",
        "arrearsBalance": "0,00 ₽",
        "openDate": "01.01.2022",
        "value": "600 000,00 ₽"
      },
      {
        "caption": "ВТБ",
        "arrearsSum": "0,00 ₽",
        "paymentAmount": "8 000,00 ₽",
        "duration": "01.01.2027",
        "outStandingBalance": "200 000,00 ₽",
        "arrearsBalance": "0,00 ₽",
        "openDate": "01.06.2023",
        "value": "300 000,00 ₽"
      }
    ],
    "loansObligationsClosed": [
      {
        "caption": "Альфа-Банк",
        "paymentAmount": "10 000,00 ₽",
        "duration": "01.01.2025",
        "outStandingBalance": "-",
        "arrearsBalance": "-",
        "openDate": "01.01.2020",
        "closeDate": "01.01.2022",
        "value": "200 000,00 ₽"
      },
      {
        "caption": "Газпромбанк",
        "paymentAmount": "8 000,00 ₽",
        "duration": "01.01.2024",
        "outStandingBalance": "-",
        "arrearsBalance": "-",
        "openDate": "01.06.2020",
        "closeDate": "01.06.2022",
        "value": "150 000,00 ₽"
      }
    ],
    "collateralContractsOpen": [],
    "collateralContractsClosed": [
      {
        "caption": "Сбербанк",
        "openDate": "01.01.2020",
        "closeDate": "01.01.2022",
        "value": "100 000,00 ₽"
      }
    ],
    "statements": [
      {
        "title": "Сбербанк",
        "date": "01.01.2022",
        "status": "Одобрено",
        "source": "Сбербанк",
        "value": "600 000,00 ₽",
        "commitment": "15 000,00 ₽"
      },
      {
        "title": "ВТБ",
        "date": "01.06.2023",
        "status": "Одобрено",
        "source": "ВТБ",
        "value": "300 000,00 ₽",
        "commitment": "8 000,00 ₽"
      }
    ]
  }
}

')
