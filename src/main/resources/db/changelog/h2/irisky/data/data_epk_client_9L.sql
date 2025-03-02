--liquibase formatted sql

--changeset ser_aleu_kris:7cb80142-e6fd-6a4b-8d72-e0d1ed70bffe runOnChange:true failOnError:true
--comment: Дефолтное значение
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (9l,9999l, 'k11102915530099', true, 'Киркоров Антон Магамедович',
        '{
	"taskID": "4363eb71-b6b6-4bdc-8ed4-620ad0ef5d04",
	"responseDate": "21.01.2025",
	"rating": {
		"score": 765,
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
				"caption": "ПАО СБЕРБАНК",
				"arrearsSum": "0,00 ₽",
				"paymentAmount": "55 000,00 ₽",
				"duration": "13.08.2031",
				"outStandingBalance": "0,00 ₽",
				"arrearsBalance": "0,00 ₽",
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
			},
			{
				"caption": "ПАО СОВКОМБАНК",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "30.10.2019",
				"closeDate": "01.01.2020",
				"value": "5 000 000,00 ₽"
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
				"caption": "АО АК БАРС БАНК",
				"date": "14.08.2024"
			},
			{
				"caption": "ООО БЫСТРОДЕНЬГИ",
				"date": "12.08.2024"
			},
			{
				"caption": "ООО ДЕНЬГИ МИГОМ",
				"date": "12.08.2024"
			},
			{
				"caption": "АО БАНК ИМПЕРИАЛ",
				"date": "01.08.2024"
			},
			{
				"caption": "ОАО БАНК ЗАРЕЧЬЕ",
				"date": "15.07.2024"
			},
			{
				"caption": "ООО ЗАЙМИ-КУПИ",
				"date": "10.03.2024"
			},
			{
				"caption": "ООО ДЕНЬГИ СРАЗУ",
				"date": "20.12.2023"
			}
		],
		"statements": [
			{
				"title": "ООО БЫСТРОДЕНЬГИ",
				"date": "30.10.2024",
				"status": "Approved",
				"source": "ООО БЫСТРОДЕНЬГИ",
				"value": "30 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ООО ЗАЙМИ-КУПИ",
				"date": "30.10.2024",
				"status": "Approved",
				"source": "ООО ЗАЙМИ-КУПИ",
				"value": "30 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ООО ДЕНЬГИ СРАЗУ",
				"date": "30.10.2024",
				"status": "Declined",
				"source": "ООО ДЕНЬГИ СРАЗУ",
				"value": "30 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ООО ДЕНЬГИ МИГОМ",
				"date": "30.10.2024",
				"status": "Declined",
				"source": "ООО ДЕНЬГИ МИГОМ",
				"value": "30 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ООО ЗАЕМ.РУ",
				"date": "30.10.2024",
				"status": "Approved",
				"source": "ООО ЗАЕМ.РУ",
				"value": "30 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ООО ЗАЙМЕР",
				"date": "30.10.2024",
				"status": "Declined",
				"source": "ООО ЗАЙМЕР",
				"value": "5 000 000,00 ₽",
				"commitment": "-"
			}
		]
	}
}'
)
