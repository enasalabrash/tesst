/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author enas
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of test.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("result")
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
       return "ok";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
       @POST
     @Path("getresult")
  @Produces(MediaType.APPLICATION_JSON)
    public JsonObject postJson(@FormParam("a") double a , @FormParam("b") double b,@FormParam("c") double c) {
     JsonObject json;
       double delta;
        String equation= a+"x^2"+b+"x"+c;
        double d=b*b-(4*a*c);
        if(d<0)
        {
          json = Json.createObjectBuilder()
  .add(equation, Json.createArrayBuilder()
    .add(Json.createObjectBuilder()
      .add("Unsolvable equation", " ")))
  .build();
        }
        else
        {
      delta=Math.sqrt(d);
        
    if(delta >0){
      double r1=(-b+delta)/(2*a);
      double r2=(-b-delta)/(2*a);
   
  json = Json.createObjectBuilder()
  .add(equation, Json.createArrayBuilder()
    .add(Json.createObjectBuilder()
      .add("root1", r1)
      .add("root2", r2)))
  .build();
          
    }
        else
      {
          double r=-b/2*a;
    json = Json.createObjectBuilder()
  .add(equation, Json.createArrayBuilder()
    .add(Json.createObjectBuilder()
      .add("root", r)))
  .build();
      }
     
        }
    
          // String ss= r1+"--"+r2;
           //return new Roots(r1,r2);
          // return Response.status(201).entity(ss).build();
        /*  JsonObject myObject;
        myObject = Json.createObjectBuilder().add("r1", r1).add("r2", r2).build();
          return myObject;
       // return r1+" "+r2 ;
                */
    return json;
         
    }
}
