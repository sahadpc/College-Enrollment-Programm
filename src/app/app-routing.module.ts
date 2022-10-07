import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
<<<<<<< HEAD
<<<<<<< HEAD
=======
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
>>>>>>> b4da0397c6fb143ab2fa70dbcaa85fc0e8d8de46
=======
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
=======
>>>>>>> fe7442e4b687c8990a898508d9b388c02737e167
>>>>>>> 3585b4dec4566d02fa53cc7cb93a1864dd3c6825
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SignupComponent } from './signup/signup.component';
<<<<<<< HEAD
<<<<<<< HEAD

=======
import { UsercoursesComponent } from './usercourses/usercourses.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
>>>>>>> b4da0397c6fb143ab2fa70dbcaa85fc0e8d8de46
=======
import { UsercoursesComponent } from './usercourses/usercourses.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
=======

>>>>>>> fe7442e4b687c8990a898508d9b388c02737e167
>>>>>>> 3585b4dec4566d02fa53cc7cb93a1864dd3c6825

const routes: Routes = [
{path:'',redirectTo:'login',pathMatch:'full'},
{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},
<<<<<<< HEAD
<<<<<<< HEAD
{path:'forget',component:ForgetPasswordComponent,canActivate:[AuthGuard]},
{path: 'user', loadChildren: () => import('./userdashboard/userdashboard.module').then(m => m.UserDashboardModule) },
=======
=======
>>>>>>> 3585b4dec4566d02fa53cc7cb93a1864dd3c6825
{path:'userdash',component:UserdashboardComponent,canActivate :[AuthGuard]},
//{path:'dash',component:DashboardComponent,canActivate:[AuthGuard]},
{path:'forget',component:ForgetPasswordComponent},
{path:'changepassword',component:ChangepasswordComponent},
{path:'coursedetails',component:UsercoursesComponent},
<<<<<<< HEAD
>>>>>>> b4da0397c6fb143ab2fa70dbcaa85fc0e8d8de46
=======
=======
{path:'forget',component:ForgetPasswordComponent,canActivate:[AuthGuard]},
{path: 'user', loadChildren: () => import('./userdashboard/userdashboard.module').then(m => m.UserDashboardModule) },
>>>>>>> fe7442e4b687c8990a898508d9b388c02737e167
>>>>>>> 3585b4dec4566d02fa53cc7cb93a1864dd3c6825
{path:'**',component:PagenotfoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }