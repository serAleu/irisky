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
public class Rating {
    private int score;
    private String title;
    private String caption;
    private String icon;
    private List<Integer> levels;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}