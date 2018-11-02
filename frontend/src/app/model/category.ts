export class Category {
    category_id: number;
    name_category: string;

    static cloneBase(category: Category): Category {
        const clonedCategory: Category = new Category();
        clonedCategory.category_id = category.category_id;
        clonedCategory.name_category = category.name_category;
        return clonedCategory;
    }
}
