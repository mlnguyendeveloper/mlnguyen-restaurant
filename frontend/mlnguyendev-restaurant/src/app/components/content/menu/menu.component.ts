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

  //menuItems!: MenuItem[];
  menuCategories!: MenuCategory[];

  constructor(private menuService: MenuService) { }

  ngOnInit(): void {
    this.listMenuCategories();
    console.log(this.menuCategories);
  }

  listMenuCategories(){
    this.menuService.getMenuCategoriesList().subscribe(
      data => {
        this.menuCategories = data;
        console.log('Menu Categories=' + JSON.stringify(data));
      }
    )
  }
}
