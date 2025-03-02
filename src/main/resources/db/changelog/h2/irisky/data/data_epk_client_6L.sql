--liquibase formatted sql

--changeset ser_aleu_kris:7cb10142-e3fd-4a4b-8d71-e0d1ed70bffw runOnChange:true failOnError:true
--comment: КИ с ошибочными идентичными повторяющимися записями
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (6l, 6666L, 'k111029335389066', true, 'Грабко Антонина Владимировна',
        '{
	"taskID": "7443eb71-b6b6-4bdc-8ed9-620ad0ef5d44",
	"responseDate": "25.01.2025",
	"rating": {
		"score": 894,
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
				"caption": "АО АК БАРС БАНК",
				"arrearsSum": "5 000 000,00 ₽",
				"paymentAmount": "-",
				"duration": "13.08.2028",
				"outStandingBalance": "0,00 ₽",
				"arrearsBalance": "5 000 000,00 ₽",
				"openDate": "30.10.2019",
				"value": "7 000 000,00 ₽"
			},
			{
				"caption": "АО АК БАРС БАНК",
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
				"caption": "ПАО СОВКОМБАНК",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "30.10.2019",
				"closeDate": "13.08.2021",
				"value": "5 000 000,00 ₽"
			},
			{
				"caption": "ПАО СОВКОМБАНК",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "30.10.2019",
				"closeDate": "13.08.2021",
				"value": "5 000 000,00 ₽"
			}
		],
		"collateralContractsOpen": [],
		"collateralContractsClosed": [
			{
				"caption": "ПАО СОВКОМБАНК",
				"openDate": "12.06.2021",
				"closeDate": "12.06.2021",
				"value": "10,00 ₽"
			},
			{
				"caption": "ПАО СОВКОМБАНК",
				"openDate": "12.06.2021",
				"closeDate": "12.06.2021",
				"value": "10,00 ₽"
			}
		],
		"statements": [
			{
				"title": "ПАО СОВКОМБАНК",
				"date": "13.08.2021",
				"status": "Одобрено",
				"source": "ПАО СОВКОМБАНК",
				"value": "7 000 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ПАО СОВКОМБАНК",
				"date": "13.08.2021",
				"status": "Одобрено",
				"source": "ПАО СОВКОМБАНК",
				"value": "7 000 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ПАО СОВКОМБАНК",
				"date": "13.08.2021",
				"status": "Одобрено",
				"source": "ПАО СОВКОМБАНК",
				"value": "7 000 000,00 ₽",
				"commitment": "-"
			}
		]
	}
}'
)
