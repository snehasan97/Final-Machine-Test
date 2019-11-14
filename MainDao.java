package sneha.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sneha.ust.model.Login;
import sneha.ust.model.VendorContact;

public class MainDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		
		this.template = template;
	}

	//user validation
	public Login check(String username, String password){
		
		String sql = "select userId from logintable where username=? and password=?";
		
		return template.queryForObject(sql, new Object[] {username,password},
				new BeanPropertyRowMapper<Login>(Login.class));

	}
	
	
	//view Vendor list
	//select and display vendor details along with contact details
	public List<VendorContact> getVendorDetails() {
		return template
				.query("select v.vendorId,vendorName,address,location,service"
						+ ",contactName,phone from vendorTable"
						+ " v join contactTable c on(v.vendorId=c.vendorId) where isActiveV='Yes' ",
						new RowMapper<VendorContact>() {
							public VendorContact mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContact vc = new VendorContact();
								vc.setVendorId(rs.getInt(1));
								vc.setVendorName(rs.getString(2));
								vc.setAddress(rs.getString(3));
								vc.setLocation(rs.getString(4));
								vc.setService(rs.getString(5));
								vc.setContactName(rs.getString(6));
								vc.setPhone(rs.getString(7));
							
								return vc;

							}
						});
	}
	
	
	//view Vendor using vendorId
	public VendorContact getVendorById(int vendorId){
		String sql="select v.vendorId,vendorName,address,location,service"
				+ ",contactName,phone from vendorTable "
				+ "v join contactTable c on(v.vendorId=c.vendorId) where v.vendorId=?";
		return template.queryForObject(sql, new Object[] { vendorId },
				new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
	}
	
	//search Vendor details using 'vendorName'
	//search and display Vendor details using vendor name
	/*public VendorContact getVendorByName(String searchString) {
		
		String sql = "select v.vendorId,vendorName,address,location,service"
					+ ",contactName,phone from vendorTable "
					+ "v join contactTable c on(v.vendorId=c.vendorId) where vendorName='"+searchString+"' or location='"+searchString
					+ "' or service='"+searchString+"'";
		return template.queryForObject(sql, new Object[] { searchString },
				new BeanPropertyRowMapper<VendorContact>(VendorContact.class));				
	}*/
	
	public List<VendorContact> getVendorBy(String searchString) {
		return template
				.query("select v.vendorId,vendorName,address,location,service"
						+ ",contactName,phone from vendorTable "
						+ "v join contactTable c on(v.vendorId=c.vendorId) where vendorName='"+searchString
						+ "' or location='"+searchString
						+ "' or service='"+searchString+"'",
						new RowMapper<VendorContact>() {
							public VendorContact mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContact vc = new VendorContact();
								vc.setVendorId(rs.getInt(1));
								vc.setVendorName(rs.getString(2));
								vc.setAddress(rs.getString(3));
								vc.setLocation(rs.getString(4));
								vc.setService(rs.getString(5));
								vc.setContactName(rs.getString(6));
								vc.setPhone(rs.getString(7));
							
								return vc;

							}
						});
	}
	
	
	//search Vendor details using 'location'
	//search and display Vendor details using location
	public VendorContact getVendorByLoc(String location) {
		 String sql = "select v.vendorId,vendorName,address,location,service"
					+ ",contactName,phone from vendorTable "
					+ "v join contactTable c on(v.vendorId=c.vendorId) where location=?";
		 
		 return template.queryForObject(sql, new Object[] { location },
					new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
		 
	}
	
	
	//search Vendor details using 'service'
	//search and display Vendor details using service they provide
	public VendorContact getVendorByService(String service) {
		String sql = "select v.vendorId,vendorName,address,location,service"
				+ ",contactName,phone from vendorTable "
				+ "v join contactTable c on(v.vendorId=c.vendorId) where service=?";
		
		return template.queryForObject(sql, new Object[] { service },
				new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
		
	}
	
	
	/*//get vendorId using vendorName
	public VendorContact getVendorId(String vendorName) {
		String sql = "select vendorId from vendorTable where vendorName=?";
		return template.queryForObject(sql, new Object[] {vendorName },
				new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
	}*/
	
	
	
	//insert new Vendor and Contact Person 
	//insert new vendor into vendor table and get the max vendor id to insert into contact table
	public int insertVendor(VendorContact vendor){
		
	    String sql1 = "insert into vendorTable(vendorName,address,location,service,pincode,isActiveV) values('"
	    		+vendor.getVendorName()
	    		+"','"
	    		+vendor.getAddress()
	    		+"','"
	    		+vendor.getLocation()
	    		+"','"
	    		+vendor.getService()
	    		+"',"
	    		+vendor.getPincode()
	    		+","
	    		+"'Yes'"
	    		+")";
	    		
	    
	    template.update(sql1);
	    
	    Integer maxId = getSequence();
	    
	    String sql2 = "insert into contactTable(contactName,vendorId,department,email,phone,isActiveP) values('"
	    		+vendor.getContactName()
	    		+"',"
	    		+maxId
	    		+",'"
	    		+vendor.getDepartment()
	    		+"','"
	    		+vendor.geteMail()
	    		+"','"
	    		+vendor.getPhone()
	    		+"',"
	    		+"'Yes'"
	    		+")";
	    
	    
	    return template.update(sql2);
	    
	}
	    
	
	//function to get max id from vendorTable
	private Integer getSequence() {

			Integer seq;

			String sql = "select MAX(vendorId)from vendorTable";

			seq = template.queryForObject(sql, new Object[] {}, Integer.class);

			return seq;
		
	}
	
	
	//update vendor details
	public int updateVendor(VendorContact vendor){
		
		String sql1 = "update vendorTable set vendorName='"+vendor.getVendorName()+"',address='"+vendor.getAddress()
				+"',location='"+vendor.getLocation()+"',service='"+vendor.getService()+"',pincode="+vendor.getPincode()
				+" where vendorId="+vendor.getVendorId()+"";
		
		template.update(sql1, new Object[] {});
		
		String sql2 = "update contactTable set contactName='"+vendor.getContactName()+"',department='"+vendor.getDepartment()
				+"',email='"+vendor.geteMail()+"',phone='"+vendor.getPhone()+"' where vendorId="+vendor.getVendorId()+"";
		
		return template.update(sql2, new Object[] {});
	}
	
	
	//disable Vendor
	//disabling the Vendor by setting isActive status to 'No'
	public int disableVendor(int vendorId) {
		String sql = "update vendorTable set isActiveV='No' where vendorId=?";
		return template.update(sql, new Object[] { vendorId });
	}
	
	
	
	
}
