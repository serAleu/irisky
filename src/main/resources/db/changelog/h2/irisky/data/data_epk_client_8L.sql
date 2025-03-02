--liquibase formatted sql

--changeset ser_aleu_kris:7cb44142-e3fd-4a4b-8d72-e0d1ed70bffe runOnChange:true failOnError:true
--comment: Дефолтное значение
Insert into i_risky.epk_client (id,
                                epk_id,
                                credit_history_identifier,
                                agreement_provided,
                                full_name,
                                report_credit_history)
values (8l,85588L, 'k111029175380088', true, 'Снежный Константин Артемович',
        '{
	"taskID": "7663eb71-b6b6-4bdc-8ed9-620ad0ef5d66",
	"responseDate": "03.03.2024",
	"rating": {
		"score": 267,
		"levels": [
			532,
			677,
			817,
			999
		]
	},
	"factors": [
		{
			"factorInfluence": "16"
		},
		{
			"factorInfluence": "43"
		},
		{
			"factorInfluence": "41"
		}
	],
	"report": {
		"loansObligationsOpen": [
			{
				"caption": "ООО ОЗОН КРЕДИТЫ",
				"arrearsSum": "0,00 ₽",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "5 000 000,00 ₽",
				"arrearsBalance": "1 000 000,00 ₽",
				"openDate": "30.10.2019",
				"value": "7 000 000,00 ₽"
			},
			{
				"caption": "ООО ДЖЕНТЛЕНТ",
				"arrearsSum": "0,00 ₽",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "5 000 000,00 ₽",
				"arrearsBalance": "5 000 000,00 ₽",
				"openDate": "30.10.2024",
				"value": "7 000 000,00 ₽"
			}
		],
		"loansObligationsClosed": [
			{
				"caption": "АО ТИНЬКОФФ БАНК",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "30.10.2019",
				"closeDate": "13.08.2021",
				"value": "1 000 000,00 ₽"
			},
			{
				"caption": "ПАО ТКБ БАНК",
				"paymentAmount": "-",
				"duration": "13.08.2031",
				"outStandingBalance": "-",
				"arrearsBalance": "-",
				"openDate": "30.10.2019",
				"closeDate": "13.08.2021",
				"value": "15 000 000,00 ₽"
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
		"collateralContractsClosed": [
			{
				"caption": "ПАО СБЕРБАНК",
				"openDate": "12.06.2021",
				"closeDate": "12.06.2021",
				"value": "10,00 ₽"
			},
			{
				"caption": "ПАО СБЕРБАНК",
				"openDate": "13.05.2021",
				"closeDate": "13.05.2021",
				"value": "15 000 000,00 ₽"
			}
		],
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
				"title": "ПАО СОВКОМБАНК",
				"date": "30.10.2024",
				"status": "Declined",
				"source": "ПАО СОВКОМБАНК",
				"value": "5 000 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ПАО АК БАРС БАНК",
				"date": "30.10.2024",
				"status": "Declined",
				"source": "ПАО АК БАРС БАНК",
				"value": "5 000 000,00 ₽",
				"commitment": "-"
			},
			{
				"title": "ПАО СБЕРБАНК",
				"date": "30.08.2024",
				"status": "Declined",
				"source": "ПАО СБЕРБАНК",
				"value": "5 000 000,00 ₽",
				"commitment": "-"
			}
		]
	}
}'
)
