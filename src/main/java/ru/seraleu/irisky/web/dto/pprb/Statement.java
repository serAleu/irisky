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
public class Statement {
    private String title;
    private String iconId;
    private String date;
    private String status;
    private String source;
    private String value;
    private String commitment;
    private String bankIcon;
    private String bankName;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
