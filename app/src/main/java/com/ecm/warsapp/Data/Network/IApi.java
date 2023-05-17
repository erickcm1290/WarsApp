package com.ecm.warsapp.Data.Network;

import com.ecm.warsapp.Data.Models.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface IApi {

    @GET("all.json")
    Call<List<Models.Personaje>> getPersonajes();
}