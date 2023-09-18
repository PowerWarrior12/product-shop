import React from 'react';
import {Route, Routes} from "react-router-dom";
import {routers} from "../router/routers";

export const AppRouter = ({routers}) => {
    return (
        <Routes>
            {
                routers.map(route =>
                    <Route key={route.path} element={route.component} path={route.path}/>
                )
            }
        </Routes>
    );
};