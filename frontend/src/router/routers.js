import Products from "../pages/products/Products";
import ProductPage from "../pages/product/ProductPage";

export const routers = [
    {path: '/home', component: <Products/>, exact: true},
    {path: '/products/:productName', component: <ProductPage/>, exact: true}
]