import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Vendor } from './vendor';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class MainserviceService {
  vendorId: number;

  constructor(private _httpService:HttpClient, private router:Router) { }

  verifyLogin(username:String,password:String){
    return this._httpService.get<boolean>(environment.APIUrl +'/login'+'/'+username+'/'+password);
  }

  getVendors(): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl+'/vendor');
  }

  getEditVendor():Observable<Vendor>
  {
    return this._httpService.get<Vendor>(environment.APIUrl+'/vendorbyid/'+this.vendorId);
  }

  disableVendor(vendor:Vendor,vendorId:number){
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpService.put(environment.APIUrl +'/disable/'+vendorId, body, options);
  }

  searchVendor(searchString:string):Observable<Vendor[]>
   {
     return this._httpService.get<Vendor[]>(environment.APIUrl+'/vendorbyname/'+searchString);
   }

   addVendor(vendor:Vendor){
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    if(vendor.vendorId)
    {
      return this._httpService.put(environment.APIUrl +'/insertvendor', body, options);
    }else{
      return this._httpService.post(environment.APIUrl +'/insertvendor', body, options);
    }
  }

  editVendor(vendorId:number){
    this.vendorId=vendorId;
    console.log(vendorId);
  }
}