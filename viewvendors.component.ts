import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { MainserviceService } from '../mainservice.service';

@Component({
  selector: 'app-viewvendors',
  templateUrl: './viewvendors.component.html',
  styleUrls: ['./viewvendors.component.scss']
})
export class ViewvendorsComponent implements OnInit {
  vendors: Vendor[];
  vendor = new Vendor();
  popoverMessage:string='Do you want to disable ?';

  constructor(private _mainservice:MainserviceService) { }

  ngOnInit() {
    this.getVendors();
  }


  getVendors(): void{
    this._mainservice.getVendors().subscribe((vendordata)=>
    {
      this.vendors=vendordata,
      console.log(vendordata);
    },(error)=>{
      console.log(error);
    }
    );
  }

  disableVendor(vendorId:number):void{
    this._mainservice.disableVendor(this.vendor,vendorId).subscribe((response)=>
    {
      console.log(response);
      this.getVendors();
    },(error)=>{
      console.log(error);
    }
    );
  }

  searchVendor(searchString:string){
    if(searchString!=null){
      this._mainservice.searchVendor(searchString).subscribe((vendordata)=>
      {
        this.vendors=vendordata,
        console.log(vendordata);
        if(this.vendors==null)
        {
          alert("Vendor Not Found!!!");
        }
      },(error)=>{
        console.log(error);
      }
      );
    }else{
      this.getVendors();
    }
  }

  vendorId:number;
  editVendor(vendorId:number)
  {
    this._mainservice.editVendor(vendorId);
  }

}

