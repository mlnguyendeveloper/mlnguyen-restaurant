import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/common/location';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  locations: Location[] = [];

  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
    this.populateLocations();
  }

  populateLocations() {
    this.locations = this.locationService.getLocations();
  }

  handleLocation(locationName: string) {
    this.locationService.populateLocation(locationName);
  }

}
