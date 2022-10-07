import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddaddressComponent } from '../addaddress/addaddress.component';
import { AuthGuard } from '../auth/auth.guard';
import { ChangepasswordComponent } from '../changepassword/changepassword.component';
import { ProfileComponent } from '../profile/profile.component';
import { UsercoursesComponent } from '../usercourses/usercourses.component';
import { UserdashboardComponent } from '../userdashboard/userdashboard.component';
import { UserdashboardLandingComponent } from './dashboardlanding/dashboardlanding.component';

const routes: Routes = [
    {
        path: '', component: UserdashboardLandingComponent,canActivate:[AuthGuard],
        children: [
            {path:'dashboard',component:UserdashboardComponent,canActivate:[AuthGuard]},
            {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]},
            {path:'changepassword',component:ChangepasswordComponent,canActivate: [AuthGuard]},
            {path:'coursedetails',component:UsercoursesComponent,canActivate: [AuthGuard]},
            // { path: 'addaddress', component: AddaddressComponent, canActivate: [AuthGuard] },
            { path: '**', component: UserdashboardComponent }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UserDashboardRoutingModule { }