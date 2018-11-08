import { Category } from './category';

export class Product {

    product_id: number;
    name: string;
    cost: number;
    long_description: string;
    short_description: string;
    image: string;
    category_id: Category;
    comment_id: Comment;
}
