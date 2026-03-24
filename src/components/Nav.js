import React from "react";
// import AddProduct from "./AddProduct";
// import UpdateProduct from "./UpdateProduct";
// import DeleteProduct from "./DeleteProduct";
// import ViewProducts from "./ViewProducts";
function Nav(){

 return(

<nav className="navbar navbar-expand-lg navbar-dark bg-primary">

<div className="container">

<a className="navbar-brand" href="/">Product Inventory</a>

<div>

<a className="btn btn-light me-2" href="/">View Products</a>

<a className="btn btn-light me-2" href="/save">Add Product</a>

<a className="btn btn-light me-2" href="/update">Update Product</a>

<a className="btn btn-light" href="/delete">Delete Product</a>

</div>

</div>

</nav>

 );

}
export default Nav;