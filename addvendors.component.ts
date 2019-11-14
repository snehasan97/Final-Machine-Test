import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { MainserviceService } from '../mainservice.service';

@Component({
  selector: 'app-addvendors',
  templateUrl: './addvendors.component.html',
  styleUrls: ['./addvendors.component.scss']
})
export class AddvendorsComponent implements OnInit {

  vendor = new Vendor();

  constructor(private _mainservice:MainserviceService) { }

  ngOnInit() {

    this.getEditVendor();

  }

  private reset()
  {
 
    this.vendor.vendorName=null;
    this.vendor.address=null;
    this.vendor.location=null;
    this.vendor.pincode=null;
    this.vendor.eMail=null;
    this.vendor.department=null;
    this.vendor.phone=null;
    this.vendor.contactName=null;
    this.vendor.service=null;

  
  }

  addVendor():void{
    console.log(this.vendor);
    this. _mainservice.addVendor(this.vendor).subscribe((response)=>
    {
      this.reset();
      console.log(response);
    },(error)=>{
      console.log(error);
    }
    );
  }
  
  getEditVendor(): void{
    this._mainservice.getEditVendor().subscribe((vendordata)=>
    {
      this.vendor=vendordata,
      console.log(vendordata);
    },(error)=>{
      console.log(error);
    }
    );
  }

}
