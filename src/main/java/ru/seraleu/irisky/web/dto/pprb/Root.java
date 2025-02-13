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
public class Root {
    private String taskID;
    private String responseDate;
    private Rating rating;
    private ArrayList<Factor> factors;
    private Report report;
}