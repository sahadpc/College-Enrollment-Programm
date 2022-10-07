import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
<<<<<<< HEAD
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
=======
>>>>>>> fe7442e4b687c8990a898508d9b388c02737e167
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SignupComponent } from './signup/signup.component';
<<<<<<< HEAD
import { UsercoursesComponent } from './usercourses/usercourses.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
=======

>>>>>>> fe7442e4b687c8990a898508d9b388c02737e167

const routes: Routes = [
{path:'',redirectTo:'login',pathMatch:'full'},
{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},
<<<<<<< HEAD
{path:'userdash',component:UserdashboardComponent,canActivate :[AuthGuard]},
//{path:'dash',component:DashboardComponent,canActivate:[AuthGuard]},
{path:'forget',component:ForgetPasswordComponent},
{path:'changepassword',component:ChangepasswordComponent},
{path:'coursedetails',component:UsercoursesComponent},
=======
{path:'forget',component:ForgetPasswordComponent,canActivate:[AuthGuard]},
{path: 'user', loadChildren: () => import('./userdashboard/userdashboard.module').then(m => m.UserDashboardModule) },
>>>>>>> fe7442e4b687c8990a898508d9b388c02737e167
{path:'**',component:PagenotfoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }