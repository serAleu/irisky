--liquibase formatted sql

--changeset ser_aleu_kris:2cb85145-e3fr-4a4b-8d72-e0d1ed70bffe runOnChange:true failOnError:true
--comment: Задвоение в loansObligationsOpen и loansObligationsClosed
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (7l,7777L, 'k111029165389677', true, 'Почеп Анастасия Олеговна',
        '{
  "taskID":"5563eb71-b6b6-4bdc-8ed9-620ad0ef5d05",
  "responseDate":"22.05.2024",
  "rating":{
    "score":906,
    "levels":[
      570,
      793,
      874,
      999
    ]
  },
  "factors":[
    {
      "factorInfluence":"59"
    },
    {
      "factorInfluence":"41"
    }
  ],
  "report":{
    "loansObligationsOpen":[
      {

        "caption":"ПАО СБЕРБАНК",
        "arrearsSum":"5 000 000,00 ₽",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"5 000 000,00 ₽",
        "arrearsBalance":"5 000 000,00 ₽",
        "openDate":"30.10.2019",
        "value":"7 000 000,00 ₽"
      }
    ],
    "loansObligationsClosed":[
      {
        "caption":"ПАО СБЕРБАНК",
        "arrearsSum":"5 000 000,00 ₽",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"5 000 000,00 ₽",
        "arrearsBalance":"5 000 000,00 ₽",
        "openDate":"30.10.2019",
        "value":"7 000 000,00 ₽"
      },{
        "caption":"ПАО СОВКОМБАНК",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"-",
        "arrearsBalance":"-",
        "openDate":"30.10.2019",
        "closeDate":"13.08.2021",
        "value":"5 000 000,00 ₽"
      },
      {

        "caption":"ИП ВОЛК",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"-",
        "arrearsBalance":"-",
        "openDate":"30.10.2019",
        "closeDate":"13.08.2021",
        "value":"5 000 000,00 ₽"
      }
    ],
    "collateralContractsOpen":[
    ],
    "collateralContractsClosed":[
      {

        "caption":"ПАО СОВКОМБАНК",
        "openDate":"12.06.2021",
        "closeDate":"12.06.2021",
        "value":"10 000,00 ₽"
      },
      {
        "caption":"ПАО СОВКОМБАНК",
        "openDate":"13.05.2021",
        "closeDate":"13.05.2021",
        "value":"5 000 000,00 ₽"
      }
    ],
    "statements":[
      {
        "title":"ПАО СОВКОМБАНК",
        "date":"13.08.2021",
        "status":"-",
        "source":"ПАО СОВКОМБАНК",
        "value":"7 000 000,00 ₽",
        "commitment":"-"
      },
      {
        "title":"КОРНИЛОВ С. Ю.",
        "date":"13.08.2021",
        "status":"-",
        "source":"КОРНИЛОВ С. Ю.",
        "value":"5 000 000,00 ₽",
        "commitment":"-"
      },
      {
        "title":"СТАРАДУБЦЕВ Р. А.",
        "date":"13.08.2021",
        "status":"-",
        "source":"СТАРАДУБЦЕВ Р. А.",
        "value":"5 000 000,00 ₽",
        "commitment":"-"
      }
    ]
  }
}')
