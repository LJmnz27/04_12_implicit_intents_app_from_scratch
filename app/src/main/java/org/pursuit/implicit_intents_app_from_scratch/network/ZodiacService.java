package org.pursuit.implicit_intents_app_from_scratch.network;

import org.pursuit.implicit_intents_app_from_scratch.models.ZodiacWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacService {

    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacWrapper> getZodiacs();
}
