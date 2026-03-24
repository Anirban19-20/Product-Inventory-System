import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import AddProduct from "./components/AddProduct";
import UpdateProduct from "./components/UpdateProduct";
import DeleteProduct from "./components/DeleteProduct";
import ViewProducts from "./components/ViewProducts";

function App() {

  return (

    <BrowserRouter>

      <Routes>

        <Route path="/" element={<ViewProducts />} />

        <Route path="/save" element={<AddProduct />} />

        <Route path="/update" element={<UpdateProduct />} />

        <Route path="/delete" element={<DeleteProduct />} />

      </Routes>

    </BrowserRouter>

  )

}

export default App;