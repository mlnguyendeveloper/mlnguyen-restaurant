import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './components/header/navbar/navbar.component';
import { HomeComponent } from './components/content/home/home.component';
import { AboutComponent } from './components/content/about/about.component';
import { LocationsComponent } from './components/content/locations/locations.component';
import { MenuComponent } from './components/content/menu/menu.component';
import { FooterComponent } from './components/footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faTwitter, faFacebook, faInstagram} from '@fortawesome/free-brands-svg-icons';
import { LocationService } from './services/location.service';
import { HttpClientModule } from '@angular/common/http';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { MenuService } from './services/menu.service';
import { OrderComponent } from './components/content/order/order.component';
import { AddItemComponent } from './popup/add-item/add-item.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    AboutComponent,
    LocationsComponent,
    MenuComponent,
    FooterComponent,
    NotfoundComponent,
    OrderComponent,
    AddItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    HttpClientModule
  ],
  providers: [LocationService, MenuService],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor(library: FaIconLibrary) {
    library.addIcons(faTwitter, faFacebook, faInstagram);
  }
}
