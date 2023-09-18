export const selectUserState = (state) => state.user;
export const selectUserFromUserState = (state) => selectUserState(state).user