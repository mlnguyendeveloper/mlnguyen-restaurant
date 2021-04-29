import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LocationService } from 'src/app/services/location.service';
import { Router } from '@angular/router';
import { Location } from 'src/app/common/location';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit {
  currentLocation : Location = new Location();

  constructor(private locationService: LocationService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.handleLocation();
  }

  handleLocation() {

    //On page load, get the 'id' of the location from param string
    const locationName: string = this.route.snapshot.url[1].toString();

    this.locationService.populateLocation(locationName).subscribe(
      data => {
        this.currentLocation = data;
      }
    );
  }
}
