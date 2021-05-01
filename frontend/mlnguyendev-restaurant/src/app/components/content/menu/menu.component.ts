import { Component, OnInit } from '@angular/core';
import { MenuCategory } from 'src/app/common/menu-category';
import { MenuItem } from 'src/app/common/menu-item';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  //Hardcoded categories to ensure order
  menuCategoryNames: string[] = ['Appetizers and Snacks', 'Burgers', 'Pizzas', 'Mains', 'Desserts']

  
  menuCategories: MenuCategory[] = [];

  constructor(private menuService: MenuService) { }

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
