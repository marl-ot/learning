CREATE TABLE open_data (
    id INT,
    name STRING,
    host_id INT,
    host_name STRING,
    neighbourhood_group STRING,
    neighbourhood STRING,
    latitude DOUBLE,
    longitude DOUBLE,
    room_type STRING,
    price INT,
    minimum_nights INT,
    number_of_reviews INT,
    last_review STRING,
    reviews_per_month DOUBLE,
    calculated_host_listings_count INT,
    availability_365 INT
);

LOAD DATA LOCAL INPATH 'AB_NYC_2019.csv' INTO TABLE open_data;

SELECT
    AVG(price) AS avg_price,
    VARIANCE(price) AS var_price
FROM open_data;