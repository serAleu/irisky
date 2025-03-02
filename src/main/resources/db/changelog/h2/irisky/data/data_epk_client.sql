--liquibase formatted sql

--changeset ser_aleu_kris:7cb80142-e3fd-4a4b-8d72-e0d1ed70bffe runOnChange:true failOnError:true
--comment: Дефолтное значение
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (1l,55555L, 'k111029165389685', true, 'Новиков Михаил Андреевич',
        '{
	"taskID": "7363eb71-b6b6-4bdc-8ed9-620ad0ef5d07",
	"responseDate": "21.01.2025",
	"rating": {
		"score": 925,
		"levels": [
			570,
			793,
			874,
			999
		]
	},
	"factors": [
		{
			"factorInfluence": "59"
		},
		{
			"factorInfluence": "41"
		}
	],
	"report": {
		"loansObligationsOpen": [
			{
				"caption": "ПАО СОВКОМБАНК",
				"arrearsSum": "5 000 000,00 ₽",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "0,00 ₽",
				"arrearsBalance": "5 000 000,00 ₽",
				"openDate": "30.10.2019",
				"value": "7 000 000,00 ₽"
			}
		],
		"loansObligationsClosed": [
			{
				"caption": "ПАО СБЕРБАНК",
				"paymentAmount": "-",
				"duration": "13.08.2022",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "30.10.2019",
				"closeDate": "15.08.2021",
				"value": "3 000 000,00 ₽"
			},
			{
				"caption": "АО АК БАРС БАНК",
				"paymentAmount": "-",
				"duration": "10.05.2018",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "30.10.2015",
				"closeDate": "10.05.2018",
				"value": "1 800 000,00 ₽"
			}
		],
		"collateralContractsOpen": [
			{
				"caption": "ПАО СОВКОМБАНК",
				"openDate": "30.10.2019",
				"closeDate": "13.08.2031",
				"value": "5 000 000,00 ₽"
			}
		],
		"collateralContractsClosed": [],
		"statements": [
			{
				"title": "ПАО СОВКОМБАНК",
				"date": "30.10.2019",
				"status": "Approved",
				"source": "ПАО СОВКОМБАНК",
				"value": "5 000 000,00 ₽",
				"commitment": "-"
			}
		]
	}
}'
)
