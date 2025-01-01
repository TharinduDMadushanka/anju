import React from 'react';
import { useParams } from 'react-router-dom';
import rentProperties from "../../assets/rent-property/rentProperties";
import buyProperties from "../../assets/buy-property/buyProperties";
import './PropertyDetail.css';
import Navbar from '../../component/Navbar/Navbar';

const PropertyDetail = () => {
  const { id } = useParams();  // Retrieve the ID from the URL
  const allProperties = [...rentProperties, ...buyProperties];  // Combine both rent and buy properties
  const property = allProperties.find(prop => prop.id === id);  // Find the property based on the ID

  if (!property) {
    return <div>Property not found</div>;
  }

  return (
    <div className="property-detail-page">
        <Navbar/>
      <div className="property-detail-container">
        <div className="left-side">
          <img src={property.picture} alt={property.type} className="property-image" />
        </div>
        <div className="right-side">
          <div className="property-card">
            <h2>{property.type}</h2>
            <p>{property.bedrooms} Bedrooms</p>
            <p>${property.price.toLocaleString()}</p>
            <p>{property.tenure}</p>
            <p>{property.description}</p>
            <p>Location: {property.location}</p>
            <p>Added: {property.added.month} {property.added.day}, {property.added.year}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PropertyDetail;
