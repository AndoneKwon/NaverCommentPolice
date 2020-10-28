package com.followme.search.domain;

import lombok.Builder;

public class FullQuery {
    private int from;
    private int size=50;
    private String[] _source;
    private Object query;



    public FullQuery(Object query_string){
        this.from = 0;
        this.query=new Query(query_string);
    }

    public FullQuery(int from, Object query_string){
        this.from = from;
        this.query=new Query(query_string);
    }
}
