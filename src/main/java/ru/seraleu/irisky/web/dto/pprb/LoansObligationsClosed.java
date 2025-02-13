package ru.seraleu.irisky.web.dto.pprb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
public class LoansObligationsClosed {
    private String title;
    private String caption;
    private String iconId;
    private String style;
    private String paymentAmount;
    private String duration;
    private String outStandingBalance;
    private String arrearsBalance;
    private String openDate;
    private String closeDate;
    private String value;
    private String bankIcon;
    private String bankName;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}