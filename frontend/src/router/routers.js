import Products from "../pages/products/Products";
import ProductPage from "../pages/product/ProductPage";
import AccountPage from "../pages/account/AccountPage";

export const routers = [
    {path: '/home', component: <Products/>, exact: true},
    {path: '/account', component: <AccountPage/>, exact: true},
    {path: '/products/:productName', component: <ProductPage/>, exact: true}
]