import Products from "../pages/products/Products";
import ProductPage from "../pages/product/ProductPage";
import AccountPage from "../pages/account/AccountPage";
import PersonalData from "../pages/account/personalData/PersonalData";
import Orders from "../pages/account/orders/Orders";
import AddProductPage from "../pages/addProduct/AddProductPage";
import Basket from "../pages/basket/Basket";

export const routers = [
    {path: '/', component: <Products/>, exact: true},
    {path: '/account/*', component: <AccountPage/>, exact: true},
    {path: '/products/:productName', component: <ProductPage/>, exact: true},
    {path: '/basket', component: <Basket/>, exact: true}
]

export const accountRouters = [
    {path: 'personal', component: <PersonalData/>, exact: true},
    {path: 'orders', component: <Orders/>, exact: true},
    {path: 'addProduct', component: <AddProductPage/>, exact: true},
]