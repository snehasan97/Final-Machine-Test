import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { Router } from '@angular/router';
import { MainserviceService } from '../mainservice.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.scss']
})
export class LoginpageComponent implements OnInit {

  login=new Login();

  constructor(private router:Router,private _mainservice:MainserviceService) { }
  boolean:boolean;
  message:string;

  ngOnInit() {
  }

  loginUser(event)
  {
    event.preventDefault();
    console.log(event);

    var username=event.target.elements[0].value;
    var password=event.target.elements[1].value;

    this._mainservice.verifyLogin(username,password).subscribe((logindata)=>
    {
      this.boolean=logindata;

      if(this.boolean=true)
      {
        this.router.navigate(['viewvendors']);
      }else
      {
        this.message="Invalid Username or Password!!"
      }
    },(error)=>{
      console.log(error);
    }
    );
  }

}
