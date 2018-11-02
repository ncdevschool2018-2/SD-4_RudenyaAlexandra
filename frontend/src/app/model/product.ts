export class Product {
    product_id: number;
    name: string;
    cost: number;
    long_description: string;
    short_description: string;
    image: string;
    type_id: number;
    comment_id: number;

    static cloneBase(product: Product): Product {
        const cloneProduct: Product = new Product();
        cloneProduct.product_id = product.product_id;
        cloneProduct.name = product.name;
        cloneProduct.cost = product.cost;
        cloneProduct.long_description = product.long_description;
        cloneProduct.short_description = product.short_description;
        cloneProduct.image = product.image;
        cloneProduct.type_id = product.type_id;
        cloneProduct.comment_id = product.comment_id;
        return cloneProduct;
    }
}
