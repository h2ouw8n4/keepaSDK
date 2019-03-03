export * from './category.service';
import { CategoryService } from './category.service';
export * from './product.service';
import { ProductService } from './product.service';
export const APIS = [CategoryService, ProductService];
