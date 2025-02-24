package ru.seraleu.irisky.web.dto.pprb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class LoansObligationsOpen {
    private String caption;
    private String arrearsSum;
    private String paymentAmount;
    private String duration;
    private String outStandingBalance;
    private String arrearsBalance;
    private String openDate;
    private String value;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}