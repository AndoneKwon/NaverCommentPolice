package com.followme.search.web.dto;

import com.followme.search.domain.Search;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SearchResponseDto {

    private String comment;
    private String comment_date;
    private float score;
}
