package sneha.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sneha.ust.dao.MainDao;
import sneha.ust.model.Login;
import sneha.ust.model.VendorContact;


@RestController
public class MainController {

	@Autowired
	MainDao mDao;
	
	
	// verify login
		@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
		@ResponseBody
		public Login selectRoleName(@PathVariable("username") String username,
				@PathVariable("password") String password) {
			return mDao.check(username, password);
		}
	
	//view Vendor list
	@RequestMapping(value="/api/vendor", method=RequestMethod.GET)
	@ResponseBody
	public List getVendor(Model m){
		List list=mDao.getVendorDetails();
		return list;
	}
	
	
	//view Vendor by id
	@RequestMapping(value="/api/vendorbyid/{vendorId}", method=RequestMethod.GET)
	@ResponseBody
	public VendorContact getVendorById(@PathVariable("vendorId")int vendorId){
		VendorContact v1=mDao.getVendorById(vendorId);
		return v1;
	}
	
	//view vendor by name
	@RequestMapping(value="/api/vendorbyname/{searchString}", method=RequestMethod.GET)
	@ResponseBody
	public List<VendorContact> getVendorByName(@PathVariable("searchString")String searchString){
		List list=mDao.getVendorBy(searchString);
		return list;
	}
	
	//view vendor by location
	@RequestMapping(value="/api/vendorbylocation/{location}", method=RequestMethod.GET)
	@ResponseBody
	public VendorContact getVendorByLoc(@PathVariable("location")String location){
		VendorContact v1=mDao.getVendorByLoc(location);
		return v1;
	}
	
	//view vendor by service
	@RequestMapping(value="/api/vendorbyservice/{service}", method=RequestMethod.GET)
	@ResponseBody
	public VendorContact getVendorByService(@PathVariable("service")String service){
		VendorContact v1=mDao.getVendorByService(service);
		return v1;
	}
	
	//insert and update vendor and contact person
	@RequestMapping(value ="/api/insertvendor", method= {RequestMethod.POST,RequestMethod.PUT})
	public void insertVendor(@RequestBody VendorContact vendor)
	{
		if(vendor.getVendorId()==0){
			mDao.insertVendor(vendor);
		}
		else{
			mDao.updateVendor(vendor);
		}
	}
	
	/*//update vendor and contact person details
	@RequestMapping(value ="/api/updatevendor", method= RequestMethod.PUT)
	public void updateVendor(@RequestBody VendorContact vendor)
	{
		mDao.updateVendor(vendor);
	}*/
	
	//disable a vendor
	@RequestMapping(value = "/api/disable/{vendorId}", method = RequestMethod.PUT)
	void vendorDisable(@PathVariable("vendorId") int vendorId) {
		mDao.disableVendor(vendorId);
	}
}
