--liquibase formatted sql

--changeset ser_aleu_kris:7cb44142-e3fd-4a4b-8d72-e0d1ed70bffe runOnChange:true failOnError:true
--comment: Дефолтное значение
Insert into i_risky.epk_client (id,
                                epk_id,
                                phone_num,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (8l,85588L, 'k111029175380088', true, 'Снежный Константин Артемович',
        '{
  "taskID":"7663eb71-b6b6-4bdc-8ed9-620ad0ef5d66",
  "responseDate":"03.03.2024",
  "rating":{
    "score":267,
    "levels":[
      532,
      677,
      817,
      999
    ]
  },
  "factors":[
    {
      "factorInfluence":"16"
    },
    {
      "factorInfluence":"43"
    }, {
      "factorInfluence":"41"
    }
  ],
  "report":{
    "loansObligationsOpen":[
      {

        "caption":"ООО ОЗОН КРЕДИТЫ",
        "arrearsSum":"0,00 ₽",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"5 000 000,00 ₽",
        "arrearsBalance":"0,00 ₽",
        "openDate":"30.10.2019",
        "value":"7 000 000,00 ₽"
      },
      {

        "caption":"ООО ДЖЕНТЛЕНТ",
        "arrearsSum":"0,00 ₽",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"5 000 000,00 ₽",
        "arrearsBalance":"5 000 000,00 ₽",
        "openDate":"30.10.2024",
        "value":"7 000 000,00 ₽"
      }
    ],
    "loansObligationsClosed":[
      {

        "caption":"АО ТИНЬКОФФ БАНК",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"-",
        "arrearsBalance":"-",
        "openDate":"30.10.2019",
        "closeDate":"13.08.2021",
        "value":"1 000 000,00 ₽"
      },
      {

        "caption":"ПАО ТКБ БАНК",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"-",
        "arrearsBalance":"-",
        "openDate":"30.10.2019",
        "closeDate":"13.08.2021",
        "value":"15 000 000,00 ₽"
      },
      {

        "caption":"ПАО СОВКОМБАНК",
        "paymentAmount":"-",
        "duration":"13.08.2031",
        "outStandingBalance":"-",
        "arrearsBalance":"-",
        "openDate":"30.10.2019",
        "closeDate":"01.01.2020",
        "value":"5 000 000,00 ₽"
      }
    ],
    "collateralContractsOpen":[
      {

        "caption":"КОРНИЛОВ С. Ю.",
        "openDate":"30.10.2019",
        "closeDate":"30.10.2019",
        "value":"5 000,00 ₽"
      },
      {

        "caption":"СТАРАДУБЦЕВ Р. А.",
        "openDate":"30.10.2019",
        "closeDate":"30.10.2019",
        "value":"12 000,00 ₽"
      },
      {

        "caption":"ПАО СОВКОМБАНК",
        "openDate":"30.10.2019",
        "closeDate":"30.10.2019",
        "value":"44 000,00 ₽"
      }
    ],
    "collateralContractsClosed":[
      {

        "caption":"ПАО СБЕРБАНК",
        "openDate":"12.06.2021",
        "closeDate":"12.06.2021",
        "value":"10,00 ₽"
      },
      {
        "caption":"ПАО СБЕРБАНК",
        "openDate":"13.05.2021",
        "closeDate":"13.05.2021",
        "value":"15 000 000,00 ₽"
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
        "title":"ПАО СОВКОМБАНК",
        "date":"13.08.2021",
        "status":"-",
        "source":"ПАО СОВКОМБАНК",
        "value":"56 000,00 ₽",
        "commitment":"-"
      },
      {
        "title":"ПАО СБЕРБАНК",
        "date":"13.08.2021",
        "status":"-",
        "source":"ПАО СБЕРБАНК",
        "value":"7 000 000,00 ₽",
        "commitment":"-"
      },
      {
        "title":"ПАО СОВКОМБАНК",
        "date":"13.08.2021",
        "status":"-",
        "source":"ПАО СОВКОМБАНК",
        "value":"5 000 000,00 ₽",
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
        "value":"4 000 000,00 ₽",
        "commitment":"-"
      }
    ]
  }
}')
