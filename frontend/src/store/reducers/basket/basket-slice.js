import {createSlice} from "@reduxjs/toolkit";
import {enableMapSet} from "immer";

const initialState = {
    basketProducts: new Map()
}

enableMapSet();

export const basketSlice = createSlice({
    name: "basket",
    initialState: initialState,
    reducers: {
        resetBasketProducts(state) {
            state.basketProducts = new Map()
        },
        setBasketProducts(state, action) {
            state.basketProducts = new Map(Object.entries(action.payload))
        },
        addProduct(state, action) {
            if (state.basketProducts.has(action.payload.product_name)) {
                let basketProduct = state.basketProducts.get(action.payload.product_name)
                basketProduct.count = basketProduct.count + 1;
            } else {
                state.basketProducts.set(action.payload.product_name, {
                    product: action.payload,
                    count: 1
                })
            }
            localStorage.setItem("basket", JSON.stringify(Object.fromEntries(state.basketProducts.entries())))
        },
        deleteProduct(state, action) {
            if (state.basketProducts.has(action.payload.product_name)) {
                let basketProduct = state.basketProducts.get(action.payload.product_name)
                basketProduct.count = basketProduct.count - 1;
                if (basketProduct.count < 1) {
                    state.basketProducts.delete(action.payload.product_name)
                }
            }
            localStorage.setItem("basket", JSON.stringify(Object.fromEntries(state.basketProducts.entries())))
        }
    }
})

export default basketSlice.reducer
export const { resetBasketProducts, setBasketProducts, addProduct, deleteProduct} = basketSlice.actions