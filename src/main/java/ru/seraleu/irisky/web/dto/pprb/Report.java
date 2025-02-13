package ru.seraleu.irisky.web.dto.pprb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
public class Report {
    private List<LoansObligationsOpen> loansObligationsOpen;
    private List<LoansObligationsClosed> loansObligationsClosed;
    private List<CollateralContractsOpen> collateralContractsOpen;
    private List<CollateralContractsClosed> collateralContractsClosed;
    private List<Statement> statements;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
