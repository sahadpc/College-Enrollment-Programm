import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
<<<<<<< HEAD
=======
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
>>>>>>> b4da0397c6fb143ab2fa70dbcaa85fc0e8d8de46
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SignupComponent } from './signup/signup.component';
<<<<<<< HEAD

=======
import { UsercoursesComponent } from './usercourses/usercourses.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
>>>>>>> b4da0397c6fb143ab2fa70dbcaa85fc0e8d8de46

const routes: Routes = [
{path:'',redirectTo:'login',pathMatch:'full'},
{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},
<<<<<<< HEAD
{path:'forget',component:ForgetPasswordComponent,canActivate:[AuthGuard]},
{path: 'user', loadChildren: () => import('./userdashboard/userdashboard.module').then(m => m.UserDashboardModule) },
=======
{path:'userdash',component:UserdashboardComponent,canActivate :[AuthGuard]},
//{path:'dash',component:DashboardComponent,canActivate:[AuthGuard]},
{path:'forget',component:ForgetPasswordComponent},
{path:'changepassword',component:ChangepasswordComponent},
{path:'coursedetails',component:UsercoursesComponent},
>>>>>>> b4da0397c6fb143ab2fa70dbcaa85fc0e8d8de46
{path:'**',component:PagenotfoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }