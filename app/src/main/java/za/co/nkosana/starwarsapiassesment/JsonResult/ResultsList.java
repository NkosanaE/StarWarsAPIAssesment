
package za.co.nkosana.starwarsapiassesment.JsonResult;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResultsList {

    @SerializedName("results")
   private List<People> results;

    public List<People> getResults() {
        return results;
    }

}
