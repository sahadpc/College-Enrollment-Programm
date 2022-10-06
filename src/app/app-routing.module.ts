import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SignupComponent } from './signup/signup.component';
import { UsercoursesComponent } from './usercourses/usercourses.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';

const routes: Routes = [
{path:'',redirectTo:'login',pathMatch:'full'},
{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},
{path:'userdash',component:UserdashboardComponent,canActivate :[AuthGuard]},
//{path:'dash',component:DashboardComponent,canActivate:[AuthGuard]},
{path:'forget',component:ForgetPasswordComponent},
{path:'changepassword',component:ChangepasswordComponent},
{path:'coursedetails',component:UsercoursesComponent},
{path:'**',component:PagenotfoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
