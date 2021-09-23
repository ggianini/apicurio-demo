package org.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.example.api.beans.Activities;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/history")
public interface HistoryResource {
  /**
   * The User Activity endpoint returns data about a user's lifetime activity with Uber. The response will include pickup locations and times, dropoff locations and times, the distance of past requests, and information about which products were requested.<br><br>The history array in the response will have a maximum length based on the limit parameter. The response value count may exceed limit, therefore subsequent API requests may be necessary.
   */
  @GET
  @Produces("application/json")
  Activities userActivity(@QueryParam("offset") int offset, @QueryParam("limit") int limit);
}
