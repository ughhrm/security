CREATE TABLE product_property (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  product_id INT NOT NULL,
                                  property_type_id INT NOT NULL,
                                  property_value VARCHAR(255) NOT NULL,
                                  FOREIGN KEY (product_id) REFERENCES product(id),
                                  FOREIGN KEY (property_type_id) REFERENCES property_type(id)
);




