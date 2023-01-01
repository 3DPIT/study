import { createSlice } from "@reduxjs/toolkit";

const user = createSlice({
  name: "user",
  initialState: { name: "park", age: 20 },
  reducers: {
    changeName(state) {
      return { name: "kim", age: 20 };
    },
    addAge(state, action) {
      state.age += action.payload;
    },
  },
});

export const { changeName, addAge } = user.actions;

export default user;
