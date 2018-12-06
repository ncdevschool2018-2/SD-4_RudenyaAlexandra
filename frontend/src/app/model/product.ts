import { Category } from './category';
import {Comment} from './comment';
export class Product {
    productId: number;
    name: string;
    cost: number;
    longDescription: string;
    shortDescription: string;
    image: string;
    category: Category;
    comment: Comment;
}
