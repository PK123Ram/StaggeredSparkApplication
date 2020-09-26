package com.example.staggeredsparkapplication.dataaccesslayer.response;

import java.util.List;

public class Result {
    private List<Root> results;

    public Result(List<Root> results) {
        this.results = results;
    }

    public Result() {
    }

    public List<Root> getResults() {
        return results;
    }

    public void setResults(List<Root> results) {
        this.results = results;
    }
}
