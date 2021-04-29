import { NgModule } from '@angular/core';
import { ExtraOptions, RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/content/about/about.component';
import { HomeComponent } from './components/content/home/home.component';
import { LocationsComponent } from './components/content/locations/locations.component';
import { MenuComponent } from './components/content/menu/menu.component';
import { NotfoundComponent } from './components/notfound/notfound.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'locations/:name', component: LocationsComponent },
  { path: 'menu', component: MenuComponent },
  { path: '**', component: NotfoundComponent } 
];

const routerOptions: ExtraOptions = {
  scrollPositionRestoration: 'enabled',
  anchorScrolling: 'enabled',
  scrollOffset: [0, 64],
};

@NgModule({
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
