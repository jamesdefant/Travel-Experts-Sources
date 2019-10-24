package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
 

public class AgentRestServiceApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	 
	public AgentRestServiceApplication() {
		singletons.add(new AgencyRestService());
		singletons.add(new AgentRestService());
		singletons.add(new BookingRestService());
		singletons.add(new CustomerRestService());
		singletons.add(new Customer_rewardsRestService());
		singletons.add(new PackageRestService());
		singletons.add(new Package_Product_SupplierRestService());
		singletons.add(new ProductRestService());
		singletons.add(new ProductSupplierRestService());
		singletons.add(new RewardRestService());
		singletons.add(new SupplierRestService());
		singletons.add(new TripTypeRestService());

	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return null;
	}

}
