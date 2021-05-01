import { MenuItem } from "./menu-item";

export class MenuCategory {
    id!: number;
    categoryName!: string;
    description?: string;
    menuItems?: Set<MenuItem>;
}
