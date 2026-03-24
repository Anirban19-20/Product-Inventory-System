import React,{useState} from "react";
import axios from "axios";
import Nav from "./Nav";

function DeleteProduct(){

const [id,setId] = useState("");
const [msg,setMsg] = useState("");

const deleteProduct = ()=>{

axios.delete(`http://localhost:1004/product/delete/${id}`)
.then(res=>{
 setMsg("✅ Product Deleted Successfully");
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

<h3 className="text-center">Delete Product</h3>

<input
className="form-control mt-3"
placeholder="Enter Product ID"
onChange={(e)=>setId(e.target.value)}
/>

<button
className="btn btn-danger  w-auto mx-auto d-block mt-3"
onClick={deleteProduct}
>
Delete Product
</button>

<h5 className="text-success text-center mt-3">{msg}</h5>

</div>

</div>

</div>

);

}

export default DeleteProduct;