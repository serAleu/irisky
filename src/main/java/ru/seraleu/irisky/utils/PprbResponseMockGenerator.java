package ru.seraleu.irisky.utils;

import org.springframework.stereotype.Component;
import ru.seraleu.irisky.web.dto.pprb.*;

import java.util.Arrays;

@Component
public class PprbResponseMockGenerator {

    public Root getRandomPprbResponseMosk(String phoneNumber) {
        return new Root();
//                .setTaskID("7363eb71-b6b6-4bdc-8ed9-620ad0ef5d07");
//                .setResponseDate("21.01.2025");
//                .setRating(new Rating()
//                        .setScore(906)
//                       // .setTitle("Title")
//                       // .setCaption("Caption")
//                       // .setIcon("Icon")
//                        .setLevels(Arrays.asList(570, 793, 874, 999)))
//                .setFactors(Arrays.asList(
////                        new Factor().setFactorInfluence("59").setFactorDescription("FactorDescription59"),
////                        new Factor().setFactorInfluence("41").setFactorDescription("FactorDescription41")))
//                .setReport(new Report()
//                        .setLoansObligationsOpen(Arrays.asList(
//                                new LoansObligationsOpen()
//                                      //  .setTitle("Title1")
//                                        .setCaption("ПАО Колхозбанк")
//                                       // .setStyle("SuperStar")
//                                       // .setWarning("Pay Attention")
//                                       // .setWarningIconId("ght-7567j-dd-w2")
//                                       // .setWarningValue("5 000 000,00 ₽")
//                                        .setArrearsSum("5 000 000,00 ₽")
//                                        .setPaymentAmount("5 000 000,00 ₽")
//                                        .setDuration("13.08.2031")
//                                        .setOutStandingBalance("5 000 000,00 ₽")
//                                        .setArrearsBalance("5 000 000,00 ₽")
//                                        .setOpenDate("30.10.2019")
//                                        .setValue("7 000 000,00 ₽"),
//                                       //.setBankIcon("BankIcon")
//                                        //.setBankName("BankName"),
//                                new LoansObligationsOpen()
//                                      //  .setTitle("Title2")
//                                        .setCaption("ПАО Завхозбанк")
//                                       // .setStyle("PuperStar")
//                                        //.setWarning("Pay for it")
//                                       // .setWarningIconId("ght-7567j-dd-w3")
//                                      //  .setWarningValue("6 000 000,00 ₽")
//                                        .setArrearsSum("4 000 000,00 ₽")
//                                        .setPaymentAmount("7 000 000,00 ₽")
//                                        .setDuration("13.01.2031")
//                                        .setOutStandingBalance("3 000 000,00 ₽")
//                                        .setArrearsBalance("8 000 000,00 ₽")
//                                        .setOpenDate("30.11.2019")
//                                        .setValue("2 000 000,00 ₽")))
//                                      //  .setBankIcon("BankIcon1")
//                                       // .setBankName("BankName1")))
//                        .setLoansObligationsClosed(Arrays.asList(
//                                new LoansObligationsClosed()
//                                        .setTitle("ClosedTitle1")
//                                        .setCaption("ПАО Колхозбанк")
//                                       // .setIconId("ICCConId1")
//                                       // .setStyle("SuperStar")
//                                        .setPaymentAmount("5 000 000,00 ₽")
//                                        .setDuration("13.08.2031")
//                                        .setOutStandingBalance("5 000 000,00 ₽")
//                                        .setArrearsBalance("5 000 000,00 ₽")
//                                        .setOpenDate("30.10.2019")
//                                        .setCloseDate("13.02.2025"),
//                                        //.setValue("7 000 000,00 ₽")
//                                       // .setBankIcon("BankIcon")
//                                       // .setBankName("BankName"),
//                                new LoansObligationsClosed()
//                                        .setTitle("ClosedTitle2")
//                                        .setCaption("ПАО Колхозбанк")
//                                       // .setIconId("ICCConId2")
//                                       // .setStyle("PuperStar")
//                                        .setPaymentAmount("5 000 000,00 ₽")
//                                        .setDuration("13.08.2031")
//                                        .setOutStandingBalance("5 000 000,00 ₽")
//                                        .setArrearsBalance("5 000 000,00 ₽")
//                                        .setOpenDate("30.10.2019")
//                                        .setCloseDate("13.02.2024")))
//                                        //.setValue("7 000 000,00 ₽")
//                                        //.setBankIcon("BankIcon")
//                                        //.setBankName("BankName")))
//                        .setCollateralContractsOpen(Arrays.asList(
//                                new CollateralContractsOpen()
//                                        .setTitle("OpenTitle1")
//                                      //  .setIconId("JustIconId1")
//                                        .setCaption("КОРНИЛОВ С. Ю.")
//                                        .setOpenDate("30.10.2019")
//                                        .setCloseDate("13.02.2024")
//                                        .setValue("7 000 000,00 ₽"),
//                                      //  .setBankIcon("BankIcon")
//                                      //  .setBankName("BankName"),
//                                new CollateralContractsOpen()
//                                        .setTitle("OpenTitle2")
//                                       // .setIconId("JustIconId2")
//                                        .setCaption("ЧЕРНИЛОВ С. Ю.")
//                                        .setOpenDate("31.10.2019")
//                                        .setCloseDate("23.02.2024")
//                                        .setValue("3 000 000,00 ₽")))
//                                       // .setBankIcon("BankIconJ")
//                                       // .setBankName("BankNameJ")))
//                        .setCollateralContractsClosed(Arrays.asList(
//                                new CollateralContractsClosed()
//                                        .setTitle("ClosedTitle1")
//                                       // .setIconId("ClosedIconId1")
//                                        .setCaption("КОРНИЛОВ С. Ю.")
//                                        .setOpenDate("11.10.2019")
//                                        .setCloseDate("03.02.2024")
//                                        .setValue("9 000 000,00 ₽"),
//                                       // .setBankIcon("BankIconС")
//                                       // .setBankName("BankNameС"),
//                                new CollateralContractsClosed()
//                                        .setTitle("ClosedTitle2")
//                                        //.setIconId("ClosedIconId2")
//                                        .setCaption("ЧЕРНИЛОВ С. Ю.")
//                                        .setOpenDate("01.10.2019")
//                                        .setCloseDate("23.12.2024")
//                                        .setValue("8 000 000,00 ₽")))
//                                        //.setBankIcon("BankIconT")
//                                        //.setBankName("BankNameT")))
//                        .setStatements(Arrays.asList(
//                                new Statement()
//                                        .setTitle("StatementTitle1")
//                                       // .setIconId("StatementIcon1")
//                                        .setDate("24.02.2014")
//                                        .setStatus("SUCCESS")
//                                        .setSource("КОРНИЛОВ С. Ю.")
//                                        .setCommitment("-")
//                                        .setValue("2 000 000,00 ₽"),
//                                      //  .setBankIcon("StatementIcon1")
//                                      //  .setBankName("StatementName2"),
//                                new Statement()
//                                        .setTitle("StatementTitle2")
//                                       // .setIconId("StatementIcon2")
//                                        .setDate("24.05.2014")
//                                        .setStatus("FAILURE")
//                                        .setSource("ПАО Завхозбанк")
//                                        .setCommitment("-")
//                                        .setValue("1 000 000,00 ₽")
//                                       //.setBankIcon("StatementIcon3")
//                                      //  .setBankName("StatementName4")
//                        )));
    }

    public String getBadRequestMessage() {
        return "{\"message\": \"Request doesn't have phoneNumber field\"}";
    }
}
