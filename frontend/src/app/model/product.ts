import { Category } from './category';

export class Product {
    productId: number;
    name: string;
    cost: number;
    longDescription: string;
    shortDescription: string;
    image: string;
    categoryId: Category;
    commentId: Comment;
}
