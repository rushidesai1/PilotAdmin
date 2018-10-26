import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from './pilotadmin/errors/not-found/not-found.component';
import {PilotComponent} from './pilotadmin/containers/pilot/pilot.component';
import {LabelComponent} from './pilotadmin/containers/label/label.component';
import {SearchPilotsComponent} from './pilotadmin/components/search-pilots/search-pilots.component';
import {NavbarComponent} from './pilotadmin/navbar/navbar.component';
import {ReactiveFormsModule} from '@angular/forms';
// import {AppRoutingModule} from './pilotadmin/app-routing/app-routing.module';
// import {AccessDeniedComponent} from './pilotadmin/access-denied/access-denied.component';


const routes: Routes = [
  {path: '', component: PilotComponent, pathMatch: 'full'},
  {path: 'labels', component: LabelComponent},
  {path: '**', component: NotFoundComponent, pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    PilotComponent,
    LabelComponent,
    SearchPilotsComponent,
    NavbarComponent,
    // AccessDeniedComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
    // AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
