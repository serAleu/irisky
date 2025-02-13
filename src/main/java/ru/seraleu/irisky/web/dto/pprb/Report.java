package ru.seraleu.irisky.web.dto.pprb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
public class Report {
    private ArrayList<LoansObligationsOpen> loansObligationsOpen;
    private ArrayList<LoansObligationsClosed> loansObligationsClosed;
    private ArrayList<CollateralContractsOpen> collateralContractsOpen;
    private ArrayList<CollateralContractsClosed> collateralContractsClosed;
    private ArrayList<Statement> statements;
}
