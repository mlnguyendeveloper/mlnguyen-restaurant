import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MenuItem } from '../common/menu-item';
import { map } from 'rxjs/operators';
import { MenuCategory } from '../common/menu-category';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private menuItemUrl = 'http://localhost:8080/api/menuItems';
  private menuCategoryUrl = 'http://localhost:8080/api/menu-categories';

  constructor(private httpClient: HttpClient) { }

  getMenuItemList(categoryId: number): Observable<MenuItem[]> {

    //build url for products by category id
    const searchUrl = `${this.menuItemUrl}/search/findByCategoryId?id=${categoryId}`;

    return this.getMenuItems(searchUrl);
  }

  getMenuCategoriesList(): Observable<MenuCategory[]> {
    return this.httpClient.get<GetResponseMenuCategories>(this.menuCategoryUrl).pipe(
      map(response => response._embedded.menuCategory)
    )
  }

  private getMenuItems(searchUrl: string): Observable<MenuItem[]> {
    return this.httpClient.get<GetResponseMenuItems>(searchUrl).pipe(
      map(response => response._embedded.menuItems)
    );
  }
}

interface GetResponseMenuItems {
  _embedded: {
    menuItems: MenuItem[];
  }
}

interface GetResponseMenuCategories {
  _embedded: {
    menuCategory: MenuCategory[];
  }
}