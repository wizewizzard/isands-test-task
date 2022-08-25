package com.wz.testtask.estore.rest.application;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.wz.testtask.estore.exception.NoSuchEmployeeException;
import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.service.DeviceLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeeService;
import com.wz.testtask.estore.service.EmployeeServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author aleksei
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/estore",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Estore.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
public class RestApiApplication extends Application {
	
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		JacksonJsonProvider provider = new JacksonJsonProvider();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		provider.setMapper(mapper);
		singletons.add(provider);
		singletons.add(this);
		return singletons;
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}
	
	@GET
	@Path("/employee/{employeeId}")
	@Produces("application/json")
	public Response getEmployee(@PathParam("employeeId") long employeeId){
		try{
			return Response.ok(EmployeeLocalServiceUtil.getEmployee(employeeId)).build();
		}
		catch (PortalException exception){
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found").build();
		}
	}
	
	@GET
	@Path("/employee")
	@Produces("application/json")
	public Response getEmployees(@QueryParam("groupId") long groupId){
		if(groupId != 0)
			return Response.ok(EmployeeLocalServiceUtil.getEmployees(groupId)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Group id must be specified").build();
	}
	
	@GET
	@Path("/employee")
	@Produces("application/json")
	public Response getDevices(@QueryParam("groupId") long groupId){
		if(groupId != 0)
			return Response.ok(DeviceLocalServiceUtil.getDevices(groupId)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Group id must be specified").build();
	}
}