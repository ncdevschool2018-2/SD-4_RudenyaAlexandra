import { OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Category } from '../model/category';
import { CategoryService } from '../service/category.service';

export class CategoryData implements OnInit, OnDestroy {

    public editCategory: Category = new Category();
    public categoryMas: Category[];
    private subscriptions: Subscription[] = [];
    ngOnInit(): void {
        this._loadCategory();
    }

    constructor( private categoryService: CategoryService) {}

    public _addCategory(): void {
        this.editCategory.nameCategory = 'game';
        this.subscriptions.push(this.categoryService.saveCategory(this.editCategory).subscribe(() => {
            this._updateCategory();
            this.refreshCategory();
        }));
    }

    private refreshCategory(): void {
        this.editCategory = new Category();
    }

    public _updateCategory(): void {
        this._loadCategory();
    }

    public _deleteCategory(category_id: number): void {
        this.subscriptions.push(this.categoryService.deleteCategory(category_id).subscribe(() => {
            this._updateCategory();
            this.refreshCategory();
        }));

    }
    public _loadCategory(): void {
        this.subscriptions.push(this.categoryService.getCategory().subscribe( categories => {
            this.categoryMas = categories as Category[];
            console.log(categories);
        }));
    }

    ngOnDestroy(): void {
        this.subscriptions.forEach( subscription =>  subscription.unsubscribe());
    }
}
