import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'src/app/common/menu-item';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  menuItem? : MenuItem;
  
  constructor() { }

  ngOnInit(): void {
  }

}
