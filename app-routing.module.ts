import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewvendorsComponent } from './viewvendors/viewvendors.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { AddvendorsComponent } from './addvendors/addvendors.component';



const routes: Routes = [
  {path:'',component:LoginpageComponent},
  {path:'viewvendors',component:ViewvendorsComponent},
  {path:'addvendors',component:AddvendorsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
