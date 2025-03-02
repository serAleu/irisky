--liquibase formatted sql

--changeset ser_aleu_kris:1cb84952-e3fd-4a5b-8d72-e9d1ed79bffe runOnChange:true failOnError:true
--comment: Отличная КИ
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (4l, 5678L, 'k111029995386533', true, 'Иванько Михаил Витальевич',
        '{
	"taskID": "7463eb71-b5b6-4bdc-8ed9-620ad0ef5d33",
	"responseDate": "08.11.2024",
	"rating": {
		"score": 999,
		"levels": [
			570,
			793,
			874,
			999
		]
	},
	"factors": [
		{
			"factorInfluence": "100"
		}
	],
	"report": {
		"loansObligationsOpen": [
			{
				"caption": "ПАО СБЕРБАНК",
				"arrearsSum": "0,00 ₽",
				"paymentAmount": "10 000,00 ₽",
				"duration": "31.12.2027",
				"outStandingBalance": "0,00 ₽",
				"arrearsBalance": "0,00 ₽",
				"openDate": "01.01.2022",
				"value": "1 000 000,00 ₽"
			}
		],
		"loansObligationsClosed": [
			{
				"caption": "ПАО ВТБ",
				"paymentAmount": "10 000,00 ₽",
				"duration": "31.12.2022",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "01.01.2020",
				"closeDate": "31.12.2022",
				"value": "500 000,00 ₽"
			},
			{
				"caption": "ПАО ГАЗПРОМБАНК",
				"paymentAmount": "5 000,00 ₽",
				"duration": "31.12.2021",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "01.01.2019",
				"closeDate": "31.12.2021",
				"value": "200 000,00 ₽"
			}
		],
		"collateralContractsOpen": [],
		"collateralContractsClosed": [],
		"requests": [
			{
				"caption": "ПАО СБЕРБАНК",
				"date": "07.12.2024"
			},
			{
				"caption": "АО АЛЬФА-БАНК",
				"date": "15.08.2024"
			},
			{
				"caption": "ФК ОТКРЫТИЕ ПАО БАНК",
				"date": "15.08.2024"
			}
		],
		"statements": [
			{
				"title": "ПАО СБЕРБАНК",
				"date": "01.01.2025",
				"status": "Одобрено",
				"source": "ПАО СБЕРБАНК",
				"value": "1 000 000,00 ₽",
				"commitment": "Подписан кредитный договор"
			},
			{
				"title": "ПАО ВТБ",
				"date": "01.01.2020",
				"status": "Одобрено",
				"source": "ПАО ВТБ",
				"value": "500 000,00 ₽",
				"commitment": "Подписан кредитный договор"
			}
		]
	}
}'
)
