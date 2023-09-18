export const selectAuthState = (state) => state.auth;
export const selectLoadingStateFromAuth = (state) => selectAuthState(state).loadingState
export const selectErrorFromAuth = (state) => selectAuthState(state).error