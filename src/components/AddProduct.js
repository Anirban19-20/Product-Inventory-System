import React,{useState} from "react";
import axios from "axios";
import Nav from "./Nav";

function AddProduct(){

const [product,setProduct] = useState({
 category:"",
 name:"",
 price:"",
 quantity:"",
 status:""
});

const [msg,setMsg] = useState("");

const addProduct = ()=>{

axios.post("http://localhost:1004/product/save",product)
.then(res=>{
 setMsg("✅ Product Added Successfully");
})
.catch(err=>{
 console.log(err);
});

};

return(

<div>

<Nav/>

<div className="container mt-5">

<div className="card shadow p-4">

<h3 className="text-center mb-4">Add Product</h3>

<input className="form-control mb-3"
placeholder="Category"
onChange={(e)=>setProduct({...product,category:e.target.value})}
/>

<input className="form-control mb-3"
placeholder="Product Name"
onChange={(e)=>setProduct({...product,name:e.target.value})}
/>

<input className="form-control mb-3"
placeholder="Price"
onChange={(e)=>setProduct({...product,price:e.target.value})}
/>

<input className="form-control mb-3"
placeholder="Quantity"
onChange={(e)=>setProduct({...product,quantity:e.target.value})}
/>

<select className="form-control mb-3"
onChange={(e)=>setProduct({...product,status:e.target.value})}
>
<option>Select Status</option>
<option value="Available">Available</option>
<option value="OutOfStock">Out-Of-Stock</option>
</select>

<button className="btn btn-success w-auto mx-auto d-block"
onClick={addProduct}>
Add Product
</button>

<h5 className="text-success mt-3 text-center">{msg}</h5>

</div>

</div>

</div>

);

}

export default AddProduct;