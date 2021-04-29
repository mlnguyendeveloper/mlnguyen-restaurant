import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { Location } from 'src/app/common/location';
import { Descriptions } from 'src/app/constants/descriptions';
import { Hours } from 'src/app/constants/hours';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  currentLocation: Subject<Location> = new BehaviorSubject<Location>(new Location());
  locations: Location[] = [];

  descriptions = Descriptions;
  hours = Hours;

  constructor() { 
    this.populateLocations();
  }

  populateLocations() {

    //hardcoded locations

    //--1234 Toronto St
    let torontoHours: Map<string, string> = new Map(Object.entries(this.hours.toronto));
    let torontoLocation: Location = new Location();
    torontoLocation.name = "Toronto";
    torontoLocation.address = "1234 Toronto St";
    torontoLocation.hoursOfOperations = torontoHours;
    torontoLocation.phone = "416-111-2222";
    torontoLocation.imageUrl = "assets/images/home/store-front-1.jpg";
    torontoLocation.description = this.descriptions.location.toronto;
    
    //--321 Yonge St
    let yongeHours: Map<string, string> = new Map(Object.entries(this.hours.yonge));
    let yongeLocation: Location = new Location();
    yongeLocation.name = "Yonge";
    yongeLocation.address = "321 Yonge St";
    yongeLocation.hoursOfOperations = yongeHours;
    yongeLocation.phone = "416-222-3333";
    yongeLocation.imageUrl = "assets/images/home/store-front-2.jpg";
    yongeLocation.description = this.descriptions.location.yonge;
    
    //--789 Keele St
    let keeleHours: Map<string, string> = new Map(Object.entries(this.hours.keele));
    let keeleLocation: Location = new Location();
    keeleLocation.name = "Keele";
    keeleLocation.address = "789 Keele St";
    keeleLocation.hoursOfOperations = keeleHours;
    keeleLocation.phone = "416-333-4444";
    keeleLocation.imageUrl = "assets/images/home/store-front-3.jpg";
    keeleLocation.description = this.descriptions.location.keele;
    
    //populate array of locations for return
    let locations: Location[] = [torontoLocation, yongeLocation, keeleLocation];

    this.locations = locations;
  }

  getLocations (): Location[] {
    return this.locations;
  }

  populateLocation(location: string) {
    for (let tempLocation of this.locations){
      if (tempLocation.name == location){
        this.currentLocation.next(tempLocation);
      }
    }

    return this.currentLocation;
  }
}
