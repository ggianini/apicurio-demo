package org.example.api;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.example.api.beans.PriceEstimate;
import org.example.api.beans.Product;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/estimates")
public interface EstimatesResource {
  /**
   * The Price Estimates endpoint returns an estimated price range for each product offered at a given location. The price estimate is provided as a formatted string with the full price range and the localized currency symbol.<br><br>The response also includes low and high estimates, and the [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code for situations requiring currency conversion. When surge is active for a particular product, its surge_multiplier will be greater than 1, but the price estimate already factors in this multiplier.
   */
  @Path("/price")
  @GET
  @Produces("application/json")
  List<PriceEstimate> priceEstimates(@QueryParam("start_latitude") double startLatitude,
      @QueryParam("start_longitude") double startLongitude,
      @QueryParam("end_latitude") double endLatitude,
      @QueryParam("end_longitude") double endLongitude);

  /**
   * The Time Estimates endpoint returns ETAs for all products offered at a given location, with the responses expressed as integers in seconds. We recommend that this endpoint be called every minute to provide the most accurate, up-to-date ETAs.
   */
  @Path("/time")
  @GET
  @Produces("application/json")
  List<Product> timeEstimates(@QueryParam("start_latitude") double startLatitude,
      @QueryParam("start_longitude") double startLongitude,
      @QueryParam("customer_uuid") String customerUuid, @QueryParam("product_id") String productId);
}
