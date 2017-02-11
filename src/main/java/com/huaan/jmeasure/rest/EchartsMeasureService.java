package com.huaan.jmeasure.rest;

import com.huaan.jmeasure.core.MapMultilThreadAlgorithm;
import com.huaan.jmeasure.core.Measure;
import com.huaan.jmeasure.echarts.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by mai on 2017/2/11 0011.
 */
@Path("/echartsMeasureService")
public class EchartsMeasureService {
    @GET
    @Path("/{param}")
    public Response getMeasureResult(@PathParam("param") String testType) {
        Measure measure = new EchartsMeasure();
        if ("map".equals(testType))
        {
            measure.setAlgorithm(new MapMultilThreadAlgorithm());
        }
        measure.run();
        return Response.status(200).entity(measure.show()).build();

    }
}
