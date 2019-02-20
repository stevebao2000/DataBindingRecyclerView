package com.steve.databindingrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntryService {
    @GET("/users")
    Call<List<Entry>> getGithubEntries();
}
