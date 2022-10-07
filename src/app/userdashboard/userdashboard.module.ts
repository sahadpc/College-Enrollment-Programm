import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from '../auth/auth.guard';
import { AuthInterceptor } from '../auth/auth.interceptor';
import { UserdashboardComponent } from './userdashboard.component';
import { ProfileComponent } from '../profile/profile.component';
import { AddaddressComponent } from '../addaddress/addaddress.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { UserDashboardRoutingModule } from './userdashboard.routing.module';
import { UserdashboardLandingComponent } from './dashboardlanding/dashboardlanding.component';
import { CommonModule } from '@angular/common';
import { UsercoursesComponent } from '../usercourses/usercourses.component';
import { ChangepasswordComponent } from '../changepassword/changepassword.component';


@NgModule({
  declarations: [
    UserdashboardComponent,
    ProfileComponent,
    AddaddressComponent,
    ChangepasswordComponent,
    UsercoursesComponent,
    UserdashboardLandingComponent
  ],
  imports: [
    RouterModule,
    CommonModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    FormsModule,
    UserDashboardRoutingModule
  ],
  providers: [AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ]
})
export class UserDashboardModule { }
