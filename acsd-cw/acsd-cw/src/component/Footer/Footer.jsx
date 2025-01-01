import React from 'react';
import './Footer.css';

const Footer = () => {
  return (
    <div className="footer-container">
      {/* Newsletter Section */}
      <section className="newsletter-section">
        <div className="newsletter-icon">
          <i className="fas fa-paper-plane"></i>
        </div>
        <h2 className="newsletter-title">Stay Up to Date</h2>
        <p className="newsletter-subtitle">
          Subscribe to our newsletter to receive our weekly feed.
        </p>
        <div className="newsletter-form">
          <input
            type="email"
            placeholder="Your email"
            className="newsletter-input"
          />
          <button className="newsletter-button">Send →</button>
        </div>
      </section>

      {/* Footer Bottom Section */}
      <footer className="footer-bottom">
        <p className="footer-copyright">Copyright © 2024. JustHome</p>
        <div className="footer-logo">JustHome</div>
        <div className="footer-social">
          <a href="#"><i className="fab fa-facebook-f"></i></a>
          <a href="#"><i className="fab fa-twitter"></i></a>
          <a href="#"><i className="fab fa-instagram"></i></a>
          <a href="#"><i className="fab fa-linkedin-in"></i></a>
        </div>
      </footer>
    </div>
  );
};

export default Footer;
