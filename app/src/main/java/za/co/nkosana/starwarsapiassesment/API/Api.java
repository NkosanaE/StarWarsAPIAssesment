

package za.co.nkosana.starwarsapiassesment.API;

import za.co.nkosana.starwarsapiassesment.JsonResult.ResultsList;;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL = "https://swapi.dev/api/";

    @GET
    Call<ResultsList> getAllResults(@Url String url);

}
