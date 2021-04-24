import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/content/about/about.component';
import { HomeComponent } from './components/content/home/home.component';
import { LocationsComponent } from './components/content/locations/locations.component';
import { MenuComponent } from './components/content/menu/menu.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'locations', component: LocationsComponent },
  { path: 'menu', component: MenuComponent },
  { path: '**', component: HomeComponent } // TODO: make a 404 not found page
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
