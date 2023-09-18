export const selectBasketState = (state) => state.basket;
export const selectBasketProductsFromBasket = (state) => selectBasketState(state).basketProducts