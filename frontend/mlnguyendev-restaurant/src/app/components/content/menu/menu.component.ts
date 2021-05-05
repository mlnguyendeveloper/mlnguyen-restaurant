import { Component, OnInit } from '@angular/core';
import { MenuCategory } from 'src/app/common/menu-category';
import { MenuService } from 'src/app/services/menu.service';
import { Menu } from 'src/app/constants/menu';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  //Hardcoded categories to ensure order
  menuCategoryNames: string[];
  menuCategoryColorCodes: string[]; 
  
  menuCategories: MenuCategory[] = [];

  constructor(private menuService: MenuService) { 
    this.menuCategoryNames = Menu.menuCategoryNames;
    this.menuCategoryColorCodes = Menu.menuCategoryColorCodes;
  }

  ngOnInit(): void { 
    this.populateMenuCategories();
  }

  populateMenuCategories() {
    this.menuService.getMenuCategoriesList().subscribe(
      data => {
        console.log(data);
        this.menuCategories = data;
      }
    )
  }
}
