import {interfaces} from "inversify";

import { CategoryService } from './api/category.service';
import { ProductService } from './api/product.service';

export class ApiServiceBinder {
    public static with(container: interfaces.Container) {
        container.bind<CategoryService>("CategoryService").to(CategoryService).inSingletonScope();
        container.bind<ProductService>("ProductService").to(ProductService).inSingletonScope();
    }
}
