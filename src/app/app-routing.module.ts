import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';

import { RegisterUserComponent } from './register-user/register-user.component';
import { UserLoginComponent } from './user-login/user-login.component';

const routes: Routes = [
  {path:'',redirectTo:'signin',pathMatch:'full'},
  { path: 'signup', component: RegisterUserComponent},
  { path: 'signin', component: UserLoginComponent},
  { path: 'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ RegisterUserComponent, UserLoginComponent ]
