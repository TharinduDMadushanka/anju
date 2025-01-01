import React, { useState } from "react";
import Navbar from "../../component/Navbar/Navbar";
import { Link } from "react-router-dom";
import rentProperties from "../../assets/rent-property/rentProperties";
import buyProperties from "../../assets/buy-property/buyProperties";
import "./FilterPage.css";

const FilterPage = () => {
  const [propertyType, setPropertyType] = useState("rent");
  const [properties, setProperties] = useState(rentProperties);

  const handleFilterChange = (type) => {
    setPropertyType(type);
    setProperties(type === "rent" ? rentProperties : buyProperties);
  };

  return (
    <div className="filter-page">
      <Navbar />

      {/* Filter Section */}
      {/* Filter Section */}
      <div className="filter-section">
        <div className="filter-item">
          <label className="filter-label" htmlFor="price-min">Price:</label>
          <input
            id="price-min"
            type="number"
            placeholder="Min Price"
            className="filter-input"
          />
          <input
            id="price-max"
            type="number"
            placeholder="Max Price"
            className="filter-input"
          />
        </div>

        <div className="filter-item">
          <label className="filter-label" htmlFor="property-type">Type:</label>
          <select id="property-type" className="filter-select">
            <option value="">Select Type</option>
            <option value="House">House</option>
            <option value="Flat">Flat</option>
            <option value="Apartment">Apartment</option>
            <option value="Villa">Villa</option>
            <option value="Cottage">Cottage</option>
            <option value="Penthouse">Penthouse</option>
          </select>
        </div>

        <div className="filter-item">
          <label className="filter-label" htmlFor="bedrooms">Bedrooms:</label>
          <input
            id="bedrooms"
            type="number"
            placeholder="Bedrooms"
            className="filter-input"
          />
        </div>

        <div className="filter-item">
          <label className="filter-label" htmlFor="added-date">Date:</label>
          <input id="added-date" type="date" className="filter-input" />
        </div>

        <div className="filter-item">
          <label className="filter-label" htmlFor="post-code">Post Code:</label>
          <input
            id="post-code"
            type="text"
            placeholder="Post Code"
            className="filter-input"
          />
        </div>

        <div className="filter-item filter-button">
          <button className="search-btn">Search</button>
        </div>
      </div>

      {/* Property Type Buttons */}
      <div className="filter-buttons">
        <button
          className={`filter-btn ${propertyType === "rent" ? "active" : ""}`}
          onClick={() => handleFilterChange("rent")}
        >
          Rent
        </button>
        <button
          className={`filter-btn ${propertyType === "buy" ? "active" : ""}`}
          onClick={() => handleFilterChange("buy")}
        >
          Buy
        </button>
      </div>

      {/* Properties Display */}
      <div className="properties-grid">
        {properties.map((property) => (
          <div className="property-card" key={property.id}>
            <img src={property.picture} alt={property.type} />
            <div className="property-details">
              <h3>{property.type}</h3>
              <p>{property.bedrooms} Bedrooms</p>
              <p>${property.price.toLocaleString()}</p>
              <p>{property.tenure}</p>
              <p>{property.location}</p>
              <Link className="view-details" to={`/property-detail/${property.id}`}>
                View Details
              </Link>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default FilterPage;
