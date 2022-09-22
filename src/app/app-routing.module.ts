import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterUserComponent } from './register-user/register-user.component';
import { UserLoginComponent } from './user-login/user-login.component';

const routes: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  { path: 'signup', component: RegisterUserComponent},
  { path: 'signin', component: UserLoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ RegisterUserComponent, UserLoginComponent ]
