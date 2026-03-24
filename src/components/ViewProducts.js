import React, { useEffect, useState } from "react";
import axios from "axios";
import Nav from "./Nav";

function ViewProducts() {

  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  const loadProducts = () => {

    axios.get("http://localhost:1004/product/fetch")
      .then((res) => {
        console.log(res.data); 
        setProducts(res.data.data);
      })
      .catch((err) => {
        console.log(err);
      });

  };

  return (

    <div>

      <Nav />

      <div className="container mt-5">

        <div className="card shadow p-4">

          <h3 className="text-center mb-4">All Products</h3>

          <div className="table-responsive">

            <table className="table table-bordered table-hover text-center">

              <thead className="table-dark">

                <tr>
                  <th>ID</th>
                  <th>Category</th>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Status</th>
                  <th>Created</th>
                  <th>Updated</th>
                </tr>

              </thead>

              <tbody>

                {products.map((p) => (

                  <tr key={p.id}>

                    <td>{p.id}</td>
                    <td>{p.category}</td>
                    <td>{p.name}</td>
                    <td>₹ {p.price}</td>
                    <td>{p.quantity}</td>
                    <td>
                      <span className={
                        p.status === "Available"
                          ? "badge bg-success"
                          : "badge bg-danger"
                      }>
                        {p.status}
                      </span>
                    </td>
                    <td>{p.createdAt}</td>
                    <td>{p.updatedAt}</td>

                  </tr>

                ))}

              </tbody>

            </table>

          </div>

        </div>

      </div>

    </div>

  );

}

export default ViewProducts;