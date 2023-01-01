import { createSlice, configureStore } from "@reduxjs/toolkit";
import user from "./userSlice.js";

const stock = createSlice({
  name: "stock",
  initialState: [10, 11, 12],
});

const cartItem = createSlice({
  name: "cartItem",
  initialState: [
    { id: 0, name: "White and Black", count: 2 },
    { id: 2, name: "Grey Yordan", count: 1 },
  ],
  reducers: {
    sortItem() {
      return [
        { id: 2, name: "Grey Yordan", count: 1 },
        { id: 0, name: "White and Black", count: 2 },
      ];
    },
    addCount(state, action) {
      console.log(state);
      console.log(action);
      const cartProduct = state.findIndex((obj) => {
        return obj.id == action.payload;
      });
      console.log(cartProduct);
      state[cartProduct].count++;
    },
    addItem(state, action) {
      console.log(action.payload);
      console.log(state[0].id);
      state.push(action.payload);
      console.log(state[2].id);
    },
  },
});

export const { sortItem, addCount, addItem } = cartItem.actions;

export default configureStore({
  reducer: {
    user: user.reducer,
    stock: stock.reducer,
    cartItem: cartItem.reducer,
  },
});
