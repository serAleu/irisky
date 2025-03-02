--liquibase formatted sql

--changeset ser_aleu_kris:1cb80942-e3fd-4a4b-8d72-e9d1ed79bffe runOnChange:true failOnError:true
--comment: Плохая КИ
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (2l, 1234L, 'k111029145389499', true, 'Никитина Дарья Антоновна',
        '{
  "taskID": "7363eb71-b6b6-4bdc-8ed9-620ad0ef5d07",
  "responseDate": "21.01.2025",
  "rating": {
    "score": 300,
    "levels": [
      200,
      300,
      400,
      500
    ]
  },
  "factors": [
    {
      "factorInfluence": "70"
    },
    {
      "factorInfluence": "30"
    }
  ],
  "report": {
    "loansObligationsOpen": [
      {
        "caption": "ПАО СОВКОМБАНК",
        "arrearsSum": "1500000,00 ₽",
        "paymentAmount": "-",
        "duration": "13.08.2031",
        "outStandingBalance": "10000000,00 ₽",
        "arrearsBalance": "1500000,00 ₽",
        "openDate": "30.10.2019",
        "value": "12000000,00 ₽"
      },
      {
        "caption": "ПАО Сбербанк",
        "arrearsSum": "3000000,00 ₽",
        "paymentAmount": "-",
        "duration": "15.03.2028",
        "outStandingBalance": "7000000,00 ₽",
        "arrearsBalance": "3000000,00 ₽",
        "openDate": "01.05.2020",
        "value": "10000000,00 ₽"
      },
	    {
        "caption": "ПАО ВТБ",
        "arrearsSum": "750000,00 ₽",
        "paymentAmount": "-",
        "duration": "28.02.2026",
        "outStandingBalance": "2500000,00 ₽",
        "arrearsBalance": "750000,00 ₽",
        "openDate": "10.11.2022",
        "value": "3000000,00 ₽"
      }
    ],
    "loansObligationsClosed": [],
    "collateralContractsOpen": [],
    "collateralContractsClosed": [],
    "statements": []
  }
}

')
