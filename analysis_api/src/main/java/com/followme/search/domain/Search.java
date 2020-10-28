package com.followme.search.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Search {
    private String comments;
    private String comment_date;

    public Search(String comments,String comment_date){
        this.comments=comments;
        this.comment_date=comment_date;
    }

    public Search() {

    }
}
