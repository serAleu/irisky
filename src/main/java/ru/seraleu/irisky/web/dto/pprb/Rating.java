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
public class Rating {
    private int score;
    private String title;
    private String caption;
    private String icon;
    private ArrayList<Integer> levels;
}