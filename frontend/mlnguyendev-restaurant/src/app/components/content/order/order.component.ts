import { Component, OnInit } from '@angular/core';
import { MenuCategory } from 'src/app/common/menu-category';
import { MenuService } from 'src/app/services/menu.service';
import { Menu } from 'src/app/constants/menu';
import { LocationService } from 'src/app/services/location.service';
import { Location } from 'src/app/common/location';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MenuItem } from 'src/app/common/menu-item';
import { AddItemComponent } from 'src/app/popup/add-item/add-item.component';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

    //Hardcoded categories to ensure order
    menuCategoryNames: string[];
    menuCategoryColorCodes: string[]; 
    
    menuCategories: MenuCategory[] = [];

    locations: Location[] = [];
    currentLocation : Location = new Location();
    
  constructor(private menuService: MenuService, private locationService: LocationService, private modalService: NgbModal) { 
    this.menuCategoryNames = Menu.menuCategoryNames;
    this.menuCategoryColorCodes = Menu.menuCategoryColorCodes;
  }

  ngOnInit(): void {
    this.populateMenuCategories();
    this.populateLocations();

    //Automatically assume current location with whatever is in the first location
    this.populateLocation(this.locations[0].name);
  }

  open(menuItem: MenuItem) {

    console.log("Opening modal for:" + menuItem.name);
    
    const ref = this.modalService.open(AddItemComponent);
    ref.componentInstance.menuItem = menuItem;
  }

  populateMenuCategories() {
    this.menuService.getMenuCategoriesList().subscribe(
      data => {
        console.log(data);
        this.menuCategories = data;
      }
    )
  }

  populateLocations() {
    this.locations = this.locationService.getLocations();
  }

  populateLocation(locationName: string){
    this.locationService.populateLocation(locationName).subscribe(
      data => {
        this.currentLocation = data;
      }
    );
  }

  getTodaysHours(location: Location): string {
    let day: string;

    switch (new Date().getDay()) {
      case 0:
        day = "Sunday";
        break;
      case 1:
        day = "Monday";
        break;
      case 2:
        day = "Tuesday";
        break;
      case 3:
        day = "Wednesday";
        break;
      case 4:
        day = "Thursday";
        break;
      case 5:
        day = "Friday";
        break;
      case 6:
        day = "Saturday";
        break
      default:
        day = "";
    }

    let hours = location.hoursOfOperations.get(day);
    return day + ": " + hours;
  }
}
