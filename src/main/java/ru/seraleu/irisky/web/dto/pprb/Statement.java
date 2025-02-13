package ru.seraleu.irisky.web.dto.pprb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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
}
