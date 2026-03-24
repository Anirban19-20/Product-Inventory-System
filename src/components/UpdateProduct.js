import React, { useState } from "react";
import axios from "axios";
import Nav from "./Nav";

function UpdateProduct() {

  const [productId, setProductId] = useState("");
  const [selectedField, setSelectedField] = useState("");
  const [value, setValue] = useState("");
  const [msg, setMsg] = useState("");

  const updateProduct = () => {
    if (!selectedField) {
      setMsg("❗ Please select a field to update");
      return;
    }

    const updatedData = {
      [selectedField]: value
    };

    axios
      .put(`http://localhost:1004/product/update/${productId}`, updatedData)
      .then(() => {
        setMsg("✅ Selected field updated successfully");
      })
      .catch((err) => {
        console.log(err);
        setMsg("❌ Error updating product");
      });
  };

  return (
    <div>

      <Nav />

      <div className="container mt-5">

        <div className="card shadow p-4">

          <h3 className="text-center mb-4">Update Product</h3>

          {/* Product ID */}
          <input
            className="form-control mb-3"
            placeholder="Product ID"
            onChange={(e) => setProductId(e.target.value)}
          />

          {/* Field Selection */}
          <p className="fw-bold text-center mb-2">Select field to update:</p>

          <div className="d-flex flex-wrap justify-content-center gap-2 mb-4">
            {["category", "name", "price", "quantity", "status"].map((field) => (
              <button
                key={field}
                className={`btn px-3 py-1 rounded-pill text-capitalize ${
                  selectedField === field
                    ? "btn-primary"
                    : "btn-outline-secondary"
                }`}
                onClick={() => {
                  setSelectedField(field);
                  setValue("");
                }}
              >
                {field}
              </button>
            ))}
          </div>

          {/* Dynamic Input */}
          {selectedField && selectedField !== "status" && (
            <input
              className="form-control mb-3"
              type={
                selectedField === "price" || selectedField === "quantity"
                  ? "number"
                  : "text"
              }
              placeholder={`Enter new ${selectedField}`}
              value={value}
              onChange={(e) => setValue(e.target.value)}
            />
          )}

          {selectedField === "status" && (
            <select
              className="form-control mb-3"
              value={value}
              onChange={(e) => setValue(e.target.value)}
            >
              <option value="">Select Status</option>
              <option value="Available">Available</option>
              <option value="OutOfStock">Out Of Stock</option>
            </select>
          )}

          {/* Update Button */}
          <button
            className="btn btn-warning w-auto mx-auto d-block"
            onClick={updateProduct}
          >
            Update Product
          </button>

          {/* Message */}
          {msg && (
            <h5 className="text-center mt-3 text-success">
              {msg}
            </h5>
          )}

        </div>

      </div>

    </div>
  );
}

export default UpdateProduct;